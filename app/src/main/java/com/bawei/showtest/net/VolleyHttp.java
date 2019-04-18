package com.bawei.showtest.net;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.showtest.VolleyApp;

/**
 * Project_Name: ShowTest
 * Time: 2019/4/18
 * Data: 晚么
 * Description:
 */
public class VolleyHttp {
    private static final VolleyHttp ourInstance = new VolleyHttp();

    public static VolleyHttp getInstance() {
        return ourInstance;
    }

    private VolleyHttp() {
    }
    //get请求
    public void getVolleyHttp(String url, final VolleyCallBack volleyCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallBack.onFail(error);
            }
        });
        stringRequest.setTag("testget");

        VolleyApp.getHttpVolley().add(stringRequest);
    }

    //
    public interface VolleyCallBack{
        void onSuccess(String result);

        void onFail(VolleyError error);
}


}
