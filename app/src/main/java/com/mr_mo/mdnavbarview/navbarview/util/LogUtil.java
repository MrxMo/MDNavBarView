package com.mr_mo.mdnavbarview.navbarview.util;

import android.util.Log;

/**
 * 日志工具类。统一管理日志信息的显示/隐藏
 *
 * @author moguangjian
 *
 * @since 2014-11-26 上午11:13:29
 */
public class LogUtil {

	private static final String TAG = LogUtil.class.getSimpleName();
	/** 是否开启debug模式，false则不打印日志 */
	private static final boolean isDebug = true;
	/** 是否打印e级别异常，开启后，在debug模式也可正常打印 */
	private static final boolean isShowE = true;

	/** 是否已经显示佛祖 */
	private static boolean isShowBuddha = false;

	/**
	 * 佛祖显灵
	 */
	public static void showBuddha() {
		if (isShowBuddha) {
			return;
		}
		isShowBuddha = true;
		Log.i(TAG, "                            _ooOoo_");
		Log.i(TAG, "                           o8888888o");
		Log.i(TAG, "                          88\" . \"88");
		Log.i(TAG, "                           (| -_- |)");
		Log.i(TAG, "                            O\\ = /O");
		Log.i(TAG, "                        ____/`---'\\____");
		Log.i(TAG, "                      .   ' \\| |// `.");
		Log.i(TAG, "                       / \\\\||| : |||// \\");
		Log.i(TAG, "                     / _||||| -:- |||||- \\");
		Log.i(TAG, "                       | | \\\\\\ - /// | |");
		Log.i(TAG, "                     | \\_| ''\\---/'' | |");
		Log.i(TAG, "                      \\ .-\\__ `-` ___/-. /");
		Log.i(TAG, "                   ___`. .' /--.--\\ `. . __");
		Log.i(TAG, "                .\"\" '< `.___\\_<|>_/___.' >'\"\".");
		Log.i(TAG, "               | | : `- \\`.;`\\ _ /`;.`/ - ` : | |");
		Log.i(TAG, "                 \\ \\ `-. \\_ __\\ /__ _/ .-` / /");
		Log.i(TAG, "         ======`-.____`-.___\\_____/___.-`____.-'======");
		Log.i(TAG, "                            `=---='");
		Log.i(TAG, "         .............................................");
		Log.i(TAG, "         				信佛祖，无bug");
		Log.i(TAG, "         				del bug ...");
	}

	/**
	 * 打印log.i日志
	 *
	 * @param tag
	 * @param msg
	 */
	public static void i(String tag, String msg) {
		showBuddha();

		if (isDebug) {
			Log.i(tag, msg);
		}
	}

	/**
	 * 打印log.w日志
	 *
	 * @param tag
	 * @param msg
	 */
	public static void w(String tag, String msg) {
		if (isDebug) {
			Log.w(tag, msg);
		}
	}

	/**
	 * 打印log.e日志
	 *
	 * @param tag
	 * @param msg
	 */
	public static void e(String tag, String msg) {
		if (isShowE || isDebug) {
			Log.e(tag, msg);
		}
	}

	/**
	 * 打印(println)日志
	 */
	public static void println(String TAG, String msg) {
		if (isDebug) {
			System.out.println(TAG + " : " + msg);
		}
	}

}
