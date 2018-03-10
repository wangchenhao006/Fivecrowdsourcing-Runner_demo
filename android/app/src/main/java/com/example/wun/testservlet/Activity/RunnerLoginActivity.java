
package com.example.wun.testservlet.Activity;

/**
 * Created by WUN on 2018/2/18.
 */


        import android.content.Intent;
        import android.os.Bundle;

        import android.app.Activity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.Toast;

        import com.example.wun.testservlet.R;
        import com.example.wun.testservlet.Bean.Runner;
        import com.example.wun.testservlet.Presenter.RunnerLoginPresenter;
        import com.example.wun.testservlet.View.IRunnerLoginView;

public class RunnerLoginActivity extends Activity implements IRunnerLoginView
{


    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private RunnerLoginPresenter mRunnerLoginPresenter;//这里是将IUserLoginView接口的实例（即Activity）传给了Presenter

    {
        mRunnerLoginPresenter = new RunnerLoginPresenter(this);
    }

    private ProgressBar id_progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runner_login);
        initViews();
        mPbLoading.setVisibility(View.GONE);

    }

    private void initViews()
    {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);

        mBtnClear = (Button) findViewById(R.id.id_btn_register);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);

        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mRunnerLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mRunnerLoginPresenter.clear();
            }
        });
    }


    @Override
    public String getUserName()
    {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword()
    {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName()
    {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword()
    {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading()
    {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(Runner runner)
    {
        Toast.makeText(this, runner.getName() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
       // RunnerMainActivity.actionStart(RunnerLoginActivity.this,mEtUsername.getText().toString());

        //Intent intent = new Intent (RunnerLoginActivity.this,ShortTabActivity.class);
        Intent intent = new Intent (RunnerLoginActivity.this,ShortTabActivity.class);
        startActivity(intent);
    }

    @Override
    public void showFailedError()
    {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}