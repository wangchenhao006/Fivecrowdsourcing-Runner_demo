package com.example.wun.testservlet.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.wun.testservlet.R;
import com.example.wun.testservlet.Fragment.BaseFragment;
import  com.example.wun.testservlet.Fragment.FragmentFactory;


public class ShortTabActivity extends AppCompatActivity {
    private TabLayout mTab;
    private ViewPager mViewPager;
    public static final int TAB_LONG_COUNT=9;
    public static final int TAB_SHORT_COUNT=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runner_main);
        Toast.makeText(this,
                "setContentView Success", Toast.LENGTH_SHORT).show();
        initView();
       initData();
    }

    private void initData() {
        ShortPagerAdapter adapter = new ShortPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewPager);
       /* Toast.makeText(this,
                "initData", Toast.LENGTH_SHORT).show();*/

    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.runner_main_tab);
        mViewPager = (ViewPager) findViewById(R.id.runner_main_viewpager);
       /* Toast.makeText(this,
                "initView", Toast.LENGTH_SHORT).show();*/
    }

    private class ShortPagerAdapter extends FragmentPagerAdapter {
        public String[] mTilte;

        //获取title
        public ShortPagerAdapter(FragmentManager fm) {
            super(fm);
            mTilte = getResources().getStringArray(R.array.tab_short_Title);

        }

        //设置title
        @Override
        public CharSequence getPageTitle(int position) {
            return mTilte[position];
        }

        //跳转fragment
        @Override
        public BaseFragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        //设置首栏显示数目
        @Override
        public int getCount() {
            return TAB_SHORT_COUNT;
        }

    }
}