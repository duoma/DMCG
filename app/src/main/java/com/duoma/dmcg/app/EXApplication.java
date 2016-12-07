package com.duoma.dmcg.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.umeng.analytics.MobclickAgent;


/**
 * Created by Administrator on 2016/11/30.
 * Application
 */

public class EXApplication extends Application {
    private static final String TAG = "DMCGTag";
    private Context context;
    public static int tabsIndex = 0;//Tabs点击了哪个标签

    public Context getContext() {
        return context;
    }

    /**
     * 调试日志
     */
    public static void E_Log(String str) {
        Log.d("DMCGTag", str);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "EXApplication-onCreate()");

        context = getApplicationContext();

        /**
         * 友盟统计start
         */
        MobclickAgent.setScenarioType(context, MobclickAgent.EScenarioType.E_UM_NORMAL);//普通统计场景类型
        MobclickAgent.setDebugMode(false);//使用集成测试模式请先在程序入口处调用如下代码，打开调试模式
        MobclickAgent.enableEncrypt(true);//日志加密设置
        /**
         * 友盟统计end
         */
    }
}
