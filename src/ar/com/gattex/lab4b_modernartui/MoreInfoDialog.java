package ar.com.gattex.lab4b_modernartui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreInfoDialog  extends Dialog{

	private Context context;
	
	public MoreInfoDialog(Context context) {
		super(context);
		this.context = context;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_more_info);
		Button notNowButton = (Button) findViewById(R.id.moreinformationnotnow);
		Button goToButton = (Button) findViewById(R.id.moreinformationvisit);
		
		//Cancel button
		notNowButton.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MoreInfoDialog.this.cancel();
			}
		});
		

		//open a browser with moma url
		goToButton.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri url = Uri.parse(context.getResources().getString(R.string.more_information_visit_url_moma));
		        Intent intent = new Intent(Intent.ACTION_VIEW, url);
		        context.startActivity(intent);
		        MoreInfoDialog.this.cancel();
			}
		});
		
		
		
	}
}
