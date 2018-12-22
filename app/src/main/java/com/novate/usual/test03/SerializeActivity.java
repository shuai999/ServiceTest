package com.novate.usual.test03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.novate.usual.R;

import static com.novate.usual.test03.TestActivity.SER_KEY;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/7 8:56
 * Version 1.0
 * Params:
 * Description:    serialize 方式接受数据
 * ================================================
*/

public class SerializeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialize);

        TextView tv_serialize = (TextView) findViewById(R.id.tv_serialize);

        // 获取TestActivity传递过来的数据
        Person person = (Person) getIntent().getSerializableExtra(SER_KEY);

        tv_serialize.setText("姓名: "+person.getName()+", 年龄："+person.getAge());
    }
}
