package com.zhuxc.farme.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.Log;


/**
 * 自定义Application
 * @ClassName: CommApplication 
 * @Description: TODO
 * @author zhuxc
 * @date 2015-4-3 下午2:46:30 
 *
 */
public class CommApplication extends Application {
	private List<Activity> records = new ArrayList<Activity>();
	public static String content;
	public static Context context;
	public static DisplayMetrics displayMetrics;
	//屏幕宽度与高度
	public static int screenHight;
	public static int ScreenWidth;
	// 原始UI界面设计图的宽度(px)，用于后期对控件做缩放
	public static final float UI_Design_Width = 720;
	public static final float UI_Design_Height = 1136;
	// 屏幕宽度缩放比（相对于原设计图）
	public static float screenWidthScale = 1f;
	public static float screenHeightScale = 1f;

	/** 缓存路径 */
	private static String cacheDir;
	private static final String TAG = "Application";
	private static CommApplication instance = new CommApplication();;
	
    public static StringBuffer sb;
    public static String add_now = null;//当前城市
    public static String address = null;//当前城市
    public static String lat_now = null;//纬度
    public static String lon_now = null;//经度
    public static String areaid = null;//当前地区id
  //设置全局用户信息对象



	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
		displayMetrics = getResources().getDisplayMetrics();
		displayMetrics = getResources().getDisplayMetrics();
		screenHight = displayMetrics.heightPixels;
		ScreenWidth = displayMetrics.widthPixels;
		// 初始化屏幕宽度缩放比例
		screenWidthScale = ScreenWidth / UI_Design_Width;
		screenHeightScale = screenHight / UI_Design_Height;
		
	}

	public  static CommApplication getInstance() {
		return instance;
	}


	
	/**
	 * 获取的 缓存目录，用于文件保存
	 * @return
	 */
	public static String getCacheDirPath() {
		File f;
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			f = new File(Environment.getExternalStorageDirectory() + "/comm/");
			if (!f.exists()) {
				f.mkdir();
			}
		} else {
			f = context.getCacheDir();
		}
		cacheDir = f.getAbsolutePath();
		return cacheDir;
	}

	/**
	 * 添加一个activity
	 * 
	 * @param activity
	 */
	public void addActvity(Activity activity) {
		records.add(activity);
		Log.d(TAG, "Current Acitvity Size :" + getCurrentActivitySize());
	}

	/**
	 * 移除一个activity
	 * 
	 * @param activity
	 */
	public void removeActvity(Activity activity) {
		records.remove(activity);
		Log.d(TAG, "Current Acitvity Size :" + getCurrentActivitySize());
	}

	/**
	 * 退出Activity
	 */
	public void exit() {
		for (Activity activity : records) {
			activity.finish();
		}
		// 杀死进程
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(0);
	}

	/**
	 * 获取当前activity数
	 * 
	 * @return
	 */
	public int getCurrentActivitySize() {
		return records.size();
	}
	
	/**
	 * 获取应用程序名称
	 * @return
	 */
	public String getApplicationName() { 
		PackageManager packageManager = null; 
		ApplicationInfo applicationInfo = null; 
		try { 
			packageManager = getApplicationContext().getPackageManager(); 
			applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0); 
		} catch (PackageManager.NameNotFoundException e) { 
			applicationInfo = null; 
		} 
		String applicationName = (String) packageManager.getApplicationLabel(applicationInfo); 
		return applicationName; 
	} 
	 
}
