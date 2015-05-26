package ar.com.gattex.lab4b_modernartui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekBarListener implements OnSeekBarChangeListener{
	
	private View viewLeftOne;
	private View viewLeftTwo;
	private View viewRightOne;
	private View viewRightTwo;
	private View viewRightThree;
	
	private  int KEY_TAG_VIEW_LEFT_ONE = 150;

	SeekBarListener(View viewLeftOne, View viewLeftTwo, View viewRightOne, View viewRightTwo, View viewRightThree){
		this.viewLeftOne = viewLeftOne;
		this.viewLeftTwo = viewLeftTwo;
		this.viewRightOne = viewRightOne;
		this.viewRightTwo = viewRightTwo;
		this.viewRightThree = viewRightThree;
	}
	
	
	@Override
	public void onProgressChanged(SeekBar seek, int progress, boolean fromUser) {
		
		ObjectTag leftOneTag = (ObjectTag)this.viewLeftOne.getTag(R.id.viewLeftOne);
		Integer hexaValue = null;
		if (leftOneTag != null){
			hexaValue = Integer.parseInt(leftOneTag.tag.substring(1,leftOneTag.tag.length()-1),16);
			if (leftOneTag.progree < progress){ //increment
				hexaValue+=progress;
			}else{
				hexaValue-=progress;
			}
		}else{
			leftOneTag = new ObjectTag();
			leftOneTag.progree = progress;
			leftOneTag.tag = (String)this.viewLeftOne.getTag();
			hexaValue = Integer.parseInt(leftOneTag.tag.substring(1,leftOneTag.tag.length()-1),16);
			hexaValue+=progress;
		}
		String hexColor = String.format("#%06X", (0xFFFFFF & hexaValue));
		int colorViewLeftOne = Color.parseColor(hexColor);
		viewLeftOne.setBackgroundColor(colorViewLeftOne);
		this.viewLeftOne.setTag(R.id.viewLeftOne,leftOneTag);		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seek) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStopTrackingTouch(SeekBar seek) {
		// TODO Auto-generated method stub
	}

}

class ObjectTag{
	
	String tag;
	Integer progree;
}
