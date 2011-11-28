package com.kniffenwebdesign.roku.ecp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.net.ParseException;
import android.net.http.AndroidHttpClient;
import android.util.Log;

public class EcpClient {
	private static final String TAG = "EcpClient";
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

	public String executeRequest(String action) {
		HttpClient client = new DefaultHttpClient();
		String uri = "http://" + this.ipAddress + ":" + this.port + "/"
				+ action;
		Log.v(TAG, uri);
		HttpUriRequest request = new HttpPost(uri);

		String responseText = null;
		try {
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			responseText = _getResponseBody(entity);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseText;
	}

	public void keyPress(String key) {
		executeRequest("keypress/" + key);
	}

	public void keyUp(String key) {
		executeRequest("keyup/" + key);
	}

	public void keyDown(String key) {
		executeRequest("keydown/" + key);
	}

	public void sendCharacter(char character) {
		executeRequest("keydown/Lit_" + character);
	}

	public void sendString(String string) {
		for (int i = 0; i < string.length() - 1; i++) {
			sendCharacter(string.charAt(i));
		}
	}

	public ArrayList<String> getChannels(){
		
		HttpClient client = new DefaultHttpClient();
		String uri = "http://" + this.ipAddress + ":" + this.port + "/query/apps";
		Log.v(TAG, uri);
		HttpUriRequest request = new HttpGet(uri);

		String responseText = null;
		try {
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			responseText = _getResponseBody(entity);
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
			System.out.println("XML Pasing Excpetion = " + e);
		}

		/** Get result from MyXMLHandler SitlesList Object */
		return ChannelParser.channelList;
	}

	public String _getResponseBody(final HttpEntity entity)
			throws IOException, ParseException {

		if (entity == null) {
			throw new IllegalArgumentException("HTTP entity may not be null");
		}

		InputStream instream = entity.getContent();

		if (instream == null) {
			return "";
		}

		if (entity.getContentLength() > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(

			"HTTP entity too large to be buffered in memory");
		}

		String charset = getContentCharSet(entity);

		if (charset == null) {
			charset = HTTP.DEFAULT_CONTENT_CHARSET;
		}

		Reader reader = new InputStreamReader(instream, charset);
		StringBuilder buffer = new StringBuilder();

		try {
			char[] tmp = new char[1024];

			int l;

			while ((l = reader.read(tmp)) != -1) {
				buffer.append(tmp, 0, l);
			}
		} finally {
			reader.close();
		}
		return buffer.toString();
	}

	public String getContentCharSet(final HttpEntity entity)
			throws ParseException {

		if (entity == null) {
			throw new IllegalArgumentException("HTTP entity may not be null");
		}

		String charset = null;

		if (entity.getContentType() != null) {

			HeaderElement values[] = entity.getContentType().getElements();

			if (values.length > 0) {
				NameValuePair param = values[0].getParameterByName("charset");
				if (param != null) {
					charset = param.getValue();
				}
			}
		}
		return charset;
	}

	public String getResponseBody(HttpResponse response) {
		String response_text = null;
		HttpEntity entity = null;
		try {
			entity = response.getEntity();
			response_text = _getResponseBody(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			if (entity != null) {
				try {
					entity.consumeContent();
				} catch (IOException e1) {

				}
			}
		}
		return response_text;
	}

}