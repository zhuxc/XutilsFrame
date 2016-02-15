package com.zhuxc.farme.framework.fragment;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment implements OnClickListener{

	public View view;
	public Context ct;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		initData(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ct = getActivity();
		
	}
  
	/**
	 * setContentView;
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//		view = initView(inflater);

		return view;
	}
    public  View getRootView(){
    	return view;
    }
    /**
	 * 每次fragment切换都会重新调用此方法
	 */
	public abstract void loadData();

}
