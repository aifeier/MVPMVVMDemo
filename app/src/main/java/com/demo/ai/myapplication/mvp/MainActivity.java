package com.demo.ai.myapplication.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.demo.ai.myapplication.R;
import com.demo.ai.myapplication.mvp.bean.User;
import com.demo.ai.myapplication.mvp.bif.IUserLoginView;
import com.demo.ai.myapplication.mvp.presenter.UserLoginPresenter;

/**
 * Created by chen on 2017/11/20.
 * Email：237142681@qq.com
 */

public class MainActivity extends AppCompatActivity implements IUserLoginView {
    private AutoCompleteTextView email;
    private EditText password;
    private Button submit;
    private UserLoginPresenter userLoginPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (AutoCompleteTextView) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.email_sign_in_button);
        progressBar = (ProgressBar) findViewById(R.id.login_progress);
        userLoginPresenter = new UserLoginPresenter(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });

    }

    @Override
    public void showWaitDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void closeWaitDialog() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void clearEmail() {
        email.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public String getEmail() {
        return email.getEditableText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void JumpToNextActivity(User user) {
        Toast.makeText(this, "Login Success , jump to next Activity", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setError(Throwable throwable) {
        email.setError(throwable.getMessage());
        email.requestFocus();
    }
}
