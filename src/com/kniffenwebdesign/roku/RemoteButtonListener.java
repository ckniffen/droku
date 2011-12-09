package com.kniffenwebdesign.roku;

import android.view.MotionEvent;
import android.view.View;

import com.kniffenwebdesign.roku.ecp.Key;

public class RemoteButtonListener implements View.OnClickListener, View.OnTouchListener {
	public void onClick(View v) {
		Key key = (Key) v.getTag(R.id.key_type);
   	 	new EcpAsyncTask().execute(key);
	}

	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
