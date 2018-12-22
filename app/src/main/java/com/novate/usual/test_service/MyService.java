package com.novate.usual.test_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.novate.usual.test_service.aidl.MyAIDLService;


/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/18 15:09
 * Version 1.0
 * Params:
 * Description:
 * 备注：任何一个 Service在整个应用程序范围内都是通用的，也就是说 MyService 不仅可以和ServiceActivity关联，
 *       还可以和任何一个Activity关联，而且在关联时都可以获取到相同的 MyBinder实例
 * ================================================
*/

public class MyService extends Service {

    // 自己自定义MyBinder继承Binder
//    private MyBinder mBinder = new MyBinder() ;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG" , "onCreate__executed") ;
        Log.e("TAG" , "Service process id is__"+ Process.myPid()) ;
        /*try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }


    /**
     * Binder是父类，Stub是子类
     *
     * 第一：这里首先对MyAIDLService.Stub进行实现，重写sum()和toUppercase()方法
     */
    MyAIDLService.Stub mBinder = new MyAIDLService.Stub() {

        /**
         * 两个整数相加
         */
        @Override
        public int sum(int a, int b) throws RemoteException {
            return a+b;
        }


        /**
         * 将传入的字符串全部转为大写
         */
        @Override
        public String toUppercase(String str) throws RemoteException {
            if (str != null){
                return str.toUpperCase() ;
            }
            return null;
        }
    } ;




    /**
     * 在 MyService 中开启子线程
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG" , "onStartCommand__executed") ;

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 开始执行后台任务
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG" , "onDestroy__executed") ;
    }


    /**
     * Activity 与 Service关联，返回MyBinder实例对象：
     *      用于在 Activity中，通过onServiceConnected方法，指定 Service执行相关任务
     */

    /**
     * 第二：在 onBinde方法中直接返回 Stub的对象mBinder
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    class MyBinder extends Binder{

        /**
         * 自己自定义MyBinder继承Binder，然后随便定义一个方法，
         * 用于在后台执行下载任务，这里只是做一个测试
         */
        public void startDownload(){
            // 模拟在后台下载任务
            Log.e("TAG" , "startDownload__模拟在后台下载任务") ;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 执行具体的下载任务
                }
            }).start();
        }
    }
}
