package com.kniffenwebdesign.roku.ecp;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ChannelParser extends DefaultHandler {

	Boolean currentElement = false;
	String currentValue = null;
	Channel currentChannel = null;
	public static ArrayList<Channel> channelList = null;

	public static ArrayList<Channel> getSitesList() {
		return channelList;
	}

	public static void setSitesList(ArrayList<Channel> aChannelList) {
		channelList = aChannelList;
	}

	/**
	 * Called when tag starts ( ex:- <name>AndroidPeople</name> -- <name> )
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		currentElement = true;

		if (localName.equals("apps")) {
			/** Start */
			channelList = new ArrayList<Channel>();
		}
		
		if (localName.equals("app")){
			Integer id = Integer.parseInt(attributes.getValue("id"));
			String version = attributes.getValue("version");
			
			currentChannel = new Channel();
			currentChannel.setId(id);
			currentChannel.setVersion(version);
		}
	}

	/**
	 * Called when tag closing ( ex:- <name>AndroidPeople</name> -- </name> )
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		currentElement = false;

		/** set value */
		if (localName.equals("app")) {
			currentChannel.setName(currentValue);
			channelList.add(currentChannel);
		}
	}

	/**
	 * Called to get tag characters ( ex:- <name>AndroidPeople</name> -- to get
	 * AndroidPeople Character )
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentElement) {
			currentValue = new String(ch, start, length);
			currentElement = false;
		}

	}

}
