package com.shenzhe.lib_common.util;

import android.annotation.SuppressLint;
import android.app.Application;

import java.lang.reflect.Method;

/**
 * 获取上下文
 */
public class AppGlobals {
    private static Application sApplication;

    @SuppressLint("PrivateApi")
    public static Application getsApplication(){
        if(sApplication ==null){
            //去反射得到
            try {
                Class<?> aClass = Class.forName("android.app.ActivityThread");
                //获取里面的currentApplication
                Method currentApplication = aClass.getDeclaredMethod("currentApplication");
                sApplication = (Application) currentApplication.invoke(null,null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sApplication;
    }

}
