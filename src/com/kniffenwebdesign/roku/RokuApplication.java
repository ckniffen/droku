package com.kniffenwebdesign.roku;

import com.kniffenwebdesign.roku.ecp.EcpClient;

import android.app.Application;

public class RokuApplication extends Application {
	protected ApplicationPreferences preferences;
	
	@Override
	public void onCreate(){
		preferences = new ApplicationPreferences(this);

        EcpClient.getInstance().setIpAddress(preferences.getIpAddress());
		super.onCreate();
	}
	
	public ApplicationPreferences getPreferences(){
		return this.preferences;
	}
}
