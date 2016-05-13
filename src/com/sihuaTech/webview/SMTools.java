package com.sihuaTech.webview;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * SIM卡工具类
 */
public class SMTools {
	
	private Context context;
	private TelephonyManager tm;
	
	private static String imsi; //for ShanXi by zhouww
	
	public SMTools(Context context) {
		this.context = context;
		tm = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
	}
	
	/**
	 * 获得设备号
	 * @return
	 */
	public String getDeviceID(){
		
		if(tm != null){
			return tm.getDeviceId();
		}
		
		return null;
	}
	
	/**
	 * 获得电话号码
	 * @return
	 */
	public String getTel(){
		
		if(tm != null){
			return tm.getSimSerialNumber();
		}
		
		return null;
	}
	
	/**
	 * 获得IMEI
	 * @return
	 */
	public String getIMEI(){
		
		if(tm != null){
			return tm.getSimSerialNumber();
		}
		
		return null;
	}
	
	//for ShanXi by zhouww
	public static void setIMSI(String imsi) {
		SMTools.imsi = imsi;
	}
	
	/**
	 * 获得IMSI
	 * @return
	 */
	public static String getIMSI(){
		return imsi;
	}
	
	/**
	 * 获得手机状态
	 * @return
	 */
	public int getState(){
		
		if(tm != null){
			//return  TelephonyManager.SIM_STATE_READY;
			return tm.getSimState();
		}
		
		return 0;
	}
	
}
