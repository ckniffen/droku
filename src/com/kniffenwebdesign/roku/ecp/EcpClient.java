package com.kniffenwebdesign.roku.ecp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
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
	
	public String getChannelIconUrl(Integer id){
		return this.getBaseUrl() + "/query/icon/" + id;
	}
	
	public ArrayList<Channel> getChannels(){	
		HttpClient client = new DefaultHttpClient();
		String uri = this.getBaseUrl() + "/query/apps";
		Log.d(LOG_TAG, uri);
		HttpUriRequest request = new HttpGet(uri);

		String responseText = null;
		try {
			HttpResponse response = client.execute(request);
			responseText = HttpUtil.getResponseBody(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			/** Handling XML */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			
			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
			ChannelParser myXMLHandler = new ChannelParser();
			
			ByteArrayInputStream inputStream = new ByteArrayInputStream(responseText.getBytes());
			
			xr.setContentHandler(myXMLHandler);
			xr.parse(new InputSource( inputStream ));

		} catch (Exception e) {
			Log.e(LOG_TAG, "XML Pasing Excpetion = ", e);
		}

		/** Get result from MyXMLHandler SitlesList Object */
		return ChannelParser.channelList;
	}
}