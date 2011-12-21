package com.kniffenwebdesign.roku.ecp;

import android.graphics.Bitmap;

public class Channel {
	Integer id = null;
	String version = null;
	String name = null;
	Bitmap iconBitmap = null;
	
	public Channel() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageUrl() {
		return EcpClient.getInstance().getChannelIconUrl(this.id);
	}

	public Bitmap getIconBitmap(){
		return iconBitmap;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
