package com.kniffenwebdesign.roku.ui.main;

import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;

import com.kniffenwebdesign.roku.EcpAsyncTask;
import com.kniffenwebdesign.roku.R;

import com.kniffenwebdesign.roku.ecp.Key;
import com.kniffenwebdesign.roku.ui.OnClickListenerRequiresWifi;

public class RemoteButtonListener extends OnClickListenerRequiresWifi {
	public void onClickHandler(View view) {
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
