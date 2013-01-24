package net.gordonator.xlate;

import java.math.BigInteger;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private State previousState = State.TEXT;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
 
    
    // this is totally broken ATM. I'm going to work on base conversions first, before dealing 
    //with converting to/from text. 
    public void convertText(View v)
    { 
    	if (previousState == State.TEXT) 
    		return;
    	
    	/* 
    	EditText box = (EditText)findViewById(R.id.textBox);
    	String oldContents = box.toString();

    	String newContents = ""; 
    	//need to add additional types here: 
    	//You should also create an enum in State to represenet the additional type. 
    	if (previousState == State.BINARY)
    	{ 
    		String decimal = new BigInteger(oldContents, 2).toString(10);
    		while (decimal.length() % 3 != 0) 
    			decimal = '0' + decimal; 
    		
    		for (int i = 0; i < decimal.length(); i += 3) 
    			newContents += (char)(Integer.parseInt(decimal.substring(i, i+3)));
    	} 
*/     	
    	previousState = State.TEXT; 
    	
   // 	box.setText(newContents); 
    	
    }
    
    public void convertBin(View v)
    { 
    	if (previousState == State.BINARY)
    		return; 
    	
    	EditText box = (EditText)findViewById(R.id.textBox); 
    	//box.setText("01000001"); //we know now we've got the right methods being called, etc. 
    	
    	String boxText = box.toString();
    	
    	String newText = ""; 
    	
    	if (previousState == State.TEXT)
    	{ 
    		newText = "This feature is not yet implemented. "; 
    	}
    	else if (previousState == State.DECIMAL)
    	{ 
    		newText = new BigInteger(boxText, 10).toString(2); 
    	}
    	else //this *SHOULD* never get executed. 
    		newText = "stop trying to break the rubber ducking program!";
    	
    	
    	box.setText(newText);     	
    	
    	previousState = State.BINARY; 
    	
    }
    
    public void convertDec(View v) 
    { 
    	if (previousState == State.DECIMAL)
    		return; 
    	
    	EditText box = (EditText)findViewById(R.id.textBox); 
    	
    	String boxText = box.toString(); 
    	
    	String newText = ""; 
    	
    	if (previousState == State.TEXT)
    		newText = "This feature is not yet implemented."; 
    	else if (previousState == State.BINARY)
    	{ 
    		newText = new BigInteger(boxText, 2).toString(10); 
    	}
    	else //this *SHOULD* never get executed. 
    		newText = "stop trying to break the rubber ducking program!";
    	
    	box.setText(newText); 

    		    	
    	previousState = State.DECIMAL; 
    	
    }
    
    
    
}
