package com.loquequieran.comosea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView mensaje;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mensaje=(TextView)findViewById(R.id.texto);
	}
	
	public void picar(View view){
		mensaje.setVisibility(View.INVISIBLE);		
	}
}
