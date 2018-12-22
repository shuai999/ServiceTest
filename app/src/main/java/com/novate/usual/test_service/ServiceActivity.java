package com.novate.usual.test_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.novate.usual.R;
import com.novate.usual.test_service.aidl.MyAIDLService;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/18 15:37
 * Version 1.0
 * Params:
 * Description:    在Activity中演示：启动服务StartService 与 StopService停止服务
 * ================================================
*/

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startService;
    private Button stopService;
    private Intent intent;

    private Button bindService;
    private Button unbindService;


    private MyService.MyBinder myBinder ;


    /**
     * 创建匿名内部类，重写 onServiceConnected 和 onServiceDisconnected方法
     */
    /*private ServiceConnection connection = new ServiceConnection() {

        // Activity 与 Service 建立关联调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 二者建立关联后，通过向下转型获取 MyBinder实例，有了这个实例，可以在Activity中根据具体场景，
            // 调用 MyBinder 中任何 public 方法，实现了 Activity指挥Service干什么，Service就去干什么
            myBinder = (MyService.MyBinder) service;
            myBinder.startDownload();
        }

        // Activity 与 Service 解除关联调用
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    } ;*/


    private MyAIDLService myAIDLService ;
    /**
     * AIDL方式对应的 ServiceConnection
     *
     */
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 这里把 IBinder对象转为 MyAIDLService对象，就可以调用MyAIDLService.aidl文件中所有接口了
            myAIDLService = MyAIDLService.Stub.asInterface(service) ;
            try {
                int result = myAIDLService.sum(5,5) ;
                String upperStr = myAIDLService.toUppercase("yintao") ;
                Log.e("TAG" , "result: "+result + ", upperStr: "+upperStr) ;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    } ;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        startService = (Button) findViewById(R.id.start_service);
        stopService = (Button) findViewById(R.id.stop_service);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);


        bindService = (Button) findViewById(R.id.bind_service);
        unbindService = (Button) findViewById(R.id.unbind_service);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);

        Log.e("TAG" , "ServiceActivity thread id is " + Thread.currentThread().getId()) ;
        Log.e("TAG" , "Activity process id is__"+ Process.myPid()) ;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // 启动服务
            // onCreate__executed
            // onStartCommand__executed
            case R.id.start_service:
                 intent = new Intent(ServiceActivity.this , MyService.class);
                 startService(intent) ;


                 break;
            // 停止服务
            // stopService__
            // onDestroy__executed
            case R.id.stop_service:
                 Log.e("TAG" , "stopService__") ;
                 intent = new Intent(ServiceActivity.this , MyService.class);
                 stopService(intent) ;
                 break;

            // 绑定服务：将 Activity与Service绑定，接收3个参数：
            // param_1: intent对象
            // param_2: 上边的 ServiceConnection实例对象
            // param_3: 一个标志位，BIND_AUTO_CREATE表示Activity与Service建立关联后，会自动创建Service
            // 然后MyService中的 onCreate方法执行，但是 onStartCommand不会执行

            // onCreate__executed
            // startDownload__模拟在后台下载任务 只会执行一次
            case R.id.bind_service:
                 Intent intent = new Intent(ServiceActivity.this , MyService.class) ;
                 bindService(intent , connection , BIND_AUTO_CREATE) ;
                 break;


            // 解绑服务：解除 Activity与Service的关联
            // unBindService__
            // onDestroy__executed
            case R.id.unbind_service:
                Log.e("TAG" , "unBindService__") ;
                 unbindService(connection);
                 break;
        }
    }
}
