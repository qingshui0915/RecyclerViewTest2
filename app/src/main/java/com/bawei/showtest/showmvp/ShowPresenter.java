package com.bawei.showtest.showmvp;

import com.android.volley.VolleyError;
import com.bawei.showtest.MainActivity;

/**
 * Project_Name: ShowTest
 * Time: 2019/4/18
 * Data: 晚么
 * Description:
 */
public class ShowPresenter implements ShowConstract.IShowPresenter {

    private ShowModel showModel;
    private MainActivity ishowview;

    @Override
    public void accth(MainActivity mainActivity) {
        this.ishowview=mainActivity;
        showModel = new ShowModel();
        showModel.getRequester(new ShowConstract.IShowModel.ModelCallBack() {
            @Override
            public void onSuccess(String result) {
                ishowview.getPreData(result);
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }

    @Override
    public void decth() {
        if (ishowview!=null){
            ishowview=null;
        }
        if (showModel!=null){
            showModel=null;
        }
        System.gc();

    }

    @Override
    public void getModel() {

    }
}
