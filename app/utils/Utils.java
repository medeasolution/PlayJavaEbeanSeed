package utils;

import com.ning.http.util.Base64;
import play.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Utils {

	public static long timeToDays(long time) {
		
		return time / 1000 / 60 / 24;
	}
	 
    public static String encode(String data)
    {
    	byte[] byteData = data.getBytes();
        return Base64.encode(byteData);
    }
    
    public static String decode(String data)
    {
    	String decode = null;
    	byte[] bytes = Base64.decode(data);
    	try {
			decode = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			Logger.error("Utils,decode", e);
		}
        return decode;
    }    
    
    public static String computeSHAHash(String password)
    {
        MessageDigest mdSha1 = null;
        String SHAHash = "";
        try
        {
            mdSha1 = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e1) {
            Logger.info("myapp", "Error initializing SHA1 message digest");
        }
        try {
            mdSha1.update(password.getBytes());
        } catch (Exception e) {
            
            Logger.error("Utils, computeSHAHash", e);
        }
        byte[] data = mdSha1.digest();
        try {
            SHAHash=byteArrayToHexString(data);
        } catch (Exception e) {
            Logger.error("Utils,computeSHAHash", e);
        }
        return SHAHash;
    }
    
    public static String byteArrayToHexString(byte[] b) {
	    String result = "";
	    for (int i = 0; i < b.length; i++) {
	        result += Integer.toString((b[i] & 0xff) + 0x100, 16)
	                .substring(1);
	    }
	    return result;
    }
}
