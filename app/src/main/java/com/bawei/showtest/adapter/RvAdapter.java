package com.bawei.showtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.showtest.R;
import com.bawei.showtest.bean.ShowBean;

/**
 * Project_Name: ShowTest
 * Time: 2019/4/18
 * Data: 晚么
 * Description:
 */
public class RvAdapter extends RecyclerView.Adapter{
    private Context context;
    private ShowBean.ResultBean showBeanResult;
    int TypeRxxp=0;
    int TypePzsh=1;
    int TypeMlss=2;
    private View inflate;
    private int itemViewType;
    private int viewHolderItemViewType;
    private ShowBean.ResultBean.RxxpBean rxxpBean;
    private RxxpAdapter rxxpAdapter;

    public RvAdapter(Context context, ShowBean.ResultBean showBeanResult) {
        this.context = context;
        this.showBeanResult = showBeanResult;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        itemViewType = getItemViewType(i);
       if (itemViewType==TypeRxxp){
           inflate = LayoutInflater.from(context).inflate(R.layout.rxxp, viewGroup, false);
           return new ViewHolderRxxp(inflate);
       }else if (itemViewType==TypePzsh){
           return null;
       }else {
           return null;
       }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        viewHolderItemViewType = viewHolder.getItemViewType();
        if (viewHolderItemViewType==TypeRxxp){
            ViewHolderRxxp viewHolderRxxp= (ViewHolderRxxp) viewHolder;
            rxxpBean = showBeanResult.getRxxp();
            viewHolderRxxp.rxxptv.setText(showBeanResult.getRxxp().getName());
            //布局管理器
            LinearLayoutManager  rxxpmanager=new LinearLayoutManager(context);
            rxxpmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
            //添加布局管理器
            viewHolderRxxp.rxxprc.setLayoutManager(rxxpmanager);
            rxxpAdapter = new RxxpAdapter(context, rxxpBean);
            viewHolderRxxp.rxxprc.setAdapter(rxxpAdapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
       if (position==0){
           return TypeRxxp;
       }else if (position==1){
           return  TypePzsh;
       }else{
           return TypeMlss;
       }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolderRxxp extends RecyclerView.ViewHolder{

        private final TextView rxxptv;
        private final RecyclerView rxxprc;

        public ViewHolderRxxp(@NonNull View itemView) {
            super(itemView);

            rxxptv = itemView.findViewById(R.id.show_rxxp_tv);
            rxxprc = itemView.findViewById(R.id.show_rxxp_rc);
        }
    }
    public class ViewHolderMlss extends RecyclerView.ViewHolder{
        public ViewHolderMlss(@NonNull View itemView) {
            super(itemView);
        }
    }
    public class ViewHolderPzsh extends RecyclerView.ViewHolder{
        public ViewHolderPzsh(@NonNull View itemView) {
            super(itemView);
        }
    }
}
