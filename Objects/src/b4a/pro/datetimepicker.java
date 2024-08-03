package b4a.pro;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class datetimepicker extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.pro.datetimepicker");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.pro.datetimepicker.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _vvvv7 = "";
public Object _vvvv0 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvv1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvv2 = null;
public long _vvvvv3 = 0L;
public long _vvvvv4 = 0L;
public b4a.example3.customlistview _clv1 = null;
public b4a.example3.customlistview _clv2 = null;
public b4a.example3.customlistview _clv3 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _label1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _label2 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _label3 = null;
public long _vvvvv5 = 0L;
public boolean _vvvvv6 = false;
public int _vvvvv7 = 0;
public int _vvvvv0 = 0;
public int _vvvvvv1 = 0;
public int _vvvvvv2 = 0;
public int _vvvvvv3 = 0;
public int _vvvvvv4 = 0;
public int _vvvvvv5 = 0;
public int _vvvvvv6 = 0;
public boolean _vvvvvv7 = false;
public b4a.pro.main _vvvvvv0 = null;
public b4a.pro.starter _vvvvvvv1 = null;
public String  _vv2() throws Exception{
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _path = null;
 //BA.debugLineNum = 72;BA.debugLine="Private Sub applyLineColor";
 //BA.debugLineNum = 73;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 74;BA.debugLine="cvs.Initialize(Label1)";
_cvs.Initialize(_label1);
 //BA.debugLineNum = 75;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
_cvs.ClearRect(_cvs.getTargetRect());
 //BA.debugLineNum = 76;BA.debugLine="Dim path As B4XPath";
_path = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 77;BA.debugLine="path.Initialize(0,0)";
_path.Initialize((float) (0),(float) (0));
 //BA.debugLineNum = 78;BA.debugLine="path.LineTo(cvs.TargetRect.Width,0)";
_path.LineTo(_cvs.getTargetRect().getWidth(),(float) (0));
 //BA.debugLineNum = 83;BA.debugLine="cvs.DrawPath(path,lineColor,False,1dip)";
_cvs.DrawPath(_path,_vvvvvv3,__c.False,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 84;BA.debugLine="path.Initialize(0,cvs.TargetRect.Height)";
_path.Initialize((float) (0),_cvs.getTargetRect().getHeight());
 //BA.debugLineNum = 85;BA.debugLine="path.LineTo(cvs.TargetRect.Width,cvs.TargetRect.H";
_path.LineTo(_cvs.getTargetRect().getWidth(),_cvs.getTargetRect().getHeight());
 //BA.debugLineNum = 90;BA.debugLine="cvs.DrawPath(path,lineColor,False,1dip)";
_cvs.DrawPath(_path,_vvvvvv3,__c.False,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 91;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
 //BA.debugLineNum = 93;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 94;BA.debugLine="cvs.Initialize(Label2)";
_cvs.Initialize(_label2);
 //BA.debugLineNum = 95;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
_cvs.ClearRect(_cvs.getTargetRect());
 //BA.debugLineNum = 96;BA.debugLine="Dim path As B4XPath";
_path = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 97;BA.debugLine="path.Initialize(0,0)";
_path.Initialize((float) (0),(float) (0));
 //BA.debugLineNum = 98;BA.debugLine="path.LineTo(cvs.TargetRect.Width,0)";
_path.LineTo(_cvs.getTargetRect().getWidth(),(float) (0));
 //BA.debugLineNum = 103;BA.debugLine="cvs.DrawPath(path,lineColor,False,1dip)";
_cvs.DrawPath(_path,_vvvvvv3,__c.False,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 104;BA.debugLine="path.Initialize(0,cvs.TargetRect.Height)";
_path.Initialize((float) (0),_cvs.getTargetRect().getHeight());
 //BA.debugLineNum = 105;BA.debugLine="path.LineTo(cvs.TargetRect.Width,cvs.TargetRect.H";
_path.LineTo(_cvs.getTargetRect().getWidth(),_cvs.getTargetRect().getHeight());
 //BA.debugLineNum = 110;BA.debugLine="cvs.DrawPath(path,lineColor,False,1dip)";
_cvs.DrawPath(_path,_vvvvvv3,__c.False,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 111;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
 //BA.debugLineNum = 114;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 115;BA.debugLine="cvs.Initialize(Label3)";
_cvs.Initialize(_label3);
 //BA.debugLineNum = 116;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
_cvs.ClearRect(_cvs.getTargetRect());
 //BA.debugLineNum = 117;BA.debugLine="Dim path As B4XPath";
_path = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 118;BA.debugLine="path.Initialize(0,0)";
_path.Initialize((float) (0),(float) (0));
 //BA.debugLineNum = 119;BA.debugLine="path.LineTo(cvs.TargetRect.Width,0)";
_path.LineTo(_cvs.getTargetRect().getWidth(),(float) (0));
 //BA.debugLineNum = 124;BA.debugLine="cvs.DrawPath(path,lineColor,False,1dip)";
_cvs.DrawPath(_path,_vvvvvv3,__c.False,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 125;BA.debugLine="path.Initialize(0,cvs.TargetRect.Height)";
_path.Initialize((float) (0),_cvs.getTargetRect().getHeight());
 //BA.debugLineNum = 126;BA.debugLine="path.LineTo(cvs.TargetRect.Width,cvs.TargetRect.H";
_path.LineTo(_cvs.getTargetRect().getWidth(),_cvs.getTargetRect().getHeight());
 //BA.debugLineNum = 131;BA.debugLine="cvs.DrawPath(path,lineColor,False,1dip)";
_cvs.DrawPath(_path,_vvvvvv3,__c.False,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 132;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
int _centerindex = 0;
 //BA.debugLineNum = 50;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 54;BA.debugLine="clv1.AsView.SetLayoutAnimated(0,0,0,Width*0.4,Hei";
_clv1._asview().SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width*0.4),(int) (_height));
 //BA.debugLineNum = 55;BA.debugLine="Dim centerIndex As Int = Floor((Height/30dip)/2)";
_centerindex = (int) (__c.Floor((_height/(double)__c.DipToCurrent((int) (30)))/(double)2));
 //BA.debugLineNum = 56;BA.debugLine="centerIndex = centerIndex*30dip + 3dip";
_centerindex = (int) (_centerindex*__c.DipToCurrent((int) (30))+__c.DipToCurrent((int) (3)));
 //BA.debugLineNum = 57;BA.debugLine="Label1.SetLayoutAnimated(0,0,centerIndex,clv1.AsV";
_label1.SetLayoutAnimated((int) (0),(int) (0),_centerindex,_clv1._asview().getWidth(),__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 59;BA.debugLine="clv2.AsView.SetLayoutAnimated(0,clv1.AsView.Left+";
_clv2._asview().SetLayoutAnimated((int) (0),(int) (_clv1._asview().getLeft()+_clv1._asview().getWidth()),(int) (0),(int) (_width*0.25),(int) (_height));
 //BA.debugLineNum = 60;BA.debugLine="Label2.SetLayoutAnimated(0,clv2.AsView.Left,cente";
_label2.SetLayoutAnimated((int) (0),_clv2._asview().getLeft(),_centerindex,_clv2._asview().getWidth(),__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 62;BA.debugLine="clv3.AsView.SetLayoutAnimated(0,clv2.AsView.Left+";
_clv3._asview().SetLayoutAnimated((int) (0),(int) (_clv2._asview().getLeft()+_clv2._asview().getWidth()),(int) (0),(int) (_width*0.35),(int) (_height));
 //BA.debugLineNum = 63;BA.debugLine="Label3.SetLayoutAnimated(0,clv3.AsView.Left,cente";
_label3.SetLayoutAnimated((int) (0),_clv3._asview().getLeft(),_centerindex,_clv3._asview().getWidth(),__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 66;BA.debugLine="applyLineColor";
_vv2();
 //BA.debugLineNum = 69;BA.debugLine="mBase.Color = backgroundColor";
_vvvvv2.setColor(_vvvvvv4);
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private mEventName As String 'ignore";
_vvvv7 = "";
 //BA.debugLineNum = 5;BA.debugLine="Private mCallBack As Object 'ignore";
_vvvv0 = new Object();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI";
_vvvvv1 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 7;BA.debugLine="Private mBase As B4XView";
_vvvvv2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Private minDate,maxDate As Long";
_vvvvv3 = 0L;
_vvvvv4 = 0L;
 //BA.debugLineNum = 9;BA.debugLine="Private clv1,clv2,clv3 As CustomListView";
_clv1 = new b4a.example3.customlistview();
_clv2 = new b4a.example3.customlistview();
_clv3 = new b4a.example3.customlistview();
 //BA.debugLineNum = 10;BA.debugLine="Private Label1,Label2,Label3 As B4XView";
_label1 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_label2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
_label3 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private initValue As Long = DateTime.Now";
_vvvvv5 = __c.DateTime.getNow();
 //BA.debugLineNum = 12;BA.debugLine="Private layoutLoaded As Boolean = False";
_vvvvv6 = __c.False;
 //BA.debugLineNum = 13;BA.debugLine="Private ScrollChangedIndex1,ScrollChangedIndex2,S";
_vvvvv7 = 0;
_vvvvv0 = 0;
_vvvvvv1 = 0;
 //BA.debugLineNum = 14;BA.debugLine="Private xui As XUI 'ignore";
_vvvvv1 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 15;BA.debugLine="Public InactiveDuration As Int = 200";
_vvvvvv2 = (int) (200);
 //BA.debugLineNum = 16;BA.debugLine="Public lineColor As Int = xui.Color_Gray";
_vvvvvv3 = _vvvvv1.Color_Gray;
 //BA.debugLineNum = 17;BA.debugLine="Public backgroundColor As Int = xui.Color_Transpa";
_vvvvvv4 = _vvvvv1.Color_Transparent;
 //BA.debugLineNum = 18;BA.debugLine="Public focusedTextColor As Int = xui.Color_Black";
_vvvvvv5 = _vvvvv1.Color_Black;
 //BA.debugLineNum = 19;BA.debugLine="Public notFocusedTextColor As Int = xui.Color_Gra";
_vvvvvv6 = _vvvvv1.Color_Gray;
 //BA.debugLineNum = 20;BA.debugLine="Public fadeAwayEffect As Boolean = True";
_vvvvvv7 = __c.True;
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _clv1_scrollchanged(int _offset) throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
int _centerindex = 0;
int _visiblepart = 0;
float _m = 0f;
int[] _clr = null;
int _x = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
b4a.example3.customlistview._clvitem _item2 = null;
int _visiblepart2 = 0;
int _visibleitems = 0;
int _alpha = 0;
 //BA.debugLineNum = 349;BA.debugLine="Private Sub clv1_ScrollChanged (Offset As Int)";
 //BA.debugLineNum = 351;BA.debugLine="ScrollChanged1(Offset)";
_vvv3(_offset);
 //BA.debugLineNum = 353;BA.debugLine="Dim i As Int = clv1.FirstVisibleIndex";
_i = _clv1._getfirstvisibleindex();
 //BA.debugLineNum = 354;BA.debugLine="Dim item As CLVItem	 = clv1.GetRawListItem(i)";
_item = _clv1._getrawlistitem(_i);
 //BA.debugLineNum = 355;BA.debugLine="Dim centerIndex As Int = Floor((clv1.sv.Height/it";
_centerindex = (int) (__c.Floor((_clv1._sv.getHeight()/(double)_item.Size)/(double)2));
 //BA.debugLineNum = 356;BA.debugLine="Dim visiblepart As Int =  item.Offset + item.Size";
_visiblepart = (int) (_item.Offset+_item.Size-_offset);
 //BA.debugLineNum = 357;BA.debugLine="If visiblepart / item.Size < 0.5 Then";
if (_visiblepart/(double)_item.Size<0.5) { 
 //BA.debugLineNum = 358;BA.debugLine="i = i+1";
_i = (int) (_i+1);
 };
 //BA.debugLineNum = 361;BA.debugLine="Dim m As Float = (255-80)/(item.Size*1.5-0)";
_m = (float) ((255-80)/(double)(_item.Size*1.5-0));
 //BA.debugLineNum = 362;BA.debugLine="Dim clr() As Int = GetARGB(notFocusedTextColor)";
_clr = _vv3(_vvvvvv6);
 //BA.debugLineNum = 363;BA.debugLine="For x=Max(0,i-1) To Min(i+(clv1.sv.Height/item.Si";
{
final int step11 = 1;
final int limit11 = (int) (__c.Min(_i+(_clv1._sv.getHeight()/(double)_item.Size),_clv1._getsize()-1));
_x = (int) (__c.Max(0,_i-1)) ;
for (;_x <= limit11 ;_x = _x + step11 ) {
 //BA.debugLineNum = 364;BA.debugLine="If clv1.GetValue(x)>-1 Then";
if ((double)(BA.ObjectToNumber(_clv1._getvalue(_x)))>-1) { 
 //BA.debugLineNum = 365;BA.debugLine="If x=i+centerIndex Then";
if (_x==_i+_centerindex) { 
 //BA.debugLineNum = 366;BA.debugLine="Dim lbl As B4XView = clv1.GetPanel(x).GetView(";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _clv1._getpanel(_x).GetView((int) (0));
 //BA.debugLineNum = 367;BA.debugLine="lbl.TextColor = focusedTextColor";
_lbl.setTextColor(_vvvvvv5);
 //BA.debugLineNum = 368;BA.debugLine="lbl.TextSize = 18";
_lbl.setTextSize((float) (18));
 }else {
 //BA.debugLineNum = 370;BA.debugLine="Dim lbl As B4XView = clv1.GetPanel(x).GetView(";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _clv1._getpanel(_x).GetView((int) (0));
 //BA.debugLineNum = 371;BA.debugLine="If fadeAwayEffect Then";
if (_vvvvvv7) { 
 //BA.debugLineNum = 372;BA.debugLine="Dim item2 As CLVItem	 = clv1.GetRawListItem(x";
_item2 = _clv1._getrawlistitem(_x);
 //BA.debugLineNum = 373;BA.debugLine="Dim visiblepart2 As Int =  item2.Offset  - Of";
_visiblepart2 = (int) (_item2.Offset-_offset);
 //BA.debugLineNum = 374;BA.debugLine="Dim visibleItems As Int = Floor(clv1.sv.Heigh";
_visibleitems = (int) (__c.Floor(_clv1._sv.getHeight()/(double)_item.Size));
 //BA.debugLineNum = 376;BA.debugLine="If x > i+centerIndex Then";
if (_x>_i+_centerindex) { 
 //BA.debugLineNum = 377;BA.debugLine="visiblepart2 = visibleItems*item2.Size - vis";
_visiblepart2 = (int) (_visibleitems*_item2.Size-_visiblepart2-_item2.Size);
 };
 //BA.debugLineNum = 379;BA.debugLine="visiblepart2 = Min(Max(visiblepart2,0),visibl";
_visiblepart2 = (int) (__c.Min(__c.Max(_visiblepart2,0),_visibleitems*_item2.Size+1));
 //BA.debugLineNum = 382;BA.debugLine="Dim alpha As Int = m*visiblepart2 + 80";
_alpha = (int) (_m*_visiblepart2+80);
 //BA.debugLineNum = 384;BA.debugLine="lbl.TextColor = xui.Color_ARGB(alpha,clr(0),c";
_lbl.setTextColor(_vvvvv1.Color_ARGB(_alpha,_clr[(int) (0)],_clr[(int) (1)],_clr[(int) (2)]));
 }else {
 //BA.debugLineNum = 386;BA.debugLine="lbl.TextColor = notFocusedTextColor";
_lbl.setTextColor(_vvvvvv6);
 };
 //BA.debugLineNum = 388;BA.debugLine="lbl.TextSize = 12";
_lbl.setTextSize((float) (12));
 };
 };
 }
};
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return "";
}
public String  _clv2_scrollchanged(int _offset) throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
int _centerindex = 0;
int _visiblepart = 0;
float _m = 0f;
int[] _clr = null;
int _x = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
b4a.example3.customlistview._clvitem _item2 = null;
int _visiblepart2 = 0;
int _visibleitems = 0;
int _alpha = 0;
 //BA.debugLineNum = 394;BA.debugLine="private Sub clv2_ScrollChanged (Offset As Int)";
 //BA.debugLineNum = 395;BA.debugLine="ScrollChanged2(Offset)";
_vvv4(_offset);
 //BA.debugLineNum = 396;BA.debugLine="Dim i As Int = clv2.FirstVisibleIndex";
_i = _clv2._getfirstvisibleindex();
 //BA.debugLineNum = 397;BA.debugLine="Dim item As CLVItem	 = clv2.GetRawListItem(i)";
_item = _clv2._getrawlistitem(_i);
 //BA.debugLineNum = 398;BA.debugLine="Dim centerIndex As Int = Floor((clv2.sv.Height/it";
_centerindex = (int) (__c.Floor((_clv2._sv.getHeight()/(double)_item.Size)/(double)2));
 //BA.debugLineNum = 399;BA.debugLine="Dim visiblepart As Int =  item.Offset + item.Size";
_visiblepart = (int) (_item.Offset+_item.Size-_offset);
 //BA.debugLineNum = 400;BA.debugLine="If visiblepart / item.Size < 0.5 Then";
if (_visiblepart/(double)_item.Size<0.5) { 
 //BA.debugLineNum = 401;BA.debugLine="i = i+1";
_i = (int) (_i+1);
 };
 //BA.debugLineNum = 404;BA.debugLine="Dim m As Float = (255-80)/(item.Size*1.5-0)";
_m = (float) ((255-80)/(double)(_item.Size*1.5-0));
 //BA.debugLineNum = 405;BA.debugLine="Dim clr() As Int = GetARGB(notFocusedTextColor)";
_clr = _vv3(_vvvvvv6);
 //BA.debugLineNum = 406;BA.debugLine="For x=Max(0,i-1) To Min(i+(clv2.sv.Height/item.Si";
{
final int step11 = 1;
final int limit11 = (int) (__c.Min(_i+(_clv2._sv.getHeight()/(double)_item.Size),_clv2._getsize()-1));
_x = (int) (__c.Max(0,_i-1)) ;
for (;_x <= limit11 ;_x = _x + step11 ) {
 //BA.debugLineNum = 407;BA.debugLine="If clv2.GetValue(x)>-1 Then";
if ((double)(BA.ObjectToNumber(_clv2._getvalue(_x)))>-1) { 
 //BA.debugLineNum = 408;BA.debugLine="If x=i+centerIndex Then";
if (_x==_i+_centerindex) { 
 //BA.debugLineNum = 409;BA.debugLine="Dim lbl As B4XView = clv2.GetPanel(x).GetView(";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _clv2._getpanel(_x).GetView((int) (0));
 //BA.debugLineNum = 410;BA.debugLine="lbl.TextColor = focusedTextColor";
_lbl.setTextColor(_vvvvvv5);
 //BA.debugLineNum = 411;BA.debugLine="lbl.TextSize = 18";
_lbl.setTextSize((float) (18));
 }else {
 //BA.debugLineNum = 413;BA.debugLine="Dim lbl As B4XView = clv2.GetPanel(x).GetView(";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _clv2._getpanel(_x).GetView((int) (0));
 //BA.debugLineNum = 414;BA.debugLine="If fadeAwayEffect Then";
if (_vvvvvv7) { 
 //BA.debugLineNum = 415;BA.debugLine="Dim item2 As CLVItem	 = clv2.GetRawListItem(x";
_item2 = _clv2._getrawlistitem(_x);
 //BA.debugLineNum = 416;BA.debugLine="Dim visiblepart2 As Int =  item2.Offset  - Of";
_visiblepart2 = (int) (_item2.Offset-_offset);
 //BA.debugLineNum = 417;BA.debugLine="Dim visibleItems As Int = Floor(clv2.sv.Heigh";
_visibleitems = (int) (__c.Floor(_clv2._sv.getHeight()/(double)_item.Size));
 //BA.debugLineNum = 419;BA.debugLine="If x > i+centerIndex Then";
if (_x>_i+_centerindex) { 
 //BA.debugLineNum = 420;BA.debugLine="visiblepart2 = visibleItems*item2.Size - vis";
_visiblepart2 = (int) (_visibleitems*_item2.Size-_visiblepart2-_item2.Size);
 };
 //BA.debugLineNum = 422;BA.debugLine="visiblepart2 = Min(Max(visiblepart2,0),visibl";
_visiblepart2 = (int) (__c.Min(__c.Max(_visiblepart2,0),_visibleitems*_item2.Size+1));
 //BA.debugLineNum = 424;BA.debugLine="Dim alpha As Int = m*visiblepart2 + 80";
_alpha = (int) (_m*_visiblepart2+80);
 //BA.debugLineNum = 426;BA.debugLine="lbl.TextColor = xui.Color_ARGB(alpha,clr(0),c";
_lbl.setTextColor(_vvvvv1.Color_ARGB(_alpha,_clr[(int) (0)],_clr[(int) (1)],_clr[(int) (2)]));
 }else {
 //BA.debugLineNum = 428;BA.debugLine="lbl.TextColor = notFocusedTextColor";
_lbl.setTextColor(_vvvvvv6);
 };
 //BA.debugLineNum = 430;BA.debugLine="lbl.TextSize = 12";
_lbl.setTextSize((float) (12));
 };
 };
 }
};
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return "";
}
public String  _clv3_scrollchanged(int _offset) throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
int _centerindex = 0;
int _visiblepart = 0;
float _m = 0f;
int[] _clr = null;
int _x = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
b4a.example3.customlistview._clvitem _item2 = null;
int _visiblepart2 = 0;
int _visibleitems = 0;
int _alpha = 0;
 //BA.debugLineNum = 436;BA.debugLine="Private Sub clv3_ScrollChanged (Offset As Int)";
 //BA.debugLineNum = 437;BA.debugLine="ScrollChanged3(Offset)";
_vvv5(_offset);
 //BA.debugLineNum = 438;BA.debugLine="Dim i As Int = clv3.FirstVisibleIndex";
_i = _clv3._getfirstvisibleindex();
 //BA.debugLineNum = 439;BA.debugLine="Dim item As CLVItem	 = clv3.GetRawListItem(i)";
_item = _clv3._getrawlistitem(_i);
 //BA.debugLineNum = 440;BA.debugLine="Dim centerIndex As Int = Floor((clv3.sv.Height/it";
_centerindex = (int) (__c.Floor((_clv3._sv.getHeight()/(double)_item.Size)/(double)2));
 //BA.debugLineNum = 441;BA.debugLine="Dim visiblepart As Int =  item.Offset + item.Size";
_visiblepart = (int) (_item.Offset+_item.Size-_offset);
 //BA.debugLineNum = 442;BA.debugLine="If visiblepart / item.Size < 0.5 Then";
if (_visiblepart/(double)_item.Size<0.5) { 
 //BA.debugLineNum = 443;BA.debugLine="i = i+1";
_i = (int) (_i+1);
 };
 //BA.debugLineNum = 446;BA.debugLine="Dim m As Float = (255-80)/(item.Size*1.5-0)";
_m = (float) ((255-80)/(double)(_item.Size*1.5-0));
 //BA.debugLineNum = 447;BA.debugLine="Dim clr() As Int = GetARGB(notFocusedTextColor)";
_clr = _vv3(_vvvvvv6);
 //BA.debugLineNum = 448;BA.debugLine="For x=Max(0,i-1) To Min(i+(clv3.sv.Height/item.Si";
{
final int step11 = 1;
final int limit11 = (int) (__c.Min(_i+(_clv3._sv.getHeight()/(double)_item.Size),_clv3._getsize()-1));
_x = (int) (__c.Max(0,_i-1)) ;
for (;_x <= limit11 ;_x = _x + step11 ) {
 //BA.debugLineNum = 449;BA.debugLine="If clv3.GetValue(x)>-1 Then";
if ((double)(BA.ObjectToNumber(_clv3._getvalue(_x)))>-1) { 
 //BA.debugLineNum = 450;BA.debugLine="If x=i+centerIndex Then";
if (_x==_i+_centerindex) { 
 //BA.debugLineNum = 451;BA.debugLine="Dim lbl As B4XView = clv3.GetPanel(x).GetView(";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _clv3._getpanel(_x).GetView((int) (0));
 //BA.debugLineNum = 452;BA.debugLine="lbl.TextColor = focusedTextColor";
_lbl.setTextColor(_vvvvvv5);
 //BA.debugLineNum = 453;BA.debugLine="lbl.TextSize = 18";
_lbl.setTextSize((float) (18));
 }else {
 //BA.debugLineNum = 455;BA.debugLine="Dim lbl As B4XView = clv3.GetPanel(x).GetView(";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _clv3._getpanel(_x).GetView((int) (0));
 //BA.debugLineNum = 456;BA.debugLine="If fadeAwayEffect Then";
if (_vvvvvv7) { 
 //BA.debugLineNum = 457;BA.debugLine="Dim item2 As CLVItem	 = clv3.GetRawListItem(x";
_item2 = _clv3._getrawlistitem(_x);
 //BA.debugLineNum = 458;BA.debugLine="Dim visiblepart2 As Int =  item2.Offset  - Of";
_visiblepart2 = (int) (_item2.Offset-_offset);
 //BA.debugLineNum = 459;BA.debugLine="Dim visibleItems As Int = Floor(clv3.sv.Heigh";
_visibleitems = (int) (__c.Floor(_clv3._sv.getHeight()/(double)_item.Size));
 //BA.debugLineNum = 461;BA.debugLine="If x > i+centerIndex Then";
if (_x>_i+_centerindex) { 
 //BA.debugLineNum = 462;BA.debugLine="visiblepart2 = visibleItems*item2.Size - vis";
_visiblepart2 = (int) (_visibleitems*_item2.Size-_visiblepart2-_item2.Size);
 };
 //BA.debugLineNum = 464;BA.debugLine="visiblepart2 = Min(Max(visiblepart2,0),visibl";
_visiblepart2 = (int) (__c.Min(__c.Max(_visiblepart2,0),_visibleitems*_item2.Size+1));
 //BA.debugLineNum = 466;BA.debugLine="Dim alpha As Int = m*visiblepart2 + 80";
_alpha = (int) (_m*_visiblepart2+80);
 //BA.debugLineNum = 468;BA.debugLine="lbl.TextColor = xui.Color_ARGB(alpha,clr(0),c";
_lbl.setTextColor(_vvvvv1.Color_ARGB(_alpha,_clr[(int) (0)],_clr[(int) (1)],_clr[(int) (2)]));
 }else {
 //BA.debugLineNum = 470;BA.debugLine="lbl.TextColor = notFocusedTextColor";
_lbl.setTextColor(_vvvvvv6);
 };
 //BA.debugLineNum = 472;BA.debugLine="lbl.TextSize = 12";
_lbl.setTextSize((float) (12));
 };
 };
 }
};
 //BA.debugLineNum = 476;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Public Sub DesignerCreateView (Base As Object, lbl";
 //BA.debugLineNum = 29;BA.debugLine="mBase = Base";
_vvvvv2 = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
 //BA.debugLineNum = 30;BA.debugLine="mBase.Tag = Me";
_vvvvv2.setTag(this);
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public int[]  _vv3(int _color) throws Exception{
int[] _res = null;
 //BA.debugLineNum = 631;BA.debugLine="Private Sub GetARGB(Color As Int) As Int()";
 //BA.debugLineNum = 632;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
 //BA.debugLineNum = 633;BA.debugLine="res(3) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (3)] = __c.Bit.UnsignedShiftRight(__c.Bit.And(_color,((int)0xff000000)),(int) (24));
 //BA.debugLineNum = 634;BA.debugLine="res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (2)] = __c.Bit.UnsignedShiftRight(__c.Bit.And(_color,((int)0xff0000)),(int) (16));
 //BA.debugLineNum = 635;BA.debugLine="res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (1)] = __c.Bit.UnsignedShiftRight(__c.Bit.And(_color,((int)0xff00)),(int) (8));
 //BA.debugLineNum = 636;BA.debugLine="res(0) = Bit.And(Color, 0xff)";
_res[(int) (0)] = __c.Bit.And(_color,((int)0xff));
 //BA.debugLineNum = 637;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 638;BA.debugLine="End Sub";
return null;
}
public long  _getvvvv5() throws Exception{
long _date = 0L;
int _hour = 0;
int _minute = 0;
long _parsed = 0L;
 //BA.debugLineNum = 296;BA.debugLine="Public Sub getSelected As Long";
 //BA.debugLineNum = 297;BA.debugLine="If layoutLoaded = False Then Return -1";
if (_vvvvv6==__c.False) { 
if (true) return (long) (-1);};
 //BA.debugLineNum = 299;BA.debugLine="Dim date As Long = clv1.GetValue(clv1.FirstVisibl";
_date = BA.ObjectToLongNumber(_clv1._getvalue((int) (_clv1._getfirstvisibleindex()+_vv6())));
 //BA.debugLineNum = 300;BA.debugLine="If date < 0 Then";
if (_date<0) { 
 //BA.debugLineNum = 301;BA.debugLine="If clv1.FirstVisibleIndex+halfIndex2 > 5 Then";
if (_clv1._getfirstvisibleindex()+_vv7()>5) { 
 //BA.debugLineNum = 302;BA.debugLine="date = clv1.GetValue(clv1.Size-6)";
_date = BA.ObjectToLongNumber(_clv1._getvalue((int) (_clv1._getsize()-6)));
 }else {
 //BA.debugLineNum = 304;BA.debugLine="date = clv1.GetValue(5)";
_date = BA.ObjectToLongNumber(_clv1._getvalue((int) (5)));
 };
 };
 //BA.debugLineNum = 307;BA.debugLine="Dim hour As Int = clv2.GetValue(clv2.FirstVisible";
_hour = (int)(BA.ObjectToNumber(_clv2._getvalue((int) (_clv2._getfirstvisibleindex()+_vv7()))));
 //BA.debugLineNum = 308;BA.debugLine="If hour < 0 Then";
if (_hour<0) { 
 //BA.debugLineNum = 309;BA.debugLine="If clv2.FirstVisibleIndex+halfIndex2 > 5 Then";
if (_clv2._getfirstvisibleindex()+_vv7()>5) { 
 //BA.debugLineNum = 310;BA.debugLine="hour = clv2.GetValue(clv2.Size-6)";
_hour = (int)(BA.ObjectToNumber(_clv2._getvalue((int) (_clv2._getsize()-6))));
 }else {
 //BA.debugLineNum = 312;BA.debugLine="hour = clv2.GetValue(5)";
_hour = (int)(BA.ObjectToNumber(_clv2._getvalue((int) (5))));
 };
 };
 //BA.debugLineNum = 315;BA.debugLine="Dim minute As Int = clv3.GetValue(clv3.FirstVisib";
_minute = (int)(BA.ObjectToNumber(_clv3._getvalue((int) (_clv3._getfirstvisibleindex()+_vv0()))));
 //BA.debugLineNum = 316;BA.debugLine="If minute < 0 Then";
if (_minute<0) { 
 //BA.debugLineNum = 317;BA.debugLine="If clv3.FirstVisibleIndex+halfIndex2 > 5 Then";
if (_clv3._getfirstvisibleindex()+_vv7()>5) { 
 //BA.debugLineNum = 318;BA.debugLine="minute = clv3.GetValue(clv3.Size-6)";
_minute = (int)(BA.ObjectToNumber(_clv3._getvalue((int) (_clv3._getsize()-6))));
 }else {
 //BA.debugLineNum = 320;BA.debugLine="minute = clv3.GetValue(5)";
_minute = (int)(BA.ObjectToNumber(_clv3._getvalue((int) (5))));
 };
 };
 //BA.debugLineNum = 323;BA.debugLine="DateTime.DateFormat = \"MM/dd/yyyy HH:mm\"";
__c.DateTime.setDateFormat("MM/dd/yyyy HH:mm");
 //BA.debugLineNum = 324;BA.debugLine="Dim parsed As Long = DateTime.DateParse($\"${DateT";
_parsed = __c.DateTime.DateParse((""+__c.SmartStringFormatter("",(Object)(__c.DateTime.GetMonth(_date)))+"/"+__c.SmartStringFormatter("",(Object)(__c.DateTime.GetDayOfMonth(_date)))+"/"+__c.SmartStringFormatter("",(Object)(__c.DateTime.GetYear(_date)))+" "+__c.SmartStringFormatter("",(Object)(_hour))+":"+__c.SmartStringFormatter("",(Object)(_minute))+""));
 //BA.debugLineNum = 325;BA.debugLine="DateTime.DateFormat = DateTime.DeviceDefaultDateF";
__c.DateTime.setDateFormat(__c.DateTime.getDeviceDefaultDateFormat());
 //BA.debugLineNum = 326;BA.debugLine="Return parsed";
if (true) return _parsed;
 //BA.debugLineNum = 330;BA.debugLine="End Sub";
return 0L;
}
public anywheresoftware.b4a.objects.collections.List  _getvvvv6() throws Exception{
anywheresoftware.b4a.objects.collections.List _response = null;
String _valueclv1 = "";
String _valueclv2 = "";
String _valueclv3 = "";
 //BA.debugLineNum = 333;BA.debugLine="Public Sub getSelectedRawValues As List";
 //BA.debugLineNum = 334;BA.debugLine="Dim response As List";
_response = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 335;BA.debugLine="response.Initialize";
_response.Initialize();
 //BA.debugLineNum = 336;BA.debugLine="If layoutLoaded = False Then Return response";
if (_vvvvv6==__c.False) { 
if (true) return _response;};
 //BA.debugLineNum = 338;BA.debugLine="Dim valueClv1 As String = clv1.GetPanel(clv1.Firs";
_valueclv1 = _clv1._getpanel((int) (_clv1._getfirstvisibleindex()+_vv6())).GetView((int) (0)).getText();
 //BA.debugLineNum = 339;BA.debugLine="Dim valueClv2 As String = clv2.GetPanel(clv2.Firs";
_valueclv2 = _clv2._getpanel((int) (_clv2._getfirstvisibleindex()+_vv7())).GetView((int) (0)).getText();
 //BA.debugLineNum = 340;BA.debugLine="Dim valueClv3 As String = clv3.GetPanel(clv3.Firs";
_valueclv3 = _clv3._getpanel((int) (_clv3._getfirstvisibleindex()+_vv0())).GetView((int) (0)).getText();
 //BA.debugLineNum = 342;BA.debugLine="response.Add(valueClv1)";
_response.Add((Object)(_valueclv1));
 //BA.debugLineNum = 343;BA.debugLine="response.Add(valueClv2)";
_response.Add((Object)(_valueclv2));
 //BA.debugLineNum = 344;BA.debugLine="response.Add(valueClv3)";
_response.Add((Object)(_valueclv3));
 //BA.debugLineNum = 346;BA.debugLine="Return response";
if (true) return _response;
 //BA.debugLineNum = 347;BA.debugLine="End Sub";
return null;
}
public int  _vv6() throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
 //BA.debugLineNum = 488;BA.debugLine="Private Sub halfIndex1 As Int";
 //BA.debugLineNum = 489;BA.debugLine="Dim i As Int = clv1.FirstVisibleIndex";
_i = _clv1._getfirstvisibleindex();
 //BA.debugLineNum = 490;BA.debugLine="Dim item As CLVItem	 = clv1.GetRawListItem(i)";
_item = _clv1._getrawlistitem(_i);
 //BA.debugLineNum = 491;BA.debugLine="Return Floor((clv1.sv.Height/item.Size)/2)";
if (true) return (int) (__c.Floor((_clv1._sv.getHeight()/(double)_item.Size)/(double)2));
 //BA.debugLineNum = 492;BA.debugLine="End Sub";
return 0;
}
public int  _vv7() throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
 //BA.debugLineNum = 538;BA.debugLine="Private Sub halfIndex2 As Int";
 //BA.debugLineNum = 539;BA.debugLine="Dim i As Int = clv2.FirstVisibleIndex";
_i = _clv2._getfirstvisibleindex();
 //BA.debugLineNum = 540;BA.debugLine="Dim item As CLVItem	 = clv2.GetRawListItem(i)";
_item = _clv2._getrawlistitem(_i);
 //BA.debugLineNum = 541;BA.debugLine="Return Floor((clv2.sv.Height/item.Size)/2)";
if (true) return (int) (__c.Floor((_clv2._sv.getHeight()/(double)_item.Size)/(double)2));
 //BA.debugLineNum = 542;BA.debugLine="End Sub";
return 0;
}
public int  _vv0() throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
 //BA.debugLineNum = 588;BA.debugLine="Private Sub halfIndex3 As Int";
 //BA.debugLineNum = 589;BA.debugLine="Dim i As Int = clv3.FirstVisibleIndex";
_i = _clv3._getfirstvisibleindex();
 //BA.debugLineNum = 590;BA.debugLine="Dim item As CLVItem	 = clv3.GetRawListItem(i)";
_item = _clv3._getrawlistitem(_i);
 //BA.debugLineNum = 591;BA.debugLine="Return Floor((clv3.sv.Height/item.Size)/2)";
if (true) return (int) (__c.Floor((_clv3._sv.getHeight()/(double)_item.Size)/(double)2));
 //BA.debugLineNum = 592;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 23;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 24;BA.debugLine="mEventName = EventName";
_vvvv7 = _eventname;
 //BA.debugLineNum = 25;BA.debugLine="mCallBack = Callback";
_vvvv0 = _callback;
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public String  _vvv1() throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Private Sub load";
 //BA.debugLineNum = 35;BA.debugLine="mBase.LoadLayout(\"datetimelayout\")";
_vvvvv2.LoadLayout("datetimelayout",ba);
 //BA.debugLineNum = 36;BA.debugLine="layoutLoaded = True";
_vvvvv6 = __c.True;
 //BA.debugLineNum = 37;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_vvvvv2.getWidth(),_vvvvv2.getHeight());
 //BA.debugLineNum = 38;BA.debugLine="clv1.AsView.Color = backgroundColor";
_clv1._asview().setColor(_vvvvvv4);
 //BA.debugLineNum = 39;BA.debugLine="clv2.AsView.Color = backgroundColor";
_clv2._asview().setColor(_vvvvvv4);
 //BA.debugLineNum = 40;BA.debugLine="clv3.AsView.Color = backgroundColor";
_clv3._asview().setColor(_vvvvvv4);
 //BA.debugLineNum = 41;BA.debugLine="clv1.sv.Color = backgroundColor";
_clv1._sv.setColor(_vvvvvv4);
 //BA.debugLineNum = 42;BA.debugLine="clv2.sv.Color = backgroundColor";
_clv2._sv.setColor(_vvvvvv4);
 //BA.debugLineNum = 43;BA.debugLine="clv3.sv.Color = backgroundColor";
_clv3._sv.setColor(_vvvvvv4);
 //BA.debugLineNum = 44;BA.debugLine="mBase.Color = backgroundColor";
_vvvvv2.setColor(_vvvvvv4);
 //BA.debugLineNum = 45;BA.debugLine="If mBase.Height < 150dip Then";
if (_vvvvv2.getHeight()<__c.DipToCurrent((int) (150))) { 
 //BA.debugLineNum = 46;BA.debugLine="Log(\"DateTimePicker suggested view height is 150";
__c.LogImpl("51769484","DateTimePicker suggested view height is 150dip",0);
 };
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public void  _vvv2() throws Exception{
ResumableSub_MoveToInitValues rsub = new ResumableSub_MoveToInitValues(this);
rsub.resume(ba, null);
}
public static class ResumableSub_MoveToInitValues extends BA.ResumableSub {
public ResumableSub_MoveToInitValues(b4a.pro.datetimepicker parent) {
this.parent = parent;
}
b4a.pro.datetimepicker parent;
int _i = 0;
int step2;
int limit2;
int step17;
int limit17;
int step32;
int limit32;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 247;BA.debugLine="Sleep(0)";
parent.__c.Sleep(ba,this,(int) (0));
this.state = 56;
return;
case 56:
//C
this.state = 1;
;
 //BA.debugLineNum = 248;BA.debugLine="For i=0 To clv1.Size-1";
if (true) break;

case 1:
//for
this.state = 19;
step2 = 1;
limit2 = (int) (parent._clv1._getsize()-1);
_i = (int) (0) ;
this.state = 57;
if (true) break;

case 57:
//C
this.state = 19;
if ((step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2)) this.state = 3;
if (true) break;

case 58:
//C
this.state = 57;
_i = ((int)(0 + _i + step2)) ;
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 249;BA.debugLine="If i+halfIndex1 > clv1.Size-1 Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_i+parent._vv6()>parent._clv1._getsize()-1) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 250;BA.debugLine="ScrollChanged1(0)";
parent._vvv3((int) (0));
 //BA.debugLineNum = 251;BA.debugLine="Exit";
this.state = 19;
if (true) break;
 if (true) break;
;
 //BA.debugLineNum = 253;BA.debugLine="If clv1.GetValue(i+halfIndex1) > -1 Then";

case 7:
//if
this.state = 18;
if ((double)(BA.ObjectToNumber(parent._clv1._getvalue((int) (_i+parent._vv6()))))>-1) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 254;BA.debugLine="If Abs(clv1.GetValue(i+halfIndex1) - initValue)";
if (true) break;

case 10:
//if
this.state = 17;
if (parent.__c.Abs((double)(BA.ObjectToNumber(parent._clv1._getvalue((int) (_i+parent._vv6()))))-parent._vvvvv5)<parent.__c.DateTime.TicksPerDay) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 255;BA.debugLine="If i = clv1.FirstVisibleIndex Then";
if (true) break;

case 13:
//if
this.state = 16;
if (_i==parent._clv1._getfirstvisibleindex()) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 256;BA.debugLine="clv1_ScrollChanged(clv1.sv.ScrollViewOffsetY)";
parent._clv1_scrollchanged(parent._clv1._sv.getScrollViewOffsetY());
 if (true) break;

case 16:
//C
this.state = 17;
;
 //BA.debugLineNum = 258;BA.debugLine="clv1.ScrollToItem(i)";
parent._clv1._scrolltoitem(_i);
 //BA.debugLineNum = 259;BA.debugLine="Exit";
this.state = 19;
if (true) break;
 if (true) break;

case 17:
//C
this.state = 18;
;
 if (true) break;

case 18:
//C
this.state = 58;
;
 if (true) break;
if (true) break;
;
 //BA.debugLineNum = 263;BA.debugLine="For i=0 To clv2.Size-1";

case 19:
//for
this.state = 37;
step17 = 1;
limit17 = (int) (parent._clv2._getsize()-1);
_i = (int) (0) ;
this.state = 59;
if (true) break;

case 59:
//C
this.state = 37;
if ((step17 > 0 && _i <= limit17) || (step17 < 0 && _i >= limit17)) this.state = 21;
if (true) break;

case 60:
//C
this.state = 59;
_i = ((int)(0 + _i + step17)) ;
if (true) break;

case 21:
//C
this.state = 22;
 //BA.debugLineNum = 264;BA.debugLine="If i+halfIndex2 > clv2.Size-1 Then";
if (true) break;

case 22:
//if
this.state = 25;
if (_i+parent._vv7()>parent._clv2._getsize()-1) { 
this.state = 24;
}if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 265;BA.debugLine="ScrollChanged2(0)";
parent._vvv4((int) (0));
 //BA.debugLineNum = 266;BA.debugLine="Exit";
this.state = 37;
if (true) break;
 if (true) break;
;
 //BA.debugLineNum = 268;BA.debugLine="If clv2.GetValue(i+halfIndex2) > -1 Then";

case 25:
//if
this.state = 36;
if ((double)(BA.ObjectToNumber(parent._clv2._getvalue((int) (_i+parent._vv7()))))>-1) { 
this.state = 27;
}if (true) break;

case 27:
//C
this.state = 28;
 //BA.debugLineNum = 269;BA.debugLine="If DateTime.GetHour(initValue) = clv2.GetValue(";
if (true) break;

case 28:
//if
this.state = 35;
if (parent.__c.DateTime.GetHour(parent._vvvvv5)==(double)(BA.ObjectToNumber(parent._clv2._getvalue((int) (_i+parent._vv7()))))) { 
this.state = 30;
}if (true) break;

case 30:
//C
this.state = 31;
 //BA.debugLineNum = 270;BA.debugLine="If i = clv2.FirstVisibleIndex Then";
if (true) break;

case 31:
//if
this.state = 34;
if (_i==parent._clv2._getfirstvisibleindex()) { 
this.state = 33;
}if (true) break;

case 33:
//C
this.state = 34;
 //BA.debugLineNum = 271;BA.debugLine="clv2_ScrollChanged(clv2.sv.ScrollViewOffsetY)";
parent._clv2_scrollchanged(parent._clv2._sv.getScrollViewOffsetY());
 if (true) break;

case 34:
//C
this.state = 35;
;
 //BA.debugLineNum = 273;BA.debugLine="clv2.ScrollToItem(i)";
parent._clv2._scrolltoitem(_i);
 //BA.debugLineNum = 274;BA.debugLine="Exit";
this.state = 37;
if (true) break;
 if (true) break;

case 35:
//C
this.state = 36;
;
 if (true) break;

case 36:
//C
this.state = 60;
;
 if (true) break;
if (true) break;
;
 //BA.debugLineNum = 278;BA.debugLine="For i=0 To clv3.Size-1";

case 37:
//for
this.state = 55;
step32 = 1;
limit32 = (int) (parent._clv3._getsize()-1);
_i = (int) (0) ;
this.state = 61;
if (true) break;

case 61:
//C
this.state = 55;
if ((step32 > 0 && _i <= limit32) || (step32 < 0 && _i >= limit32)) this.state = 39;
if (true) break;

case 62:
//C
this.state = 61;
_i = ((int)(0 + _i + step32)) ;
if (true) break;

case 39:
//C
this.state = 40;
 //BA.debugLineNum = 279;BA.debugLine="If i+halfIndex3 > clv3.Size-1 Then";
if (true) break;

case 40:
//if
this.state = 43;
if (_i+parent._vv0()>parent._clv3._getsize()-1) { 
this.state = 42;
}if (true) break;

case 42:
//C
this.state = 43;
 //BA.debugLineNum = 280;BA.debugLine="ScrollChanged3(0)";
parent._vvv5((int) (0));
 //BA.debugLineNum = 281;BA.debugLine="Exit";
this.state = 55;
if (true) break;
 if (true) break;
;
 //BA.debugLineNum = 283;BA.debugLine="If clv3.GetValue(i+halfIndex3) > -1 Then";

case 43:
//if
this.state = 54;
if ((double)(BA.ObjectToNumber(parent._clv3._getvalue((int) (_i+parent._vv0()))))>-1) { 
this.state = 45;
}if (true) break;

case 45:
//C
this.state = 46;
 //BA.debugLineNum = 284;BA.debugLine="If DateTime.GetMinute(initValue) = clv3.GetValu";
if (true) break;

case 46:
//if
this.state = 53;
if (parent.__c.DateTime.GetMinute(parent._vvvvv5)==(double)(BA.ObjectToNumber(parent._clv3._getvalue((int) (_i+parent._vv0()))))) { 
this.state = 48;
}if (true) break;

case 48:
//C
this.state = 49;
 //BA.debugLineNum = 285;BA.debugLine="If i = clv3.FirstVisibleIndex Then";
if (true) break;

case 49:
//if
this.state = 52;
if (_i==parent._clv3._getfirstvisibleindex()) { 
this.state = 51;
}if (true) break;

case 51:
//C
this.state = 52;
 //BA.debugLineNum = 286;BA.debugLine="clv3_ScrollChanged(clv3.sv.ScrollViewOffsetY)";
parent._clv3_scrollchanged(parent._clv3._sv.getScrollViewOffsetY());
 if (true) break;

case 52:
//C
this.state = 53;
;
 //BA.debugLineNum = 288;BA.debugLine="clv3.ScrollToItem(i)";
parent._clv3._scrolltoitem(_i);
 //BA.debugLineNum = 289;BA.debugLine="Exit";
this.state = 55;
if (true) break;
 if (true) break;

case 53:
//C
this.state = 54;
;
 if (true) break;

case 54:
//C
this.state = 62;
;
 if (true) break;
if (true) break;

case 55:
//C
this.state = -1;
;
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _vvv3(int _offset) throws Exception{
ResumableSub_ScrollChanged1 rsub = new ResumableSub_ScrollChanged1(this,_offset);
rsub.resume(ba, null);
}
public static class ResumableSub_ScrollChanged1 extends BA.ResumableSub {
public ResumableSub_ScrollChanged1(b4a.pro.datetimepicker parent,int _offset) {
this.parent = parent;
this._offset = _offset;
}
b4a.pro.datetimepicker parent;
int _offset;
int _myindex = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 481;BA.debugLine="ScrollChangedIndex1 = ScrollChangedIndex1 + 1";
parent._vvvvv7 = (int) (parent._vvvvv7+1);
 //BA.debugLineNum = 482;BA.debugLine="Dim MyIndex As Int = ScrollChangedIndex1";
_myindex = parent._vvvvv7;
 //BA.debugLineNum = 483;BA.debugLine="Sleep(InactiveDuration)";
parent.__c.Sleep(ba,this,parent._vvvvvv2);
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 //BA.debugLineNum = 484;BA.debugLine="If ScrollChangedIndex1 = MyIndex Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._vvvvv7==_myindex) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 485;BA.debugLine="SnapCLV1(Offset)";
parent._vvvv2(_offset);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 487;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _vvv4(int _offset) throws Exception{
ResumableSub_ScrollChanged2 rsub = new ResumableSub_ScrollChanged2(this,_offset);
rsub.resume(ba, null);
}
public static class ResumableSub_ScrollChanged2 extends BA.ResumableSub {
public ResumableSub_ScrollChanged2(b4a.pro.datetimepicker parent,int _offset) {
this.parent = parent;
this._offset = _offset;
}
b4a.pro.datetimepicker parent;
int _offset;
int _myindex = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 531;BA.debugLine="ScrollChangedIndex2 = ScrollChangedIndex2 + 1";
parent._vvvvv0 = (int) (parent._vvvvv0+1);
 //BA.debugLineNum = 532;BA.debugLine="Dim MyIndex As Int = ScrollChangedIndex2";
_myindex = parent._vvvvv0;
 //BA.debugLineNum = 533;BA.debugLine="Sleep(InactiveDuration)";
parent.__c.Sleep(ba,this,parent._vvvvvv2);
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 //BA.debugLineNum = 534;BA.debugLine="If ScrollChangedIndex2 = MyIndex Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._vvvvv0==_myindex) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 535;BA.debugLine="SnapCLV2(Offset)";
parent._vvvv3(_offset);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 537;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _vvv5(int _offset) throws Exception{
ResumableSub_ScrollChanged3 rsub = new ResumableSub_ScrollChanged3(this,_offset);
rsub.resume(ba, null);
}
public static class ResumableSub_ScrollChanged3 extends BA.ResumableSub {
public ResumableSub_ScrollChanged3(b4a.pro.datetimepicker parent,int _offset) {
this.parent = parent;
this._offset = _offset;
}
b4a.pro.datetimepicker parent;
int _offset;
int _myindex = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 581;BA.debugLine="ScrollChangedIndex3 = ScrollChangedIndex3 + 1";
parent._vvvvvv1 = (int) (parent._vvvvvv1+1);
 //BA.debugLineNum = 582;BA.debugLine="Dim MyIndex As Int = ScrollChangedIndex3";
_myindex = parent._vvvvvv1;
 //BA.debugLineNum = 583;BA.debugLine="Sleep(InactiveDuration)";
parent.__c.Sleep(ba,this,parent._vvvvvv2);
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 //BA.debugLineNum = 584;BA.debugLine="If ScrollChangedIndex3 = MyIndex Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._vvvvvv1==_myindex) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 585;BA.debugLine="SnapCLV3(Offset)";
parent._vvvv4(_offset);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 587;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _vvv6(long _md) throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Public Sub SetMaxDate(md As Long)";
 //BA.debugLineNum = 142;BA.debugLine="maxDate = md";
_vvvvv4 = _md;
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public String  _vvv7(long _md) throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Public Sub SetMinDate(md As Long)";
 //BA.debugLineNum = 137;BA.debugLine="minDate = md";
_vvvvv3 = _md;
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public String  _vvv0(long _init) throws Exception{
 //BA.debugLineNum = 243;BA.debugLine="Public Sub SetSelectedValue(init As Long)";
 //BA.debugLineNum = 244;BA.debugLine="initValue = init";
_vvvvv5 = _init;
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public String  _vvvv1() throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
long _temmax = 0L;
long _temmin = 0L;
int _numofdays = 0;
anywheresoftware.b4a.objects.LabelWrapper _tmp = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
 //BA.debugLineNum = 146;BA.debugLine="Public Sub Show";
 //BA.debugLineNum = 147;BA.debugLine="If layoutLoaded = False Then load";
if (_vvvvv6==__c.False) { 
_vvv1();};
 //BA.debugLineNum = 148;BA.debugLine="clv1.Clear";
_clv1._clear();
 //BA.debugLineNum = 149;BA.debugLine="clv2.Clear";
_clv2._clear();
 //BA.debugLineNum = 150;BA.debugLine="clv3.Clear";
_clv3._clear();
 //BA.debugLineNum = 151;BA.debugLine="For i = 1 To 5";
{
final int step5 = 1;
final int limit5 = (int) (5);
_i = (int) (1) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 152;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvv1.CreatePanel(ba,"");
 //BA.debugLineNum = 153;BA.debugLine="p.Color = backgroundColor";
_p.setColor(_vvvvvv4);
 //BA.debugLineNum = 154;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, clv1.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_clv1._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 155;BA.debugLine="clv1.Add(p, -1)";
_clv1._add(_p,(Object)(-1));
 }
};
 //BA.debugLineNum = 157;BA.debugLine="Dim temMax As Long = maxDate-DateTime.GetHour(max";
_temmax = (long) (_vvvvv4-__c.DateTime.GetHour(_vvvvv4)*__c.DateTime.TicksPerHour-__c.DateTime.GetMinute(_vvvvv4)*__c.DateTime.TicksPerMinute+1);
 //BA.debugLineNum = 158;BA.debugLine="Dim temMin As Long = minDate-DateTime.GetHour(min";
_temmin = (long) (_vvvvv3-__c.DateTime.GetHour(_vvvvv3)*__c.DateTime.TicksPerHour-__c.DateTime.GetMinute(_vvvvv3)*__c.DateTime.TicksPerMinute+1);
 //BA.debugLineNum = 159;BA.debugLine="Dim numOfDays As Int = Floor((temMax-temMin)/Date";
_numofdays = (int) (__c.Floor((_temmax-_temmin)/(double)__c.DateTime.TicksPerDay));
 //BA.debugLineNum = 160;BA.debugLine="For i = 0 To numOfDays";
{
final int step14 = 1;
final int limit14 = _numofdays;
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
 //BA.debugLineNum = 161;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvv1.CreatePanel(ba,"");
 //BA.debugLineNum = 162;BA.debugLine="p.Color = backgroundColor";
_p.setColor(_vvvvvv4);
 //BA.debugLineNum = 163;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, clv1.AsView.Width-2";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_clv1._asview().getWidth()-__c.DipToCurrent((int) (2))),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 164;BA.debugLine="Dim tmp As Label";
_tmp = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 165;BA.debugLine="tmp.Initialize(\"\")";
_tmp.Initialize(ba,"");
 //BA.debugLineNum = 166;BA.debugLine="Dim lbl As B4XView = tmp";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_tmp.getObject()));
 //BA.debugLineNum = 167;BA.debugLine="p.AddView(lbl,0,0,clv1.AsView.Width-2dip, 30dip)";
_p.AddView((android.view.View)(_lbl.getObject()),(int) (0),(int) (0),(int) (_clv1._asview().getWidth()-__c.DipToCurrent((int) (2))),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 168;BA.debugLine="DateTime.DateFormat=(\"MMM dd\")";
__c.DateTime.setDateFormat(("MMM dd"));
 //BA.debugLineNum = 169;BA.debugLine="lbl.Text = $\"$Date{temMax-DateTime.TicksPerDay*(";
_lbl.setText(BA.ObjectToCharSequence((""+__c.SmartStringFormatter("date",(Object)(_temmax-__c.DateTime.TicksPerDay*(_numofdays-_i)))+"")));
 //BA.debugLineNum = 170;BA.debugLine="lbl.TextColor = notFocusedTextColor";
_lbl.setTextColor(_vvvvvv6);
 //BA.debugLineNum = 171;BA.debugLine="lbl.TextSize = 12";
_lbl.setTextSize((float) (12));
 //BA.debugLineNum = 172;BA.debugLine="lbl.SetTextAlignment(\"CENTER\",\"RIGHT\")";
_lbl.SetTextAlignment("CENTER","RIGHT");
 //BA.debugLineNum = 174;BA.debugLine="clv1.Add(p, temMax-DateTime.TicksPerDay*(numOfDa";
_clv1._add(_p,(Object)(_temmax-__c.DateTime.TicksPerDay*(_numofdays-_i)));
 }
};
 //BA.debugLineNum = 176;BA.debugLine="DateTime.DateFormat = DateTime.DeviceDefaultDateF";
__c.DateTime.setDateFormat(__c.DateTime.getDeviceDefaultDateFormat());
 //BA.debugLineNum = 177;BA.debugLine="For i = 1 To 5";
{
final int step30 = 1;
final int limit30 = (int) (5);
_i = (int) (1) ;
for (;_i <= limit30 ;_i = _i + step30 ) {
 //BA.debugLineNum = 178;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvv1.CreatePanel(ba,"");
 //BA.debugLineNum = 179;BA.debugLine="p.Color = backgroundColor";
_p.setColor(_vvvvvv4);
 //BA.debugLineNum = 180;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, clv1.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_clv1._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 181;BA.debugLine="clv1.Add(p, -1)";
_clv1._add(_p,(Object)(-1));
 }
};
 //BA.debugLineNum = 183;BA.debugLine="For i = 1 To 5";
{
final int step36 = 1;
final int limit36 = (int) (5);
_i = (int) (1) ;
for (;_i <= limit36 ;_i = _i + step36 ) {
 //BA.debugLineNum = 184;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvv1.CreatePanel(ba,"");
 //BA.debugLineNum = 185;BA.debugLine="p.Color = backgroundColor";
_p.setColor(_vvvvvv4);
 //BA.debugLineNum = 186;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, clv2.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_clv2._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 187;BA.debugLine="clv2.Add(p, -1)";
_clv2._add(_p,(Object)(-1));
 }
};
 //BA.debugLineNum = 189;BA.debugLine="For i = 0 To 23";
{
final int step42 = 1;
final int limit42 = (int) (23);
_i = (int) (0) ;
for (;_i <= limit42 ;_i = _i + step42 ) {
 //BA.debugLineNum = 190;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvv1.CreatePanel(ba,"");
 //BA.debugLineNum = 191;BA.debugLine="p.Color = backgroundColor";
_p.setColor(_vvvvvv4);
 //BA.debugLineNum = 192;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, clv2.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_clv2._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 193;BA.debugLine="Dim tmp As Label";
_tmp = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 194;BA.debugLine="tmp.Initialize(\"\")";
_tmp.Initialize(ba,"");
 //BA.debugLineNum = 195;BA.debugLine="Dim lbl As B4XView = tmp";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_tmp.getObject()));
 //BA.debugLineNum = 196;BA.debugLine="p.AddView(lbl,0,0,clv2.AsView.Width,30dip)";
_p.AddView((android.view.View)(_lbl.getObject()),(int) (0),(int) (0),_clv2._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 197;BA.debugLine="lbl.Text = $\"$2.0{i}\"$";
_lbl.setText(BA.ObjectToCharSequence((""+__c.SmartStringFormatter("2.0",(Object)(_i))+"")));
 //BA.debugLineNum = 198;BA.debugLine="lbl.TextColor = notFocusedTextColor";
_lbl.setTextColor(_vvvvvv6);
 //BA.debugLineNum = 199;BA.debugLine="lbl.TextSize = 12";
_lbl.setTextSize((float) (12));
 //BA.debugLineNum = 200;BA.debugLine="lbl.SetTextAlignment(\"CENTER\",\"CENTER\")";
_lbl.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 201;BA.debugLine="clv2.Add(p, i)";
_clv2._add(_p,(Object)(_i));
 }
};
 //BA.debugLineNum = 203;BA.debugLine="For i = 1 To 5";
{
final int step56 = 1;
final int limit56 = (int) (5);
_i = (int) (1) ;
for (;_i <= limit56 ;_i = _i + step56 ) {
 //BA.debugLineNum = 204;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvv1.CreatePanel(ba,"");
 //BA.debugLineNum = 205;BA.debugLine="p.Color = backgroundColor";
_p.setColor(_vvvvvv4);
 //BA.debugLineNum = 206;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, clv2.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_clv2._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 207;BA.debugLine="clv2.Add(p, -1)";
_clv2._add(_p,(Object)(-1));
 }
};
 //BA.debugLineNum = 210;BA.debugLine="For i = 1 To 5";
{
final int step62 = 1;
final int limit62 = (int) (5);
_i = (int) (1) ;
for (;_i <= limit62 ;_i = _i + step62 ) {
 //BA.debugLineNum = 211;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvv1.CreatePanel(ba,"");
 //BA.debugLineNum = 212;BA.debugLine="p.Color = backgroundColor";
_p.setColor(_vvvvvv4);
 //BA.debugLineNum = 213;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, clv3.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_clv3._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 214;BA.debugLine="clv3.Add(p, -1)";
_clv3._add(_p,(Object)(-1));
 }
};
 //BA.debugLineNum = 216;BA.debugLine="For i = 0 To 59";
{
final int step68 = 1;
final int limit68 = (int) (59);
_i = (int) (0) ;
for (;_i <= limit68 ;_i = _i + step68 ) {
 //BA.debugLineNum = 217;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvv1.CreatePanel(ba,"");
 //BA.debugLineNum = 218;BA.debugLine="p.Color = backgroundColor";
_p.setColor(_vvvvvv4);
 //BA.debugLineNum = 219;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, clv3.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_clv3._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 220;BA.debugLine="Dim tmp As Label";
_tmp = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 221;BA.debugLine="tmp.Initialize(\"\")";
_tmp.Initialize(ba,"");
 //BA.debugLineNum = 222;BA.debugLine="Dim lbl As B4XView = tmp";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_tmp.getObject()));
 //BA.debugLineNum = 223;BA.debugLine="p.AddView(lbl,0,0,clv3.AsView.Width,30dip)";
_p.AddView((android.view.View)(_lbl.getObject()),(int) (0),(int) (0),_clv3._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 224;BA.debugLine="lbl.Text = $\"$2.0{i}\"$";
_lbl.setText(BA.ObjectToCharSequence((""+__c.SmartStringFormatter("2.0",(Object)(_i))+"")));
 //BA.debugLineNum = 225;BA.debugLine="lbl.TextColor = notFocusedTextColor";
_lbl.setTextColor(_vvvvvv6);
 //BA.debugLineNum = 226;BA.debugLine="lbl.TextSize = 12";
_lbl.setTextSize((float) (12));
 //BA.debugLineNum = 227;BA.debugLine="lbl.SetTextAlignment(\"CENTER\",\"LEFT\")";
_lbl.SetTextAlignment("CENTER","LEFT");
 //BA.debugLineNum = 228;BA.debugLine="clv3.Add(p, i)";
_clv3._add(_p,(Object)(_i));
 }
};
 //BA.debugLineNum = 230;BA.debugLine="For i = 1 To 5";
{
final int step82 = 1;
final int limit82 = (int) (5);
_i = (int) (1) ;
for (;_i <= limit82 ;_i = _i + step82 ) {
 //BA.debugLineNum = 231;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvv1.CreatePanel(ba,"");
 //BA.debugLineNum = 232;BA.debugLine="p.Color = backgroundColor";
_p.setColor(_vvvvvv4);
 //BA.debugLineNum = 233;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, clv3.AsView.Width,";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_clv3._asview().getWidth(),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 234;BA.debugLine="clv3.Add(p, -1)";
_clv3._add(_p,(Object)(-1));
 }
};
 //BA.debugLineNum = 237;BA.debugLine="MoveToInitValues";
_vvv2();
 //BA.debugLineNum = 239;BA.debugLine="applyLineColor";
_vv2();
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public String  _vvvv2(int _offset) throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
int _centerindex = 0;
int _visiblepart = 0;
int _diff = 0;
boolean _found = false;
int _x = 0;
int _ici = 0;
 //BA.debugLineNum = 493;BA.debugLine="Private Sub SnapCLV1 (Offset As Int)";
 //BA.debugLineNum = 494;BA.debugLine="Dim i As Int = clv1.FirstVisibleIndex";
_i = _clv1._getfirstvisibleindex();
 //BA.debugLineNum = 495;BA.debugLine="Dim item As CLVItem	 = clv1.GetRawListItem(i)";
_item = _clv1._getrawlistitem(_i);
 //BA.debugLineNum = 496;BA.debugLine="Dim centerIndex As Int = Floor((clv1.sv.Height/it";
_centerindex = (int) (__c.Floor((_clv1._sv.getHeight()/(double)_item.Size)/(double)2));
 //BA.debugLineNum = 497;BA.debugLine="Dim visiblepart As Int =  item.Offset + item.Size";
_visiblepart = (int) (_item.Offset+_item.Size-_offset);
 //BA.debugLineNum = 498;BA.debugLine="If visiblepart / item.Size < 0.5 Then";
if (_visiblepart/(double)_item.Size<0.5) { 
 //BA.debugLineNum = 499;BA.debugLine="i = i+1";
_i = (int) (_i+1);
 };
 //BA.debugLineNum = 501;BA.debugLine="Dim diff As Int = 0";
_diff = (int) (0);
 //BA.debugLineNum = 502;BA.debugLine="Dim found As Boolean = False";
_found = __c.False;
 //BA.debugLineNum = 503;BA.debugLine="If i+centerIndex < clv1.Size-1 Then";
if (_i+_centerindex<_clv1._getsize()-1) { 
 //BA.debugLineNum = 504;BA.debugLine="If -1 = clv1.Getvalue(i+centerIndex) Then";
if (-1==(double)(BA.ObjectToNumber(_clv1._getvalue((int) (_i+_centerindex))))) { 
 //BA.debugLineNum = 505;BA.debugLine="For x=(i+centerIndex) To clv1.Size-1";
{
final int step12 = 1;
final int limit12 = (int) (_clv1._getsize()-1);
_x = (int) ((_i+_centerindex)) ;
for (;_x <= limit12 ;_x = _x + step12 ) {
 //BA.debugLineNum = 506;BA.debugLine="If clv1.GetValue(x)>-1 Then";
if ((double)(BA.ObjectToNumber(_clv1._getvalue(_x)))>-1) { 
 //BA.debugLineNum = 507;BA.debugLine="found = True";
_found = __c.True;
 //BA.debugLineNum = 508;BA.debugLine="diff = x-(i+centerIndex)";
_diff = (int) (_x-(_i+_centerindex));
 //BA.debugLineNum = 509;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 512;BA.debugLine="If found = False Then";
if (_found==__c.False) { 
 //BA.debugLineNum = 513;BA.debugLine="Dim ici As Int = i+centerIndex";
_ici = (int) (_i+_centerindex);
 //BA.debugLineNum = 514;BA.debugLine="Do While True";
while (__c.True) {
 //BA.debugLineNum = 515;BA.debugLine="If clv1.GetValue(ici)>-1 Then";
if ((double)(BA.ObjectToNumber(_clv1._getvalue(_ici)))>-1) { 
 //BA.debugLineNum = 516;BA.debugLine="found = True";
_found = __c.True;
 //BA.debugLineNum = 517;BA.debugLine="diff = ici-(i+centerIndex)";
_diff = (int) (_ici-(_i+_centerindex));
 //BA.debugLineNum = 518;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 520;BA.debugLine="ici = ici-1";
_ici = (int) (_ici-1);
 }
;
 };
 };
 };
 //BA.debugLineNum = 526;BA.debugLine="clv1.ScrollToItem(i+diff)";
_clv1._scrolltoitem((int) (_i+_diff));
 //BA.debugLineNum = 528;BA.debugLine="End Sub";
return "";
}
public String  _vvvv3(int _offset) throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
int _centerindex = 0;
int _visiblepart = 0;
int _diff = 0;
boolean _found = false;
int _x = 0;
int _ici = 0;
 //BA.debugLineNum = 543;BA.debugLine="Private Sub SnapCLV2 (Offset As Int)";
 //BA.debugLineNum = 544;BA.debugLine="Dim i As Int = clv2.FirstVisibleIndex";
_i = _clv2._getfirstvisibleindex();
 //BA.debugLineNum = 545;BA.debugLine="Dim item As CLVItem	 = clv2.GetRawListItem(i)";
_item = _clv2._getrawlistitem(_i);
 //BA.debugLineNum = 546;BA.debugLine="Dim centerIndex As Int = Floor((clv2.sv.Height/it";
_centerindex = (int) (__c.Floor((_clv2._sv.getHeight()/(double)_item.Size)/(double)2));
 //BA.debugLineNum = 547;BA.debugLine="Dim visiblepart As Int =  item.Offset + item.Size";
_visiblepart = (int) (_item.Offset+_item.Size-_offset);
 //BA.debugLineNum = 548;BA.debugLine="If visiblepart / item.Size < 0.5 Then";
if (_visiblepart/(double)_item.Size<0.5) { 
 //BA.debugLineNum = 549;BA.debugLine="i = i+1";
_i = (int) (_i+1);
 };
 //BA.debugLineNum = 551;BA.debugLine="Dim diff As Int = 0";
_diff = (int) (0);
 //BA.debugLineNum = 552;BA.debugLine="Dim found As Boolean = False";
_found = __c.False;
 //BA.debugLineNum = 553;BA.debugLine="If i+centerIndex < clv2.Size-1 Then";
if (_i+_centerindex<_clv2._getsize()-1) { 
 //BA.debugLineNum = 554;BA.debugLine="If -1 = clv2.Getvalue(i+centerIndex) Then";
if (-1==(double)(BA.ObjectToNumber(_clv2._getvalue((int) (_i+_centerindex))))) { 
 //BA.debugLineNum = 555;BA.debugLine="For x=(i+centerIndex) To clv2.Size-1";
{
final int step12 = 1;
final int limit12 = (int) (_clv2._getsize()-1);
_x = (int) ((_i+_centerindex)) ;
for (;_x <= limit12 ;_x = _x + step12 ) {
 //BA.debugLineNum = 556;BA.debugLine="If clv2.GetValue(x)>-1 Then";
if ((double)(BA.ObjectToNumber(_clv2._getvalue(_x)))>-1) { 
 //BA.debugLineNum = 557;BA.debugLine="found = True";
_found = __c.True;
 //BA.debugLineNum = 558;BA.debugLine="diff = x-(i+centerIndex)";
_diff = (int) (_x-(_i+_centerindex));
 //BA.debugLineNum = 559;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 562;BA.debugLine="If found = False Then";
if (_found==__c.False) { 
 //BA.debugLineNum = 563;BA.debugLine="Dim ici As Int = i+centerIndex";
_ici = (int) (_i+_centerindex);
 //BA.debugLineNum = 564;BA.debugLine="Do While True";
while (__c.True) {
 //BA.debugLineNum = 565;BA.debugLine="If clv2.GetValue(ici)>-1 Then";
if ((double)(BA.ObjectToNumber(_clv2._getvalue(_ici)))>-1) { 
 //BA.debugLineNum = 566;BA.debugLine="found = True";
_found = __c.True;
 //BA.debugLineNum = 567;BA.debugLine="diff = ici-(i+centerIndex)";
_diff = (int) (_ici-(_i+_centerindex));
 //BA.debugLineNum = 568;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 570;BA.debugLine="ici = ici-1";
_ici = (int) (_ici-1);
 }
;
 };
 };
 };
 //BA.debugLineNum = 576;BA.debugLine="clv2.ScrollToItem(i+diff)";
_clv2._scrolltoitem((int) (_i+_diff));
 //BA.debugLineNum = 578;BA.debugLine="End Sub";
return "";
}
public String  _vvvv4(int _offset) throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
int _centerindex = 0;
int _visiblepart = 0;
int _diff = 0;
boolean _found = false;
int _x = 0;
int _ici = 0;
 //BA.debugLineNum = 593;BA.debugLine="Private Sub SnapCLV3 (Offset As Int)";
 //BA.debugLineNum = 594;BA.debugLine="Dim i As Int = clv3.FirstVisibleIndex";
_i = _clv3._getfirstvisibleindex();
 //BA.debugLineNum = 595;BA.debugLine="Dim item As CLVItem	 = clv3.GetRawListItem(i)";
_item = _clv3._getrawlistitem(_i);
 //BA.debugLineNum = 596;BA.debugLine="Dim centerIndex As Int = Floor((clv3.sv.Height/it";
_centerindex = (int) (__c.Floor((_clv3._sv.getHeight()/(double)_item.Size)/(double)2));
 //BA.debugLineNum = 597;BA.debugLine="Dim visiblepart As Int =  item.Offset + item.Size";
_visiblepart = (int) (_item.Offset+_item.Size-_offset);
 //BA.debugLineNum = 598;BA.debugLine="If visiblepart / item.Size < 0.5 Then";
if (_visiblepart/(double)_item.Size<0.5) { 
 //BA.debugLineNum = 599;BA.debugLine="i = i+1";
_i = (int) (_i+1);
 };
 //BA.debugLineNum = 601;BA.debugLine="Dim diff As Int = 0";
_diff = (int) (0);
 //BA.debugLineNum = 602;BA.debugLine="Dim found As Boolean = False";
_found = __c.False;
 //BA.debugLineNum = 603;BA.debugLine="If i+centerIndex < clv3.Size-1 Then";
if (_i+_centerindex<_clv3._getsize()-1) { 
 //BA.debugLineNum = 604;BA.debugLine="If -1 = clv3.Getvalue(i+centerIndex) Then";
if (-1==(double)(BA.ObjectToNumber(_clv3._getvalue((int) (_i+_centerindex))))) { 
 //BA.debugLineNum = 605;BA.debugLine="For x=(i+centerIndex) To clv3.Size-1";
{
final int step12 = 1;
final int limit12 = (int) (_clv3._getsize()-1);
_x = (int) ((_i+_centerindex)) ;
for (;_x <= limit12 ;_x = _x + step12 ) {
 //BA.debugLineNum = 606;BA.debugLine="If clv3.GetValue(x)>-1 Then";
if ((double)(BA.ObjectToNumber(_clv3._getvalue(_x)))>-1) { 
 //BA.debugLineNum = 607;BA.debugLine="found = True";
_found = __c.True;
 //BA.debugLineNum = 608;BA.debugLine="diff = x-(i+centerIndex)";
_diff = (int) (_x-(_i+_centerindex));
 //BA.debugLineNum = 609;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 612;BA.debugLine="If found = False Then";
if (_found==__c.False) { 
 //BA.debugLineNum = 613;BA.debugLine="Dim ici As Int = i+centerIndex";
_ici = (int) (_i+_centerindex);
 //BA.debugLineNum = 614;BA.debugLine="Do While True";
while (__c.True) {
 //BA.debugLineNum = 615;BA.debugLine="If clv3.GetValue(ici)>-1 Then";
if ((double)(BA.ObjectToNumber(_clv3._getvalue(_ici)))>-1) { 
 //BA.debugLineNum = 616;BA.debugLine="found = True";
_found = __c.True;
 //BA.debugLineNum = 617;BA.debugLine="diff = ici-(i+centerIndex)";
_diff = (int) (_ici-(_i+_centerindex));
 //BA.debugLineNum = 618;BA.debugLine="Exit";
if (true) break;
 };
 //BA.debugLineNum = 620;BA.debugLine="ici = ici-1";
_ici = (int) (_ici-1);
 }
;
 };
 };
 };
 //BA.debugLineNum = 626;BA.debugLine="clv3.ScrollToItem(i+diff)";
_clv3._scrolltoitem((int) (_i+_diff));
 //BA.debugLineNum = 628;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
