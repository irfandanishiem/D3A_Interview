package com.d3a.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.d3a.qa.base.D3A_Base;
import com.d3a.qa.uimap.D3A_Simulations_Locators;

public class D3A_Simulations_Actions extends D3A_Base {
	
	D3A_Project_Actions pa=new D3A_Project_Actions();

	public D3A_Simulations_Actions() throws IOException {
		super();
	}
	public boolean newSimulationBtn_isDisplayed()
	{
		boolean newSimulationDisplayValue=driver.findElement(By.xpath(D3A_Simulations_Locators.newSimulation_Btn)).isDisplayed();
		return newSimulationDisplayValue;
	}
	
	public void clickSimulation_Btn()
	{
		driver.findElement(By.xpath(D3A_Simulations_Locators.newSimulation_Btn)).click();
	}
	public void clickNext()
	{
		WebElement simulationnext=driver.findElement(By.xpath(D3A_Simulations_Locators.simulationNext_Btn));
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(simulationnext));
		simulationnext.click();
	} 
	public void moveToProjects() throws IOException
	{
		driver.get("https://www.d3a.io/projects");
		pa.clickHeader();
	}
	public String getSimulationName()
	{
		WebElement simulationname=driver.findElement(By.xpath(D3A_Simulations_Locators.simulationName_Title));
		String s=simulationname.getText();
		return s;
	}

}
