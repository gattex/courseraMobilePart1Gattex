package ar.com.gattex.lab4b_modernartui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.SeekBar;

public class MainActivity extends Activity {

	private SeekBar seekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initActionBar();
		setContentView(R.layout.activity_main);
		this.seekBar = (SeekBar) super.findViewById(R.id.seekBar);
		this.seekBar.setOnSeekBarChangeListener(
				new SeekBarListener(this,
						super.findViewById(R.id.viewLeftOne),
						super.findViewById(R.id.viewLeftTwo), 
						super.findViewById(R.id.viewRigthOne), 
						super.findViewById(R.id.viewRigthTwo),
						super.findViewById(R.id.viewRigthThree)
						)
				);
	}

	private void initActionBar() {
		getActionBar().setHomeButtonEnabled(false);
		getActionBar().setDisplayHomeAsUpEnabled(false);
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayUseLogoEnabled(false);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.color_action_bar));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.items, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.info:
			MoreInfoDialog dialog = new  MoreInfoDialog(this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);   
			dialog.show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
