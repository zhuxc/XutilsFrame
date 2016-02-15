package com.zhuxc.farme.framework.view.datepicker;


public interface OnWheelChangedListener {
	void onChanged(WheelView wheel, int oldValue, int newValue);

	void onChanged(WheelViewTime wheelViewTime, int oldValue, int newValue);
}
