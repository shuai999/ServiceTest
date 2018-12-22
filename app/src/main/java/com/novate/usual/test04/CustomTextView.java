package com.novate.usual.test04;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by ThinkPad on 2018/12/8.
 */

public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        this(context , null) ;
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        this(context , attrs , 0) ;
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    /**
     * 触摸事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            // 手指按下
            case MotionEvent.ACTION_DOWN:
                 break;

            // 手指移动
            case MotionEvent.ACTION_MOVE:
                 break;

            // 手指松开
            case MotionEvent.ACTION_UP:
                 break;
        }
        return true;
    }
}
