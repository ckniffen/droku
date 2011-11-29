package com.kniffenwebdesign.roku;

import java.util.ArrayList;

import com.kniffenwebdesign.roku.ecp.Channel;
import com.kniffenwebdesign.roku.ecp.EcpClient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ChannelsActivity extends Activity{
	private ListView lv1;
	
	@Override
	public void onCreate(Bundle icicle)
	{
		super.onCreate(icicle);
		setContentView(R.layout.channels);
		EcpClient.getInstance().setIpAddress("192.168.1.109");
		ArrayList<Channel> channels = EcpClient.getInstance().getChannels();
		lv1 = (ListView)findViewById(R.id.ListView01);
		// By using setAdpater method in listview we an add string array in list.
		lv1.setAdapter(new ChannelAdapter(this, R.layout.channel_list_item, channels));
	}
}