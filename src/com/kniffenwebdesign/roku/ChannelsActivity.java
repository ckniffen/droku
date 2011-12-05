package com.kniffenwebdesign.roku;

import java.util.ArrayList;

import com.kniffenwebdesign.roku.ecp.Channel;
import com.kniffenwebdesign.roku.ecp.EcpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.GridView;

public class ChannelsActivity extends Activity {
	private GridView gridViewChannels;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.channels);
		
		new LoadChannelsTask().execute("");
	}

	private class LoadChannelsTask extends AsyncTask<String, Integer, ArrayList<Channel>> {
		@Override
		protected ArrayList<Channel> doInBackground(String... voids) {
			ArrayList<Channel> channels = EcpClient.getInstance().getChannels();
			return channels;
		}
		
		@Override
		protected void onPostExecute(ArrayList<Channel> channels){
			gridViewChannels = (GridView) ChannelsActivity.this.findViewById(R.id.gridview_channels);
			gridViewChannels.setAdapter(new ChannelAdapter(ChannelsActivity.this, R.layout.channel_list_item, channels));
		}
	}
}