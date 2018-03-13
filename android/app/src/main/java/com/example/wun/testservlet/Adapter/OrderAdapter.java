package com.example.wun.testservlet.Adapter;
import com.example.wun.testservlet.Bean.OrderBean;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView.ViewHolder;

import java.util.LinkedList;
import java.util.List;
import android.util.Log;
import com.example.wun.testservlet.R;
/**
 * Created by WUN on 2018/3/11.
 */

public class OrderAdapter extends BaseAdapter {
    //OrderBean OrderBean;
    private List<OrderBean> mData;
    //private Context mContext;
    private LayoutInflater inflater;

    public OrderAdapter(List<OrderBean> mData, Context mContext) {

        this.mData = mData;
       // this.mContext = mContext;
        this.inflater=LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mData==null?0:mData.size();
    }

    @Override
    public OrderBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("MyListViewBase", "getView " + position + " " + convertView);

        ViewHolder holder = null;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_order, parent,false);
            holder = new ViewHolder();
            holder.img_icon = (ImageView) convertView.findViewById(R.id.imgicon);
            holder.orderid = (TextView) convertView.findViewById(R.id.orderid);
            holder.ordertitle = (TextView) convertView.findViewById(R.id.ordertitle);
            convertView.setTag(holder);   //将Holder存储到convertView中
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        //OrderBean orderBean=getItem(position);

        /*ImageView img_icon = (ImageView) convertView.findViewById(R.id.imgicon);
        TextView orderid = (TextView) convertView.findViewById(R.id.orderid);
        TextView ordertitle = (TextView) convertView.findViewById(R.id.ordertitle);*/
        //img_icon.setImageResource(orderBean.getIcon());
        holder.img_icon.setImageResource(mData.get(position).getIcon());
        Log.v("setImageResource", "Icon: " + mData.get(position).getIcon());

        holder.orderid.setText(mData.get(position).getOrderId());
       holder.ordertitle.setText(mData.get(position).getTitle());
        return convertView;
    }

static class ViewHolder{
    ImageView img_icon;
    TextView orderid;
    TextView ordertitle;
}
}