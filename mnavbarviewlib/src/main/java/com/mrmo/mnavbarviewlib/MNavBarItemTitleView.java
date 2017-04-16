package com.mrmo.mnavbarviewlib;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mrmo.mnavbarviewlib.impl.INavBarItemView;
import com.mrmo.mnavbarviewlib.util.LogUtil;
import com.mrmo.mnavbarviewlib.util.StringUtil;
import com.mrmo.mnavbarviewlib.util.UnitConversionUtil;

/**
 * 单纯标题的item
 * Created by moguangjian on 15/8/4 10:08.
 */
public class MNavBarItemTitleView extends android.support.v7.widget.AppCompatTextView implements INavBarItemView {

    private static final String TAG = MNavBarItemTitleView.class.getSimpleName();

    private int titleColor = R.color.m_cl_555555;
    private int titleColorSelect = R.color.m_cl_555555;
    private int icon;
    private int iconSelect;
    private boolean isShowIcon;
    private int bgImage;
    private int bgImageSelect;
    private int bgColor;
    private int bgColorSelect;

    public MNavBarItemTitleView(Context context) {
        super(context);
        init();
    }

    public MNavBarItemTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MNavBarItemTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            setTitleColorSelect(titleColorSelect);
            setIconSelect(iconSelect);
            setBGSelect(bgImageSelect);
            setBGColorSelect(bgColorSelect);

        } else {
            setTitleColor(titleColor);
            setIcon(icon);
            setBG(bgImage);
            setBGColor(bgImageSelect);
        }
        isShowIcon(isShowIcon);
    }

    private void init() {

        setGravity(Gravity.CENTER);
        setSingleLine();
        setTitleSize(16);
        setTitleColor(getResources().getColor(R.color.m_cl_555555));
        setBG(R.mipmap.ic_select_arrow);
        setEllipsize(TextUtils.TruncateAt.END);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        setLayoutParams(params);
    }

    @Override
    public void setTitle(String title) {
        if (StringUtil.isEmpty(title)) {
            return;
        }
        setText(title);
    }

    @Override
    public void setTitleSize(int sp) {
        UnitConversionUtil.spToPx(getContext(), sp);
        setTextSize(sp);
    }

    @Override
    public void setTitleColor(int colorId) {
        titleColor = colorId;
        try {
            setTextColor(colorId);
            if (colorId > 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setTitleColorSelect(int colorId) {
        titleColorSelect = colorId;

        try {
            setTextColor(colorId);
            if (colorId > 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setIcon(int resId) {
        icon = resId;
        LogUtil.e(TAG, "setIcon is not implements");
    }

    @Override
    public void setIconSelect(int resId) {
        iconSelect = resId;
        LogUtil.e(TAG, "setIconSelect is not implements");
    }

    @Override
    public void isShowIcon(boolean isShow) {
        isShowIcon = isShow;
        LogUtil.e(TAG, "isShowIcon is not implements");
    }

    @Override
    public void setBG(int resId) {
        bgImage = resId;
        try {
            if (resId > 0) {
                setBackgroundResource(resId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBGSelect(int resId) {
        bgImageSelect = resId;
        try {
            if (resId > 0) {
                setBackgroundResource(resId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBGColor(int colorId) {
        bgColor = colorId;
        try {
            if (colorId > 0) {
                setBackgroundColor(colorId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBGColorSelect(int colorId) {
        bgColorSelect = colorId;
        try {
            if (colorId > 0) {
                setBackgroundColor(colorId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
