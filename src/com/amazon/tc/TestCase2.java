package com.amazon.tc;

import org.testng.annotations.Test;

public class TestCase2 extends BusinessLogic{
	
	@Test
	public void verifyBenficiaryAccounts() throws InterruptedException{
		verifyHomeScreen();
		login("TC02");
		logout();
				
		
			
		
	}

}



