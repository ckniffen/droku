package com.kniffenwebdesign.roku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kniffenwebdesign.roku.ecp.*;

public class RokuActivity extends Activity {
	private static final String LOG_TAG = "RokuActivity";
	private ApplicationPreferences preferences;
	
	ImageView buttonUp;
	ImageView buttonDown;
	ImageView buttonLeft;
	ImageView buttonRight;
	ImageView buttonSelect;
	
	ImageView buttonReverse;
	ImageView buttonPlay;
	ImageView buttonForward;
	
	ImageView buttonBack;
	ImageView buttonHome;
	
	ImageView buttonReplay;
	ImageView buttonInfo;
	
	Button buttonChannels;
	Button buttonTextInput;
	Button buttonSearch;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = new ApplicationPreferences(getApplicationContext());
        
        setContentView(R.layout.main);
        
        EcpClient.getInstance().setIpAddress(preferences.getIpAddress());
        
        buttonUp = (ImageView) findViewById(R.id.button_up);
        buttonDown = (ImageView) findViewById(R.id.button_down);
        buttonLeft = (ImageView) findViewById(R.id.button_left);
        buttonRight = (ImageView) findViewById(R.id.button_right);
        buttonSelect = (ImageView) findViewById(R.id.button_select);
        
        buttonReverse = (ImageView) findViewById(R.id.button_reverse);
        buttonPlay = (ImageView) findViewById(R.id.button_play);
        buttonForward = (ImageView) findViewById(R.id.button_forward);
        
        buttonBack = (ImageView) findViewById(R.id.button_back);
        buttonHome = (ImageView) findViewById(R.id.button_home);
        
        buttonReplay = (ImageView) findViewById(R.id.button_replay);
        buttonInfo = (ImageView) findViewById(R.id.button_info);
        
        buttonChannels = (Button) findViewById(R.id.button_channels);  
        buttonTextInput = (Button) findViewById(R.id.button_text_input);
        buttonSearch = (Button) findViewById(R.id.button_search);
        
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 new EcpAsyncTask().execute(Key.BACK);
            }
        });
        
        buttonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	new EcpAsyncTask().execute(Key.HOME);
            }
        });
        
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	new EcpAsyncTask().execute(Key.LEFT);
            }
        });
        
        buttonRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	new EcpAsyncTask().execute(Key.RIGHT);
            }
        });
        
        buttonUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	new EcpAsyncTask().execute(Key.UP);
            }
        });
        
        buttonDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 new EcpAsyncTask().execute(Key.DOWN);
            }
        });
        
        buttonSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 new EcpAsyncTask().execute(Key.SELECT);
            }
        });
        
        buttonReverse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 new EcpAsyncTask().execute(Key.REVERSE);
            }
        });
        
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 new EcpAsyncTask().execute(Key.PLAY);
            }
        });
        
        buttonForward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 new EcpAsyncTask().execute(Key.FORWARD);
            }
        });
        
        buttonReplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 new EcpAsyncTask().execute(Key.REPLAY);
            }
        });
        
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	new EcpAsyncTask().execute(Key.INFO);
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
            	 new EcpAsyncTask().execute(Key.SEARCH);
            }
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
	        case R.id.menu_setting:
	        	Intent i = new Intent(RokuActivity.this, PreferencesActivity.class);
	        	startActivity(i);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
        }
    }
}