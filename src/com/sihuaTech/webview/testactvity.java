package com.sihuaTech.webview;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class testactvity extends Activity{

	private WebView webView;
	private TextView textView;
	private EditText editText;
	private Button button;
	Handler myHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		button =(Button)findViewById(R.id.button1);
		editText = (EditText)findViewById(R.id.editText1);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				
				intent.setClass(testactvity.this, testactivity2.class);
				Bundle bundle = new Bundle();
		    	bundle.putString("editText", editText.getText().toString());
		    	
		    	intent.putExtras(bundle);
		    	
		    	startActivity(intent);
		    //  startActivityForResult(intent, 100);

			}
		});
		
		
	}
	// 获取网页具体内容
	public String getFromAssets(String fileName) {
		try {
			InputStreamReader inputReader = new InputStreamReader(
					getResources().getAssets().open(fileName));

			BufferedReader bufReader = new BufferedReader(inputReader);

			String line = "";
			String Result = "";

			while ((line = bufReader.readLine()) != null)
				Result += line;
			if (bufReader != null)
				bufReader.close();
			if (inputReader != null)
				inputReader.close();
			return Result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 自动生成的方法存根
		if (webView.canGoBack() && keyCode==KeyEvent.KEYCODE_BACK) {
			webView.goBack();
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
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
		public void showToast() {

			Intent intent = new Intent();
			intent.setClass(mContext, testactvity.class);
			activity.startActivity(intent);
		}
		public void showToast2() {

			Intent intent = new Intent();
			intent.setClass(mContext, MainActivity.class);
			activity.startActivity(intent); 
		//	textView.setText();
		}
		public void showToast3(String webMessage){	    	
	    	final String msgeToast = webMessage;
	    	textView = (TextView)findViewById(R.id.tv);
/*	    	 myHandler.post(new Runnable() {
	             @Override
	             public void run() {
	                 // This gets executed on the UI thread so it can safely modify Views
	                 textView.setText(msgeToast);
	             }
	         });*/
	//    	 textView.setText(msgeToast);
	       Toast.makeText(mContext, webMessage, Toast.LENGTH_SHORT).show();
	    }
	}
}
