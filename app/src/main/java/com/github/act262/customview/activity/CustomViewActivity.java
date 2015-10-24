package com.github.act262.customview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.github.act262.customview.R;
import com.github.act262.customview.view.DrawHookView;
import com.github.act262.customview.view.GridsView;
import com.github.act262.customview.view.RulesView;

/**
 * @author act262@gmail.com
 * @version 1.0
 * @time 2015/10/24
 */
public class CustomViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = null;
        int viewId = getIntent().getIntExtra("viewId", 0);
        switch (viewId) {
            case R.id.btn_grids_view:
                view = new GridsView(this);
                break;
            case R.id.btn_rules_view:
                view = new RulesView(this);
                break;
            case R.id.btn_hook_view:
                view = new DrawHookView(this);
                break;
        }
        setContentView(view, new FrameLayout.LayoutParams(-1, -1));
    }
}
