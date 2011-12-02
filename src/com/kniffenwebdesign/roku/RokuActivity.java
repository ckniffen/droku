package com.kniffenwebdesign.roku;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kniffenwebdesign.roku.ecp.*;

public class RokuActivity extends Activity {
	private static final String LOG_TAG = "RokuActivity";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EcpClient.getInstance().setIpAddress("192.168.1.109");
        
        final ImageView buttonUp = (ImageView) findViewById(R.id.button_up);
        final ImageView buttonDown = (ImageView) findViewById(R.id.button_down);
        final ImageView buttonLeft = (ImageView) findViewById(R.id.button_left);
        final ImageView buttonRight = (ImageView) findViewById(R.id.button_right);
        final ImageView buttonSelect = (ImageView) findViewById(R.id.button_select);
        
        final Button buttonReverse = (Button) findViewById(R.id.button_reverse);
        final Button buttonPlay = (Button) findViewById(R.id.button_play);
        final Button buttonForward = (Button) findViewById(R.id.button_forward);
        
        final ImageView buttonBack = (ImageView) findViewById(R.id.button_back);
        final ImageView buttonHome = (ImageView) findViewById(R.id.button_home);
        
        final Button buttonChannels = (Button) findViewById(R.id.button_channels);  
        final Button buttonTextInput = (Button) findViewById(R.id.button_text_input);
        final Button buttonSearch  = (Button) findViewById(R.id.button_search);
        
        
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 Key.BACK.keyPress();
            }
        });
        
        buttonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 Key.HOME.keyPress();
            }
        });
        
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 Key.LEFT.keyPress();
            }
        });
        
        buttonRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 Key.RIGHT.keyPress();
            }
        });
        
        buttonUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 Key.UP.keyPress();
            }
        });
        
        buttonDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 Key.DOWN.keyPress();
            }
        });
        
        buttonSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 Key.SELECT.keyPress();
            }
        });
        
        buttonReverse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 Key.REVERSE.keyPress();
            }
        });
        
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 Key.PLAY.keyPress();
            }
        });
        
        buttonForward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Key.FORWARD.keyPress();
            }
        });
        
        buttonChannels.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent i = new Intent(RokuActivity.this, ChannelsActivity.class);
            	startActivity(i);
            }
        });
        
        buttonTextInput.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	SendTextDialog dialog = new SendTextDialog(RokuActivity.this);
            	dialog.show();
            }
        });
        
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Key.SEARCH.keyPress();
            }
        });
    }  
}