package com.example.wun.fivecrowdsourcing_runner.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.wun.fivecrowdsourcing_runner.Adapter.MyFragmentAdapter;
import com.example.wun.fivecrowdsourcing_runner.Adapter.OrderAdapter;
import com.example.wun.fivecrowdsourcing_runner.Bean.OrderBean;
import com.example.wun.fivecrowdsourcing_runner.Bean.Runner;
import com.example.wun.fivecrowdsourcing_runner.Fragment.BaseFragment;
import com.example.wun.fivecrowdsourcing_runner.Fragment.FragmentFactory;
import com.example.wun.fivecrowdsourcing_runner.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Runner runner = new Runner();
    private TextView phone;
    private TextView name;
    private TextView title;

    private TabLayout mTab;
    private ViewPager mViewPager;
    public static final int TAB_LONG_COUNT=9;
    public static final int TAB_SHORT_COUNT=3;


    private OrderAdapter mAdapter;
    private ArrayList<OrderBean> mOrders;

    private final String[] modules = {"待接单", "待取货","配送中", "已完成"};
    private List<Fragment> mFragments;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runner= (Runner) getIntent().getSerializableExtra("runner");
        String name=runner.getName();
        mFragments = new ArrayList<>();

        bindView();
        initData();


    }

    private void initData() {
        ShortPagerAdapter adapter = new ShortPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewPager);
       /* Toast.makeText(this,
                "initData", Toast.LENGTH_SHORT).show();*/
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
       // mViewPager.setCurrentItem(0);
//        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent(BroConstant.PENDING_DELIVERY));
    }

    private void bindView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title=findViewById(R.id.title);
        title.setText("Five ");

        //TAB VIEWPAGER
        mTab = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(2);


        // FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //DrawerLayout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), mFragments, modules);


        //设置侧栏信息
        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        name=(TextView)headerLayout.findViewById(R.id.name);
        phone=(TextView)headerLayout.findViewById(R.id.phone);
        name.setText(runner.getName());
        phone.setText(runner.getPhone());

    }

   /* private void recycleInitData() {
        mOrders=new ArrayList<OrderBean>();
        for (int i=0;i<10;i++) {
            OrderBean neworder=new OrderBean("zzc"+i,"ZJUT" +i);
            mOrders.add(neworder);
        }
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //转换成JSON格式
                    Gson gson = new Gson();
                    String runnerdata = gson.toJson(runner);

                    RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                            , runnerdata);
                    Request request = new Request.Builder().
                            url(DataConfig.URL+DataConfig.RunnerGetOrder).
                            post(requestBody).
                            build();

                    OkHttpClient client = new OkHttpClient();
                    Response response = client.newCall(request).execute();

                    String jsonData= response.body().string().toString();
                    JSONObject jsonObject = new JSONObject(jsonData);
                    String result=jsonObject.getString("result");
                    String cusAddress=jsonObject.getString("cusAddress");
                    String cusName=jsonObject.getString("cusName");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
   // }

    /*private void recycleInitEvent() {
        mAdapter=new OrderAdapter(MainActivity.this,mOrders);
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //创建LinearLayoutManager 对象 这里使用 LayoutManager 是线性布局的意思
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//垂直线性布局
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));//线性宫格显示，类似gridview
       // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));//线性宫格显示类似瀑布流
        //设置Adapter
        recyclerView.setAdapter(mAdapter);


    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Authentication) {
            // Handle the camera action
            Intent intent=new Intent(MainActivity.this, RunnerInfoActivity.class);
            intent.putExtra("runner",runner);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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

