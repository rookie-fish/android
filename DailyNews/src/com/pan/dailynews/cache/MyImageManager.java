package com.pan.dailynews.cache;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.pan.dailynews.R;
import com.pan.dailynews.app.MyApplication;
import com.pan.dailynews.http.VolleyQueueManager;
/**
 * 获取图片类
 * 如果需要使用默认的错误图片，
 * @author Pan
 *
 */
public class MyImageManager {
	private static String TAG = MyImageManager.class.getSimpleName();

	// 获取图片缓存类对象
	private static ImageCache mImageCache = new MyImageCache();
	// 获取ImageLoader对象
	public static ImageLoader mImageLoader = new ImageLoader(
			VolleyQueueManager.mRequestQueue, mImageCache);
	private static Resources res = MyApplication.mApplication.getResources();
	private static Bitmap mErrorBitmap = BitmapFactory.decodeResource(res, R.drawable.error_image);
	private static Bitmap mDefaultBitmap = BitmapFactory.decodeResource(res, R.drawable.error_image);
	
	
	/**
	 * 获取ImageListener
	 * 
	 * @param view
	 * @param defaultImage
	 * @param errorImage
	 * @return
	 */
	public static ImageListener getImageListener(final ImageView view,
			final Bitmap defaultImage, final Bitmap errorImage) {

		return new ImageListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// 回调失败
				if (errorImage != null) {
					view.setImageBitmap(errorImage);
				}
			}

			@Override
			public void onResponse(ImageContainer response, boolean isImmediate) {
				// 回调成功
				if (response.getBitmap() != null) {
					view.setImageBitmap(response.getBitmap());
				} else if (defaultImage != null) {
					view.setImageBitmap(defaultImage);
				}
			}
		};

	}
	/**
	 * 加载网络图片,采用默认的错误图片
	 * @param url 图片地址
	 * @param view ImageView
	 */
	public static void loadImage(String url,ImageView view){
		mImageLoader.get(url, MyImageManager.getImageListener(view, mDefaultBitmap, mErrorBitmap));
	}
	/**
	 * 加载网络图片,采用默认的错误图片
	 * @param url 图片地址
	 * @param view ImageView
	 * @param maxWidth 最大宽度
	 * @param maxHeight 最大高度
	 */
	public static void loadImage(String url,ImageView view,int maxWidth,int maxHeight){
		mImageLoader.get(url, MyImageManager.getImageListener(view, mDefaultBitmap, mErrorBitmap), maxWidth, maxHeight);
	}
	/**
	 * 加载网络图片
	 * 
	 * @param url 图片地址
	 * @param view
	 * @param defaultImage
	 * @param errorImage
	 */
	public static void loadImage(String url, ImageView view,
			Bitmap defaultImage, Bitmap errorImage) {
		mImageLoader
				.get(url, MyImageManager.getImageListener(view, defaultImage,
						errorImage), 0, 0);
	}

	/**
	 * 加载网络图片
	 * 
	 * @param url 图片地址
	 * @param view imageview
	 * @param defaultImage 默认图片
	 * @param errorImage 错误图片
	 * @param maxWidth 最大宽度
	 * @param maxHeight 最大高度
	 */
	public static void loadImage(String url, ImageView view,
			Bitmap defaultImage, Bitmap errorImage, int maxWidth, int maxHeight) {
		mImageLoader
				.get(url, MyImageManager.getImageListener(view, defaultImage,
						errorImage), maxWidth, maxHeight);
	}
}
