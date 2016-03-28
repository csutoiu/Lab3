package ro.pub.cs.systems.eim.lab03.phonedialer;

import java.lang.reflect.Array;

import android.R.array;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends Activity {


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_dialer);
		
		int array[] = {R.id.button0, R.id.button1, R.id.button2,R.id.button3, R.id.button4,
				R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
		int i;
		for(i = 0;i < 10;i++) {
			Button button = (Button)findViewById(array[i]);
			button.setOnClickListener(new clickListener());
		}
		Button button = (Button)findViewById(R.id.button_diez);
		button.setOnClickListener(new clickListener());
		button = (Button)findViewById(R.id.button_steluta);
		button.setOnClickListener(new clickListener());
		ImageButton imagButton = (ImageButton)findViewById(R.id.imageButton1);
		imagButton.setOnClickListener(new clickListener());
		imagButton = (ImageButton)findViewById(R.id.imageButton2);
		imagButton.setOnClickListener(new clickListener());
		imagButton = (ImageButton)findViewById(R.id.imageButton3);
		imagButton.setOnClickListener(new clickListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_dialer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class clickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			EditText phoneNumber = (EditText)findViewById(R.id.textView);
			
			if(v.getClass().equals(ImageButton.class)) {
				if(((ImageButton)v).getId() == R.id.imageButton1) {
					String number = phoneNumber.getText().toString();
					if(number.length() > 0) {
						String newNumber = number.substring(0, number.length() - 1);
						phoneNumber.setText(newNumber);
					}
				} else if(((ImageButton)v).getId() == R.id.imageButton2) {
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel"+phoneNumber.getText().toString()));
					startActivity(intent);
				} else {
	
					finish();
				}
			} else {
				phoneNumber.setText(phoneNumber.getText().toString()
						+((Button)v).getText().toString());
			}
		
		}
	}
}
