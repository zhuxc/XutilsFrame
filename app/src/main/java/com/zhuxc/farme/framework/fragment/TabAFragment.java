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
 * FragmentA
 *
 * @author zhuxc
 * @ClassName: TabAFragment
 * @Description: TODO
 */
public class TabAFragment extends BaseFragment {
    @Bind(R.id.tv)
    TextView tv;
    private View view;
    protected boolean isCreated  = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fargmentA", "fargmentA onCreate");

        isCreated = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_a, container, false);
        ButterKnife.bind(this, view);

        Log.i("fargmentA", "fargmentA onCreateView");
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fargmentA", "fargmentA onDestroy");
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fargmentA", "fargmentA onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fargmentA", "fargmentA onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fargmentA", "fargmentA onResume");
    }

    @Override
    public void onPause() {//建议调用此方法时取消掉网络请求
        super.onPause();
        Log.i("fargmentA", "fargmentA onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fargmentA", "fargmentA onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.i("fargmentA", "fargmentA onDetach");
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (!isCreated) {
            return;
        }

        if (isVisibleToUser) {
            Log.i("fargmentA", "fargmentA 显示");
        }else {
            Log.i("fargmentA", "fargmentA 隐藏");
        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {

            default:
                break;
        }
    }


}
