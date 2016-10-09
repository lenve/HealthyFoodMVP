package org.sang.healthyfoodmvp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.sang.healthyfoodmvp.R;
import org.sang.healthyfoodmvp.model.FoodEntity;

import java.util.List;

/**
 * Created by 王松 on 2016/10/8.
 */

public class MyAdapter extends BaseAdapter {
    private List<FoodEntity> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<FoodEntity> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        FoodEntity foodEntity = list.get(position);
        holder.keywords.setText(foodEntity.getKeywords());
        holder.description.setText(foodEntity.getDescription());
        Picasso.with(context).load(foodEntity.getImg()).centerCrop().resizeDimen(R.dimen.iv_width,R.dimen.iv_width).into(holder.iv);
        return convertView;
    }
    class ViewHolder{
        TextView description,keywords;
        ImageView iv;

        public ViewHolder(View itemView) {
            description = (TextView) itemView.findViewById(R.id.description);
            keywords = (TextView) itemView.findViewById(R.id.keywords);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
