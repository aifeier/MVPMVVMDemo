package com.demo.ai.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.demo.ai.myapplication.R;
import com.demo.ai.myapplication.mvp.MainActivity;

/**
 * Created by chen on 2017/11/20.
 * Email：237142681@qq.com
 */

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findViewById(R.id.mvp).setOnClickListener(this);
        findViewById(R.id.mvvm).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mvp:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.mvvm:
                break;
        }
    }
}
