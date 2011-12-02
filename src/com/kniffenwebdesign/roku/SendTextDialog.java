package com.kniffenwebdesign.roku;

import com.kniffenwebdesign.roku.ecp.EcpClient;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

public class SendTextDialog extends AlertDialog{
	EditText input;
		
	public SendTextDialog(Context context){
		super(context);
		
	}
	
	public EditText getEditText(){
		return input;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		//setContentView(R.layout.text_input2);
		input = new EditText(this.getContext());
		setView(input);
		SendTextDialogClickListener clickListener =  new SendTextDialogClickListener();
		setButton(this.getContext().getText(R.string.button_ok), clickListener);
		setButton2(this.getContext().getText(R.string.button_cancel), clickListener);
		
		super.onCreate(savedInstanceState);
	}
	
	class SendTextDialogClickListener implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
        	SendTextDialog sendTextDialog = (SendTextDialog) dialog;
        	switch(which){
        		case -1:
        			String str = sendTextDialog.getEditText().getText().toString();
                	EcpClient.getInstance().sendString(str);
        			break;
        		case -2:
        			break;
        	}
        }
    }
}
