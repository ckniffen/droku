package com.kniffenwebdesign.roku.ecp;

import java.util.ArrayList;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EcpClient {
	private static final String LOG_TAG = "EcpClient";
	private static final EcpClient instance = new EcpClient();

	protected String ipAddress = "";
	protected int port = 8060;

	// Private constructor prevents instantiation from other classes
	private EcpClient() {

	}

	public static EcpClient getInstance() {
		return instance;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getBaseUrl(){
		return "http://" + this.ipAddress + ":" + this.port;
	}
	public String executeAction(String action) {
		String url = this.getBaseUrl() + "/" + action;
		Log.d(LOG_TAG, url);

		return HttpUtil.request(url, "POST");
	}

	public void keyPress(String key) {
		executeAction("keypress/" + key);
	}

	public void keyUp(String key) {
		executeAction("keyup/" + key);
	}

	public void keyDown(String key) {
		executeAction("keydown/" + key);
	}

	public void sendCharacter(char character) {
		executeAction("keypress/Lit_" + character);
	}
	

	public void sendString(String string) {
		for (int i = 0; i < string.length(); i++) {
			sendCharacter(string.charAt(i));
		}
	}
	
	public void launchChannel(Integer channelId){
		this.executeAction("/launch/" + channelId);
	}
	
	public String getChannelIconUrl(Integer id){
		return this.getBaseUrl() + "/query/icon/" + id;
	}
	
	public ArrayList<Channel> getChannels(){	
		String url = this.getBaseUrl() + "/query/apps";
		Log.d(LOG_TAG, url);

		String responseText = HttpUtil.request(url, "GET");
		
		Document doc = Jsoup.parse(responseText);
		Elements apps = doc.select("app");
		
		ArrayList<Channel> channels = new ArrayList<Channel>();
		for (Element app : apps) {
			Channel channel = new Channel();
			
			String idString = app.attr("id");
			Integer id = Integer.parseInt(idString);
			String version = app.attr("version");
			String name = app.text();
			
			channel.setId(id);
			channel.setVersion(version);
			channel.setName(name);
			channel.loadBitmap();
			channels.add(channel);
		}

		return channels;
	}
}