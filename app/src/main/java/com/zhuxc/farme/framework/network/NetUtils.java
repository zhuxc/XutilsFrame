package com.zhuxc.farme.framework.network;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.squareup.okhttp.Request;
import com.zhuxc.farme.framework.R;
import com.zhuxc.farme.framework.okhttp_volley.RequestManager;
import com.zhuxc.farme.framework.utils.CommonUtil;
import com.zhuxc.farme.framework.utils.Config;

/**
 * 网络工具类
 * @ClassName: NetUtils 
 * @Description: TODO
 * @author zhuxc
 * @date modify by 2015-7-3 下午2:58:31 
 *
 */
public class NetUtils {
	private static NetUtils netUtils;
	private  static final String TAG = "NetUtils";
	public static String GET = "get";
	public static String POST = "post";
	public static int TIMEOUT = 30000;
	public ResponseListener responseListener;

	public void setResponseListener(ResponseListener responseListener){
		this.responseListener = responseListener;
	}
	public interface ResponseListener {
		public  void onSuccess(String type, String code, String msg, JSONObject data);
		public abstract void onFailure(String type, String arg1);
	}
	

	public static NetUtils newInstance() {
		if (null == netUtils) {
			netUtils = new NetUtils();
		}
		return netUtils;
	}

	/**
	 * 网络请求数据，返回的是String格式数据
	 * @param context
	 * @param get请求
	 * @param url
	 * @param params
	 */
	public  void getStringServer(final Context context,final String url,String...params){
		boolean b = CommonUtil.hasNetwork(context);
		if (!b) {
			CommonUtil.Toast(context, context.getResources().getString(R.string.net_error));
			responseListener.onFailure(url, context.getResources().getString(R.string.net_error));
			return;
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append(Config.BASEURL);
			buffer.append(url);

			String content;
			String key = null;
			String value = null;

			for (int i = 0; i < params.length; i++) {
				try {
					content = params[i];
					if (!TextUtils.isEmpty(content) && content.contains("=")) {
						String[] strs = content.split("=");
						key = strs[0];
						if (strs.length == 2) {
							value = content.split("=")[1];
						}

						if (TextUtils.isEmpty(key)) {
							break;
						} else {
							if (TextUtils.isEmpty(value)) {
								value = "";
							}
						}

						Log.i(TAG, "key=" + key + ";value=" + value);
						if (i == 0) {
							buffer.append(key + "=" + value);
						} else {
							buffer.append("&" + key + "=" + value);
						}
					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			String absoluteUrl = buffer.toString();
			Log.i(TAG, url + "的接口url=" + absoluteUrl);


			StringRequest request = new StringRequest(
					com.android.volley.Request.Method.GET,
					absoluteUrl,
					new Response.Listener<String>() {
						@Override
						public void onResponse(String response) {

//							JSONObject jsonObject = new JSONObject(response);
//							String status = jsonObject.optString("status");
//							String msg = jsonObject.optString("message");
//							JSONObject data =  jsonObject.optJSONObject("data");
//							responseListener.onSuccess(url,status,msg, data);
						}
					},
					new Response.ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError error) {
							responseListener.onFailure(url, error.toString());
						}
					});
			RequestManager.getInstance(context).addRequest(request, context);

		}
	}

	/**
	 * 网络请求数据，返回的是json格式数据
	 * @param context
	 * @param get请求     默认get，需求为post时直接换请求方式
	 * @param url
	 * @param params
	 */
	public  void getJsonServer(final Context context,final String url,String...params){
		boolean b = CommonUtil.hasNetwork(context);
		if (!b) {
			CommonUtil.Toast(context, context.getResources().getString(R.string.net_error));
			responseListener.onFailure(url, context.getResources().getString(R.string.net_error));
			return;
		} else {
			StringBuffer buffer = new StringBuffer();
			buffer.append(Config.BASEURL);
			buffer.append(url);

			String absoluteUrl = buffer.toString();
			Log.i(TAG, url + "的接口url=" + absoluteUrl);

			JSONObject obj = new JSONObject();
			String content;
			String key = null;
			String value = null;

			for (int i = 0; i < params.length; i++) {
				try {
					content = params[i];
					if (!TextUtils.isEmpty(content) && content.contains("=")) {
						String[] strs = content.split("=");
						key = strs[0];
						if (strs.length == 2) {
							value = content.split("=")[1];
						}

						if (TextUtils.isEmpty(key)) {
							break;
						} else {
							if (TextUtils.isEmpty(value)) {
								value = "";
							}
						}

						obj.put(key,value);
					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET,
					absoluteUrl,
					obj,
					new Response.Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							Log.d("TAG", response.toString());
//							JSONObject jsonObject = new JSONObject(response);
							String status = response.optString("status");
							String msg = response.optString("message");
							JSONObject data =  response.optJSONObject("data");
							responseListener.onSuccess(url,status,msg, data);
						}
					}, new Response.ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
					responseListener.onFailure(url, error.toString());
				}
			});
			RequestManager.getInstance(context).addRequest(request, context);

		}
	}

	/**
	 * 普通参数和多个文件上传请求
	 * @param context
	 * @param url
	 * @param images
	 * @param params
	 */
	public  void uploadDataAndFileFromServer(final Context context,final String url, Map<String, String> images,String...params){
		boolean b = CommonUtil.hasNetwork(context);
		if (!b) {
			CommonUtil.Toast(context, context.getResources().getString(R.string.net_error));
			netUtils.responseListener.onFailure(url,context.getResources().getString(R.string.net_error));
			return;
		} else {
			
			File file = new File(Environment.getExternalStorageDirectory(), "messenger_01.png");
	        if (!file.exists())
	        {
	            Toast.makeText(context, "文件不存在，请修改文件路径", Toast.LENGTH_SHORT).show();
	            return;
	        }
	        StringBuffer buffer = new StringBuffer();
			buffer.append(Config.BASEURL);
			buffer.append("user!postFile");
			String absoluteUrl = buffer.toString();
			
//			 OkHttpUtils
//             .postFile()
//             .url(absoluteUrl)
//             .file(file)
//             .build()
//             .execute(new StringCallback() {
//
// 				@Override
// 				public void onResponse(String response) {
// 					// TODO Auto-generated method stub
// 					Log.i(TAG, url + "接口返回的数据"+response);
//
// 					try {
// 						JSONObject jsonObject = new JSONObject(response);
// 						String status = jsonObject.optString("status");
// 						String msg = jsonObject.optString("message");
// 						JSONObject data =  jsonObject.optJSONObject("data");
// 						responseListener.onSuccess(url,status,msg, data);
// 					} catch (JSONException e) {
// 						// TODO Auto-generated catch block
// 						e.printStackTrace();
// 						Log.i(TAG, url + "接口返回的数据格式不对！"+response);
// 						responseListener.onFailure(url, e.getMessage());
// 					}
// 				}
//
// 				@Override
// 				public void onError(Request request, Exception e) {
// 					// TODO Auto-generated method stub
// 					responseListener.onFailure(url, request.toString());
// 				}
//
// 				@Override
// 		        public void onBefore(Request request){
// 		            super.onBefore(request);
//
// 		        }
//
// 		        @Override
// 		        public void onAfter(){
// 		            super.onAfter();
//
// 		        }
//
// 		        @Override
// 		        public void inProgress(float progress){
//
// 		            Log.e(TAG, "inProgress:" + progress);
// 		        }
// 			});
		}
	}
	
	/**
	 * 下载文件
	 * @param context
	 * @param downloadUrl，下载路径
	 * @param filePath ，保存路径
	 * @param continueLoad，是否继续下载，断点续传
	 */
	public void downloadFile(final Context context,String downloadUrl,String filePath,boolean continueLoad){

	}
	/**
	 * 停止下载
	 * @param mayInterruptIfRunning
	 */
	public void cancelDownloadFile(boolean mayInterruptIfRunning){
	}

}
