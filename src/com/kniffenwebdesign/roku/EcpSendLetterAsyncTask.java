package com.kniffenwebdesign.roku;

import android.os.AsyncTask;

import com.kniffenwebdesign.roku.ecp.EcpClient;

public class EcpSendLetterAsyncTask extends AsyncTask<Character, Integer, Boolean> {
	@Override
	protected Boolean doInBackground(Character... characters) {
		for (char character : characters) {
			EcpClient.getInstance().sendCharacter(character);
		}
		return true;
	}
}
