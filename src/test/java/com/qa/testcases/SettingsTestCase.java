package com.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBaseChild;

public class SettingsTestCase extends TestBaseChild{

	public SettingsTestCase() {
		super();
	}


	@BeforeMethod
	public void setUp() {	
		initialization();
		this.xy();

	}

	@Test(priority=1)
	public void settingsTabTest() throws InterruptedException {		
		settingsPage.validatesettingsTabTest();

	}

	@Test(priority=2)
	public void weekStartTest() throws InterruptedException {		
		settingsPage.validatweekStartTest();

	}
	@Test(priority=3)
	public void timeFormat () throws InterruptedException {		
		settingsPage.validatTimeFormatTest();

	}
	
	@Test(priority=4)
	public void notificationSettingTest () throws InterruptedException {		
		settingsPage.validationNotificationSettingTest();

	}
	
	@Test(priority=5)
	public void shiftSettingTest () throws InterruptedException {		
		settingsPage.validationShiftSettingTest();

	}
}
