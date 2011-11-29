package com.kniffenwebdesign.roku.ecp;

public class Channel {
	Integer id = null;
	String version = null;
	String name = null;
	
	
	public Channel() {
	
	}
	
	public Channel(Integer id, String version, String name) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageSrc() {
		return EcpClient.getInstance().getChannelIconUrl(this.id);
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
