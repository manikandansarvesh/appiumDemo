package com.amazon.tc;

import org.testng.annotations.Test;

public class TestCase1 extends BusinessLogic {
	
	@Test(priority = 0)
	public void productSearch() throws InterruptedException{
		verifyHomeScreen();

		signIn("TC01");

	}

}
