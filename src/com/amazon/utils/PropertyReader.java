package com.amazon.utils;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	static Properties propConfig=new Properties();
	static Properties propObjetRepo=new Properties();
	
		
	public static void loadPropertyFiles()
	{
		try
		{		
			propConfig.load(new FileInputStream("C:\\Users\\Dell\\Desktop\\appiumDemo\\src\\com\\amazon\\ObjectRepo\\configuration.properties"));
			propObjetRepo.load(new FileInputStream("C:\\Users\\Dell\\Desktop\\appiumDemo\\src\\com\\amazon\\ObjectRepo\\AndroidObjectRepo.Properties"));
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static  String getConfigProperty(String property)
	{
		return propConfig.getProperty(property);
	}
	
	public static String getObject(String property)
	
	{
		return propObjetRepo.getProperty(property);
	}

}




