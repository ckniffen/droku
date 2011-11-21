package com.kniffenwebdesign.roku;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
        
        final Button buttonLeft = (Button) findViewById(R.id.button_left);
        final Button buttonRight = (Button) findViewById(R.id.button_right);
        final Button buttonUp = (Button) findViewById(R.id.button_up);
        final Button buttonDown = (Button) findViewById(R.id.button_down);
        final Button buttonSelect = (Button) findViewById(R.id.button_select);
        final Button buttonReverse = (Button) findViewById(R.id.button_reverse);
        final Button buttonPlay = (Button) findViewById(R.id.button_play);
        final Button buttonForward = (Button) findViewById(R.id.button_forward);
        final ImageView buttonBack = (ImageView) findViewById(R.id.button_back);
        final ImageView buttonHome = (ImageView) findViewById(R.id.button_home);
        
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
    }  
}