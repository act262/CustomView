package com.github.act262.customview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.act262.customview.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, CustomViewActivity.class);
        intent.putExtra("viewId", v.getId());
        switch (v.getId()) {
            case R.id.btn_grids_view:
                break;
            case R.id.btn_rules_view:
                break;
        }
        startActivity(intent);
    }
}
