package com.zhuxc.farme.framework.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 * Gson 工具类
 * @ClassName: GsonTools 
 * @Description: TODO
 * @author zhuxc
 * @date modify by 2015-7-3 下午3:03:29 
 *
 */
public class GsonTools {

	public GsonTools() {
		
	}


	
	/**
	 * json字符串转T
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> T gson2Bean(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		T t = gson.fromJson(gsonString, cls);
		return t;
	}
	
	/**json字符串转list<T>
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> jsonArray2List(JSONArray jsonArray, Class<T> cls) {
		List<T> list = new ArrayList<T>();
//		List<T> list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
//		}.getType());
		if(jsonArray!=null&&jsonArray.length()>0){
			for (int i = 0; i < jsonArray.length(); i++) {
				list.add(gson2Bean(jsonArray.optJSONObject(i).toString(), cls));
			}
		}
		return list;
	}
	
	/**list<T>转json字符串
	 * @param lists
	 * @return
	 */
	public static <T> String list2GsonString(List<T> lists) {
		Gson gson = new Gson();
		String gsonString = gson.toJson(lists);
		return gsonString;
	}
	/**
	 * 创建一个json字符串
	 * @param object
	 * @return
	 */
	public static String createGsonString(Object object) {
		Gson gson = new Gson();
		String gsonString = gson.toJson(object);
		return gsonString;
	}

	/**json字符串转list<T>
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> gson2List(String gsonString, Class<T> cls) {
		Gson gson = new Gson();
		List<T> list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
		}.getType());
		return list;
	}

	/**
	 * json字符串转list<Map<String,T>>
	 * @param gsonString
	 * @return
	 */
	public static <T> List<Map<String, T>> gson2ListMaps(String gsonString) {
		List<Map<String, T>> list = null;
		Gson gson = new Gson();
		list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
		}.getType());
		return list;
	}

	/**json字符串转Map<String,T>
	 * @param gsonString
	 * @return
	 */
	public static <T> Map<String, T> gson2Maps(String gsonString) {
		Map<String, T> map = null;
		Gson gson = new Gson();
		map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
		}.getType());
		return map;
	}

}
