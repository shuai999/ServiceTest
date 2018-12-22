package com.novate.usual.test01;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/6 17:18
 * Version 1.0
 * Params:
 * Description:
 * ================================================
*/

public class AppApplication extends Application {

    // 用application 保存全局变量 //
    private String testStr ;
    public String getTestStr() {
        return testStr;
    }
    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }


    // 这个是全局的AppApplication，可以用于整个项目中需要的mInstance
    private static AppApplication mInstance;
    private static Activity sActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        // 给testStr设置初始值
        testStr = "王子文 - 001" ;


        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.d("YWK",activity+"onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.d("YWK",activity+"onActivityStarted");
                sActivity=activity;

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
    public static AppApplication getInstance() {
        return mInstance;
    }

    public static Activity getActivity(){
        return sActivity;
    }
}
