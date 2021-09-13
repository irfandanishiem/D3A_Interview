package com.d3a.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class D3A_Base {
	public static WebDriver driver;
	public static Properties prop;
	
	public D3A_Base() throws IOException {
		prop=new Properties();
		FileInputStream fp=new FileInputStream("./src\\main\\java\\com\\d3a\\qa\\config\\Config.properties");
		prop.load(fp);
	}
	
	public static void initialization() throws IOException {
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
