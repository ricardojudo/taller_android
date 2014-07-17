package com.example.intents;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String LOG_TAG = MainActivity.class.getSimpleName();

	private static final int RESULT_CODE_LANZADA = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void actividad(View view) {
		Intent intent = new Intent(this, LanzadaActivity.class);
		intent.putExtra("cadena", "una cadena: " + Math.random());
		startActivity(intent);
	}

	public void actividadResultado(View view) {
		Intent intent = new Intent(this, PrompActivity.class);
		intent.putExtra("cadena", "una cadena: " + Math.random());
		startActivityForResult(intent, RESULT_CODE_LANZADA);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != RESULT_OK) {
			return;
		}
		switch (requestCode) {
		case RESULT_CODE_LANZADA:
			Bundle b = data.getExtras();
			String resultado = b.getString("resultado");
			Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
			break;
		case RESULT_CONTACT_PICKER:
			Uri uri = data.getData();
			Cursor cursor = getContentResolver().query(uri, null, null, null,
					null);
			cursor.moveToFirst();
			resultado = cursor
					.getString(cursor
							.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DATA));
			Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
			break;
		}

	}

	public void openGoogle(View view) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.google.com"));
		startActivity(intent);
	}

	private static final int RESULT_CONTACT_PICKER = 10001;

	public void selectContact(View view) {
		Intent intent = new Intent(Intent.ACTION_PICK, Contacts.CONTENT_URI);
		intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
		startActivityForResult(intent, RESULT_CONTACT_PICKER);
	}
}
