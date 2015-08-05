package com.mr_mo.mdnavbarview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.mr_mo.mdnavbarview.navbarview.MDNavBarItemTitleView;
import com.mr_mo.mdnavbarview.navbarview.MDNavBarPopupSortView;
import com.mr_mo.mdnavbarview.navbarview.MDNavBarView;
import com.mr_mo.mdnavbarview.navbarview.NavBarSortModel;
import com.mr_mo.mdnavbarview.navbarview.adapter.MDNavBarSortAdapter;
import com.mr_mo.mdnavbarview.navbarview.impl.INavBarItemView;
import com.mr_mo.mdnavbarview.navbarview.impl.NavBarPopupSelectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * MDNavBarView下拉导航菜单（仿美团导航下拉菜单） demo
 * Created by moguangjian on 15/8/2 15:46.
 */
public class MainActivity extends Activity {

    private ListView listView;
    private List list;
    private MDNavBarSortAdapter adapter;
    private MDNavBarView mdNavBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListView();
        initNavBarView();
    }

    private void initNavBarView() {
        mdNavBarView = (MDNavBarView) findViewById(R.id.mdNavBarView);

        INavBarItemView itemViewAdress = new MDNavBarItemTitleView(this);
        itemViewAdress.setTitle("地区");
//        itemViewAdress.setTitleColorSelect(Color.RED);

        INavBarItemView itemViewTime = new MDNavBarItemTitleView(this);
        itemViewTime.setTitle("时间段");
//        itemViewTime.setTitleColorSelect(Color.RED);

        INavBarItemView itemViewFilter = new MDNavBarItemTitleView(this);
        itemViewFilter.setTitle("筛选");
//        itemViewFilter.setTitleColorSelect(Color.RED);

        List list = new ArrayList();
        list.add(itemViewAdress);
        list.add(itemViewTime);
        list.add(itemViewFilter);

        mdNavBarView.setNavBarItemView(list);
        mdNavBarView.setNavBarViewBGColor(Color.WHITE);

        MDNavBarPopupSortView sortView = new MDNavBarPopupSortView(this);
        sortView.setBackgroundColor(Color.RED);
        sortView.setNavBarPopupViewHeight(100);
        sortView.setOnNavBarPopupSelectListener(new NavBarPopupSelectListener() {
            @Override
            public void onSelect(View view, int index, Object itemData) {
                mdNavBarView.hide();
                mdNavBarView.isShowNavBarItemIcon(false, index);
                NavBarSortModel model = (NavBarSortModel) itemData;
//                mdNavBarView.setNavBarItemTitle(model.getTitle(), index);
            }
        });

        MDNavBarPopupSortView sortView1 = new MDNavBarPopupSortView(this);
        sortView1.setBackgroundColor(Color.YELLOW);
        sortView1.setNavBarPopupViewHeight(210);//设置下拉菜单的高度
        sortView1.setOnNavBarPopupSelectListener(new NavBarPopupSelectListener() {
            @Override
            public void onSelect(View view, int index, Object itemData) {
                mdNavBarView.hide();
                mdNavBarView.isShowNavBarItemIcon(false, index);
                NavBarSortModel model = (NavBarSortModel) itemData;
                mdNavBarView.setNavBarItemTitle(model.getTitle(), index);//更新导航标题
            }
        });

        MDNavBarPopupSortView sortView2 = new MDNavBarPopupSortView(this);
        sortView2.setBackgroundColor(Color.BLUE);
        sortView2.setNavBarPopupViewHeight(350);
        sortView2.setOnNavBarPopupSelectListener(new NavBarPopupSelectListener() {
            @Override
            public void onSelect(View view, int index, Object itemData) {
                mdNavBarView.hide();
                mdNavBarView.isShowNavBarItemIcon(false, index);
                NavBarSortModel model = (NavBarSortModel) itemData;
//                mdNavBarView.setNavBarItemTitle(model.getTitle(), index);
            }
        });

        List listOperateView = new ArrayList();
        listOperateView.add(sortView);
        listOperateView.add(sortView1);
        listOperateView.add(sortView2);
        mdNavBarView.setNavBarPopupOperateView(listOperateView);
    }

    private void initListView() {
        NavBarSortModel model;
        list = new ArrayList();
        for (int i = 0; i < 50; i++) {
            model = new NavBarSortModel();
            model.setTitle("title is "+i);
            model.setIsSelect(false);
            list.add(model);
        }

        listView = (ListView) findViewById(R.id.listView);
        adapter = new MDNavBarSortAdapter(this, list);
        listView.setAdapter(adapter);

    }
}