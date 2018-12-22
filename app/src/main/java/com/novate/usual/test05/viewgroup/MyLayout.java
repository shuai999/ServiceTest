package com.novate.usual.test05.viewgroup;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by ThinkPad on 2018/12/10.
 */

public class MyLayout extends LinearLayout {
    public MyLayout(Context context) {
        this(context,null);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
