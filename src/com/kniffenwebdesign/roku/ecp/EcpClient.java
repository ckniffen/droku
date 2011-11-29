package com.kniffenwebdesign.roku.ecp;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.util.Log;

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
		executeAction("keydown/Lit_" + character);
	}
	

	public void sendString(String string) {
		for (int i = 0; i < string.length() - 1; i++) {
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
		String responseText = HttpUtil.request(url, "GET");
		
		try {
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			
			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			ChannelParser channelXmlHandler = new ChannelParser();
			
			ByteArrayInputStream inputStream = new ByteArrayInputStream(responseText.getBytes());
			
			xr.setContentHandler(channelXmlHandler);
			xr.parse(new InputSource( inputStream ));
		} catch (Exception e) {
			Log.e(LOG_TAG, "XML Pasing Excpetion", e);
		}

		/** Get result from MyXMLHandler SitlesList Object */
		return ChannelParser.channelList;
	}
}