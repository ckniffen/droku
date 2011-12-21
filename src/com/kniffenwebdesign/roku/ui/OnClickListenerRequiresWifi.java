package com.kniffenwebdesign.roku.ui;

import com.kniffenwebdesign.roku.R;
import com.kniffenwebdesign.roku.RokuApplication;
import com.kniffenwebdesign.roku.ui.main.RokuActivity;

import android.view.View;
import android.widget.Toast;

abstract public class OnClickListenerRequiresWifi implements
		View.OnClickListener {
	public void onClick(View view) {
		RokuActivity activity = (RokuActivity) view.getContext();
		RokuApplication application = (RokuApplication) activity
				.getApplication();
		if (application.isConnected()) {
			onClickHandler(view);
		} else {
			Toast toast = Toast.makeText(application,
					R.string.wifi_disabled_message, Toast.LENGTH_LONG);
			toast.show();
		}
	}

	abstract protected void onClickHandler(View view);
}
