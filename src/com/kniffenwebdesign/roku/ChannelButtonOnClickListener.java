package com.kniffenwebdesign.roku;

import android.content.Intent;
import android.view.View;

public class ChannelButtonOnClickListener extends OnClickListenerRequiresWifi {
	public void onClickHandler(View view) {
		RokuActivity rokuActivity = (RokuActivity) view.getContext();
        Intent i = new Intent(rokuActivity, ChannelsActivity.class);
        view.getContext().startActivity(i);
	}
}
