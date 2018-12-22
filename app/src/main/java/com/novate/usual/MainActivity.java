package com.novate.usual;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.novate.usual.test01.AppApplication;
import com.novate.usual.test01.SecondActivity;
import com.novate.usual.test02.GlobalData;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/6 17:36
 * Version 1.0
 * Params:
 * Description:    第一个页面
 * ================================================
*/
public class MainActivity extends AppCompatActivity {

    private TextView tv_str_1,tv_str_2;
    private AppApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_str_1 = (TextView) findViewById(R.id.tv_str_1);
        tv_str_2 = (TextView) findViewById(R.id.tv_str_2);

        // application方式
        showTv1() ;

        // 普通方式
        showTv2();

        try {
            TextView tv = (TextView) findViewById(R.id.tv);
            byte[] bytes = "Hello World王子文王子文!".getBytes("GBK");
            byte[] bytes2 = tv.getText().toString().getBytes("GBK");
            String GBK = URLEncoder.encode(tv.getText().toString(), "GBK");

            Log.e("TAG" , "bytes："+bytes.length+", bytes2: "+bytes2.length+", GBK: "+GBK.length()+"文字："+tv.getText().toString()) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showTv2() {
        String testStr = GlobalData.getTestStr();
        // 刚进入首页时，首先取出普通类中的变量，显示到tv_str_2即可
        tv_str_2.setText(testStr);
    }

    private void showTv1() {
        application = (AppApplication) getApplication();
        // 刚进入首页时，首先取出application的onCreate()的testStr初始值，显示到tv_str_1即可
        tv_str_1.setText(application.getTestStr());
    }

    /**
     * application方式
     *
     * 当点击 click1 后，将 application中的 testStr 修改为 王子文 - 002，
     * 用于在 SecondActivity 页面显示
     */
    public void click1(View view) {
        application.setTestStr("王子文 - 002");
        Intent intent = new Intent(MainActivity.this , SecondActivity.class) ;
        startActivity(intent);
    }


    /**
     * 普通类方式
     *
     * 当点击 click2 后，将 GlobalData 中的 testStr 修改为 殷桃 - 002
     * 用于在 SecondActivity 页面显示
     */
    public void click2(View view) {
        GlobalData.setTestStr("殷桃 - 002");
        Intent intent = new Intent(MainActivity.this , SecondActivity.class) ;
        startActivity(intent);
    }
}
