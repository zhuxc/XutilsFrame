package com.zhuxc.farme.framework.utils;


import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class VersionUtil {
	@SuppressWarnings("unused")
	private final static String TAG = "VersionUtil";
	private Context context;

	public VersionUtil(Context context) {
		this.context = context;
	}

	/**
	 * 获得当前程序版本信息
	 * 
	 * @return
	 */
	public Map<String, String> getCurrentVersion() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			int curVersionCode = info.versionCode;
			String curVersionName = info.versionName;
			map.put("versionCode", String.valueOf(curVersionCode));
			map.put("curVersionName", curVersionName);
		} catch (NameNotFoundException e) {
			e.printStackTrace(System.err);
		}
		return map;
	}

	/**
	 * 比较版本号
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int compare(String s1, String s2) {
		if (s1 == null && s2 == null)
			return 0;
		else if (s1 == null)
			return -1;
		else if (s2 == null)
			return 1;

		String[] arr1 = s1.split("[^a-zA-Z0-9]+"), arr2 = s2.split("[^a-zA-Z0-9]+");

		int i1, i2, i3;

		for (int ii = 0, max = Math.min(arr1.length, arr2.length); ii <= max; ii++) {
			if (ii == arr1.length)
				return ii == arr2.length ? 0 : -1;
			else if (ii == arr2.length)
				return 1;

			try {
				i1 = Integer.parseInt(arr1[ii]);
			} catch (Exception x) {
				i1 = Integer.MAX_VALUE;
			}

			try {
				i2 = Integer.parseInt(arr2[ii]);
			} catch (Exception x) {
				i2 = Integer.MAX_VALUE;
			}

			if (i1 != i2) {
				return i1 - i2;
			}

			i3 = arr1[ii].compareTo(arr2[ii]);

			if (i3 != 0)
				return i3;
		}

		return 0;
	}

}