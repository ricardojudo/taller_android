package com.example.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PrompActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_promp);
	}

	public void close(View view) {
		EditText text = (EditText) findViewById(R.id.input);
		String resultado = text.getText().toString();
		Intent intent = new Intent();
		intent.putExtra("resultado", "Resultado: " + resultado);
		setResult(RESULT_OK, intent);
		finish();
	}
}
