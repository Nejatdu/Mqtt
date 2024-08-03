B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.9
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	Private working As Boolean = True
	Public mqtt As MqttClient
	Private username As String = "encan"
	Private password As String = "18844fa8672c4e09a8e247e17fa0a9a4"
	Public temperature As Int
	Public lamba As Int

'	Dim message As String
'	Dim bytes() As Byte = message.GetBytes("UTF-8")
End Sub

Sub Service_Create
	working = True
	mqtt.Initialize("mqtt", "ssl://io.adafruit.com:8883", "B4A" & Rnd(0, 999999999))
	ConnectAndReconnect

End Sub

Sub ConnectAndReconnect
	Do While working
		If mqtt.IsInitialized Then mqtt.Close
		mqtt.Initialize("mqtt", "ssl://io.adafruit.com:8883", "B4X" & Rnd(0, 999999999))
		Dim mo As MqttConnectOptions
		mo.Initialize(username, password)
		Log("Trying to connect")
		mqtt.Connect2(mo)
		Wait For Mqtt_Connected (Success As Boolean)
		If Success Then
			Log("Mqtt connected")
			AfterConnect
			Do While working And mqtt.Connected
				mqtt.Publish2($"${username}/f/light"$, Array As Byte(0), 1, False)
				Sleep(5000)
			Loop
			Log("Disconnected")
		Else
			Log("Error connecting.")
		End If
		UpdateState
		Sleep(1000)
	Loop
End Sub

Private Sub AfterConnect
	mqtt.Subscribe($"${username}/f/counter"$, 1)  ' liht  feed i ve aşadakini değiştirebilirsin
	mqtt.Subscribe($"${username}/f/light"$, 1)  ' liht  feed i ve aşadakini değiştirebilirsin
	UpdateState
End Sub

Sub mqtt_MessageArrived (Topic As String, Payload() As Byte)
	If Topic.EndsWith("/counter") Then
		Dim ping As String = BytesToString(Payload, 0, Payload.Length, "ascii")
		temperature = ping
		UpdateState
	End If
	
	If Topic.EndsWith("/light") Then
		Dim ping As String = BytesToString(Payload, 0, Payload.Length, "ascii")
		lamba = ping
		UpdateState
	End If	
	
'	mqtt.Publish("encan/feeds/light", bytes)
	UpdateState
	
	
End Sub

Sub UpdateState
	CallSub(Main, "SetState")
End Sub


Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 'Starter service can start in the foreground state in some edge cases.
End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub
