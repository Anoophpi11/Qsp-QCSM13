package deom.actiTimeGenericUnits;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {

	public String getPropertyData(String filepath,String key)
	{
		try {
			FileInputStream file=new FileInputStream(filepath);
			Properties property=new Properties();
			property.load(file);
			return property.getProperty(key);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
