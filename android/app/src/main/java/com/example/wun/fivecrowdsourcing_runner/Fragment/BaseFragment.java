package com.example.wun.fivecrowdsourcing_runner.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    protected Context mContent;
   // private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContent = getContext();//上下文。

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       /* View view = inflater.inflate(R.layout.fragment_order_item, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);*/
        return initView();//初始化布局。
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();//初始化数据。
    }

    protected abstract void loadData();

    protected abstract View initView();

}