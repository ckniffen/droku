package com.kniffenwebdesign.roku;

import java.util.ArrayList;

import com.kniffenwebdesign.roku.ecp.EcpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class ChannelsActivity extends Activity{
	private ListView lv1;
	private String lv_arr[] ={ "Android", "iPhone", "BlackBerry", "AndroidPeople"};
	
	@Override
	public void onCreate(Bundle icicle)
	{
		super.onCreate(icicle);
		setContentView(R.layout.channels);
		EcpClient.getInstance().setIpAddress("192.168.1.109");
		ArrayList<String> channels = EcpClient.getInstance().getChannels();
		lv1 = (ListView)findViewById(R.id.ListView01);
		// By using setAdpater method in listview we an add string array in list.
		lv1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, channels));
	}
}