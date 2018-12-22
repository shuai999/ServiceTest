package com.novate.usual.test03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.novate.usual.R;

import static com.novate.usual.test03.TestActivity.PAR_KEY;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/7 8:56
 * Version 1.0
 * Params:
 * Description:   parcel 方式接受数据
 * ================================================
*/

public class ParcelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel);

        TextView tv_parcel = (TextView) findViewById(R.id.tv_parcel);

        // 获取TestActivity传递过来的数据
        Book book = (Book) getIntent().getParcelableExtra(PAR_KEY) ;

        tv_parcel.setText("书名: "+book.getBookName()+", 作者："+book.getAuthor()+", 时间："+book.getPublishTime());
    }
}
