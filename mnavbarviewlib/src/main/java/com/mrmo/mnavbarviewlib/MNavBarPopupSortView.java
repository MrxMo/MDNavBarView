package com.mrmo.mnavbarviewlib;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.mrmo.mnavbarviewlib.adapter.MNavBarSortAdapter;
import com.mrmo.mnavbarviewlib.impl.INavBarPopupView;
import com.mrmo.mnavbarviewlib.impl.NavBarPopupSelectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序列表
 * Created by moguangjian on 15/8/4 16:28.
 */
public class MNavBarPopupSortView extends LinearLayout implements INavBarPopupView {

    private ListView listView;
    private MNavBarSortAdapter adapter;
    private List list;
    private NavBarPopupSelectListener navBarPopupSelectListener;
    private int navBarPopupViewHeight = LayoutParams.MATCH_PARENT;

    public MNavBarPopupSortView(Context context) {
        super(context);
        init();
    }

    public MNavBarPopupSortView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        list = new ArrayList();
        NavBarSortModel model = new NavBarSortModel();
        model.setTitle("智能排序");
        model.setIsSelect(false);

        NavBarSortModel model1 = new NavBarSortModel();
        model1.setTitle("离我最近");
        model1.setIsSelect(false);

        NavBarSortModel model2 = new NavBarSortModel();
        model2.setTitle("好评优先");
        model2.setIsSelect(false);

        NavBarSortModel model3 = new NavBarSortModel();
        model3.setTitle("人气最高");
        model3.setIsSelect(false);

        NavBarSortModel model4 = new NavBarSortModel();
        model4.setTitle("折扣最大");
        model4.setIsSelect(false);

        list.add(model);
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        listView = new ListView(getContext());
        listView.setLayoutParams(params);
        listView.setDivider(null);
        listView.setCacheColorHint(Color.TRANSPARENT);
        addView(listView);

        adapter = new MNavBarSortAdapter(getContext(), list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setSelect(position);
                if (navBarPopupSelectListener != null) {
                    NavBarSortModel model = (NavBarSortModel) list.get(position);
                    int tag = (int) getTag();
                    navBarPopupSelectListener.onSelect(MNavBarPopupSortView.this, tag, model);
                }
            }
        });
    }

    public void setOnNavBarPopupSelectListener(NavBarPopupSelectListener navBarPopupSelectListener) {
        this.navBarPopupSelectListener = navBarPopupSelectListener;
    }

    @Override
    public void setNavBarPopupViewHeight(int height) {
        navBarPopupViewHeight = height;
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, navBarPopupViewHeight);
        setLayoutParams(params);
    }

    @Override
    public int getNavBarPopupViewHeight() {
        return navBarPopupViewHeight;
    }
}
