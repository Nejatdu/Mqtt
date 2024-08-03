package b4a.pro;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, BA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "b4a.pro", "b4a.pro.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.pro.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static boolean _vvvvvvvvv3 = false;
public static anywheresoftware.b4j.objects.MqttAsyncClientWrapper _v5 = null;
public static String _vvvvvvvvv2 = "";
public static String _vvvvvvvvv4 = "";
public static int _v6 = 0;
public static int _v7 = 0;
public b4a.pro.main _vvvvvv0 = null;
public static String  _vvvvvvvvv1() throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Private Sub AfterConnect";
 //BA.debugLineNum = 51;BA.debugLine="mqtt.Subscribe($\"${username}/f/counter\"$, 1)  ' l";
_v5.Subscribe((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_vvvvvvvvv2))+"/f/counter"),(int) (1));
 //BA.debugLineNum = 52;BA.debugLine="mqtt.Subscribe($\"${username}/f/light\"$, 1)  ' lih";
_v5.Subscribe((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_vvvvvvvvv2))+"/f/light"),(int) (1));
 //BA.debugLineNum = 53;BA.debugLine="UpdateState";
_vv1();
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 90;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return false;
}
public static void  _v0() throws Exception{
ResumableSub_ConnectAndReconnect rsub = new ResumableSub_ConnectAndReconnect(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ConnectAndReconnect extends BA.ResumableSub {
public ResumableSub_ConnectAndReconnect(b4a.pro.starter parent) {
this.parent = parent;
}
b4a.pro.starter parent;
anywheresoftware.b4j.objects.MqttAsyncClientWrapper.MqttConnectOptionsWrapper _mo = null;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 26;BA.debugLine="Do While working";
if (true) break;

case 1:
//do while
this.state = 20;
while (parent._vvvvvvvvv3) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 27;BA.debugLine="If mqtt.IsInitialized Then mqtt.Close";
if (true) break;

case 4:
//if
this.state = 9;
if (parent._v5.IsInitialized()) { 
this.state = 6;
;}if (true) break;

case 6:
//C
this.state = 9;
parent._v5.Close();
if (true) break;

case 9:
//C
this.state = 10;
;
 //BA.debugLineNum = 28;BA.debugLine="mqtt.Initialize(\"mqtt\", \"ssl://io.adafruit.com:8";
parent._v5.Initialize(processBA,"mqtt","ssl://io.adafruit.com:8883","B4X"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (999999999))));
 //BA.debugLineNum = 29;BA.debugLine="Dim mo As MqttConnectOptions";
_mo = new anywheresoftware.b4j.objects.MqttAsyncClientWrapper.MqttConnectOptionsWrapper();
 //BA.debugLineNum = 30;BA.debugLine="mo.Initialize(username, password)";
_mo.Initialize(parent._vvvvvvvvv2,parent._vvvvvvvvv4);
 //BA.debugLineNum = 31;BA.debugLine="Log(\"Trying to connect\")";
anywheresoftware.b4a.keywords.Common.LogImpl("51048582","Trying to connect",0);
 //BA.debugLineNum = 32;BA.debugLine="mqtt.Connect2(mo)";
parent._v5.Connect2((org.eclipse.paho.client.mqttv3.MqttConnectOptions)(_mo.getObject()));
 //BA.debugLineNum = 33;BA.debugLine="Wait For Mqtt_Connected (Success As Boolean)";
anywheresoftware.b4a.keywords.Common.WaitFor("mqtt_connected", processBA, this, null);
this.state = 21;
return;
case 21:
//C
this.state = 10;
_success = (Boolean) result[0];
;
 //BA.debugLineNum = 34;BA.debugLine="If Success Then";
if (true) break;

case 10:
//if
this.state = 19;
if (_success) { 
this.state = 12;
}else {
this.state = 18;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 35;BA.debugLine="Log(\"Mqtt connected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("51048586","Mqtt connected",0);
 //BA.debugLineNum = 36;BA.debugLine="AfterConnect";
_vvvvvvvvv1();
 //BA.debugLineNum = 37;BA.debugLine="Do While working And mqtt.Connected";
if (true) break;

case 13:
//do while
this.state = 16;
while (parent._vvvvvvvvv3 && parent._v5.getConnected()) {
this.state = 15;
if (true) break;
}
if (true) break;

case 15:
//C
this.state = 13;
 //BA.debugLineNum = 38;BA.debugLine="mqtt.Publish2($\"${username}/f/light\"$, Array A";
parent._v5.Publish2((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent._vvvvvvvvv2))+"/f/light"),new byte[]{(byte) (0)},(int) (1),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 39;BA.debugLine="Sleep(5000)";
anywheresoftware.b4a.keywords.Common.Sleep(processBA,this,(int) (5000));
this.state = 22;
return;
case 22:
//C
this.state = 13;
;
 if (true) break;

case 16:
//C
this.state = 19;
;
 //BA.debugLineNum = 41;BA.debugLine="Log(\"Disconnected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("51048592","Disconnected",0);
 if (true) break;

case 18:
//C
this.state = 19;
 //BA.debugLineNum = 43;BA.debugLine="Log(\"Error connecting.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("51048594","Error connecting.",0);
 if (true) break;

case 19:
//C
this.state = 1;
;
 //BA.debugLineNum = 45;BA.debugLine="UpdateState";
_vv1();
 //BA.debugLineNum = 46;BA.debugLine="Sleep(1000)";
anywheresoftware.b4a.keywords.Common.Sleep(processBA,this,(int) (1000));
this.state = 23;
return;
case 23:
//C
this.state = 1;
;
 if (true) break;

case 20:
//C
this.state = -1;
;
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _mqtt_connected(boolean _success) throws Exception{
}
public static String  _mqtt_messagearrived(String _topic,byte[] _payload) throws Exception{
String _ping = "";
 //BA.debugLineNum = 56;BA.debugLine="Sub mqtt_MessageArrived (Topic As String, Payload(";
 //BA.debugLineNum = 57;BA.debugLine="If Topic.EndsWith(\"/counter\") Then";
if (_topic.endsWith("/counter")) { 
 //BA.debugLineNum = 58;BA.debugLine="Dim ping As String = BytesToString(Payload, 0, P";
_ping = anywheresoftware.b4a.keywords.Common.BytesToString(_payload,(int) (0),_payload.length,"ascii");
 //BA.debugLineNum = 59;BA.debugLine="temperature = ping";
_v6 = (int)(Double.parseDouble(_ping));
 //BA.debugLineNum = 60;BA.debugLine="UpdateState";
_vv1();
 };
 //BA.debugLineNum = 63;BA.debugLine="If Topic.EndsWith(\"/light\") Then";
if (_topic.endsWith("/light")) { 
 //BA.debugLineNum = 64;BA.debugLine="Dim ping As String = BytesToString(Payload, 0, P";
_ping = anywheresoftware.b4a.keywords.Common.BytesToString(_payload,(int) (0),_payload.length,"ascii");
 //BA.debugLineNum = 65;BA.debugLine="lamba = ping";
_v7 = (int)(Double.parseDouble(_ping));
 //BA.debugLineNum = 66;BA.debugLine="UpdateState";
_vv1();
 };
 //BA.debugLineNum = 70;BA.debugLine="UpdateState";
_vv1();
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private working As Boolean = True";
_vvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 8;BA.debugLine="Public mqtt As MqttClient";
_v5 = new anywheresoftware.b4j.objects.MqttAsyncClientWrapper();
 //BA.debugLineNum = 9;BA.debugLine="Private username As String = \"encan\"";
_vvvvvvvvv2 = main.vvv13 (new byte[] {108,39,26,-63,121}, 882023);
 //BA.debugLineNum = 10;BA.debugLine="Private password As String = \"18844fa8672c4e09a8e";
_vvvvvvvvv4 = main.vvv13 (new byte[] {56,113,56,-7,35,114,97,-95,103,51,127,-13,45,119,51,-18,103,112,122,-69,62,48,50,-80,114,107,114,-68,100,107,111,-31}, 633487);
 //BA.debugLineNum = 11;BA.debugLine="Public temperature As Int";
_v6 = 0;
 //BA.debugLineNum = 12;BA.debugLine="Public lamba As Int";
_v7 = 0;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 19;BA.debugLine="working = True";
_vvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 20;BA.debugLine="mqtt.Initialize(\"mqtt\", \"ssl://io.adafruit.com:88";
_v5.Initialize(processBA,"mqtt","ssl://io.adafruit.com:8883","B4A"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (999999999))));
 //BA.debugLineNum = 21;BA.debugLine="ConnectAndReconnect";
_v0();
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 81;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Sub Service_TaskRemoved";
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public static String  _vv1() throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Sub UpdateState";
 //BA.debugLineNum = 76;BA.debugLine="CallSub(Main, \"SetState\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._vvvvvv0.getObject()),"SetState");
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
}
