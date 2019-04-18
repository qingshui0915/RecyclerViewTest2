package com.bawei.showtest;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Project_Name: ShowTest
 * Time: 2019/4/18
 * Data: 晚么
 * Description:
 */
public class VolleyApp extends Application {

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getHttpVolley(){

        return requestQueue;
    }
}
