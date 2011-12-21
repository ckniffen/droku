package com.kniffenwebdesign.roku.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.kniffenwebdesign.roku.R;
import com.kniffenwebdesign.roku.ecp.Channel;
import com.kniffenwebdesign.roku.ecp.EcpClient;

public class ChannelAdapter extends ArrayAdapter<Channel> {
	private ArrayList<Channel> items;

	public ChannelAdapter(Context context, int textViewResourceId,
			ArrayList<Channel> items) {
		super(context, textViewResourceId, items);
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			LayoutInflater vi = (LayoutInflater) this.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			view = vi.inflate(R.layout.channel_list_item, null);
		}
		final Channel channel = items.get(position);
		if (channel != null) {
			ImageView channelIcon = (ImageView) view
					.findViewById(R.id.channel_icon);

			channelIcon.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					EcpClient.getInstance().launchChannel(channel.getId());
					Activity activity = (Activity) getContext();
					activity.finish();
				}
			});

			Bitmap bitmap = channel.getIconBitmap();
			channelIcon.setImageBitmap(bitmap);
		}
		return view;
	}
}
