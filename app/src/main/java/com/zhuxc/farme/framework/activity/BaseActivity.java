package com.zhuxc.farme.framework.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

import com.zhuxc.farme.framework.CommApplication;
import com.zhuxc.farme.framework.okhttp_volley.RequestManager;
import com.zhuxc.farme.framework.utils.ThreadPoolManager;
import com.zhuxc.farme.framework.view.CustomProgressDialog;


/**
 * 
 * @ClassName: BaseActivity 
 * @Description: TODO
 * @author zhuxc
 * @date modify by 2015-7-6 上午9:15:06 
 *
 */

public abstract class BaseActivity extends FragmentActivity implements
		OnClickListener {
	protected Context context;
	private CommApplication application;
	protected ThreadPoolManager threadPoolManager;

	public BaseActivity() {
		threadPoolManager = ThreadPoolManager.getInstance();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		application = CommApplication.getInstance();
		application.addActvity(this);
		context = getApplicationContext();

		// 处理报错日志--输出到指定文件夹
//		SysCrashHandler crashHandler = SysCrashHandler.getInstance();
//		crashHandler.init(this);


		//判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}

	}

	protected void LoadView(int id) {
		this.setContentView(id);
	}

	protected void LoadView(View id) {
		this.setContentView(id);
	}

	/**
	 * 子类用来初始化操作
	 */
	protected void init() {
	};

	/**
	 * 绑定ID
	 */
	protected void findViewById() {
	};

	/**
	 * 子类用来设置监听的操作
	 */
	protected void setListner() {
	};

	public static CustomProgressDialog progressDialog;
	private static boolean mShowingDialog = false;

	/**
	 * 启动一个dialog
	 */
	protected void showProgressDialog() {
	    progressDialog = CustomProgressDialog.createDialog(BaseActivity.this);
		progressDialog.setCanceledOnTouchOutside(false);
		// this.progressDialog.setTitle(getString(R.string.loadTitle));
//		progressDialog.setMessage("正在加载中...");
		// this.progressDialog.setMessage(getString(R.string.LoadContent));
		if (!progressDialog.isShowing())
			progressDialog.show();
	}

	/**
	 * 关闭dialog
	 */
	protected void closeProgressDialog() {
		if (this.progressDialog != null)
			this.progressDialog.dismiss();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		application.removeActvity(this);
		RequestManager.getInstance(this).cancelAll(this);//关闭页面时取消所有网络请求
		context = null;
		threadPoolManager = null;
		if (progressDialog != null) {
			progressDialog.dismiss();
			progressDialog = null;
		}
	}
	
	protected void goActivity(Activity activity,Intent intent){
		activity.startActivity(intent);
//		overridePendingTransition(enterAnim, exitAnim)
	}

}
