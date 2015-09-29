package com.pan.dailynews.base;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings.System;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity {

	private String TAG = BaseActivity.this.getClass().getSimpleName();
	protected FragmentManager fm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		fm = getSupportFragmentManager();
		findViews();
		init();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}
	/**
	 * 获取控件
	 */
	protected abstract void findViews();
	/**
	 * 初始化
	 */
	protected abstract void init();
	
	
}
