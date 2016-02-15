package com.zhuxc.farme.framework.utils;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.widget.Button;

import com.zhuxc.farme.framework.view.CustomProgressDialog;


/***
 * @ClassName: CommonDialog
 * @Description: 对话框工具类
 * @author zhuxc
 * @date 2014-12-8 上午11:32:36
 * 
 */
public class CommonDialog {
	private final static String TAG = "CommonDialog";

	/**
	 * @Title: showExitDialog
	 * @Description: 退出对话框
	 * @author zhuxc
	 * @date 2014-12-8 上午11:32:22
	 * @param @param context
	 * @return void
	 * @throws
	 */
	public static void showExitDialog(final Context context, final Button btn_fragmenttab4_exit, final Button togglebtn_fragmenttab4) {
		try {
			AlertDialog.Builder dialog = new AlertDialog.Builder(context);
			dialog.setTitle("退出提示");
			dialog.setMessage("您确定要退出登录吗?");
			dialog.setCancelable(false);
			dialog.setOnKeyListener(keylistener);
			dialog.setNegativeButton("取消", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dailog, int arg1) {
					// TODO Auto-generated method stub
					dailog.dismiss();
				}
			});
			dialog.setPositiveButton("退出", new OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					// ToastUtils.showToast(context, "退出正在开发中...");
				}
			});
			dialog.create().show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @Title: showInfoDialog
	 * @Description: 信息提示框
	 * @author zhuxc
	 * @date 2014-12-8 上午11:32:22
	 * @param @param context
	 * @return void
	 * @throws
	 */
	public static void showInfoDialog(final Context context, String contetnt) {
		try {
			AlertDialog.Builder dialog = new AlertDialog.Builder(context);
			dialog.setMessage(contetnt);
			dialog.setCancelable(false);
			dialog.setOnKeyListener(keylistener);
			dialog.setPositiveButton("确定", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int arg1) {
					// TODO Auto-generated method stub
					// ToastUtils.showToast(context, "退出正在开发中...");
					dialog.dismiss();
				}
			});
			dialog.create().show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @Title: showGesturePasswordPromptDialog
	 * @Description: 手势输错提示对话框
	 * @author zhuxc
	 * @date 2015-1-4 上午10:18:48
	 * @param @param context
	 * @return void
	 * @throws
	 */
	public static void investFailDialog(final Context context, String content) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		try {
			// dialog.setTitle("网络断开提示");
			dialog.setMessage(content);
			dialog.setCancelable(false);
			dialog.setOnKeyListener(keylistener);
			dialog.setPositiveButton("确定", new OnClickListener() {

				@Override
				public void onClick(DialogInterface diaglog, int arg1) {
					// TODO Auto-generated method stub
					// ToastUtils.showToast(context, "退出正在开发中...");
					// Intent intent = new Intent(context, LoginActivity.class);
					// context.startActivity(intent);
					// ((Activity) context).finish();
					diaglog.dismiss();
				}
			});
			dialog.create().show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @Title: callDialog
	 * @Description: 拨打电话对话框
	 * @author zhuxc
	 * @date 2014-12-23 下午1:50:17
	 * @param @param context
	 * @return void
	 * @throws
	 */
	public static void callDialog(final Context context) {
		try {
			AlertDialog.Builder dialog = new AlertDialog.Builder(context);
			dialog.setTitle("拨打提示");
			dialog.setMessage("400-616-7070");
			dialog.setCancelable(false);
			dialog.setOnKeyListener(keylistener);
			dialog.setNegativeButton("取消", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dailog, int arg1) {
					// TODO Auto-generated method stub
					dailog.dismiss();
				}
			});
			dialog.setPositiveButton("呼叫", new OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					// ToastUtils.showToast(context, "退出正在开发中...");
//					CommonUtil.callPhone(context, "4006167070");
				}
			});
			dialog.create().show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	};

	private static AlertDialog.Builder dialog;

	/**
	 * @Title: showGesturePasswordPromptDialog
	 * @Description: 手势输错提示对话框
	 * @author zhuxc
	 * @date 2015-1-4 上午10:18:48
	 * @param @param context
	 * @return void
	 * @throws
	 */
	public static void showGesturePasswordPromptDialog(final Context context) {
		try {
			AlertDialog.Builder dialog = new AlertDialog.Builder(context);
			// dialog.setTitle("网络断开提示");
			dialog.setMessage("您已连续5次输错手势，手势解锁已关闭，请重新登录。");
			dialog.setCancelable(false);
			dialog.setOnKeyListener(keylistener);
			dialog.setPositiveButton("确定", new OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					// ToastUtils.showToast(context, "退出正在开发中...");
					// CommonApplication.clear(context);
					// Intent intent = new Intent(context, LoginActivity.class);
					// intent.putExtra("where", "gesturePassword");
					// CommonUtils.setGesturePassword(context, false);//
					// 清空之前的手势密码
					// CommonUtils.clearLoginInfo(context);
					// context.startActivity(intent);
					// ((Activity) context).finish();

				}
			});
			dialog.create().show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void payPromptDialog(final Context context) {
		try {
			AlertDialog.Builder dialog = new AlertDialog.Builder(context);
			// dialog.setTitle("网络断开提示");
			dialog.setMessage("对不起，不能充值");
			dialog.setCancelable(false);
			dialog.setOnKeyListener(keylistener);
			dialog.setPositiveButton("确定", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int arg1) {
					// TODO Auto-generated method stub
					// ToastUtils.showToast(context, "退出正在开发中...");
					dialog.dismiss();

				}
			});
			dialog.create().show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @Title: showSetGesturePasswordPromptDialog
	 * @Description: 意见对话框
	 * @author zhuxc
	 * @date 2015-1-4 下午1:38:23
	 * @param @param context
	 * @return void
	 * @throws
	 */
	public static void showFeedBackPromptDialog(final Activity context) {
		try {
			AlertDialog.Builder dialog = new AlertDialog.Builder(context);
			// dialog.setTitle("网络断开提示");
			dialog.setMessage("反馈已成功提交，感谢您对抱财网的支持！");
			dialog.setCancelable(false);
			dialog.setOnKeyListener(keylistener);
			dialog.setPositiveButton("确定", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int arg1) {
					dialog.dismiss();
				}
			});
			dialog.create().show();
		} catch (Exception e) {
		}
	}

	static OnKeyListener keylistener = new OnKeyListener() {
		public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
			if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
				return true;
			} else {
				return false;
			}
		}
	};

	public static CustomProgressDialog progressDialog;
	private static boolean mShowingDialog = false;

	/**
	 * 启动一个dialog
	 */
	public static void showProgressDialog(Context context) {
		try {
			if (!mShowingDialog) {
				progressDialog = CustomProgressDialog.createDialog(context);
				progressDialog.setCanceledOnTouchOutside(false);
				// this.progressDialog.setTitle(getString(R.string.loadTitle));
				progressDialog.setMessage("");
				// this.progressDialog.setMessage(getString(R.string.LoadContent));
				if (!progressDialog.isShowing())
					progressDialog.show();

				mShowingDialog = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 关闭dialog
	 */
	public static void closeProgressDialog() {
		try {
			if (progressDialog != null&&progressDialog.isShowing()) {
				progressDialog.dismiss();
				mShowingDialog = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static Dialog dialog_msg;


}
