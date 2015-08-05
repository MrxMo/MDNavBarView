package com.mr_mo.mdnavbarview.navbarview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mr_mo.mdnavbarview.R;
import com.mr_mo.mdnavbarview.navbarview.NavBarSortModel;
import com.mr_mo.mdnavbarview.navbarview.util.ViewHolderUtil;

import java.util.List;

/**
 * 导航弹出菜单的排序列表适配器
 * Created by moguangjian on 15/8/4 16:32.
 */
public class MDNavBarSortAdapter extends MDBaseAdapter {

    public MDNavBarSortAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = getConvertView(R.layout.listview_item_nav_bar_sort, convertView, parent);
        TextView tvTitle = ViewHolderUtil.get(convertView, R.id.tvTitle);

        NavBarSortModel model = (NavBarSortModel) getItem(position);
        if (model.isSelect()) {
            tvTitle.setBackgroundColor(Color.GREEN);
        } else {
            tvTitle.setBackgroundColor(Color.TRANSPARENT);
        }
        tvTitle.setText(model.getTitle() + "");

        return convertView;
    }


    public void setSelect(int index) {
        if (index > getCount()) {
            index = getCount() -1;
        }

        if (index < 0 ) {
            index = 0;
        }

        setNoSelect();

        NavBarSortModel model = (NavBarSortModel) getItem(index);
        model.setIsSelect(true);

        notifyDataSetChanged();
    }

    public void setNoSelect() {
        for (int i = 0; i < getCount(); i++) {
            NavBarSortModel model = (NavBarSortModel) getItem(i);
            model.setIsSelect(false);
        }
    }

}
