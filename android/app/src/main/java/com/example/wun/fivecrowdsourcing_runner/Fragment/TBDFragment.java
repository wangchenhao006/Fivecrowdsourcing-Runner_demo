package com.example.wun.fivecrowdsourcing_runner.Fragment;

/**
 * 待配送Fragment
 * Created by WUN on 2018/3/8.
 */

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TBDFragment extends  BaseFragment{
    @Override
    protected void loadData() {
        Toast.makeText(mContent,"待配送Fragment加载数据",Toast.LENGTH_SHORT).show();
        /*ArrayList<OrderBean> mOrders=new ArrayList<OrderBean>();
        for (int i=0;i<10;i++) {
            OrderBean neworder=new OrderBean("zzc"+i,"ZJUT" +i);
            mOrders.add(neworder);*/
    }

    @Override
    protected View initView()  {
        TextView mView = new TextView(mContent);
        mView.setText("Fragment待配送");
        mView.setGravity(Gravity.CENTER);
        mView.setTextSize(18);
        mView.setTextColor(Color.BLACK);
        return mView;

       /* LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        OrderAdapter adpater = new OrderAdapter();
        mRecyclerView.setAdapter(adpater);*/


    }
}
