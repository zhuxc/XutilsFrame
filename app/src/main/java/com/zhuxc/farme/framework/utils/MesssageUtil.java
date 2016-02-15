package com.zhuxc.farme.framework.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * 信息工具类
 * @ClassName: MesssageUtil 
 * @Description: TODO
 * @author zhuxc
 * @date 2015-5-12 下午1:35:40 
 *
 */
public class MesssageUtil {

	/**
	 * 打电话
	 * @param context
	 * @param phone
	 */
	public static void call(Context context,String phone){
		 Intent intent = new Intent("android.intent.action.DIAL",Uri.parse("tel:"+phone));//自定义的Intent
		 context.startActivity(intent);
	}
}
