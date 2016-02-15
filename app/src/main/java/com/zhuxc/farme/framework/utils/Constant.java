package com.zhuxc.farme.framework.utils;


import java.util.ArrayList;
import java.util.List;


import android.os.Environment;

/**
 * 常亮类
 * @ClassName: Constant 
 * @Description: TODO
 * @author zhuxc
 * @date 2015-5-3 下午2:41:16 
 *
 */

public class Constant {
	public final static int FAILED = 0;  //网络连接失败
	public final static int SUCCESS = 200;  //网络连接接成功
	public static boolean exit = true;  //退出 默认为true
	/**
	 * 数据文件的根路径 目前定在外部存储卡中
	 */
	public static String BasePath = Environment.getExternalStorageDirectory().getAbsolutePath();
	public static String SDPATH = BasePath + "/百分百云商/";
	public static final String APP_FOLDER_NAME = "百分百云商";
	public static String RootLog = "mylog";
	public static String ImagePath = "images";
	/**
	 * 总文件夹的路径
	 */
	public static String Log = BasePath + "/" + RootLog;
	/**
	 * 分享链接
	 */
	public final static String SHARE_IMAGENAME = "shareimage.png";
	public static final String SHARE_URL = "https://www.baidu.com/";
	/** 表情 */
	public static int NUM = 20;// 每页20个表情,还有最后一个删除button
	public static final int NUM_PAGE = 3;// 总共有多少页(实际上有3页，从0开始算)
	public static final int FACE_TOTAL = 60;// 总共多少表情
	public static final String COPY_IMAGE = "EASEMOBIMG";
	public static final int REQUEST_CODE_COPY_AND_PASTE = 11;
	
	public static final String RESULT_OK = "1";
	public static final String RESULT_FAIL = "0";

	
	//sharepreference中的记录值的key
	public static final String SHARE_USERID="userId";
	public static final String SHARE_Account="account";
	public static final String SHARE_PASSWORD="userPwd";
	public static final String SHARE_USERNAME="userName";
	public static final String SHARE_SCARDID="scardId";
	public static final String SHARE_FIRSTENTER="firstEnter";
	public static final String SHARE_CLASSID="classId";
	public static final String SHARE_CLASSCORD="classCode";
	public static final String SHARE_PARENTNAME="parentName";
	public static final String SHARE_CHATID="chatId";
	public static final String SHARE_ADDRESSINFO="address";
}
