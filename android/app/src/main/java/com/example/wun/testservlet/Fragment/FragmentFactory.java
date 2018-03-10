package com.example.wun.testservlet.Fragment;

/**
 * Created by WUN on 2018/3/8.
 */

import java.util.HashMap;

/**
 * Fragment工厂类。
 * Created by LW on 2017/4/20.
 */

public class FragmentFactory {
    private static HashMap<Integer, BaseFragment> mBaseFragments = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int pos) {
        BaseFragment baseFragment = mBaseFragments.get(pos);

        if (baseFragment == null) {
            switch (pos) {
                case 0:
                    //获取服务区推的订单 抢单成功存数据库
                    baseFragment = new TBDFragment();//待配送
                    break;
                case 1:
                    //获取数据库存储数据 配送完成存储数据库 查询一天的数据
                    baseFragment = new DeliveryFragment();//配送中
                    break;
                case 2:
                    //获取数据库存储数据
                    baseFragment = new CompletedFragment();//已完成
                    break;
                default:break;

            }
            mBaseFragments.put(pos, baseFragment);
        }
        return baseFragment;
    }
}