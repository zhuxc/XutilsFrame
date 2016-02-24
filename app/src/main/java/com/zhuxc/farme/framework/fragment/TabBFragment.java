package com.zhuxc.farme.framework.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhuxc.farme.framework.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Fragment
 *
 * @author zhuxc
 * @ClassName: TabBFragment
 * @Description: TODO
 */
public class TabBFragment extends BaseFragment {
    @Bind(R.id.http_tv)
    TextView httpTv;
    private View view;
    protected boolean isCreated = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isCreated = true;
        Log.i("fargmentB", "fargmentB onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_b, container, false);
        Log.i("fargmentB", "fargmentB onCreateView");

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fargmentB", "fargmentB onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fargmentB", "fargmentB onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fargmentB", "fargmentB onResume");
    }

    @Override
    public void onPause() {//建议调用此方法时取消掉网络请求
        super.onPause();
        Log.i("fargmentB", "fargmentB onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fargmentB", "fargmentB onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.i("fargmentB", "fargmentB onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fargmentB", "fargmentB onDestroy");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isCreated) {
            return;
        }

        if (isVisibleToUser) {
            Log.i("fargmentB", "fargmentB 显示");
        } else {
            Log.i("fargmentB", "fargmentB 隐藏");
        }
    }


    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }
}
