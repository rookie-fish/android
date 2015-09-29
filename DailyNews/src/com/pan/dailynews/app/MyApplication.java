package com.pan.dailynews.app;

import android.app.Application;

public class MyApplication extends Application{
	private String TAG=MyApplication.this.getClass().getSimpleName();
	public static MyApplication mApplication;
	
	public static MyApplication newInstance() {
		return mApplication;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		mApplication = this;
	}
	
}
