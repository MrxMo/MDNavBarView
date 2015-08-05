package com.mr_mo.mdnavbarview.navbarview.util;

import android.content.Context;
import android.view.View;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;


/**
 * nineoldandroid工具类
 *
 * @author moguangjian
 *         <p/>
 *         create at 2014-9-30 下午3:21:20
 */
public class AnimationUtil {
    public static final int ANIMATION_DURATION = 300;
    /**
     * X方向移动
     */
    public static final String TRANSLATION_X = "translationX";
    /**
     * Y方向移动
     */
    public static final String TRANSLATION_Y = "translationY";
    /**
     * X方向缩放
     */
    public static final String SCALE_X = "scaleX";
    /**
     * Y方向缩放
     */
    public static final String SCALE_Y = "scaleY";
    /**
     * 透明度
     */
    public static final String ALPHA = "alpha";
    /**
     * X方向旋转
     */
    public static final String ROTATION_X = "rotationX";
    /**
     * X方向旋转
     */
    public static final String ROTATION_Y = "rotationY";
    /**
     * Z方向旋转
     */
    public static final String ROTATION_Z = "rotation";

    private View mTarget;

    public AnimationUtil(View target) {
        mTarget = target;
    }

    public int getWidth() {
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width) {
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }

    public int getHeight() {
        return mTarget.getLayoutParams().height;
    }

    public void setHeight(int height) {
        mTarget.getLayoutParams().height = height;
        mTarget.requestLayout();
    }

    /**
     * 伸展动画
     *
     * @param context
     * @param view
     * @param animationDuration
     * @param height
     */
    public static void stretchAnimate(Context context, View view, int animationDuration, int height) {
        AnimationUtil wrapper = new AnimationUtil(view);
        ObjectAnimator.ofInt(wrapper, "height", 0, UnitConversionUtil.dpToPx(context, height)).setDuration(animationDuration).start();
    }

    public static void stretchAnimate(Context context, View view, int animationDuration, int startHeight, int height) {
        AnimationUtil wrapper = new AnimationUtil(view);
        ObjectAnimator.ofInt(wrapper, "height", UnitConversionUtil.dpToPx(context, startHeight), UnitConversionUtil.dpToPx(context, height)).setDuration(animationDuration).start();
    }

    /**
     * 伸展动画
     *
     * @param context
     * @param view
     * @param animationDuration
     */
    public static void stretchAnimateWidth(Context context, View view, int animationDuration, int width) {
        AnimationUtil wrapper = new AnimationUtil(view);
        ObjectAnimator.ofInt(wrapper, "width", 0, UnitConversionUtil.dpToPx(context, width)).setDuration(animationDuration).start();
    }

    /**
     * 收缩动画
     *
     * @param context
     * @param view
     * @param animationDuration
     * @param height
     */
    public static void shrinkAnimate(Context context, View view, int animationDuration, int height) {
        AnimationUtil wrapper = new AnimationUtil(view);
        height = UnitConversionUtil.dpToPx(context, height);
        ObjectAnimator.ofInt(wrapper, "height", height, 0).setDuration(animationDuration).start();
    }

    /**
     * 收缩动画
     *
     * @param context
     * @param view
     * @param animationDuration
     */
    public static void shrinkAnimateWidth(Context context, View view, int animationDuration, int width) {
        AnimationUtil wrapper = new AnimationUtil(view);
        ObjectAnimator.ofInt(wrapper, "width", UnitConversionUtil.dpToPx(context, width), 0).setDuration(animationDuration).start();
    }

    /**
     * 隐藏右菜单
     */
    public static void hideRightView(final View rightView) {
        int hideRightLayoutX = rightView.getWidth();

        float[] titleTranslation = new float[]{0, hideRightLayoutX};
        ObjectAnimator animator = ObjectAnimator.ofFloat(rightView, AnimationUtil.TRANSLATION_X, titleTranslation);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator arg0) {
            }

            @Override
            public void onAnimationRepeat(Animator arg0) {
            }

            @Override
            public void onAnimationEnd(Animator arg0) {
                rightView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator arg0) {
                rightView.setVisibility(View.INVISIBLE);
            }
        });
        animator.setDuration(ANIMATION_DURATION).start();
    }

    /**
     * 显示右边菜单
     */
    public static void showRightView(View rightView) {

        rightView.setVisibility(View.VISIBLE);
        int[] location = new int[2];
        rightView.getLocationOnScreen(location);

        int rightShowX = rightView.getWidth();
        float[] rightTranslation = new float[]{rightShowX, 0};
        ObjectAnimator.ofFloat(rightView, AnimationUtil.TRANSLATION_X, rightTranslation).setDuration(ANIMATION_DURATION).start();
    }

    public static void showAlphaAnimation(View view) {
        showAlphaAnimation(view, AnimationUtil.ANIMATION_DURATION);
    }

    public static void showAlphaAnimation(View view, int duration) {
        ObjectAnimator.ofFloat(view, AnimationUtil.ALPHA, 0, 1).setDuration(duration).start();
    }

    public static void hideAlphaAnimation(final View view) {
        hideAlphaAnimation(view, AnimationUtil.ANIMATION_DURATION);
    }

    public static void hideAlphaAnimation(final View view, int duration) {
        ObjectAnimator.ofFloat(view, AnimationUtil.ALPHA, 1, 0).setDuration(duration).start();
    }
}
