package com.ian.xlate;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.apache.commons.lang3.StringEscapeUtils;

public class Text {
	String text;
	char[] textarray;
	int[] integerData;
	byte[] byteData;
	
	public Text(String something, int type){
		/*
		 * type :
		 * 1. text
		 * 2. binary
		 * 3. octal
		 * 4. decimal
		 * 5. hexadecimal
		 * 6. base32
		 * 7. base64
		 * 8. ASCII85
		 */
		
		if(type == 1){
			this.text = something;
			this.textarray = something.toCharArray();
			ByteBuffer bb = Charset.forName("UTF-8").encode(CharBuffer.wrap(something.toCharArray()));
			byteData = new byte[bb.remaining()];
			//bb.get(b);
		}
	}
	
	String toText(){
		CharBuffer temp;
		temp = Charset.forName("UTF-8").decode(ByteBuffer.wrap(byteData));
		return temp.toString();
	}
	
	String toHexa(){
		String temp;
		temp = StringEscapeUtils.escapeJava(text);
		return temp;
	}
}
