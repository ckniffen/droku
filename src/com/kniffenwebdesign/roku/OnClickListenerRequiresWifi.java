package com.kniffenwebdesign.roku;

import android.view.View;
import android.widget.Toast;

abstract public class OnClickListenerRequiresWifi implements View.OnClickListener{	
	public void onClick(View view) {
		RokuActivity activity = (RokuActivity) view.getContext();
		RokuApplication application = (RokuApplication) activity.getApplication();
		if(application.isConnected()){
			onClickHandler(view);
		} else {
			Toast toast = Toast.makeText(application, R.string.wifi_disabled_message, Toast.LENGTH_LONG);
			toast.show();
		}
	}
	
	abstract protected void onClickHandler(View view);
}
