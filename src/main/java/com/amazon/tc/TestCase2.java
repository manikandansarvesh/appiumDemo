package com.amazon.tc;

import org.testng.annotations.Test;

public class TestCase2 extends BusinessLogic{
	
	@Test
	public void searchProduct() throws Exception{
		verifyHomeScreen();
		search("TC02");
		//logout();
				
		
			
		
	}

}



