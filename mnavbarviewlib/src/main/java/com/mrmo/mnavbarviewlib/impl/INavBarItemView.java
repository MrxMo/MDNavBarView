package com.mrmo.mnavbarviewlib.impl;

/**
 * INavBarItemView功能
 * Created by moguangjian on 15/8/4 10:09.
 */
public interface INavBarItemView {

    /**
     * 设置标题
     * @param title
     */
    void setTitle(String title);
    /**
     * 设置标题大小(默认16sp)
     * @param sp
     */
    void setTitleSize(int sp);
    /**
     * 设置正常标题颜色
     * @param colorId
     */
    void setTitleColor(int colorId);

    /**
     * * 设置选中标题颜色
     * @param colorId
     */
    void setTitleColorSelect(int colorId);

    /**
     * 设置默认icon
     * @param resId
     */
    void setIcon(int resId);
    /**
     * 设置选中icon
     * @param resId
     */
    void setIconSelect(int resId);
    /**
     * 是否显示icon
     * @param isShow
     */
    void isShowIcon(boolean isShow);

    /**
     * * 设置正常背景图片
     * @param resId
     */
    void setBG(int resId);
    /**
     * * 设置选中背景图片
     * @param resId
     */
    void setBGSelect(int resId);
    /**
     * * 设置正常背景颜色
     * @param colorId
     */
    void setBGColor(int colorId);
    /**
     * * 设置选中背景颜色
     * @param colorId
     */
    void setBGColorSelect(int colorId);

}
