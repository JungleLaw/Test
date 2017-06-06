package com.example.jungle.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jungle.test.R;
import com.example.jungle.test.entity.People;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Jungle on 2017/6/2.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    Context context;
    List<People> peoples;

    public SimpleAdapter(Context context, List<People> peoples) {
        this.context = context;
        this.peoples = peoples;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_people, parent, false);
        ViewHolder mHolder = new ViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(peoples.get(position).name);
        holder.txtDesc.setText(peoples.get(position).desc);
    }

    @Override
    public int getItemCount() {
        return peoples == null ? 0 : peoples.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            txtName = (TextView) itemView.findViewById(R.id.name);
            txtDesc = (TextView) itemView.findViewById(R.id.desc);
        }
    }
}
