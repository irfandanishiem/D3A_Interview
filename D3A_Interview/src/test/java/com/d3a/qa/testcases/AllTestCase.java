package com.d3a.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.d3a.qa.base.D3A_Base;
import com.d3a.qa.pages.D3A_Home_Actions;
import com.d3a.qa.pages.D3A_Login_Actions;
import com.d3a.qa.pages.D3A_Project_Actions;
import com.d3a.qa.pages.D3A_Simulations_Actions;

public class AllTestCase extends D3A_Base {
	
	D3A_Login_Actions la=new D3A_Login_Actions();
	D3A_Home_Actions ha=new D3A_Home_Actions();
	D3A_Project_Actions pa=new D3A_Project_Actions();
	D3A_Simulations_Actions sa=new D3A_Simulations_Actions();

	public AllTestCase() throws IOException {
		super();
	}
	
	@BeforeClass
	public void start() throws IOException
	{
		initialization();
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	@Test
	public void TC01()
	{
		la.clickLoginTab();
		la.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		la.clickLoginBtn();
		String s=ha.getHome_Title();
		Assert.assertEquals(s, "Home","The Home title is not displayed correctly");
	}
	@Test(dependsOnMethods = {"TC01"} )
	public void TC02() throws IOException
	{
		ha.clickProjects_Tab();
		ha.clickNewProjects_Btn();
		pa.enterProject_Name();
		pa.enterProject_Desc();
		pa.clickAdd_Btn();
		pa.clickHeader();
		String s=pa.getProjectName();
		Assert.assertEquals(s,pa.projectname);
	}
	@Test(dependsOnMethods = {"TC02"})
	public void TC03() throws IOException
	{
		boolean val=sa.newSimulationBtn_isDisplayed();
		Assert.assertTrue(val,"The new simulation button is not displayed");
		sa.clickSimulation_Btn();
		sa.clickNext();
		sa.moveToProjects();
		String simulationName=sa.getSimulationName();
		Assert.assertEquals(simulationName,"default simulation","The simulation name has appeared incorrectly");
	}
}
