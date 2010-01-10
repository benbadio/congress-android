package com.sunlightlabs.android.congress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;

public class GetState extends Activity {
	private Spinner spinner;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.get_state);
        
        setupControls();
    }
	
	
	public void setupControls() {
		spinner = (Spinner) findViewById(R.id.spinner);
		
		Button ok = (Button) this.findViewById(R.id.get_text_ok);
		Button cancel = (Button) this.findViewById(R.id.get_text_cancel);
		
		ok.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String response = (String) spinner.getSelectedItem();
				
				Bundle data = new Bundle();
				data.putString("response", response);
				Intent i = new Intent();
				i.putExtras(data);
				
				setResult(RESULT_OK, i);
				finish();
			}
		});
		
		cancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}
}
