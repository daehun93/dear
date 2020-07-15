package com.hun.dear.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES128 {
	// key 사이즈는 반드시 128bit이어야만 한다!
	static final byte key[] = 
	{
	  // 01   02   03   04   05   06   07  08
		'S', 'S', 'A', 'F', 'Y', '2', 'n', 'd',  // 1
		'S', 'S', 'A', 'F', 'Y', '2', 'n', 'd'   // 2
	}; 
	
	public static String encrypt(String message)throws Exception{
	    if(message ==null){
	        return null;
	    }else{
	        SecretKeySpec secretKeySpec =new SecretKeySpec(key, "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
	         
	        byte[] encrypted = cipher.doFinal(message.getBytes());
	         
	        return byteArrayToHex(encrypted);
	    }
	}
	 
	private static String byteArrayToHex(byte[] encrypted) {
	     
	    if(encrypted ==null || encrypted.length ==0){
	        return null;
	    }
	     
	    StringBuffer sb =new StringBuffer(encrypted.length *2);
	    String hexNumber;
	     
	    for(int x=0; x<encrypted.length; x++){
	        hexNumber ="0" + Integer.toHexString(0xff & encrypted[x]);
	        sb.append(hexNumber.substring(hexNumber.length() -2));
	    }
	     
	    return sb.toString();
	}
	
	public static String decrypt(String encrypted)throws Exception{
	     
	    if(encrypted ==null){
	        return null;
	    }else{
	        SecretKeySpec secretKeySpec =new SecretKeySpec(key,"AES");
	         
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
	         
	        byte[] original = cipher.doFinal(hexToByteArray(encrypted));
	         
	        String originalStr =new String(original);
	         
	        return originalStr;
	    }
	}
	  
	private static byte[] hexToByteArray(String hex) {
	     
	    if(hex ==null || hex.length() ==0){
	        return null;
	    }
	     
	    //16진수 문자열을 byte로 변환
	    byte[] byteArray =new byte[hex.length() /2 ];
	     
	    for(int i=0; i<byteArray.length; i++){
	        byteArray[i] = (byte) Integer.parseInt(hex.substring(2 * i,2*i+2),16);
	    }
	    return byteArray;
	}
}
