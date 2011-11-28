package com.kniffenwebdesign.roku.ecp;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ChannelParser extends DefaultHandler {

	Boolean currentElement = false;
	String currentValue = null;
	public static ArrayList<String> channelList = null;

	public static ArrayList<String> getSitesList() {
		return channelList;
	}

	public static void setSitesList(ArrayList<String> aChannelList) {
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
			channelList = new ArrayList<String>();
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
			channelList.add(currentValue);
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
