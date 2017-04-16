package com.mrmo.mnavbarviewlib.impl;

import android.view.View;

/**
 * 导航弹出菜单选中回调
 * Created by moguangjian on 15/8/4 18:06.
 */
public interface NavBarPopupSelectListener {

    void onSelect(View view, int index, Object itemData);
}
