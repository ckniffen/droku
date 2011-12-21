package com.kniffenwebdesign.roku.ui;

import com.kniffenwebdesign.roku.R;
import com.kniffenwebdesign.roku.ecp.EcpClient;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;

public class PreferencesActivity extends PreferenceActivity {
	EditTextPreference ipAddressPreference;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		ipAddressPreference = (EditTextPreference) getPreferenceScreen()
				.getPreference(0);

		OnIpAddressPreferenceChangeListener onIpAddressChangeListener = new OnIpAddressPreferenceChangeListener();
		ipAddressPreference.setOnPreferenceChangeListener(onIpAddressChangeListener);
	}

	class OnIpAddressPreferenceChangeListener implements
			OnPreferenceChangeListener {
		public boolean onPreferenceChange(Preference preference, Object newValue) {
			String ipAddress = (String) newValue;
			EcpClient.getInstance().setIpAddress(ipAddress);
			return true;
		}

	}
}