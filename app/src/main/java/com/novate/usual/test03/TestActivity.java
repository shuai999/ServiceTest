package com.novate.usual.test03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.novate.usual.R;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/7 9:06
 * Version 1.0
 * Params:
 * Description:    测试Serializable、Parcelable传递对象
 * ================================================
*/

public class TestActivity extends AppCompatActivity implements View.OnClickListener {


    private Button sButton,pButton;
    public  final static String SER_KEY = "com.tutor.objecttran.ser";
    public  final static String PAR_KEY = "com.tutor.objecttran.par";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        setupViews();
    }

    private void setupViews() {
        sButton = (Button)findViewById(R.id.button1);
        pButton = (Button)findViewById(R.id.button2);
        sButton.setOnClickListener(this);
        pButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == sButton){
            serializeMethod();
        }else {
            pacelableMethod();
        }
    }


    /**
     * pacelable 方式
     */
    private void pacelableMethod() {
        Book book = new Book() ;
        book.setBookName("Android 艺术开发探索");
        book.setAuthor("任玉刚");
        book.setPublishTime(2015);

        Intent intent = new Intent(TestActivity.this , ParcelActivity.class) ;
        Bundle bundle = new Bundle() ;
        bundle.putParcelable(PAR_KEY , book);
        intent.putExtras(bundle) ;
        startActivity(intent);
    }


    /**
     * serialize 方式
     */
    private void serializeMethod() {
        Person person = new Person() ;
        person.setName("殷桃");
        person.setAge(18);

        Intent intent = new Intent(TestActivity.this , SerializeActivity.class) ;
        Bundle bundle = new Bundle() ;
        bundle.putSerializable(SER_KEY , person);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
