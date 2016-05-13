package com.sihuaTech.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.widget.Toast;

public class JavaScriptinterface {

	private Context mContext;
	//这个一定要定义，要不在showToast()方法里没办法启动intent
	Activity activity;

	/** Instantiate the interface and set the context */
	public JavaScriptinterface(Context c) {
		mContext = c;
		activity = (Activity) c;
	}

	/** 与js交互时用到的方法，在js里直接调用的 */
	public String showToast(String string) {
		System.out.println("show.....");
		SMTools tools = new SMTools(mContext);
		String info = "" ; 
		if (string.equals("phone")) {
			info = tools.getTel();
			return info;
		}else if(string.equals("")) {
			
		}else if(string.equals("")){
			
		}
		return "null";
	}
	public void showToast2() {

		Intent intent = new Intent();
		intent.setClass(mContext, MainActivity.class);
		activity.startActivity(intent);
	}
}
