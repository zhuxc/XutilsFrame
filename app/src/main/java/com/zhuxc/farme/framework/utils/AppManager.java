package com.zhuxc.farme.framework.utils;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Activity管理类
 * @author Robin
 *
 */
public class AppManager {
	
	private static CopyOnWriteArrayList<Activity> mActivityStack;
	private static AppManager mAppManager;

	private AppManager() {
	}

	/**
	 * 单一实例
	 */
	public static AppManager getInstance() {
		if (mAppManager == null) {
			mAppManager = new AppManager();
		}
		return mAppManager;
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		if (mActivityStack == null) {
			mActivityStack = new CopyOnWriteArrayList<Activity>();
		}
		mActivityStack.add(activity);
	}

//	/**
//	 * 获取栈顶Activity（堆栈中最后一个压入的）
//	 */
//	public Activity getTopActivity() {
//		Activity activity = mActivityStack.lastElement();
//		return activity;
//	}
//
//	/**
//	 * 结束栈顶Activity（堆栈中最后一个压入的）
//	 */
//	public void killTopActivity() {
//		Activity activity = mActivityStack.lastElement();
//		killActivity(activity);
//	}

	/**
	 * 结束指定的Activity
	 */
	public void killActivity(Activity activity) {
		try {
			if (activity != null) {
				mActivityStack.remove(activity);
				activity.finish();
				activity = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 结束指定类名的Activity
	 */
	public void killActivity(Class<?> cls) {
		for (Activity activity : mActivityStack) {
			if (activity.getClass().equals(cls)) {
				killActivity(activity);
			}
		}
	}

	/**
	 * 结束所有Activity
	 */
	public void killAllActivity() {
		for (int i = 0, size = mActivityStack.size(); i < size; i++) {
			if (null != mActivityStack.get(i)) {
				mActivityStack.get(i).finish();
			}
		}
		mActivityStack.clear();
	}
	/**
	 * 结束所有Activity除了指定页面
	 */
	public void killAllActivityExcept(Class aboutAcivity) {
//		for (int i = 0, size = mActivityStack.size(); i < size; i++) {
//			if (null != mActivityStack.get(i)) {
//				if (mActivityStack.get(i).getClass()!=loginAcivity) {
//					mActivityStack.get(i).finish();
//					mActivityStack.remove(mActivityStack.get(i));
//				}
//			}
//		}
		for (Activity activity:mActivityStack) {
			if(activity.getClass()!=aboutAcivity){
				activity.finish();
				mActivityStack.remove(activity);
			}
		}
	}

	/**
	 * 退出应用程序
	 */
	@SuppressWarnings("deprecation")
	public void AppExit(Context context) {
		try {
			killAllActivity();
			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.restartPackage(context.getPackageName());
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
