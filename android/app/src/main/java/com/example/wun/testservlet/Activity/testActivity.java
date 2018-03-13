package com.example.wun.testservlet.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

import com.example.wun.testservlet.Bean.OrderBean;
import com.example.wun.testservlet.Adapter.OrderAdapter;
import  com.example.wun.testservlet.R;

import java.util.List;

/**
 * MerchandiseListActivity
 * <p>
 * author: wch<br>
 * time:   2017803/11 18:03 <br>
 * GitHub: https://github.com/wangchenhao006
 * CSDN:   http://blog.csdn.net/wangchenhao006
 * 实现订单信息的显示。
 * </p>
 */
public class testActivity extends AppCompatActivity {
    //OrderBean OrderBean;
   // private List<OrderBean> mData = null;
    private Context mContext;
    private OrderAdapter mAdapter = null;
    private ListView list_view;
    private List<OrderBean> mOrder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);
        list_view = (ListView) findViewById(R.id.list_test);
        mContext = testActivity.this;
        bindViews();
        List<OrderBean> mData = new ArrayList<>();
        mData = new ArrayList<OrderBean>();
        mOrder = new LinkedList<OrderBean>();
        /*mData.add(new OrderBean("001", "订单1", R.mipmap.ic_icon_qitao));
        mData.add(new OrderBean("002", "订单2", R.mipmap.ic_icon_qitao));
        mData.add(new OrderBean("003", "订单3", R.mipmap.ic_icon_qitao));
        mData.add(new OrderBean("004", "订单4", R.mipmap.ic_icon_qitao));
        mData.add(new OrderBean("005", "订单5", R.mipmap.ic_icon_qitao));*/
        /*for(int i=0;i<10;i++){
            OrderBean ob=new OrderBean("001", "订单1", R.drawable.ic_launcher);
            ob.setOrderId("10"+i);
            ob.setTitle("name"+i);
            ob.setIcon(R.drawable.ic_launcher_round);
            mData.add(ob);
        }*/
        //System.out.println(mData.toString());
        Log.e("wch", "onCreate: orderbean ");
        mAdapter = new OrderAdapter( mData, testActivity.this);


        //list_view = (ListView) findViewById(R.id.list_test);
        list_view.setAdapter(mAdapter);
    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext,"你点击了第" + position + "项",Toast.LENGTH_SHORT).show();
    }*/

    private void bindViews(){
        list_view = (ListView) findViewById(R.id.list_test);
        TextView txt_empty = (TextView) findViewById(R.id.txt_empty);

        txt_empty.setText("暂无数据~");
        list_view.setEmptyView(txt_empty);
    }

}