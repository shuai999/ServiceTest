package com.novate.usual.test01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.novate.usual.MainActivity;
import com.novate.usual.R;
import com.novate.usual.test02.GlobalData;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/6 17:20
 * Version 1.0
 * Params:
 * Description:    第二个页面
 * ================================================
*/

public class SecondActivity extends AppCompatActivity {

    private TextView tv_str_1,tv_str_2;
    private AppApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_str_1 = (TextView) findViewById(R.id.tv_str_1);
        tv_str_2 = (TextView) findViewById(R.id.tv_str_2);

        show1() ;

        show2() ;
    }

    private void show2() {
        String testStr = GlobalData.getTestStr();
        tv_str_2.setText(testStr);
    }


    private void show1() {
        application = (AppApplication) getApplication();
        // 进入到第二个页面，然后从application中取出之前修改后的值，然后设置给 tv_2
        tv_str_1.setText(application.getTestStr());
    }


    /**
     * application方式
     * 当点击 click1 后，再次将 application中的 testStr 修改为 王子文 - 001，
     * 用于在MainActivity 页面显示
     */
    public void click1(View view) {
        application.setTestStr("王子文 - 001");
        Intent intent = new Intent(SecondActivity.this , MainActivity.class) ;
        startActivity(intent);
    }


    /**
     * 普通类方式
     * 当点击 click2 后，再次将 GlobalData 中的 testStr 修改为 殷桃 - 001
     * 用于在MainActivity 页面显示
     */
    public void click2(View view) {
        GlobalData.setTestStr("殷桃 - 001");
        Intent intent = new Intent(SecondActivity.this , MainActivity.class) ;
        startActivity(intent);
    }
}
