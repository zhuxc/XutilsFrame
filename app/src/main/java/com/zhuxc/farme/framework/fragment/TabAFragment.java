package com.zhuxc.farme.framework.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.zhuxc.farme.framework.R;
import com.zhuxc.farme.framework.network.NetUtils;
import com.zhuxc.farme.framework.okhttp_volley.RequestManager;
import com.zhuxc.farme.framework.utils.CommonUtil;

import org.json.JSONObject;

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
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.tv)
    TextView tv;
    private View view;
    private TextView fra_title;
    private ImageView fra_iv_info;
    private ImageView fra_iv_sao;
    private boolean hidden;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_a, container, false);
        ButterKnife.bind(this, view);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        StringRequest request = new StringRequest(
                Request.Method.GET,
                "https://kyfw.12306.cn/otn/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tv.setText("请求成功:" + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tv.setText("请求失败:" + error.toString());
                    }
                });
        RequestManager.getInstance(ct).addRequest(request, ct);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void loadData() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.hidden = hidden;
        if (!hidden) {
            CommonUtil.Toast(ct, "fargmentA");
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
