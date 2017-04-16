package com.mrmo.mnavbarviewlib;

/**
 * NavBarSortModel. 导航弹窗中的排序页面model.
 * Created by moguangjian on 15/8/4 16:46.
 */
public class NavBarSortModel {
    private boolean isSelect;
    private String title;

    public boolean isSelect() {
        return isSelect;
    }

    public String getTitle() {
        return title;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
