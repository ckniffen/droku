package com.kniffenwebdesign.roku;

import com.kniffenwebdesign.roku.ecp.EcpClient;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;

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
	
	public boolean isConnected(){
		boolean returnValue = false;

		WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		
		if(wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED){
			returnValue = true;
		}
		
		return returnValue;
	}

}
