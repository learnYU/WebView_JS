package com.sihuaTech.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class testactivity2 extends Activity {
	
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test2);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String editText = bundle.getString("editText");
		
		webView = (WebView)findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
//		webView.addJavascriptInterface(new JavaScriptinterface(this),"android");
//		String htmlText = getFromAssets("test.html");
		// 将html里的内容加载到webview中
//		webView.loadData(htmlText, "text/html", "utf-8");
		webView.loadUrl("http://172.21.134.122/test2.html?param="+editText);
		webView.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO 自动生成的方法存根
				if (url!=null) {
					view.loadUrl(url);
				}
				return true;
			}
			
		});
		
		
	}
}
