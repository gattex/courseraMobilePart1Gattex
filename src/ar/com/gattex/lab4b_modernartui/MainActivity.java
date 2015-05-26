package ar.com.gattex.lab4b_modernartui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SeekBar;

public class MainActivity extends Activity {

	private SeekBar seekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.seekBar = (SeekBar) super.findViewById(R.id.seekBar);
		this.seekBar.setOnSeekBarChangeListener(
				new SeekBarListener(
						super.findViewById(R.id.viewLeftOne),
						super.findViewById(R.id.viewLeftTwo), 
						super.findViewById(R.id.viewRigthOne), 
						super.findViewById(R.id.viewRigthTwo),
						super.findViewById(R.id.viewRigthThree)
						)
				);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.items, menu);
		return super.onCreateOptionsMenu(menu);
	}

}
