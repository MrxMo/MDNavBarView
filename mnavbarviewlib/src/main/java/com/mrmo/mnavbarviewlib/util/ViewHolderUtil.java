package com.mrmo.mnavbarviewlib.util;

import android.util.SparseArray;
import android.view.View;

/**
 * ViewHolder工具类<br/>
 * 说明：ViewHolder超简洁写法<br/>
 *
 * @author moguangjian<br/>
 *         <p/>
 *         create at 2014年8月2日  下午7:24:45
 */
public class ViewHolderUtil {

    /**
     * 获取View对象
     *
     * @param view 类型
     * @param id view的id
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

	/*
    //适配器中getView 的写法
  	public View getView(int position, View convertView, ViewGroup parent) {
  	    if (convertView == null) {
  	        convertView = LayoutInflater.from(context).inflate(R.layout.banana_phone, parent, false);
  	    }
  	
  	    TextView phoneView = ViewHolderUtil.get(convertView, R.id.phone);
  	    phoneView.setText("ViewHolderUtil");
  	
  	    return convertView;
  	}
  	 */
}
