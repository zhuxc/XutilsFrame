package com.zhuxc.farme.framework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import android.annotation.SuppressLint;

/**
 * 时间日期工具类
 * @ClassName: DateUtils 
 * @Description: TODO
 * @author zhuxc
 * @date modify by 2015-7-6 上午11:02:09 
 *
 */
public class DateUtils {

	
	/**
	 * 获取当前时间
	 * 
	 * @param formate
	 *            1:2012-10-6 12:36:35
	 * @param formate
	 *            2:2012-10-6
	 * @param formate
	 *            3:12:36:35
	 * @param formate
	 *            4:12-10-6 下午12:36
	 * @param formate
	 *            5:20121006
	 * @param formate
	 *            6:2012-10-06
	 * @return String
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getTime(int formate) {
		String year = "";
		String month = "";
		String day = "";
		Date now = new Date();
		DateFormat d = null;
		String str = null;
		switch (formate) {
		case 1:
			d = DateFormat.getDateTimeInstance();// 日期时间
			str = d.format(now);
			break;
		case 2:
			d = DateFormat.getDateInstance(); // 日期
			str = d.format(now);
			break;
		case 3:
			d = DateFormat.getTimeInstance();// 时间
			str = d.format(now);
			break;
		case 4:
			d = DateFormat.getInstance(); // 使用SHORT风格显示日期和时间
			str = d.format(now);
			break;
		case 5:
			d = DateFormat.getDateInstance(); // 日期
			str = d.format(now);
			year = str.split("-")[0];
			month = "0" + str.split("-")[1];
			day = "0" + str.split("-")[2];

			str = year + month.substring(month.length() - 2) + day.substring(day.length() - 2);
			break;
		case 6:
			d = DateFormat.getDateInstance(); // 日期
			str = d.format(now);
			year = str.split("-")[0];
			month = "0" + str.split("-")[1];
			day = "0" + str.split("-")[2];

			str = year + "-" + month.substring(month.length() - 2) + "-" + day.substring(day.length() - 2);
			break;
		case 7:
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			str = format.format(now);
		default:
			break;
		}
		return str;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param formate
	 *            1:2012-10-6 12:36:35
	 * @param formate
	 *            2:2012-10-6
	 * @param formate
	 *            3:12:36:35
	 * @param formate
	 *            4:12-10-6 下午12:36
	 * @param formate
	 *            5:20121006
	 * @param formate
	 *            6:2012-10-06
	 * @return String
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getTime(Date date, int formate) {
		String year = "";
		String month = "";
		String day = "";
		DateFormat d = null;
		String str = null;
		switch (formate) {
		case 1:
			d = DateFormat.getDateTimeInstance();// 日期时间
			str = d.format(date);
			break;
		case 2:
			d = DateFormat.getDateInstance(); // 日期
			str = d.format(date);
			break;
		case 3:
			d = DateFormat.getTimeInstance();// 时间
			str = d.format(date);
			break;
		case 4:
			d = DateFormat.getInstance(); // 使用SHORT风格显示日期和时间
			str = d.format(date);
			break;
		case 5:
			d = DateFormat.getDateInstance(); // 日期
			str = d.format(date);
			year = str.split("-")[0];
			month = "0" + str.split("-")[1];
			day = "0" + str.split("-")[2];

			str = year + month.substring(month.length() - 2) + day.substring(day.length() - 2);
			break;
		case 6:
			d = DateFormat.getDateInstance(); // 日期
			str = d.format(date);
			year = str.split("-")[0];
			month = "0" + str.split("-")[1];
			day = "0" + str.split("-")[2];

			str = year + "-" + month.substring(month.length() - 2) + "-" + day.substring(day.length() - 2);
			break;
		case 7:
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			str = format.format(date);
		default:
			break;
		}
		return str;
	}

	
	/**
	 * 解析日期为大写
	 * 
	 * @param str
	 * @return
	 */
	public static String[] DateSplit(String str) {
		String[] strs = null;
		String[] split = null;
		String[] strings = new String[4];
		try {
			split = str.split(" ");
			strs = split[0].split("-");
			if (strs.length == 3) {
				int m = Integer.parseInt(strs[1]);
				if (m == 1) {
					strs[1] = "一月";
				} else if (m == 2) {
					strs[1] = "二月";
				} else if (m == 3) {
					strs[1] = "三月";
				} else if (m == 4) {
					strs[1] = "四月";
				} else if (m == 5) {
					strs[1] = "五月";
				} else if (m == 6) {
					strs[1] = "六月";
				} else if (m == 7) {
					strs[1] = "七月";
				} else if (m == 8) {
					strs[1] = "八月";
				} else if (m == 9) {
					strs[1] = "九月";
				} else if (m == 10) {
					strs[1] = "十月";
				} else if (m == 11) {
					strs[1] = "十一";
				} else if (m == 12) {
					strs[1] = "十二";
				}
			}
			strings[0] = strs[0];
			strings[1] = strs[1];
			strings[2] = strs[2];
			strings[3] = split[1];
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return strings;
	}
	/**
	 * 计算上传时间的
	 * @param created
	 * @return
	 */
	public static String getUploadtime(long created) {
		StringBuffer when = new StringBuffer();
		int difference_seconds;
		int difference_minutes;
		int difference_hours;
		int difference_days;
		int difference_months;
		long curTime = System.currentTimeMillis();
		difference_months = (int) (((curTime / 2592000) % 12) - ((created / 2592000) % 12));
		if (difference_months > 0) {
			when.append(difference_months + "月");
		}

		difference_days = (int) (((curTime / 86400) % 30) - ((created / 86400) % 30));
		if (difference_days > 0) {
			when.append(difference_days + "天");
		}

		difference_hours = (int) (((curTime / 3600) % 24) - ((created / 3600) % 24));
		if (difference_hours > 0) {
			when.append(difference_hours + "小时");
		}

		difference_minutes = (int) (((curTime / 60) % 60) - ((created / 60) % 60));
		if (difference_minutes > 0) {
			when.append(difference_minutes + "分钟");
		}

		difference_seconds = (int) ((curTime % 60) - (created % 60));
		if (difference_seconds > 0) {
			when.append(difference_seconds + "秒");
		}

		return when.append("前").toString();
	}

	/**
	 * 是否为日期
	 * 
	 * @param str
	 * @param formate
	 *            0:YYYY-MM-DD
	 * @param formate
	 *            1:YYYY/MM/DD
	 * @return
	 */
	public static boolean isDate(String str, int formate) {
		boolean b = true;
		String[] strs = null;
		try {
			if (formate == 0) {
				strs = str.split("-");
			}
			if (formate == 1) {
				strs = str.split("/");
			}
			if (strs.length == 3) {
				int y = Integer.parseInt(strs[0]);
				int m = Integer.parseInt(strs[1]);
				int d = Integer.parseInt(strs[2]);
				if (y < 1600 || y > 9999) {
					return false;
				}
				if (m < 1 || m > 12) {
					return false;
				}
				if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
					if (d < 1 || d > 31) {
						return false;
					}
				}
				if (m == 4 || m == 6 || m == 9 || m == 11) {
					if (d < 1 || d > 30) {
						return false;
					}
				}
				if (m == 2) {
					if ((y % 4 == 0 && y % 100 > 0) || y % 400 == 0) {
						if (d < 1 || d > 29) {
							return false;
						}
					} else {
						if (d < 1 || d > 28) {
							return false;
						}
					}
				}
			}
		} catch (NumberFormatException e) {
			b = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 计算日期间隔
	 * 
	 * @param earlyDate
	 * @param lateDate
	 * @param formate
	 *            0:YYYY-MM-DD
	 * @param formate
	 *            1:YYYY/MM/DD
	 * @return
	 */
	public static int GetYearDifference(String earlyDate, String lateDate, int formate) {
		int year = -1;
		String[] strs1 = null;
		String[] strs2 = null;
		try {
			if (isDate(earlyDate, formate) && isDate(lateDate, formate)) {
				if (formate == 0) {
					strs1 = earlyDate.split("-");
					strs2 = lateDate.split("-");
				}
				if (formate == 1) {
					strs1 = earlyDate.split("/");
					strs2 = lateDate.split("/");
				}
				int y1 = Integer.parseInt(strs1[0]);
				int m1 = Integer.parseInt(strs1[1]);
				int d1 = Integer.parseInt(strs1[2]);

				int y2 = Integer.parseInt(strs2[0]);
				int m2 = Integer.parseInt(strs2[1]);
				int d2 = Integer.parseInt(strs2[2]);

				year = y2 - y1;
				if (m2 < m1) {
					year = year - 1;
				} else if (m2 == m1) {
					if (d2 < d1) {
						year = year - 1;
					}
				}
			}
		} catch (NumberFormatException e) {
			year = -1;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return year;
	}

	/**
	 * 计算两个月之间的相差的月份
	 * 
	 * @param date1
	 * @param date2
	 * @return months
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	public static Integer getMonthBetweenDate(String date1, String date2) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		try {
			d1 = sd.parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date d2 = null;
		try {
			d2 = sd.parse(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int months = 0;// 相差月份
		int y1 = d1.getYear();
		int y2 = d2.getYear();
		int dm1 = d2.getMonth();// 起始日期月份
		int dm2 = d2.getMonth();// 结束日期月份
		int dd1 = d1.getDate(); // 起始日期天
		int dd2 = d2.getDate(); // 结束日期天
		if (d1.getTime() < d2.getTime()) {
			months = d2.getMonth() - d1.getMonth() + (y2 - y1) * 12;
			if (dd2 < dd1) {
				months = months - 1;
			}
		}
		return months;
	}


	private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH-mm-ss");
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat(
			"HH:mm:ss");
	public static String olddata = "";

	/**
	 * 获得当前日期时间
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 */
	public static String currentDatetime() {
		return datetimeFormat.format(now());
	}

	/**
	 * 格式化日期时间
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 */
	public static String formatDatetime(Date date) {
		return datetimeFormat.format(date);
	}

	/**
	 * 格式化日期时间
	 *
	 * @param date
	 * @param pattern
	 *            格式化模式，详见{@link SimpleDateFormat}构造器
	 *            <code>SimpleDateFormat(String pattern)</code>
	 * @return
	 */
	public static String formatDatetime(Date date, String pattern) {
		SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat
				.clone();
		customFormat.applyPattern(pattern);
		return customFormat.format(date);
	}

	/**
	 * 获得当前日期
	 * <p>
	 * 日期格式yyyy-MM-dd
	 *
	 * @return
	 */
	public static String currentDate() {
		return dateFormat.format(now());
	}

	/**
	 * 格式化日期
	 * <p>
	 * 日期格式yyyy-MM-dd
	 *
	 * @return
	 */
	public static String formatDate(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * 获得当前时间
	 * <p>
	 * 时间格式HH:mm:ss
	 *
	 * @return
	 */
	public static String currentTime() {
		return timeFormat.format(now());
	}

	/**
	 * 格式化时间
	 * <p>
	 * 时间格式HH:mm:ss
	 *
	 * @return
	 */
	public static String formatTime(Date date) {
		return timeFormat.format(date);
	}

	/**
	 * 获得当前时间的<code>java.util.Date</code>对象
	 *
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	public static Calendar calendar() {
		Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		return cal;
	}

	/**
	 * 获得当前时间的毫秒数
	 * <p>
	 * 详见{@link System#currentTimeMillis()}
	 *
	 * @return
	 */
	public static long millis() {
		return System.currentTimeMillis();
	}

	/**
	 *
	 * 获得当前Chinese月份
	 *
	 * @return
	 */
	public static int month() {
		return calendar().get(Calendar.MONTH) + 1;
	}

	/**
	 * 获得月份中的第几天
	 *
	 * @return
	 */
	public static int dayOfMonth() {
		return calendar().get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 今天是星期的第几天
	 *
	 * @return
	 */
	public static int dayOfWeek() {
		return calendar().get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 今天是年中的第几天
	 *
	 * @return
	 */
	public static int dayOfYear() {
		return calendar().get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 判断原日期是否在目标日期之前
	 *
	 * @param src
	 * @param dst
	 * @return
	 */
	public static boolean isBefore(Date src, Date dst) {
		return src.before(dst);
	}

	/**
	 * 判断原日期是否在目标日期之后
	 *
	 * @param src
	 * @param dst
	 * @return
	 */
	public static boolean isAfter(Date src, Date dst) {
		return src.after(dst);
	}

	/**
	 * 判断两日期是否相同
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isEqual(Date date1, Date date2) {
		return date1.compareTo(date2) == 0;
	}

	/**
	 * 判断某个日期是否在某个日期范围
	 *
	 * @param beginDate
	 *            日期范围开始
	 * @param endDate
	 *            日期范围结束
	 * @param src
	 *            需要判断的日期
	 * @return
	 */
	public static boolean between(Date beginDate, Date endDate, Date src) {
		return beginDate.before(src) && endDate.after(src);
	}

	/**
	 * 获得当前月的最后一天
	 * <p>
	 * HH:mm:ss为0，毫秒为999
	 *
	 * @return
	 */
	public static Date lastDayOfMonth() {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_MONTH, 0); // M月置零
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1
		cal.set(Calendar.MILLISECOND, -1);// 毫秒-1
		return cal.getTime();
	}

	/**
	 * 获得当前月的第一天
	 * <p>
	 * HH:mm:ss SS为零
	 *
	 * @return
	 */
	public static Date firstDayOfMonth() {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		return cal.getTime();
	}

	private static Date weekDay(int week) {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_WEEK, week);
		return cal.getTime();
	}

	/**
	 * 获得周五日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 *
	 * @return
	 */
	public static Date friday() {
		return weekDay(Calendar.FRIDAY);
	}

	/**
	 * 获得周六日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 *
	 * @return
	 */
	public static Date saturday() {
		return weekDay(Calendar.SATURDAY);
	}

	/**
	 * 获得周日日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 *
	 * @return
	 */
	public static Date sunday() {
		return weekDay(Calendar.SUNDAY);
	}

	/**
	 * 将字符串日期时间转换成java.util.Date类型
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 *
	 * @param datetime
	 * @return
	 */
	public static Date parseDatetime(String datetime) throws ParseException {
		return datetimeFormat.parse(datetime);
	}

	/**
	 * 将字符串日期转换成java.util.Date类型
	 * <p>
	 * 日期时间格式yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String date) throws ParseException {
		return dateFormat.parse(date);
	}

	/**
	 * 将字符串日期转换成java.util.Date类型
	 * <p>
	 * 时间格式 HH:mm:ss
	 *
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date parseTime(String time) throws ParseException {
		return timeFormat.parse(time);
	}

	/**
	 * 根据自定义pattern将字符串日期转换成java.util.Date类型
	 *
	 * @param datetime
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDatetime(String datetime, String pattern)
			throws ParseException {
		SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();
		format.applyPattern(pattern);
		return format.parse(datetime);
	}

	public static String getWeek(String pTime) {

		String Week = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {

			c.setTime(format.parse(pTime));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			Week += "Sunday";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 2) {
			Week += "Monday";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 3) {
			Week += "Tuesday";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 4) {
			Week += "Wednesday";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 5) {
			Week += "Thursday";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 6) {
			Week += "Friday";
		}
		if (c.get(Calendar.DAY_OF_WEEK) == 7) {
			Week += "Saturday";
		}
		return Week;
	}

	public static String getMonth(String pTime) {
		Locale l = new Locale("en");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		String Month = "";
		try {
			date = sdf.parse(pTime);
			Month = String.format(l, "%tb", date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String Month = "";
		//
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// Calendar c = Calendar.getInstance();
		// try {
		//
		// c.setTime(format.parse(pTime));
		//
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// if (c.get(Calendar.MONTH) == 1) {
		// Month += "January";
		// }
		// if (c.get(Calendar.MONTH) == 2) {
		// Month += "February";
		// }
		// if (c.get(Calendar.MONTH) == 3) {
		// Month += "March";
		// }
		// if (c.get(Calendar.MONTH) == 4) {
		// Month += "April";
		// }
		// if (c.get(Calendar.MONTH) == 5) {
		// Month += "May";
		// }
		// if (c.get(Calendar.MONTH) == 6) {
		// Month += "June";
		// }
		// if (c.get(Calendar.MONTH) == 7) {
		// Month += "July";
		// }
		// if (c.get(Calendar.DAY_OF_WEEK) == 8) {
		// Month += "August";
		// }
		// if (c.get(Calendar.MONTH) == 9) {
		// Month += "September";
		// }
		// if (c.get(Calendar.MONTH) == 10) {
		// Month += "October";
		// }
		// if (c.get(Calendar.MONTH) == 11) {
		// Month += "November";
		// }
		// if (c.get(Calendar.MONTH) == 12) {
		// Month += "December";
		// }
		return Month;
	}
}
