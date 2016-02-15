package com.zhuxc.farme.framework.utils;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 数据库资源释放
 * 
 * @author zwy
 * 
 */
public class DBUtil {
	
	/**
	 * 释放游标
	 * @param cursor Cursor游标
	 */
	public static void Release(Cursor cursor) {
		Release(null, cursor);
	}

	/**
	 * 释放数据库连接
	 * @param conn SQLiteDatabase数据库
	 */
	public static void Release(SQLiteDatabase conn) {
		Release(conn, null);
	}

	/**
	 * 释放游标并释放数据库连接
	 * @param conn  SQLiteDatabase数据库
	 * @param cursor Cursor游标
	 */
	public static void Release(SQLiteDatabase conn, Cursor cursor) {
		if (cursor != null) {
			try {
				cursor.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			cursor = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
