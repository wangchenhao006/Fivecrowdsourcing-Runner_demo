package com.example.wun.fivecrowdsourcing_runner.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wun.fivecrowdsourcing_runner.Bean.Runner;
import com.example.wun.fivecrowdsourcing_runner.Presenter.RunnerInfoPresenter;
import com.example.wun.fivecrowdsourcing_runner.R;
import com.example.wun.fivecrowdsourcing_runner.View.RunnerInfoView;

public class RunnerInfoActivity extends AppCompatActivity implements RunnerInfoView {
    private TextView title;
    private EditText name;
    private  EditText phone;;
    //private  EditText typeofgood;
   // private  TextView address;
   // private String addressname;
    private Button firststep;
  // private  AddressInfo addressInfo;
    private Runner runner = new Runner();
    RunnerInfoPresenter runnerInfoPresenter =new RunnerInfoPresenter(this);

    public RunnerInfoActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runner_info);
        runner = (Runner) getIntent().getSerializableExtra("runner");
        //Log.v("rinfo runner id",runner.getRunnerId().toString());
        initView();
    }

    private void initView() {
        //获得pctvrf信息

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //address = findViewById(R.id.address);
        name = findViewById(R.id.runnername);
        phone = findViewById(R.id.runnerphone);
        phone.setText(runner.getPhone());
       // typeofgood = findViewById(R.id.type_good);
        firststep = findViewById(R.id.first_step);
        title = findViewById(R.id.title);
        title.setText("跑腿人信息认证");
       /* ImageView iv = findViewById(R.id.right);
       iv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //选择地址界面
               gotomap();
           }
       });*/
       firststep.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //发送商户基本信息
             runnerInfoPresenter.sendRunnerInfo(String.valueOf(name.getText()),
                     String.valueOf(phone.getText()),  runner);

           }
       });
    }

    @Override
    public void gotomap() {
        Intent intent = new Intent(RunnerInfoActivity.this, MapsActivity.class);
        startActivityForResult(intent,1);
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK) {
                    addressname =  (String)data.getSerializableExtra("addressInfo");
                    //addressname = addressInfo.getCity() + "-" + addressInfo.getDistrict() + "-" + addressInfo.getStreet();
                    address.setText(addressname);
                }
        }
    }*/

    @Override
    public void finishStep1(Runner runner) {
        Intent intent = new Intent(RunnerInfoActivity.this, Step2Activity.class);
        intent.putExtra("runner",runner);
        startActivity(intent);
    }
}
