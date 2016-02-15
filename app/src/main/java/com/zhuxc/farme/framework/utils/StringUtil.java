package com.zhuxc.farme.framework.utils;


import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 字符串工具类
 * @ClassName: StringUtil 
 * @Description: TODO
 * @author zhuxc
 * @date modify by 2015-7-6 上午11:05:21 
 *
 */
public class StringUtil {

	/**
	 * 使用MD5对原文进行加密
	 * 
	 * @param value 需要被加密的原文
	 * 
	 * @return MD5加密后数据
	 */
	public static String md5(String value) {
		StringBuilder sb = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] result = digest.digest(value.getBytes());
			sb = new StringBuilder();
			for (byte b : result) {
				String hexString = Integer.toHexString(b & 0xFF);
				if (hexString.length() == 1) {
					sb.append("0" + hexString);// 0~F
				} else {
					sb.append(hexString);
				}
			}
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	/**
	 * 获得一个UUID
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}

	/**
	 * 获得指定数目的UUID
	 * 
	 * @param number
	 *            int 需要获得的UUID数量
	 * @return String[] UUID数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}

	/**
	 * 给传入字符加密
	 * 
	 * @param str
	 * @return String
	 */
	public static String doEncrypt(String str) {
		return str;
		// return toMD5(str);
	}

	

	/**
	 * 三位数编码自增(ex: param 001,return 002;param 002,return 003)
	 * 
	 * @param CODE
	 * @return string
	 */
	public static String codeIncrement(String CODE) {
		int i = Integer.valueOf(CODE);
		i = i + 1;
		CODE = String.valueOf(i);
		if (i < 10) {
			CODE = "00" + CODE;
		} else if (i >= 10 && i < 100) {
			CODE = "0" + CODE;
		}
		return CODE;
	}

	/**
	 * 数字格式化为n位字符串
	 * 
	 * @param orderId
	 * @param n
	 * @return string
	 */
	public static String int2String(int orderId, int n) {
		String str = "";
		for (int i = 0; i < n; i++) {
			str += "0";
		}
		str = str + orderId;
		str = str.substring(str.length() - n);
		return str;
	}

	/**
	 * doule型转成保留两位小数的字符串型
	 * 
	 * @param dou
	 * @return
	 */
	public static String double2string(double dou) {
		DecimalFormat df = new DecimalFormat("0.00");
		String str = df.format(dou);
		return str;
	}

	/**
	 * 两个Double数相乘
	 * 
	 * @param v1
	 * @param v2
	 * @return Double
	 */
	public static Double mul(Double v1, Double v2) {
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 两个Double数相除，并保留scale位小数
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return Double
	 */
	public static Double div(Double v1, Double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 判定两个字符串的值是否相等
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isEqual(String str1, String str2) {
		boolean b = false;
		if (!str1.equals("") && !str1.equals("")) {
			str1.equals(str2);
			b = true;
		}
		return b;
	}

	
	/**
	 * 获取方法名
	 * 
	 * @param tableName
	 * @return
	 */
	public static String getFunName(String tableName) {
		if (tableName == null)
			return null;
		tableName = tableName.toLowerCase();
		String[] strs = tableName.split("_");
		if (strs.length > 0) {
			tableName = "";
			for (int i = 0; i < strs.length; i++) {
				tableName = tableName + strs[i].substring(0, 1).toUpperCase() + strs[i].substring(1, strs[i].length());
			}
		}
		return tableName;
	}

	/**
	 * 把Null值格式化为指定数字
	 * 
	 * @param bf
	 * @param af
	 * @return int
	 */
	public static int formatNullToInteger(Integer bf, Integer af) {
		if (bf == null) {
			bf = af;
		}
		return bf;
	}

	/**
	 * 把Null值格式化为指定数字
	 * 
	 * @param bf
	 * @param af
	 * @return int
	 */
	public static Double formatNullToDouble(Double bf, Double af) {
		if (bf == null) {
			bf = af;
		}
		return bf;
	}

	/**
	 * 空文字转化为指定文字
	 * 
	 * @param bf
	 * @param af
	 * @return String
	 */
	public static String formatNullToString(String bf, String af) {
		if (bf == null || bf == "") {
			bf = af;
		}
		return bf;
	}

	/**
	 * 把Null值格式化为空字符
	 * 
	 * @param Object
	 * @return Object
	 */
	public static Object formatNull(Object obj) {
		if (obj == null) {
			obj = "";
		}
		return obj;
	}

	/**
	 * 文字是否为空
	 * 
	 * @param str
	 * @param type
	 *            0:null or ""
	 * @param type
	 *            1:null
	 * @param type
	 *            2:""
	 * @return boolean
	 */
	public static boolean isNull(String str, int type) {
		if (type == 0) {
			if (str == null || str.equals("")) {
				return true;
			}
		}
		if (type == 1) {
			if (str == null) {
				return true;
			}
		}
		if (type == 2) {
			if (str != null && str.equals("")) {
				return true;
			}
		}
		return false;
	}

	

	/**
	 * 把数组根据特定分隔符拼成字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String arrayToString(String[] str) {
		return arrayToString(str, ",", "", "");
	}

	public static String arrayToString(String[] str, String delimiter, String prefix, String suffix) {
		String temp = "";
		if (str != null) {
			if (delimiter == null) {
				delimiter = "";
			}
			if (prefix == null) {
				prefix = "";
			}
			if (suffix == null) {
				suffix = "";
			}
			for (int i = 0; i < str.length; i++) {
				temp += prefix + str[i] + suffix + delimiter;
			}
			if (temp != "") {
				temp = temp.substring(0, temp.length() - delimiter.length());
			}
		}
		return temp;
	}

	/**
	 * 解析字符串
	 * 
	 * @param str
	 *            要解析的字符串
	 * @param divisionChar
	 *            解析所需要的字符
	 * @return String[]
	 */
	public static String[] stringSplit(String str, String divisionChar) {
		String[] strs = null;
		try {
			strs = str.split(divisionChar);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return strs;
	}


	/***
	 * 半角转换为全角
	 * 
	 * @param input
	 * @return
	 */
	public static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	/**
	 * 去除特殊字符。
	 * 
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static String StringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

}
