package com.duoma.dmcg.app;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.duoma.dmcg.R;
import com.duoma.dmcg.toolbar.ToolBarHelper;

import tools.niorgai.StatusBarCompat;

public class BaseActivity extends AppCompatActivity {

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 设置toolbar
     */
    @Override
    public void setContentView(int layoutResID) {

        ToolBarHelper mToolBarHelper = new ToolBarHelper(this, layoutResID);
        toolbar = mToolBarHelper.getToolBar();

        setContentView(mToolBarHelper.getContentView());
        setSupportActionBar(toolbar);/*把 toolbar 设置到Activity中*/

        onCreateCustomToolBar(toolbar);/*自定义的一些操作*/

        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary));//设置状态栏颜色
    }

    /**
     * 设置toolbar边距
     */
    public void onCreateCustomToolBar(Toolbar toolbar) {
        toolbar.setContentInsetsRelative(0, 0);
    }

    /**
     * 设置toolbar返回键点击效果
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
