package com.duoma.dmcg.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.duoma.dmcg.R;
import com.duoma.dmcg.fragment.Tab1Fragment;
import com.duoma.dmcg.fragment.Tab2Fragment;
import com.duoma.dmcg.fragment.Tab3Fragment;
import com.duoma.dmcg.fragment.Tab4Fragment;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;

import static com.duoma.dmcg.app.EXApplication.E_Log;
import static com.duoma.dmcg.app.EXApplication.tabsIndex;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //主界面和菜单栏 开始
    private RelativeLayout[] mTabs;
    private int lastTabsIndex = 0;//上一个页面跳转的菜单栏位置

    public static final int PAGE_TAB1 = 0;
    public static final int PAGE_TAB2 = 1;
    public static final int PAGE_TAB3 = 2;
    public static final int PAGE_TAB4 = 3;

    @SuppressLint("UseSparseArrays")
    private HashMap<Integer, Fragment> fragments = new HashMap<>();
    //主界面和菜单栏 结束

    //退出 开始
    private Handler mHandler = new Handler();
    private Boolean isExit = false;//双击退出标志位
    //退出 结束

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        E_Log("MainActivity-onCreate");

        initUI();
    }

    /**
     * 初始化控件
     */
    private void initUI() {
        /**
         * 主界面和底部菜单栏 开始（要放在Toolbar 开始 之前）
         */
        fragments.put(PAGE_TAB1, new Tab1Fragment());
        fragments.put(PAGE_TAB2, new Tab2Fragment());
        fragments.put(PAGE_TAB3, new Tab3Fragment());
        fragments.put(PAGE_TAB4, new Tab4Fragment());

        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container, fragments.get(PAGE_TAB1));
        ft.commit();

        mTabs = new RelativeLayout[4];
        mTabs[0] = (RelativeLayout) findViewById(R.id.relative_main_1);
        mTabs[1] = (RelativeLayout) findViewById(R.id.relative_main_2);
        mTabs[2] = (RelativeLayout) findViewById(R.id.relative_main_3);
        mTabs[3] = (RelativeLayout) findViewById(R.id.relative_main_4);

        for (RelativeLayout mTab : mTabs) {
            mTab.setOnClickListener(this);
        }

        tabsIndex = PAGE_TAB1;// 把第一个tab设为选中状态
        if (tabsIndex != lastTabsIndex) {//解决从X5页面跳转回来，底部菜单栏位置默认点击第一个的BUG
            tabsIndex = lastTabsIndex;
        }

        assert mTabs[tabsIndex] != null;
        mTabs[tabsIndex].setSelected(true);
        /**
         * 主界面和底部菜单栏 结束
         */
    }
    /*@Override
    public void onCreateCustomToolBar(Toolbar toolbar) {
        super.onCreateCustomToolBar(toolbar);
        toolbar.showOverflowMenu() ;
        getLayoutInflater().inflate(R.layout.toobar_button, toolbar) ;
//        TextView btn = (TextView) toolbar.findViewById(R.id.id_txt_btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"test",Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem itemCompat = menu.findItem(R.id.action_search) ;
//        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(itemCompat);
//        mSearchView.setIconified(false);
//        mSearchView.setIconifiedByDefault(false);
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
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);//友盟统计
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);//友盟统计
    }

    /**
     * 返回键点击事件
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            //点击返回键关闭侧边栏
            if (!isExit) {
                Toast.makeText(MainActivity.this, "双击退出程序", Toast.LENGTH_SHORT).show();
            }

            if (!isExit) {
                isExit = true; // 准备退出
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false; // 取消退出
                    }
                }, 600);// 如果N秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

            } else {
                finish();
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 按键点击事件
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.relative_main_1:
                isOnclickTabs(PAGE_TAB1);
                break;
            case R.id.relative_main_2:
                isOnclickTabs(PAGE_TAB2);
                break;
            case R.id.relative_main_3:
                isOnclickTabs(PAGE_TAB3);
                break;
            case R.id.relative_main_4:
                isOnclickTabs(PAGE_TAB4);
                break;
        }
    }

    /**
     * 切换界面和点击菜单栏
     */
    private void isOnclickTabs(int page) {

        if (tabsIndex == page) {//如果同一个则无操作
            return;
        }
        Fragment fragment = fragments.get(page);
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            ft.add(R.id.container, fragment);
        }
        ft.hide(fragments.get(tabsIndex));//移除上一个
        ft.show(fragments.get(page));//添加当前

        mTabs[tabsIndex].setSelected(false);
        mTabs[page].setSelected(true);// 把当前tab设为选中状态
        tabsIndex = page;

        if (!this.isFinishing()) {
            ft.commitAllowingStateLoss();
        }
    }
}
