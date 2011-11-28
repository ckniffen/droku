package com.kniffenwebdesign.roku.ecp;

public class Channel {
	Integer id = null;
	String imageSrc = null;
	String version = null;
	String name = null;
	
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
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
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
