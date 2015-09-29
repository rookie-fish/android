package com.pan.dailynews.http;

import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;



public class HttpManager {
	private static String TAG = HttpManager.class.getSimpleName();
	
	public static final String BASE_URL = "";
	
	public JSONObject getJson(String url,Object tag){
		JsonObjectRequest jsonReq = new JsonObjectRequest(BASE_URL+url, null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		VolleyQueueManager.addRequest(jsonReq, tag);
		return null;
	}
	
}
