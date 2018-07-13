package com.qait.automation.MyProject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
public class RemoteDriver 
{
	
	// the remote system just have to download the selenium server jar then open terminal

		   public static void main(String[] args)
		   
		   {
			      DesiredCapabilities capabilities =  new DesiredCapabilities();
			      capabilities.setBrowserName("chrome");
			      RemoteWebDriver remoteWD = null;
			      try
			      {
			         remoteWD = new RemoteWebDriver(new URL("http://10.0.36.99:4444/wd/hub"),capabilities);
			      } 	catch (MalformedURLException e) 
			      {
			    	  e.printStackTrace();
			      }
			      	remoteWD.get("http://www.google.com");
		   }		
}

