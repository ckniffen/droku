package com.kniffenwebdesign.roku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kniffenwebdesign.roku.ecp.*;

public class RokuActivity extends Activity {
	private static final String LOG_TAG = "RokuActivity";
	private ApplicationPreferences preferences;
	
	public static final Integer BUTTON_KEY_TAG = 0;
	
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
        
        // Directional Pad Buttons
        buttonUp = (ImageView) findViewById(R.id.button_up);
        buttonUp.setTag(R.id.key_type, Key.UP);
        buttonUp.setOnClickListener( new RemoteButtonListener());
        
        buttonDown = (ImageView) findViewById(R.id.button_down);
        buttonDown.setTag(R.id.key_type, Key.DOWN);
        buttonDown.setOnClickListener( new RemoteButtonListener());

        buttonLeft = (ImageView) findViewById(R.id.button_left);
        buttonLeft.setTag(R.id.key_type, Key.LEFT);
        buttonLeft.setOnClickListener( new RemoteButtonListener());

        buttonRight = (ImageView) findViewById(R.id.button_right);
        buttonRight.setTag(R.id.key_type, Key.RIGHT);
        buttonRight.setOnClickListener( new RemoteButtonListener());

        buttonSelect = (ImageView) findViewById(R.id.button_select);
        buttonSelect.setTag(R.id.key_type, Key.SELECT);
        buttonSelect.setOnClickListener( new RemoteButtonListener());

        // Play Direction Buttons
        buttonReverse = (ImageView) findViewById(R.id.button_reverse);
        buttonReverse.setTag(R.id.key_type, Key.REVERSE);
        buttonReverse.setOnClickListener(new RemoteButtonListener());
        
        buttonPlay = (ImageView) findViewById(R.id.button_play);
        buttonPlay.setTag(R.id.key_type, Key.PLAY);
        buttonReverse.setOnClickListener(new RemoteButtonListener());

        buttonForward = (ImageView) findViewById(R.id.button_forward);
        buttonForward.setTag(R.id.key_type, Key.FORWARD);
        buttonForward.setOnClickListener(new RemoteButtonListener());

        // Other Buttons
        buttonBack = (ImageView) findViewById(R.id.button_back);
        buttonBack.setTag(R.id.key_type, Key.BACK);
        buttonBack.setOnClickListener( new RemoteButtonListener());

        buttonHome = (ImageView) findViewById(R.id.button_home);
        buttonHome.setTag(R.id.key_type, Key.HOME);
        buttonHome.setOnClickListener(new RemoteButtonListener());

        buttonReplay = (ImageView) findViewById(R.id.button_replay);
        buttonReplay.setTag(R.id.key_type, Key.REPLAY);
        buttonReplay.setOnClickListener(new RemoteButtonListener());

        buttonInfo = (ImageView) findViewById(R.id.button_info);
        buttonInfo.setTag(R.id.key_type, Key.INFO);
        buttonInfo.setOnClickListener(new RemoteButtonListener());

        // Footer Buttons
        buttonChannels = (Button) findViewById(R.id.button_channels);
        buttonChannels.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent i = new Intent(RokuActivity.this, ChannelsActivity.class);
            	startActivity(i);
            }
        });
        
        buttonTextInput = (Button) findViewById(R.id.button_text_input);
        buttonTextInput.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	SendTextDialog dialog = new SendTextDialog(RokuActivity.this);
            	dialog.show();
            }
        });
        
        buttonSearch = (Button) findViewById(R.id.button_search);
        buttonSearch.setTag(R.id.key_type, Key.SEARCH);
        buttonSearch.setOnClickListener(new RemoteButtonListener());
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