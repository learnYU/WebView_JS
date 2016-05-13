package com.sihuaTech.webview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


/**
 * 详细js 交互 学习地址 http://www.imooc.com/article/1475
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	private WebView myWebView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		myWebView = (WebView) findViewById(R.id.myWebView);
		myWebView.getSettings().setJavaScriptEnabled(true);
		// 与js交互，JavaScriptinterface 是个接口，与js交互时用到的，这个接口实现了从网页跳到app中的activity 的
		// 方法，特别重要
		myWebView.addJavascriptInterface(new JavaScriptinterface(this),"android");
		// html里的内容，test1就是本地的html,在项目assets文件夹下 
		String htmlText = getFromAssets("test1.html");
		// 将html里的内容加载到webview中
//		myWebView.loadData(htmlText, "text/html", "utf-8");
		myWebView.loadUrl("file:///android_asset/test1.html");
//		myWebView.loadUrl("http://172.21.134.122:18888/PHONE_WGYX_SERVER/page/welcome.html");
		myWebView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "shouldOverrideUrlLoading:::::"+url, Toast.LENGTH_SHORT).show();
				if (url.indexOf("CCCC")!=-1) {
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, testactvity.class);
					startActivity(intent);
				} else {
					view.loadUrl(url);
				}
				return true;
			}
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO 自动生成的方法存根
				super.onPageStarted(view, url, favicon);
			}
		});
		myWebView.setWebChromeClient(new WebChromeClient() {});
	}

	// 此按键监听的是返回键，能够返回到上一个网页（通过网页的hostlistery）
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
			myWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
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

}