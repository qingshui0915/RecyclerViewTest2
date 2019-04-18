package com.bawei.showtest.showmvp;

import com.android.volley.VolleyError;
import com.bawei.showtest.net.VolleyHttp;

/**
 * Project_Name: ShowTest
 * Time: 2019/4/18
 * Data: 晚么
 * Description:
 */
public class ShowModel implements ShowConstract.IShowModel {
    public static final String URL="http://172.17.8.100/small/commodity/v1/commodityList";

    @Override
    public void getRequester(final ModelCallBack modelCallBack) {
        VolleyHttp.getInstance().getVolleyHttp(URL, new VolleyHttp.VolleyCallBack() {
            @Override
            public void onSuccess(String result) {
                modelCallBack.onSuccess(result);
            }

            @Override
            public void onFail(VolleyError error) {
                modelCallBack.onError(error);
            }
        });

    }
}
