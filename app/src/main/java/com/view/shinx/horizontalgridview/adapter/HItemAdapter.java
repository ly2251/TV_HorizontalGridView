package com.view.shinx.horizontalgridview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.view.shinx.horizontalgridview.R;
import com.view.shinx.horizontalgv.RecyclerView;

import java.util.List;

/**
 * Created by liuYi
 * Time 2017/4/18
 */
public class HItemAdapter extends RecyclerView.Adapter<HItemAdapter.HItemAdapterHolder> {
    private final LayoutInflater layoutInflater;

    private List<String> numData;

    public HItemAdapter(Context ctx) {
        this.layoutInflater = LayoutInflater.from(ctx);
    }

    public void updateData(List<String> numData) {
        this.numData = numData;
    }

    @Override
    public HItemAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HItemAdapterHolder holder = new HItemAdapterHolder(layoutInflater.inflate(R.layout.item_h_view, parent, false));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/4/18 点击事件，TV 一般不在这里实现
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(HItemAdapterHolder holder, int position) {
        holder.numTv.setText(numData.get(position));
    }

    @Override
    public int getItemCount() {
        return numData == null ? 0 : numData.size();
    }

    public static class HItemAdapterHolder extends RecyclerView.ViewHolder {
        private TextView numTv;

        public HItemAdapterHolder(View itemView) {
            super(itemView);
            numTv = (TextView) itemView.findViewById(R.id.h_item_num_tv);
        }
    }
}
