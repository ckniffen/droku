package com.kniffenwebdesign.roku;

import com.kniffenwebdesign.roku.ecp.Key;

import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

public class RemoteOnKeyListener implements OnKeyListener, KeyListener {
	public static String LOG_TAG = "RemoteOnKeyListener";
	
	public boolean onKey(View v, int keyCode, KeyEvent event){
		
		if (KeyEvent.ACTION_UP == event.getAction()) {
			boolean isCharacter = true;
			
			if(KeyEvent.isModifierKey(keyCode) 
				|| KeyEvent.KEYCODE_ENTER == keyCode
				|| KeyEvent.KEYCODE_BACK == keyCode
				|| KeyEvent.KEYCODE_CALL == keyCode
				|| KeyEvent.KEYCODE_CAMERA == keyCode
				|| KeyEvent.KEYCODE_ENDCALL == keyCode
				|| KeyEvent.KEYCODE_VOLUME_DOWN == keyCode
				|| KeyEvent.KEYCODE_VOLUME_UP == keyCode
				|| KeyEvent.KEYCODE_SEARCH == keyCode
				|| KeyEvent.KEYCODE_NOTIFICATION == keyCode
				|| KeyEvent.KEYCODE_HOME == keyCode
				|| KeyEvent.KEYCODE_ENVELOPE == keyCode
				|| KeyEvent.KEYCODE_UNKNOWN == keyCode
				|| KeyEvent.KEYCODE_MENU == keyCode){
				isCharacter = false;
			}
			
			if(KeyEvent.KEYCODE_DEL == keyCode){
				isCharacter = false;
		   	 	new EcpAsyncTask().execute(Key.BACKSPACE);
				Log.d(LOG_TAG, "Press key: Go Back");
			}
			
			if(KeyEvent.KEYCODE_SPACE == keyCode){
				isCharacter = false;
				new EcpSendLetterAsyncTask().execute(new Character(' '));
				Log.d(LOG_TAG, "Press key: Space");
			}
			
			if(isCharacter){
				char character = Character.toChars(event.getUnicodeChar())[0];
				new EcpSendLetterAsyncTask().execute(new Character(character));
				Log.d(LOG_TAG, "Press key: " + character);
			}
		}
		
		return false;
	}

	public int getInputType() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean onKeyDown(View view, Editable text, int keyCode,
			KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onKeyUp(View view, Editable text, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onKeyOther(View view, Editable text, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clearMetaKeyState(View view, Editable content, int states) {
		// TODO Auto-generated method stub
		
	}
}
