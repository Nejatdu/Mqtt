package b4a.pro;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.pro", "b4a.pro.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.pro", "b4a.pro.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.pro.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.WebViewWrapper _vvvvvvvv4 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittextip = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext4 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebutton1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebutton2 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebutton3 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _togglebutton4 = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _vvvvvvvv5 = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _vvvvvvvv6 = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _vvvvvvvv7 = null;
public anywheresoftware.b4a.objects.drawable.BitmapDrawable _vvvvvvvv0 = null;
public b4a.pro.slidemenu _vvvvvvvv3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext_ay = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext_dk = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext_gun = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext_saat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext_yil = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltemperature = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblstate = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblamba = null;
public b4a.pro.starter _vvvvvvv1 = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 61;BA.debugLine="Activity.LoadLayout(\"B4A-ESP8266_Local_Web_Mqtt-v";
mostCurrent._activity.LoadLayout("B4A-ESP8266_Local_Web_Mqtt-v1",mostCurrent.activityBA);
 //BA.debugLineNum = 63;BA.debugLine="sm.Initialize(Activity, Me, \"SlideMenu\", 42dip, 1";
mostCurrent._vvvvvvvv3._initialize /*String*/ (mostCurrent.activityBA,mostCurrent._activity,main.getObject(),"SlideMenu",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (42)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
 //BA.debugLineNum = 65;BA.debugLine="sm.AddItem(\"HOME PAGE\", LoadBitmap(File.DirAssets";
mostCurrent._vvvvvvvv3._vvvvvvv2 /*String*/ ("HOME PAGE",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"bomb.png"),(Object)(1));
 //BA.debugLineNum = 66;BA.debugLine="sm.AddItem(\"Item #2\", LoadBitmap(File.DirAssets,";
mostCurrent._vvvvvvvv3._vvvvvvv2 /*String*/ ("Item #2",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"book_add.png"),(Object)(2));
 //BA.debugLineNum = 67;BA.debugLine="sm.AddItem(\"Item #3\", LoadBitmap(File.DirAssets,";
mostCurrent._vvvvvvvv3._vvvvvvv2 /*String*/ ("Item #3",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"book_open.png"),(Object)(3));
 //BA.debugLineNum = 68;BA.debugLine="sm.AddItem(\"PROFILE\", LoadBitmap(File.DirAssets,";
mostCurrent._vvvvvvvv3._vvvvvvv2 /*String*/ ("PROFILE",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"wrench.png"),(Object)(4));
 //BA.debugLineNum = 69;BA.debugLine="sm.AddItem(\"SETTINGS\", LoadBitmap(File.DirAssets,";
mostCurrent._vvvvvvvv3._vvvvvvv2 /*String*/ ("SETTINGS",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"wrench_orange.png"),(Object)(5));
 //BA.debugLineNum = 70;BA.debugLine="sm.AddItem(\"BACK #6\", Null, 6)";
mostCurrent._vvvvvvvv3._vvvvvvv2 /*String*/ ("BACK #6",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),(Object)(6));
 //BA.debugLineNum = 71;BA.debugLine="sm.AddItem(\"SING OUT #7\", Null, 7)";
mostCurrent._vvvvvvvv3._vvvvvvv2 /*String*/ ("SING OUT #7",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),(Object)(7));
 //BA.debugLineNum = 78;BA.debugLine="WB.Initialize(\"WB\")";
mostCurrent._vvvvvvvv4.Initialize(mostCurrent.activityBA,"WB");
 //BA.debugLineNum = 80;BA.debugLine="ImgToggleButton1.Initialize(LoadBitmap(File.DirAs";
mostCurrent._vvvvvvvv5.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led OFF.png").getObject()));
 //BA.debugLineNum = 81;BA.debugLine="ImgToggleButton1.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv5.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 82;BA.debugLine="ToggleButton1.Background = ImgToggleButton1";
mostCurrent._togglebutton1.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv5.getObject()));
 //BA.debugLineNum = 84;BA.debugLine="ImgToggleButton2.Initialize(LoadBitmap(File.DirAs";
mostCurrent._vvvvvvvv6.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led OFF.png").getObject()));
 //BA.debugLineNum = 85;BA.debugLine="ImgToggleButton2.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv6.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 86;BA.debugLine="ToggleButton2.Background = ImgToggleButton2";
mostCurrent._togglebutton2.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv6.getObject()));
 //BA.debugLineNum = 88;BA.debugLine="ImgToggleButton3.Initialize(LoadBitmap(File.DirAs";
mostCurrent._vvvvvvvv7.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led OFF.png").getObject()));
 //BA.debugLineNum = 89;BA.debugLine="ImgToggleButton3.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv7.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 90;BA.debugLine="ToggleButton3.Background = ImgToggleButton3";
mostCurrent._togglebutton3.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv7.getObject()));
 //BA.debugLineNum = 92;BA.debugLine="ImgToggleButton4.Initialize(LoadBitmap(File.DirAs";
mostCurrent._vvvvvvvv0.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led OFF.png").getObject()));
 //BA.debugLineNum = 93;BA.debugLine="ImgToggleButton4.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv0.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 94;BA.debugLine="ToggleButton4.Background = ImgToggleButton4";
mostCurrent._togglebutton4.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv0.getObject()));
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 227;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 229;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And sm.isVisib";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._vvvvvvvv3._vvvvvvv4 /*boolean*/ ()) { 
 //BA.debugLineNum = 230;BA.debugLine="sm.Hide";
mostCurrent._vvvvvvvv3._vvvvvvv3 /*String*/ ();
 //BA.debugLineNum = 231;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 235;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_MENU Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_MENU) { 
 //BA.debugLineNum = 236;BA.debugLine="If sm.isVisible Then sm.Hide Else sm.Show";
if (mostCurrent._vvvvvvvv3._vvvvvvv4 /*boolean*/ ()) { 
mostCurrent._vvvvvvvv3._vvvvvvv3 /*String*/ ();}
else {
mostCurrent._vvvvvvvv3._vvvv1 /*String*/ ();};
 //BA.debugLineNum = 237;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 223;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 219;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 220;BA.debugLine="SetState";
_setstate();
 //BA.debugLineNum = 221;BA.debugLine="End Sub";
return "";
}
public static String  _btnshow_click() throws Exception{
 //BA.debugLineNum = 242;BA.debugLine="Sub btnShow_Click";
 //BA.debugLineNum = 243;BA.debugLine="sm.Show";
mostCurrent._vvvvvvvv3._vvvv1 /*String*/ ();
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Dim WB As WebView";
mostCurrent._vvvvvvvv4 = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private EditTextIP As EditText";
mostCurrent._edittextip = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private EditText1 As EditText";
mostCurrent._edittext1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private EditText2 As EditText";
mostCurrent._edittext2 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private EditText3 As EditText";
mostCurrent._edittext3 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private EditText4 As EditText";
mostCurrent._edittext4 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private ToggleButton1 As ToggleButton";
mostCurrent._togglebutton1 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private ToggleButton2 As ToggleButton";
mostCurrent._togglebutton2 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private ToggleButton3 As ToggleButton";
mostCurrent._togglebutton3 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private ToggleButton4 As ToggleButton";
mostCurrent._togglebutton4 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Dim ImgToggleButton1 As BitmapDrawable";
mostCurrent._vvvvvvvv5 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 37;BA.debugLine="Dim ImgToggleButton2 As BitmapDrawable";
mostCurrent._vvvvvvvv6 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 38;BA.debugLine="Dim ImgToggleButton3 As BitmapDrawable";
mostCurrent._vvvvvvvv7 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 39;BA.debugLine="Dim ImgToggleButton4 As BitmapDrawable";
mostCurrent._vvvvvvvv0 = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 40;BA.debugLine="Dim sm As SlideMenu";
mostCurrent._vvvvvvvv3 = new b4a.pro.slidemenu();
 //BA.debugLineNum = 43;BA.debugLine="Private EditText_ay As EditText";
mostCurrent._edittext_ay = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private EditText_dk As EditText";
mostCurrent._edittext_dk = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private EditText_gun As EditText";
mostCurrent._edittext_gun = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private EditText_saat As EditText";
mostCurrent._edittext_saat = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private EditText_yil As EditText";
mostCurrent._edittext_yil = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private lblTemperature As Label";
mostCurrent._lbltemperature = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private lblState As Label";
mostCurrent._lblstate = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private lblamba As Label";
mostCurrent._lblamba = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static String  _initialize() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}

private static byte[][] bb;

public static String vvv13(final byte[] _b, final int i) throws Exception {
Runnable r = new Runnable() {
{

int value = i / 8 + 905016;
if (bb == null) {
		
                bb = new byte[4][];
				bb[0] = BA.packageName.getBytes("UTF8");
                bb[1] = BA.applicationContext.getPackageManager().getPackageInfo(BA.packageName, 0).versionName.getBytes("UTF8");
                if (bb[1].length == 0)
                    bb[1] = "jsdkfh".getBytes("UTF8");
                bb[2] = new byte[] { (byte)BA.applicationContext.getPackageManager().getPackageInfo(BA.packageName, 0).versionCode };			
        }
        bb[3] = new byte[] {
                    (byte) (value >>> 24),
						(byte) (value >>> 16),
						(byte) (value >>> 8),
						(byte) value};
				try {
					for (int __b = 0;__b < (3 + 1);__b ++) {
						for (int b = 0;b<_b.length;b++) {
							_b[b] ^= bb[__b][b % bb[__b].length];
						}
					}

				} catch (Exception e) {
					throw new RuntimeException(e);
				}
                

            
}
public void run() {
}
};
return new String(_b, "UTF8");
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _setstate() throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Public Sub SetState";
 //BA.debugLineNum = 98;BA.debugLine="If Starter.mqtt.Connected Then";
if (mostCurrent._vvvvvvv1._v5 /*anywheresoftware.b4j.objects.MqttAsyncClientWrapper*/ .getConnected()) { 
 //BA.debugLineNum = 99;BA.debugLine="lblState.Text = \"Connected\"";
mostCurrent._lblstate.setText(BA.ObjectToCharSequence("Connected"));
 //BA.debugLineNum = 100;BA.debugLine="lblTemperature.Text = $\"Temperature: $1.1{Starte";
mostCurrent._lbltemperature.setText(BA.ObjectToCharSequence(("Temperature: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("1.1",(Object)(mostCurrent._vvvvvvv1._v6 /*int*/ ))+" °C")));
 //BA.debugLineNum = 101;BA.debugLine="lblamba.Text = $\"lamba: $1.1{Starter.lamba} °z\"$";
mostCurrent._lblamba.setText(BA.ObjectToCharSequence(("lamba: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("1.1",(Object)(mostCurrent._vvvvvvv1._v7 /*int*/ ))+" °z")));
 }else {
 //BA.debugLineNum = 103;BA.debugLine="lblState.Text = \"Disconnected\"";
mostCurrent._lblstate.setText(BA.ObjectToCharSequence("Disconnected"));
 //BA.debugLineNum = 104;BA.debugLine="lblTemperature.Text = \"Temperature: N/A\"";
mostCurrent._lbltemperature.setText(BA.ObjectToCharSequence("Temperature: N/A"));
 };
 //BA.debugLineNum = 107;BA.debugLine="If Starter.lamba = 1 Then";
if (mostCurrent._vvvvvvv1._v7 /*int*/ ==1) { 
 //BA.debugLineNum = 108;BA.debugLine="ImgToggleButton4.Initialize(LoadBitmap(File.DirA";
mostCurrent._vvvvvvvv0.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led ON.png").getObject()));
 //BA.debugLineNum = 109;BA.debugLine="ImgToggleButton4.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv0.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 110;BA.debugLine="ToggleButton4.Background = ImgToggleButton4";
mostCurrent._togglebutton4.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv0.getObject()));
 }else {
 //BA.debugLineNum = 112;BA.debugLine="ImgToggleButton4.Initialize(LoadBitmap(File.DirA";
mostCurrent._vvvvvvvv0.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led OFF.png").getObject()));
 //BA.debugLineNum = 113;BA.debugLine="ImgToggleButton4.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv0.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 114;BA.debugLine="ToggleButton4.Background = ImgToggleButton4";
mostCurrent._togglebutton4.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv0.getObject()));
 };
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public static String  _slidemenu_click(Object _item) throws Exception{
 //BA.debugLineNum = 248;BA.debugLine="Sub SlideMenu_Click(Item As Object)";
 //BA.debugLineNum = 252;BA.debugLine="Select Item";
switch (BA.switchObjectToInt(_item,(Object)(1),(Object)(2),(Object)(3),(Object)(4),(Object)(5),(Object)(6))) {
case 0: {
 //BA.debugLineNum = 254;BA.debugLine="ToastMessageShow(\"clicked : HOME PAGE\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("clicked : HOME PAGE"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 255;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
 break; }
case 1: {
 //BA.debugLineNum = 258;BA.debugLine="ToastMessageShow(\"clicked : 2\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("clicked : 2"),anywheresoftware.b4a.keywords.Common.True);
 break; }
case 2: {
 //BA.debugLineNum = 260;BA.debugLine="ToastMessageShow(\"clicked : 3\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("clicked : 3"),anywheresoftware.b4a.keywords.Common.True);
 break; }
case 3: {
 //BA.debugLineNum = 262;BA.debugLine="ToastMessageShow(\"clicked : 4\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("clicked : 4"),anywheresoftware.b4a.keywords.Common.True);
 break; }
case 4: {
 //BA.debugLineNum = 264;BA.debugLine="ToastMessageShow(\"clicked : SETTINGS\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("clicked : SETTINGS"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 265;BA.debugLine="Activity.LoadLayout(\"datetimelayout\")";
mostCurrent._activity.LoadLayout("datetimelayout",mostCurrent.activityBA);
 break; }
case 5: {
 //BA.debugLineNum = 267;BA.debugLine="ToastMessageShow(\"clicked : LAY1\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("clicked : LAY1"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 268;BA.debugLine="Activity.LoadLayout(\"Lay1\")";
mostCurrent._activity.LoadLayout("Lay1",mostCurrent.activityBA);
 break; }
}
;
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
return "";
}
public static String  _togglebutton1_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Sub ToggleButton1_CheckedChange(Checked As Boolean";
 //BA.debugLineNum = 119;BA.debugLine="If EditText1.Text = \"\" Then";
if ((mostCurrent._edittext1.getText()).equals("")) { 
 //BA.debugLineNum = 120;BA.debugLine="ToastMessageShow(\"IP address cannot be empty !\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("IP address cannot be empty !"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 121;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 123;BA.debugLine="If Checked = False Then";
if (_checked==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 124;BA.debugLine="ImgToggleButton1.Initialize(LoadBitmap(File.DirA";
mostCurrent._vvvvvvvv5.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led OFF.png").getObject()));
 //BA.debugLineNum = 125;BA.debugLine="ImgToggleButton1.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv5.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 126;BA.debugLine="ToggleButton1.Background = ImgToggleButton1";
mostCurrent._togglebutton1.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv5.getObject()));
 //BA.debugLineNum = 128;BA.debugLine="WB.LoadUrl(\"http://\" & EditText1.Text & \"/Relay0";
mostCurrent._vvvvvvvv4.LoadUrl("http://"+mostCurrent._edittext1.getText()+"/Relay01=0");
 }else {
 //BA.debugLineNum = 132;BA.debugLine="ImgToggleButton1.Initialize(LoadBitmap(File.DirA";
mostCurrent._vvvvvvvv5.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led ON.png").getObject()));
 //BA.debugLineNum = 133;BA.debugLine="ImgToggleButton1.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv5.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 134;BA.debugLine="ToggleButton1.Background = ImgToggleButton1";
mostCurrent._togglebutton1.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv5.getObject()));
 //BA.debugLineNum = 136;BA.debugLine="WB.LoadUrl(\"http://\" & EditText1.Text & \"/Relay0";
mostCurrent._vvvvvvvv4.LoadUrl("http://"+mostCurrent._edittext1.getText()+"/Relay01=1");
 };
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _togglebutton2_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Sub ToggleButton2_CheckedChange(Checked As Boolean";
 //BA.debugLineNum = 143;BA.debugLine="If EditText2.Text = \"\" Then";
if ((mostCurrent._edittext2.getText()).equals("")) { 
 //BA.debugLineNum = 144;BA.debugLine="ToastMessageShow(\"IP cannot be empty !\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("IP cannot be empty !"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 145;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 147;BA.debugLine="If Checked = False Then";
if (_checked==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 148;BA.debugLine="ImgToggleButton2.Initialize(LoadBitmap(File.DirA";
mostCurrent._vvvvvvvv6.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led OFF.png").getObject()));
 //BA.debugLineNum = 149;BA.debugLine="ImgToggleButton2.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv6.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 150;BA.debugLine="ToggleButton2.Background = ImgToggleButton2";
mostCurrent._togglebutton2.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv6.getObject()));
 //BA.debugLineNum = 152;BA.debugLine="WB.LoadUrl(\"http://\" & EditText2.Text & \"/Relay0";
mostCurrent._vvvvvvvv4.LoadUrl("http://"+mostCurrent._edittext2.getText()+"/Relay01=0");
 }else {
 //BA.debugLineNum = 156;BA.debugLine="ImgToggleButton2.Initialize(LoadBitmap(File.DirA";
mostCurrent._vvvvvvvv6.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led ON.png").getObject()));
 //BA.debugLineNum = 157;BA.debugLine="ImgToggleButton2.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv6.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 158;BA.debugLine="ToggleButton2.Background = ImgToggleButton2";
mostCurrent._togglebutton2.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv6.getObject()));
 //BA.debugLineNum = 160;BA.debugLine="WB.LoadUrl(\"http://\" & EditText2.Text & \"/Relay0";
mostCurrent._vvvvvvvv4.LoadUrl("http://"+mostCurrent._edittext2.getText()+"/Relay01=1");
 //BA.debugLineNum = 161;BA.debugLine="WB.LoadUrl(\"http://\" & EditText_dk.Text & \"/204_";
mostCurrent._vvvvvvvv4.LoadUrl("http://"+mostCurrent._edittext_dk.getText()+"/204_dk");
 };
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public static String  _togglebutton3_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Sub ToggleButton3_CheckedChange(Checked As Boolean";
 //BA.debugLineNum = 168;BA.debugLine="If EditText3.Text = \"\" Then";
if ((mostCurrent._edittext3.getText()).equals("")) { 
 //BA.debugLineNum = 169;BA.debugLine="ToastMessageShow(\"IP cannot be empty !\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("IP cannot be empty !"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 170;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 172;BA.debugLine="If Checked = False Then";
if (_checked==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 173;BA.debugLine="ImgToggleButton3.Initialize(LoadBitmap(File.DirA";
mostCurrent._vvvvvvvv7.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led OFF.png").getObject()));
 //BA.debugLineNum = 174;BA.debugLine="ImgToggleButton3.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv7.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 175;BA.debugLine="ToggleButton3.Background = ImgToggleButton3";
mostCurrent._togglebutton3.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv7.getObject()));
 //BA.debugLineNum = 177;BA.debugLine="WB.LoadUrl(\"http://\" & EditText3.Text & \"/Relay0";
mostCurrent._vvvvvvvv4.LoadUrl("http://"+mostCurrent._edittext3.getText()+"/Relay01=0");
 }else {
 //BA.debugLineNum = 181;BA.debugLine="ImgToggleButton3.Initialize(LoadBitmap(File.DirA";
mostCurrent._vvvvvvvv7.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Led ON.png").getObject()));
 //BA.debugLineNum = 182;BA.debugLine="ImgToggleButton3.Gravity = Gravity.FILL";
mostCurrent._vvvvvvvv7.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 183;BA.debugLine="ToggleButton3.Background = ImgToggleButton3";
mostCurrent._togglebutton3.setBackground((android.graphics.drawable.Drawable)(mostCurrent._vvvvvvvv7.getObject()));
 //BA.debugLineNum = 185;BA.debugLine="WB.LoadUrl(\"http://\" & EditText3.Text & \"/Relay0";
mostCurrent._vvvvvvvv4.LoadUrl("http://"+mostCurrent._edittext3.getText()+"/Relay01=1");
 };
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public static String  _togglebutton4_checkedchange(boolean _checked) throws Exception{
String _message = "";
byte[] _bytes = null;
 //BA.debugLineNum = 192;BA.debugLine="Sub ToggleButton4_CheckedChange(Checked As Boolean";
 //BA.debugLineNum = 194;BA.debugLine="If Checked = False Then";
if (_checked==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 195;BA.debugLine="lblamba.Text = $\"lamba: $1.1{0} °C\"$";
mostCurrent._lblamba.setText(BA.ObjectToCharSequence(("lamba: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("1.1",(Object)(0))+" °C")));
 //BA.debugLineNum = 196;BA.debugLine="WB.LoadUrl(\"http://\" & EditText4.Text & \"/Relay0";
mostCurrent._vvvvvvvv4.LoadUrl("http://"+mostCurrent._edittext4.getText()+"/Relay02=0");
 //BA.debugLineNum = 197;BA.debugLine="Dim message As String = \"1\"";
_message = "1";
 //BA.debugLineNum = 198;BA.debugLine="Dim bytes() As Byte = message.GetBytes(\"UTF-8\")";
_bytes = _message.getBytes("UTF-8");
 //BA.debugLineNum = 201;BA.debugLine="Dim message As String = \"1\"";
_message = "1";
 //BA.debugLineNum = 202;BA.debugLine="Dim bytes() As Byte = message.GetBytes(\"UTF-8\")";
_bytes = _message.getBytes("UTF-8");
 //BA.debugLineNum = 204;BA.debugLine="Starter.mqtt.Publish(\"encan/feeds/light\", bytes";
mostCurrent._vvvvvvv1._v5 /*anywheresoftware.b4j.objects.MqttAsyncClientWrapper*/ .Publish("encan/feeds/light",_bytes);
 }else {
 //BA.debugLineNum = 207;BA.debugLine="lblamba.Text = $\"lamba: $1.1{1} °C\"$";
mostCurrent._lblamba.setText(BA.ObjectToCharSequence(("lamba: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("1.1",(Object)(1))+" °C")));
 //BA.debugLineNum = 208;BA.debugLine="WB.LoadUrl(\"http://\" & EditText4.Text & \"/Relay0";
mostCurrent._vvvvvvvv4.LoadUrl("http://"+mostCurrent._edittext4.getText()+"/Relay02=1");
 //BA.debugLineNum = 210;BA.debugLine="Dim message As String = \"0\"";
_message = "0";
 //BA.debugLineNum = 211;BA.debugLine="Dim bytes() As Byte = message.GetBytes(\"UTF-8\")";
_bytes = _message.getBytes("UTF-8");
 //BA.debugLineNum = 213;BA.debugLine="Starter.mqtt.Publish(\"encan/feeds/light\", bytes)";
mostCurrent._vvvvvvv1._v5 /*anywheresoftware.b4j.objects.MqttAsyncClientWrapper*/ .Publish("encan/feeds/light",_bytes);
 };
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
}
