package com.bawei.showtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.showtest.R;
import com.bawei.showtest.bean.ShowBean;
import com.bumptech.glide.Glide;

/**
 * Project_Name: ShowTest
 * Time: 2019/4/18
 * Data: 晚么
 * Description:
 */
public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {
    private Context context;
    private ShowBean.ResultBean.RxxpBean rxxpBean;
    private View inflate;
    private ShowBean.ResultBean.RxxpBean.CommodityListBean commodityListBean;

    public RxxpAdapter(Context context, ShowBean.ResultBean.RxxpBean rxxpBean) {
        this.context=context;
        this.rxxpBean=rxxpBean;
    }
    @NonNull
    @Override
    public RxxpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.rxxp_item, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpAdapter.ViewHolder viewHolder, int i) {
        commodityListBean = rxxpBean.getCommodityList().get(i);
        viewHolder.ntv.setText(commodityListBean.getCommodityName());
        viewHolder.ptv.setText(commodityListBean.getPrice()+"");
        Glide.with(context).load(commodityListBean.getMasterPic()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return rxxpBean.getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView ntv;
        private final TextView ptv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.show_rxxp_item_iv);
            ntv = itemView.findViewById(R.id.show_rxxp_item_ntv);
            ptv = itemView.findViewById(R.id.show_rxxp_item_ptv);
        }
    }
}
