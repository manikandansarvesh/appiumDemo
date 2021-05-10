package com.amazon.tc;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCase1 extends BusinessLogic {

    @Test(priority = 0)
    public void userSigIn() throws InterruptedException, IOException {
        verifyHomeScreen();
        signIn("TC01");
        WebDriver driver= new ChromeDriver();

        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("");
        FileCopyUtils.copy(srcFile,destFile);

    }
}
