package com.zhuxc.farme.framework.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;


import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
/**
 * 获取设备信息
 * @ClassName: PhoneUtils 
 * @Description: TODO
 * @author zhuxc
 * @date modify by 2015-7-6 上午9:20:06 
 *
 */
public class PhoneUtils {

	public static PhoneUtils phoneutils;
	
	public static PhoneUtils newInstance() {
		if (null == phoneutils) {
			phoneutils = new PhoneUtils();
		}
		return phoneutils;
	}
	
	
//	设备厂商
	public  String getManufactory(){
	    return Build.MANUFACTURER;
	}
	
//	设备型号
	public  String getUnitType(){
	    return Build.MODEL;
	}
	
//	// 获取手机MAC地址  
//	private String getMacAddress() {  
//	    String result = "";  
//	    WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);  
//	    WifiInfo wifiInfo = wifiManager.getConnectionInfo();  
//	    result = wifiInfo.getMacAddress();  
//	    return result;  
//	}
	
//	CPU名称
	public  String getCpuName()
	{
	    String cpuName = "N/A";
	    try
	    {
	        BufferedReader reader = new BufferedReader(new FileReader("/proc/cpuinfo"));
	        String line = reader.readLine();
	        while (line != null)
	        {
	            if (line.toLowerCase().indexOf("processor") >= 0)
	            {
	                String[] array = line.split(":\\s");
	                cpuName = array[1].trim();
	                break;
	            }
	            line = reader.readLine();
	        }
	        reader.close();
	        reader = null;
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    return cpuName;
	}
	
	
	
	//CPU个数
	public  int getNumCores() {
	    //Private Class to display only CPU devices in the directory listing
	    class CpuFilter implements FileFilter {
	        @Override
	        public boolean accept(File pathname) {
	            //Check if filename is "cpu", followed by a single digit number
	            if(Pattern.matches("cpu[0-9]", pathname.getName())) {
	                return true;
	            }
	            return false;
	        }      
	    }

	    try {
	        //Get directory containing CPU info
	        File dir = new File("/sys/devices/system/cpu/");
	        //Filter to only list the devices we care about
	        File[] files = dir.listFiles(new CpuFilter());
	        //Return the number of cores (virtual CPU devices)
	        return files.length;
	    } catch(Exception e) {
	        //Print exception
	        e.printStackTrace();
	        //Default to return 1 core
	        return 1;
	    }
	}
	
	
	// 获取手机CPU信息  
	// 和内存信息同理，cpu信息可通过读取/proc/cpuinfo文件来得到，其中第一行为cpu型号，第二行为cpu频率。
	public String getCpuInfo() {  
	    String str1 = "/proc/cpuinfo";  
	    String str2 = "";  
	    String[] cpuInfo = { "", "" }; // 1-cpu型号 //2-cpu频率  
	    String[] arrayOfString;  
	    try {  
	        FileReader fr = new FileReader(str1);  
	        BufferedReader localBufferedReader = new BufferedReader(fr, 8192);  
	        str2 = localBufferedReader.readLine();  
	        arrayOfString = str2.split("\\s+");  
	        for (int i = 2; i < arrayOfString.length; i++) {  
	            cpuInfo[0] = cpuInfo[0] + arrayOfString[i] + " ";  
	        }  
	        str2 = localBufferedReader.readLine();  
	        arrayOfString = str2.split("\\s+");  
	        cpuInfo[1] += arrayOfString[2];  
	        localBufferedReader.close();  
	    } catch (IOException e) {  
	    }  
	    // Log.i(TAG, "cpuinfo:" + cpuInfo[0] + " " + cpuInfo[1]);  
	    return "1-cpu型号:" + cpuInfo[0] + "2-cpu频率:" + cpuInfo[1];  
	}  
	

}
