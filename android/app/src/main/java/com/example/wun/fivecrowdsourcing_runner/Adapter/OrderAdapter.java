package com.example.wun.fivecrowdsourcing_runner.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wun.fivecrowdsourcing_runner.Bean.OrderBean;
import com.example.wun.fivecrowdsourcing_runner.R;

import java.util.ArrayList;

/**
 * Created by WUN on 2018/3/18.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<OrderBean> orders;
    private Context context;
    private static OnItemClickListener mOnItemClickListener;//声明接口

    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener=onItemClickListener;
    }

    public OrderAdapter(Context context, ArrayList<OrderBean> mOrders){
        this.context=context;
        this.orders=mOrders;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public int getItemCount() {
        return orders.size();

    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        OrderBean orderBean = orders.get(position);
        // holder.paint_img.setImageURI(Uri.parse(orderBean.getPaint_img_root()));
        holder.item1_city.setText(orderBean.getCusAddress());
        holder.item2_city.setText(orderBean.getCusName());

        if( mOnItemClickListener!= null){
            holder.itemView.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });

            holder. itemView.setOnLongClickListener( new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(position);
                    return false;
                }
            });
        }
    }

    //onCreateviewHolder函数和onBindViewHolder实现了ListView里面getView的工作，分别为找到控件和控件赋值
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View wrapper = inflater.inflate(R.layout.test_layout, parent, false);
        return new ViewHolder(
                wrapper,
                (TextView)wrapper.findViewById(R.id.item1_city),
                (TextView)wrapper.findViewById(R.id.item2_city));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView item1_city;
        private TextView item2_city;


        public ViewHolder(View view, TextView item1_city,
                          TextView item2_city
        ) {
            super(view);
            this.item1_city = item1_city;
            this.item2_city = item2_city;
        }

        public void addOrder(OrderBean order,int position) {
            orders.add(position, order);
            notifyItemInserted(position);
            notifyItemRangeChanged(position,orders.size());
        }

        public void removeOrder(int position) {
            orders.remove(position);
            notifyDataSetChanged();
            notifyItemRemoved(position);
            notifyItemRangeChanged(position,orders.size());
        }

    }
















}
