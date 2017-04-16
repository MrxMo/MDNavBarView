package com.mrmo.mnavbarviewlib.impl;

/**
 * INavBarPopupView
 * Created by moguangjian on 15/8/4 16:01.
 */
public interface INavBarPopupView {

    /**
     * 设置弹出下拉菜单的高度(dp)
     * @param height
     */
    void setNavBarPopupViewHeight(int height);

    /**
     * 获取弹出下拉菜单的高度(dp)
     * @return
     */
    int getNavBarPopupViewHeight();

    /**
     * 选中监听器
     * @param navBarPopupSelectListener
     */
    void setOnNavBarPopupSelectListener(NavBarPopupSelectListener navBarPopupSelectListener);
}
