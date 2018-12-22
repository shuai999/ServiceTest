package com.novate.usual.test05.viewgroup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.novate.usual.R;

/**
 * Created by ThinkPad on 2018/12/10.
 */

public class MyLayoutActivity extends AppCompatActivity {

    private MyLayout myLayout;
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_layout);

        // 自定义的 MyLayout 根布局
        myLayout = (MyLayout) findViewById(R.id.my_layout);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);


        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("TAG" , "myLayout__onTouch") ;
                return false;
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG" , "btn1__click") ;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG" , "btn2__click") ;
            }
        });
    }
}
