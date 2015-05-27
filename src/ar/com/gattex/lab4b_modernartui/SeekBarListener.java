package ar.com.gattex.lab4b_modernartui;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekBarListener implements OnSeekBarChangeListener {

	private View viewLeftOne;
	private View viewLeftTwo;
	private View viewRightOne;
	private View viewRightTwo;
	private View viewRightThree;
	private Context context;

	SeekBarListener(Context context, View viewLeftOne, View viewLeftTwo,
			View viewRightOne, View viewRightTwo, View viewRightThree) {
		this.context = context;
		this.viewLeftOne = viewLeftOne;
		this.viewLeftTwo = viewLeftTwo;
		this.viewRightOne = viewRightOne;
		this.viewRightTwo = viewRightTwo;
		this.viewRightThree = viewRightThree;
	}

	@Override
	public void onProgressChanged(SeekBar seek, int progress, boolean fromUser) {
		this.viewLeftOne.getBackground().setColorFilter(
				modifyBlueColor(progress, context.getResources().getColor(R.color.whiteblue)));
		this.viewLeftTwo.getBackground().setColorFilter(
				modifyBlueColor(progress, context.getResources().getColor(R.color.whitered)));
		this.viewRightOne.getBackground().setColorFilter(
				modifyBlueColor(progress, context.getResources().getColor(R.color.red)));
		this.viewRightTwo.getBackground().setColorFilter(
				modifyBlueColor(progress, context.getResources().getColor(R.color.white)));
		this.viewRightThree.getBackground().setColorFilter(
				modifyBlueColor(progress, context.getResources().getColor(R.color.gray)));
	}

	public LightingColorFilter modifyBlueColor(int progress, int initColor) {
		Integer value = (int) progress * 255 / 100;
		return new LightingColorFilter(initColor, (value >> 0) & 0xFF);
	}


	@Override
	public void onStartTrackingTouch(SeekBar seek) {
	}

	@Override
	public void onStopTrackingTouch(SeekBar seek) {
	}

}
