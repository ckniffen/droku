package com.kniffenwebdesign.roku;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.kniffenwebdesign.roku.ecp.Channel;

public class ChannelAdapter extends ArrayAdapter<Channel> {
	private ArrayList<Channel> items;

    public ChannelAdapter(Context context, int textViewResourceId, ArrayList<Channel> items) {
            super(context, textViewResourceId, items);
            this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.channel_list_item, null);
            }
            Channel channel = items.get(position);
            if (channel != null) {
        		ImageView channelIcon = (ImageView)v.findViewById(R.id.channel_icon);
        	    Drawable d;
				try {
					d = new BitmapDrawable(drawableFromUrl(channel.getImageSrc()));
	        		channelIcon.setImageDrawable(d);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            return v;
    }
    
    Bitmap drawableFromUrl(String url) throws java.net.MalformedURLException, java.io.IOException {
        Bitmap x;

        HttpURLConnection connection = (HttpURLConnection)new URL(url) .openConnection();

        connection.connect();
        InputStream input = connection.getInputStream();

        x = BitmapFactory.decodeStream(input);
        return x;
    }
}
