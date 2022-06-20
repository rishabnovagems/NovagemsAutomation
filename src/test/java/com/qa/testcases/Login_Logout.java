package com.qa.testcases;

import org.testng.annotations.BeforeMethod;

import com.qa.base.TestBaseChild;

public class Login_Logout extends TestBaseChild{
	public Login_Logout() {
		super();
	}

	@BeforeMethod
	public void setUp() {	
		initialization();
		this.xy();
		

	}
}
