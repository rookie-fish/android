package com.pan.dailynews.http;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.pan.dailynews.app.MyApplication;

public class VolleyQueueManager {
	
	private String TAG=VolleyQueueManager.this.getClass().getSimpleName();
	
	public static RequestQueue mRequestQueue = Volley.newRequestQueue(MyApplication.newInstance());
	public static <T> void addRequest(Request<T> req,Object tag){
		if(tag!=null){
			req.setTag(tag);
		}
		mRequestQueue.add(req);
	}
	public static void cancleRequest(Object tag){
		if(mRequestQueue != null){
			mRequestQueue.cancelAll(tag);
		}
	}
}
