package com.kniffenwebdesign.roku;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;

import com.kniffenwebdesign.roku.ecp.Key;

public class RemoteButtonListener implements View.OnClickListener, View.OnTouchListener {
	public void onClick(View view) {
		Vibrator vibrator = (Vibrator) view.getContext().getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(50);
		
		Key key = (Key) view.getTag(R.id.key_type);
   	 	new EcpAsyncTask().execute(key);
	}

	public boolean onTouch(View view, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
