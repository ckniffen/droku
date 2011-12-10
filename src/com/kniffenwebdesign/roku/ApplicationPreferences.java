package com.kniffenwebdesign.roku;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class ApplicationPreferences {
	private Context context;

	public static String IP_ADDRESS_PREFERENCE_KEY = "ip_address";
	
	// Private constructor prevents instantiation from other classes
	public ApplicationPreferences(Context context) {
		this.context = context;
	}

	public String getIpAddress(){
		return getPrefsManager().getString(IP_ADDRESS_PREFERENCE_KEY, "0.0.0.0");
	}
	
	public void setIpAddress(){
		Editor editor = getPrefsManager().edit();
		editor.putString(IP_ADDRESS_PREFERENCE_KEY, "0.0.0.0");
	}
	
	public SharedPreferences getPrefsManager(){
		return PreferenceManager.getDefaultSharedPreferences(context);
	}
}
