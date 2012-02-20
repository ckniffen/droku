package com.kniffenwebdesign.ssdp;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {

    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean moreQuotes = true;

    public ServerThread() throws IOException {
    	this("QuoteServerThread");
    }

    public ServerThread(String name) throws IOException {
        super(name);
        socket = new DatagramSocket(4445);

        try {
            in = new BufferedReader(new FileReader("one-liners.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Could not open quote file. Serving time instead.");
        }
    }
}
