package com.ian.xlate;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {	
	Text text;
	EditText editor;
	int type = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editor = (EditText) this.findViewById(R.id.textBox);
        editor.addTextChangedListener(new TextWatcher(){
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if(type == 1){
					text = new Text(editor.getText().toString(),1);
					Toast.makeText(getApplicationContext(), text.toText(), Toast.LENGTH_LONG).show();
				}
			}
			@Override
			public void afterTextChanged(Editable s) {				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}        	
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /*
     * onClick methods
     */
    
    void dataText(){
    	//text = new Text(editor.getText().toString(),1);
    	type = 1;
    	//editor.setText(text.)
    }
    
    void dataHexa(){
    	
    }
}
