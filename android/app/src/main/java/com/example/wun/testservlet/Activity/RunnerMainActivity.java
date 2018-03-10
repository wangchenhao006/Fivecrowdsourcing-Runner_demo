package com.example.wun.testservlet.Activity;

/**
 * Created by WUN on 2018/3/7.
 */
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import java.util.List;
import com.example.wun.testservlet.R;
import com.example.wun.testservlet.Bean.Runner;
import com.example.wun.testservlet.Presenter.RunnerLoginPresenter;
import com.example.wun.testservlet.View.IRunnerLoginView;


public class RunnerMainActivity extends FragmentActivity{


    private ViewPager viewPager;

    private TabLayout tabLayout;

    public static void actionStart(Context context, String data1){
        Intent intent = new Intent(context,RunnerMainActivity.class);
        intent.putExtra("param1",data1);
        context.startActivity(intent);
    }

}
