package com.kniffenwebdesign.roku;

import com.kniffenwebdesign.roku.ecp.EcpClient;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
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
		input = new EditText(this.getContext());
		setView(input);

		setCancelable(true);
		setCanceledOnTouchOutside(true);
		
		setOnShowListener(new DialogOnShowListener());
		
		DialogOnClickListener clickListener =  new DialogOnClickListener();
		setButton(this.getContext().getText(R.string.button_ok), clickListener);
		setButton2(this.getContext().getText(R.string.button_cancel), clickListener);
		
		super.onCreate(savedInstanceState);
	}
	
	class DialogOnClickListener implements DialogInterface.OnClickListener {
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
	
	class DialogOnShowListener implements DialogInterface.OnShowListener {
		public void onShow(DialogInterface dialog) {
	        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
	        imm.showSoftInput(input, InputMethodManager.SHOW_IMPLICIT);
	    }
	}
}
