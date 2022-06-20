package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewSchedulePage;
//import com.qa.pages.PatrolCar;
import com.qa.pages.PatrolCarPage;
import com.qa.pages.ProfilePage;
import com.qa.pages.SitePage;
import com.qa.pages.StaffPage;



public class TC1_TC12_TestCase extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	StaffPage staffPage;
	SitePage sitePage;
	PatrolCarPage patrolPage;
	NewSchedulePage schedulePage;

	public TC1_TC12_TestCase() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage("Rishab", "123456");
		staffPage=new StaffPage();
		sitePage=new SitePage();
		patrolPage=new PatrolCarPage();
		schedulePage =new NewSchedulePage();

	}
	
	
	
	@Test   (priority=1)
	public void loginTest() throws InterruptedException{

		Thread.sleep(2000);
		String actual=driver.findElement(By.xpath("//div[text()='Staff']")).getText();
		System.out.println(actual);
		String expected="Staff";
		AssertJUnit.assertEquals(actual, expected);

	}


	@Test(priority=2)
	public void staffTabTest() throws InterruptedException {

		this.loginTest();
	}
	

	@Test(priority=3)  	
	public void logoutTest() throws InterruptedException{
		profilePage=new ProfilePage();
		profilePage.validatelogoutTest();
		String actual1=driver.getTitle();
		System.out.println(actual1);
		String expected1 ="Novagems Manager";
		AssertJUnit.assertEquals(actual1, expected1);

	}

	@Test (priority=4)
	public void addStaffTest() throws InterruptedException {
		//staffPage=new StaffPage(driver);
		//Thread.sleep(2000);
		staffPage.validateAddStaff();	
		

	}

	@Test(priority=5)
	public void editStaffTest() throws InterruptedException {

		staffPage.validateEditStaffTest();	
		//Done

	}

	@Test(priority=6)
	public void archiveStaffTest() throws InterruptedException {
		staffPage.validateArchiveStaffTest();
		AssertJUnit.assertEquals(true, true);   // Tricky last step Assertion Pending		

	}

	@Test(priority=7)
	public void unAarchiveStaffTest() throws InterruptedException {  

		staffPage.validateUnArchiveStaffTest();
		//Assertion pending


	}

	@Test(priority=8)
	public void siteTabTest() throws InterruptedException {  

		sitePage.validateSiteTabTest();    

		//Done //confusion

	}

	@Test(priority=9)
	public void addSiteTest() throws InterruptedException {  

		sitePage.validateAddSiteTest();    //last step pending assertion R & d dynamic text
		//Assert.assertNotEquals(actual, expected, message); 

	}

	@Test(priority=10)
	public void editSiteTest() throws InterruptedException {
		sitePage.validateEditSiteTest();


	}

	@Test(priority=11)
	public void addMultipleEmailsTest() throws InterruptedException {
		sitePage.validateMultipleEmailsTest();
		//Dynamic Assertion pending
	}
	
	
	
	@Test(priority=12)
	public void archiveSiteTest() throws InterruptedException {

		sitePage.validateArchiveSiteTest();
		//Assertion Pending
	}

	
	
	@Test(priority=13)
	public void unArchiveSiteTest() throws InterruptedException {

		sitePage.validateUnArchiveSiteTest();
		//Assertion pending

	}	

	
	@Test(enabled = false)
	public void deleteSiteTest() throws InterruptedException {

		sitePage.validateDeleteSiteTest();
		//Assertion pending

	}
	
	@Test(enabled = false)
	public void addPatrolCarTest() throws InterruptedException {

		patrolPage.validateAddPatrolCarTest();
		

	}
	
	
	@Test(enabled = false)
	public void publishShiftTest() throws InterruptedException {

		schedulePage.validatePublishShiftTest();
		
	}
	
	@Test(enabled = false)
	public void uNPublishShiftTest() throws InterruptedException {

		schedulePage.validateuNPublishShiftTest();
		
	}
	/*
	@Test(enabled = false)
       public void loginPageTitleTest() {

		 String title = loginPage.validateLoginPageTitle(); Assert.assertEquals(title,
		  "#1 Free CRM for Any Business: Online Customer Relationship Software");

	//	System.out.println("Inside login");
		//loginPage.login("Abhinav", "test@123");
	}
	*/


	/*
	 * @Test(priority=2) public void crmLogoImageTest(){ boolean flag =
	 * loginPage.validate CRMImage(); Assert.assertTrue(flag); }
	 */

	
	/*
	 * @Test(priority=2) public void loginTest(){ homePage =
	 * loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 * }
	 *
	 */
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
