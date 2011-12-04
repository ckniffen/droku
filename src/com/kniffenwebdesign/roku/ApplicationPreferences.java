package com.kniffenwebdesign.roku;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ApplicationPreferences {
	private static final String LOG_TAG = "ApplicationPreferences";
	private Context context;
	// Private constructor prevents instantiation from other classes
	public ApplicationPreferences(Context context) {
		this.context = context;
	}

	public String getIpAddress(){
		return getPrefsManager().getString("ip_address", "0.0.0.0");
	}
	
	public SharedPreferences getPrefsManager(){
		return PreferenceManager.getDefaultSharedPreferences(context);
	}
}
