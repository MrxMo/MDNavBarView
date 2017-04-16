package com.mrmo.mnavbarviewlib.util;

import android.content.Context;

/**
 * Android大小单位转换工具类
 * @author moguangjian
 * @dateTime 2014-04-08 15:18:57
 *
 */
public class UnitConversionUtil {
	
	/**
	 * dp转px
	 * @param context
	 * @param dipValue
	 * @return
	 */
	public static int dpToPx(Context context, float dipValue){
		float scale = context.getResources().getDisplayMetrics().density;
		return (int)(dipValue * scale + 0.5f);
	}
	
	/**
	 * px转dp
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int pxToDp(Context context, float pxValue){
		float scale = context.getResources().getDisplayMetrics().density;
		return (int)(pxValue / scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 * @param pxValue
	 * @return
	 */
	public static int pxToSp(Context context, float pxValue) {
		float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}
	
	/**
	 * 将sp值转换为px值，保证文字大小不变
	 * @param context
	 * @param spValue
	 * @return
	 */
	public static int spToPx(Context context, float spValue){
		float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}
}
