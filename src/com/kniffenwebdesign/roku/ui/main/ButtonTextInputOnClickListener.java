package com.kniffenwebdesign.roku.ui.main;


import com.kniffenwebdesign.roku.ui.OnClickListenerRequiresWifi;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ButtonTextInputOnClickListener extends OnClickListenerRequiresWifi{

	@Override
	protected void onClickHandler(View view) {
		Context baseContext = view.getContext();
    	InputMethodManager imm = (InputMethodManager) baseContext.getSystemService(Context.INPUT_METHOD_SERVICE);     	       
    	imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
	}
	
}
