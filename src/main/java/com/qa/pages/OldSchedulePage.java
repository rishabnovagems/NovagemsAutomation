package com.qa.pages;



import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.base.TestBaseChild;



public class OldSchedulePage extends TestBase {

	JavascriptExecutor js;
	WebDriverWait wait;
	Random randomGenerator;
	int randomInt;
	int randomIntLong;
	String uuid;
	Actions action;

	public OldSchedulePage() {

		super();

		PageFactory.initElements(driver, this);
		action =new Actions(driver);
		wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 80);
		js = (JavascriptExecutor) driver;
		randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(1000);
		randomIntLong = randomGenerator.nextInt(1000000000);
		uuid = UUID.randomUUID().toString();
	}

	public void plusIconmeth() throws InterruptedException{
		Thread.sleep(3000);
		//plusCell2.click();
		action.moveToElement(plusCell2).perform();
		plusCell.click();
		Thread.sleep(2000);
		System.out.println("==============================================");
		startTime.click();	
		action.moveToElement(startTime).sendKeys("19:40").perform();
		endTime.click();
		action.moveToElement(endTime).sendKeys("20:45").perform();
		Thread.sleep(2000);
		saveButton.click();

	}

	@FindBy(id="//span[text()=' Add Staff ']")  //   (//div[@class='guardInfo'])[2]
	public WebElement addStaff; 

	public void addStaffOldSchedule() throws InterruptedException{
		Thread.sleep(2000);
		action.moveToElement(addStaffHover).click();
		addStaff.click();


	}

	@FindBy(xpath="(//div[@class='week_tab_space gaurdCard br_red ng-star-inserted'])")   // Hover on the add Staff container + Time container
	public WebElement addStaffHover;
	
	@FindBy(xpath="//button[@class='apply btn1 mat-focus-indicator mat-button mat-button-base']")
	public WebElement saveButton;
	@FindBy(id="//input[@id='Start Time']")
	public WebElement startTime2;                 
	@FindBy(xpath="//div[@class='mat-form-field-suffix ng-tns-c25-127 ng-star-inserted']") 
	public WebElement startTime;
	@FindBy(xpath="//div[@class='endTitme']")
	public WebElement endTime;
	@FindBy(xpath="//img[@class=\"avatar mr-0 mr-sm-16\"]")
	public WebElement hoverProfile;
	@FindBy(className="s-16 mat-icon notranslate material-icons mat-icon-no-color")
	public WebElement hoverProfile1;
	@FindBy(xpath="//button//span[text()='Switch to New Schedule']")
	public WebElement switchToOldSchedule;
	@FindBy(xpath="//button[@class='apply btn1 mat-focus-indicator mat-button mat-button-base']")
	public WebElement yesButton;
	@FindBy(xpath="(//li[@class='shift-container ng-star-inserted'])[2]//div[@class='plusIcon ng-star-inserted']")
	public WebElement plusCell;
	@FindBy(xpath="(//li[@class='shift-container ng-star-inserted'])[2]")
	public WebElement plusCell2;
	@FindBy(xpath="//div[@class='startTitme']")
	public WebElement startTimeOldSchedule;
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[3]")
	public WebElement scheulePageNavigation2;
	@FindBy(xpath="")
	public WebElement ss;
	By locator = By.xpath("//span[text()='Switch to New Schedule']");
	
	public void validateOldSchedulePublishShiftTest() throws InterruptedException {

		// 15-06 

		Thread.sleep(3000);
		String a=driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[3]/a")).getText();
		String expected="Schedule";

		if (expected.equalsIgnoreCase(a)) {
			System.out.println("Schedule");

			List<WebElement> allOptions = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
			System.out.println(allOptions.size());

			for(int i = 0; i<=allOptions.size()-1; i++) {
				Thread.sleep(2000);
				if(allOptions.get(i).getText().contains("Schedule")) {
					allOptions.get(i).click();
					break;
				}	
			}
			this.plusIconmeth();

		}

		else {
			System.out.println("Schedule New");		

			Thread.sleep(1500);
			action.moveToElement(hoverProfile).perform();
			action.moveToElement(hoverProfile).perform();
			js.executeScript("arguments[0].click();", hoverProfile);
			Thread.sleep(1500);

			List<WebElement> allOptions = driver.findElements(By.xpath("//button[@class='mat-focus-indicator mat-menu-item']"));
			System.out.println(allOptions.size());

			for(int i = 0; i<=allOptions.size()-1; i++) {
				Thread.sleep(1500);
				if(allOptions.get(i).getText().contains("Switch to Old Schedule")) {
					System.out.println("===============================");
					allOptions.get(i).click();
					break;
				}
			}
			yesButton.click();
			this.plusIconmeth();

		}


	}

	public void validateoldScheduleAddStaffTest() throws InterruptedException {
		this.validateOldSchedulePublishShiftTest();
		this.plusIconmeth();
		this.addStaffOldSchedule();		
	}

}

