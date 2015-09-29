package com.pan.dailynews.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ListView;

public class PullToRefreshListView extends ListView {
	/**
	 * 未刷新
	 */
	private static final int TAP_TO_REFRESH = 1; // （未刷新）
	/**
	 * 下拉刷新
	 */
	private static final int PULL_TO_REFRESH = 2; // 下拉刷新
	/**
	 * 释放刷新
	 */
	private static final int RELEASE_TO_REFRESH = 3; // 释放刷新
	/**
	 * 正在刷新
	 */
	private static final int REFRESHING = 4; // 正在刷新
	/**
	 * 未加载更多
	 */
	private static final int TAP_TO_LOADMORE = 5; // 未加载更多
	/**
	 * 正在加载
	 */
	private static final int LOADING = 6; // 正在加载
	/**
	 * 下拉刷新动画
	 */
	private RotateAnimation mPullDownAnimation = null;
	/**
	 * 下拉后再上滑动画
	 */
	private RotateAnimation mPullUpAnimation = null;
	/**
	 */
	private RotateAnimation mOnLoadAnimation = null;

	public PullToRefreshListView(Context context) {
		super(context);
		init(context, null);
	}

	public PullToRefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public PullToRefreshListView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}

	/**
	 * 初始化
	 * 
	 * @param context
	 * @param attrs
	 */
	private void init(Context context, AttributeSet attrs) {
		// 参数：1.旋转开始的角度 2.旋转结束的角度 3. X轴伸缩模式 4.X坐标的伸缩值 5.Y轴的伸缩模式 6.Y坐标的伸缩值
		// 下拉刷新时箭头旋转的动画
		mPullDownAnimation = new RotateAnimation(0, 180,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		mPullDownAnimation.setDuration(300);
		mPullDownAnimation.setFillAfter(true);
		// 下拉后再上滑动画
		mPullUpAnimation = new RotateAnimation(180, 360,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		mPullUpAnimation.setDuration(300);
		mPullUpAnimation.setFillAfter(true);
		// 加载时的动画
		mOnLoadAnimation = new RotateAnimation(0, 359,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 05.f);
		mOnLoadAnimation.setDuration(1000);
		//为旋转动画设置线性插入器，如果不设置可能会造成卡顿
		mOnLoadAnimation.setInterpolator(new LinearInterpolator());
		mOnLoadAnimation.setRepeatCount(-1);
		
		
	}
}
