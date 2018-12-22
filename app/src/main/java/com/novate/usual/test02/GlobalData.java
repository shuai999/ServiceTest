package com.novate.usual.test02;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/6 17:39
 * Version 1.0
 * Params:
 * Description:    整个项目全局的实体类，可用于随时存储数据，然后随时获取数据来使用
 * ================================================
*/

public class GlobalData {

    private static String testStr = "殷桃 - 001" ;

    public static String getTestStr() {
        return testStr;
    }

    public static void setTestStr(String testStr) {
        GlobalData.testStr = testStr;
    }
}
