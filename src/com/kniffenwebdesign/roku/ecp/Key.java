package com.kniffenwebdesign.roku.ecp;

public enum Key {
	HOME ("Home"),
	BACK ("Back"),
	SELECT ("Select"), // On Remote is labeled OK
	ENTER ("Enter"),
	INFO ("Info"),
	SEARCH ("Search"),
	
	REVERSE ("Rev"), 
	FORWARD ("Fwd"),
	PLAY ("Play"),
	
	LEFT ("Left"),
	RIGHT ("Right"),
	UP ("Up"),
	DOWN ("Down"),
	
	BACKSPACE ("Backspace");
	
	private final String keyCode;
	
	Key(String keyCode) {
		this.keyCode = keyCode;
	}
	
	public String getKeyCode(){
		return this.keyCode;
	}
	
	public void keyPress(){
		EcpClient.getInstance().keyPress(this.keyCode);
	}
	
	public void keyDown(){
		EcpClient.getInstance().keyDown(this.keyCode);
	}
	
	public void keyUp(){
		EcpClient.getInstance().keyUp(this.keyCode);
	}
}
