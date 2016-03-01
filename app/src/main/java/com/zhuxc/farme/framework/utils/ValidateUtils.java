package com.zhuxc.farme.framework.utils;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: ValidateUtils
 * @Description: 常用数据格式校验
 * @author zhuxc
 * @date 2014-12-4 下午6:00:44
 * 
 */
public class ValidateUtils {
	private final static String TAG = "ValidateUtils";

	/**
	 * @Title: isEmpty
	 * @Description: 非空判断
	 * @author zhuxc
	 * @date 2014-12-4 下午5:54:02
	 * @param @param content
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isEmpty(String content) {
		if (null != content && !"".equals(content)) {
			return false;
		}
		return true;
	}

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			b = m.matches();
		} else {
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}

	/**
	 * @Title: identity
	 * @Description: 校验身份证
	 * @author zhuxc
	 * @date 2014-12-4 下午6:00:03
	 * @param @param str
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean identity(String str) {
		CheckIdCard checIdCard = new CheckIdCard(str);

		Log.d(TAG, "result=" + checIdCard.validate());
		return checIdCard.validate();
	}

	/**
	 * 检查是否是邮箱
	 * 
	 * @param paramString
	 * @return
	 */
	public static boolean isValidEmail(String paramString) {

		String regex = "[a-zA-Z0-9_\\.]{1,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
		if (paramString.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Title: nincValidate
	 * @Description: 昵称正则验证
	 * @author zhuxc
	 * @date 2014-12-11 下午5:05:37
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean nincValidate(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		try {
			p = Pattern.compile("^\\d*([\u4e00-\u9fa5]|[a-zA-Z])+\\d*$"); //
			m = p.matcher(str);
			b = m.matches();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return b;
	}

	/**
	 * @Title: passwordValidate
	 * @Description: 密码校验
	 * @author zhuxc
	 * @date 2014-12-11 下午5:48:25
	 * @param @param str
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean passwordValidate(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		try {
			p = Pattern.compile(""); //
			m = p.matcher(str);
			b = m.matches();
		} catch (Exception e) {
			// TODO: handle exception
		}
		b = true;
		return b;
	}

	/**
	 * @Title: realNameValidate
	 * @Description: 真实姓名校验
	 * @author zhuxc
	 * @date 2014-12-11 下午5:57:00
	 * @param @param str
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean realNameValidate(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		try {
			p = Pattern.compile(""); //
			m = p.matcher(str);
			b = m.matches();
		} catch (Exception e) {
			// TODO: handle exception
		}
		b = true;
		return b;
	}
}
