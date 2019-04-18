package com.bawei.showtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.showtest.adapter.RvAdapter;
import com.bawei.showtest.bean.ShowBean;
import com.bawei.showtest.showmvp.ShowConstract;
import com.bawei.showtest.showmvp.ShowPresenter;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements ShowConstract.IShowView {

    private ShowPresenter showPresenter;
    private ShowBean showBean;
    private RecyclerView recyclerView;
    private ShowBean.ResultBean showBeanResult;
    private RvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showPresenter = new ShowPresenter();
        showPresenter.accth(this);

        recyclerView = findViewById(R.id.rv);
    }

    @Override
    public void getPreData(String data) {
        Gson gson = new Gson();
        showBean = gson.fromJson(data, ShowBean.class);
        showBeanResult = showBean.getResult();
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        rvAdapter = new RvAdapter(MainActivity.this, showBeanResult);
        recyclerView.setAdapter(rvAdapter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showPresenter.decth();
    }
}
