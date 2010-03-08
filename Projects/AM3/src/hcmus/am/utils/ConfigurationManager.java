package hcmus.am.utils;

import java.util.ResourceBundle;

public class ConfigurationManager {
private static ResourceBundle resBun = ResourceBundle.getBundle("config");
    
    public static String getPropertiesValue(final String keyValue) {
    	String value = null;
    	try{
    		value = resBun.getString(keyValue);
    	} catch (Exception ex) {
    		
    	}
    	return value;
    }
    public static String getDriverName()
    {
    	String driverName = resBun.getString("DATABASE_DRIVER");
    	return driverName; 
    }
    public static String getConnectionURL()
    {
    	String url = resBun.getString("CONNECTION_URL");
    	return url;
    }    
}
