package com.example.wun.testservlet.Fragment;

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
    }

    @Override
    protected View initView() {
        TextView mView = new TextView(mContent);
        mView.setText("Fragment待配送");
        mView.setGravity(Gravity.CENTER);
        mView.setTextSize(18);
        mView.setTextColor(Color.BLACK);
        return mView;
    }
}
