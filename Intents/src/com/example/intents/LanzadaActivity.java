package com.example.intents;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LanzadaActivity extends Activity {

	private static final String LOG_CAT_TAG="Lanzada";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lanzada);
		Bundle extras=getIntent().getExtras();
		String cadena=extras.getString("cadena");
		
		TextView textView=(TextView) findViewById(R.id.message);
		textView.setText(cadena);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(LOG_CAT_TAG, "On start");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(LOG_CAT_TAG, "On stop");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(LOG_CAT_TAG, "On restart");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(LOG_CAT_TAG, "On resume");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(LOG_CAT_TAG, "On destroy");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(LOG_CAT_TAG, "On pause");
	}
}
