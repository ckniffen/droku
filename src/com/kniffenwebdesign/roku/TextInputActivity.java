package com.kniffenwebdesign.roku;

import com.kniffenwebdesign.roku.ecp.EcpClient;
import com.kniffenwebdesign.roku.ecp.Key;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextInputActivity extends Activity{
	private static final String LOG_TAG = "TextInputActivity";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_input);
        
        final EditText editTextSendText = (EditText) findViewById(R.id.send_text);
        final Button buttonEnter = (Button) findViewById(R.id.button_enter);
        final Button buttonCancel = (Button) findViewById(R.id.button_cancel);
        
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String str = editTextSendText.getText().toString();
            	EcpClient.getInstance().sendString(str);
            }
        });
        
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	finish();
            }
        });
    }
}
