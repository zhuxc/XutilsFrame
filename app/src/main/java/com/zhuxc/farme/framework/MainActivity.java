package com.zhuxc.farme.framework;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuxc.farme.framework.fragment.BaseFragment;
import com.zhuxc.farme.framework.fragment.TabAFragment;
import com.zhuxc.farme.framework.fragment.TabBFragment;
import com.zhuxc.farme.framework.fragment.TabCFragment;
import com.zhuxc.farme.framework.fragment.TabDFragment;
import com.zhuxc.farme.framework.utils.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {
    // 未读消息textview
    private TextView unreadLabel;
    private Button[] mTabs;
    private TabAFragment tabAFragment;
    private TabBFragment tabBFragment;
    private TabCFragment tabCFragment;
    private TabDFragment tabDFragment;
    private BaseFragment[] fragments;
    private int index;
    // 当前fragment的index
    private int currentTabIndex;
    private long exitTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMenuTab();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        //使用颜色资源
        tintManager.setStatusBarTintResource(R.color.black);
        //使用图片资源
//        tintManager.setStatusBarTintDrawable(getResources().getDrawable(R.mipmap.ic_launcher));


    }
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
    /**
     * 初始化底部菜单栏
     */
    public void initMenuTab(){
        tabAFragment = new TabAFragment();
        tabBFragment = new TabBFragment();
        tabCFragment = new TabCFragment();
        tabDFragment = new TabDFragment();

        fragments = new BaseFragment[] { tabAFragment, tabBFragment,
                tabCFragment, tabDFragment };
        // 添加显示第一个fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, tabAFragment)
                .add(R.id.fragment_container, tabBFragment)
                .hide(tabBFragment).show(tabAFragment).commit();

        mTabs = new Button[4];
        mTabs[0] = (Button) findViewById(R.id.btn_main);
        mTabs[1] = (Button) findViewById(R.id.btn_nearby);
        mTabs[2] = (Button) findViewById(R.id.btn_buy);
        mTabs[3] = (Button) findViewById(R.id.btn_mine);

        // 把第一个tab设为选中状态
        mTabs[0].setSelected(true);


    }
    /**
     * button点击事件
     *
     * @param view
     */
    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_main:
                index = 0;
                break;
            case R.id.btn_nearby:
                index = 1;
                break;
            case R.id.btn_buy:
                index = 2;
                break;
            case R.id.btn_mine:
                index = 3;
                break;
        }
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager()
                    .beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }

        mTabs[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                //退出程序
//				application.exit();
                CommApplication.getInstance().exit();
            }
            return true;
        }
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
