package com.bawei.showtest.showmvp;

import com.android.volley.VolleyError;
import com.bawei.showtest.MainActivity;

/**
 * Project_Name: ShowTest
 * Time: 2019/4/18
 * Data: 晚么
 * Description:
 */
public interface ShowConstract {
    //IShowView
    interface IShowView{
        void getPreData(String data);
    }
    //IShowModel
    interface IShowModel{
        void getRequester(ModelCallBack modelCallBack);
        interface ModelCallBack{
            void onSuccess(String result);

            void onError(VolleyError error);
        }
    }
    //IShowPresenter
    interface IShowPresenter{
        void accth(MainActivity mainActivity);

        void decth();

        void getModel();
    }
}
