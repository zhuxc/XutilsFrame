package com.zhuxc.farme.framework.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuxc.farme.framework.R;
import com.zhuxc.farme.framework.activity.BookDetailActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Fragment
 *
 * @author zhuxc
 * @ClassName: TabAFragment
 * @Description: TODO
 */
public class TabDFragment extends BaseFragment {
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private View view;

    protected boolean isCreated = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isCreated = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_d, container, false);

        ButterKnife.bind(this, view);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(ct, BookDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fargmentD", "fargmentD onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fargmentD", "fargmentD onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fargmentD", "fargmentD onResume");
    }

    @Override
    public void onPause() {//建议调用此方法时取消掉网络请求
        super.onPause();
        Log.i("fargmentD", "fargmentD onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fargmentD", "fargmentD onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.i("fargmentD", "fargmentD onDetach");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isCreated) {
            return;
        }

        if (isVisibleToUser) {
            Log.i("fargmentD", "fargmentD 显示");
        } else {
            Log.i("fargmentD", "fargmentD 隐藏");
        }
    }


    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }
}
