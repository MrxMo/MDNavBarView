package com.mr_mo.mdnavbarview.navbarview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * MDBaseAdapter。<br/>
 * 使用方法：MDBaseAdapter，并覆写getView，即在getView中添加如下代码<br/>
 * convertView = getConvertView(R.layout.resLayoutId, convertView, parent, position);
 * TextView tvTitle = ViewHolderUtil.get(convertView, R.id.tvTitle);
 * tvTitle.setText(name);
 *
 * Created by moguangjian on 15/5/20.
 */
public class MDBaseAdapter<T> extends BaseAdapter {

    protected Context context;
    protected List<T> list;

    public MDBaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size() ;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        使用方法：
//        convertView = getConvertView(R.layout.resLayoutId, convertView, parent, position);
//        TextView tvTitle = ViewHolderUtil.get(convertView, R.id.tvTitle);
//
//        tvTitle.setText(name);

        return convertView;
    }

    /**
     * 获取convertView布局（即listview item 布局）
     * @param resLayoutId
     * @param convertView
     * @param parent
     * @return
     */
    public View getConvertView(int resLayoutId, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resLayoutId, parent, false);
        }

        return convertView;
    }
}
