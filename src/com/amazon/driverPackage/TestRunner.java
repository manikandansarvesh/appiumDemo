package com.amazon.driverPackage;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.amazon.utils.ConstantClass;
import com.amazon.utils.ExcelUtils;
import com.amazon.utils.PropertyReader;

public class TestRunner extends PropertyReader {
String Udata;
	
	DesiredCapabilities mobileCapablities = new DesiredCapabilities();
	public static AppiumDriver <MobileElement>nativeDriver = null;
	
	public void initializeDriver() throws MalformedURLException{	
      
		mobileCapablities.setCapability(ConstantClass.App_Package, getConfigProperty("appPackage"));
    	mobileCapablities.setCapability(ConstantClass.App_Activity, getConfigProperty("appActivity"));
    	mobileCapablities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getConfigProperty("PlatformVersion"));
    	mobileCapablities.setCapability(MobileCapabilityType.PLATFORM_NAME, getConfigProperty("PlatformName"));   
    	mobileCapablities.setCapability(MobileCapabilityType.UDID, getConfigProperty("DeviceUDID"));
    	mobileCapablities.setCapability(MobileCapabilityType.DEVICE_NAME, getConfigProperty("DeviceName"));
    	mobileCapablities.setCapability(MobileCapabilityType.AUTOMATION_NAME,getConfigProperty("automationName"));
    	
    	nativeDriver=new AndroidDriver<MobileElement>(new URL(ConstantClass.Address_Port),mobileCapablities);
       nativeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
	}
	
	public String getTestData(String Uname, String TCID){
		System.out.println("Entered into Fetch Method");
		ExcelUtils readr=new ExcelUtils();
		System.out.println("Excel Object Created");
      
		int ColumnIndex = readr.readHeaderIndex("C:\\Users\\Dell\\Desktop\\appiumDemo\\MasterTestData.xlsx","Data", Uname);
		Udata=readr.readXLatIndex("C:\\Users\\Dell\\Desktop\\appiumDemo\\MasterTestData.xlsx","Data",TCID,ColumnIndex);
		return Udata;	
		
		
	}
	
	@BeforeClass
	public void  preconfig()
	{
	PropertyReader.loadPropertyFiles();	

		}
	@BeforeMethod
	public  void  SetUp(){			
			try {
				initializeDriver();
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
	

	@AfterMethod
	public void terminate()
	{

		nativeDriver.quit();
	}
}




