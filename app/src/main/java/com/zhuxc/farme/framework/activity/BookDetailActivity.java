package com.zhuxc.farme.framework.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhuxc.farme.framework.R;
import com.zhuxc.farme.framework.demain.Book;
import com.zhuxc.farme.framework.fragment.TabAFragment;
import com.zhuxc.farme.framework.fragment.TabBFragment;
import com.zhuxc.farme.framework.fragment.TabCFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenyc on 15/7/1.
 */
public class BookDetailActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private Book mBook;
    private TabAFragment tabAFragment;
    private TabBFragment tabBFragment;
    private TabCFragment tabCFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        initMenuTab();
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Framework");

        ImageView ivImage = (ImageView) findViewById(R.id.ivImage);
        Glide.with(ivImage.getContext())
                .load("http://c.hiphotos.baidu.com/image/pic/item/4034970a304e251f2f3d2799a086c9177e3e538d.jpg")
                .fitCenter()
                .into(ivImage);

    }

    /**
     * 初始化底部菜单栏
     */
    public void initMenuTab(){
        tabAFragment = new TabAFragment();
        tabBFragment = new TabBFragment();
        tabCFragment = new TabCFragment();


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("内容简介"));
        tabLayout.addTab(tabLayout.newTab().setText("作者简介"));
        tabLayout.addTab(tabLayout.newTab().setText("目录"));
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager mViewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(tabAFragment, "内容简介");
        adapter.addFragment(tabBFragment, "作者简介");
        adapter.addFragment(tabCFragment, "目录");
        mViewPager.setAdapter(adapter);
    }


    static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

}
