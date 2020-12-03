package com.amazon.tc;

import io.appium.java_client.*;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import com.amazon.driverPackage.TestRunner;
import org.openqa.selenium.WebElement;

public class BusinessLogic extends TestRunner {

    public BusinessLogic() {

    }

    /**
     * This method is used to verify whether the home screen is present or not
     *
     * @throws NoSuchElementException
     */
    public void verifyHomeScreen() {
        try {
            if (nativeDriver.findElement(
                    By.xpath(getObject("amazon_logo"))).isDisplayed()) {
                System.out.println("Amazon screen Header");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void clickHarmburgerMenu() {

        try {
            if (nativeDriver.findElement(
                    By.xpath(getObject("harmburger_menu"))).isDisplayed()) {
                nativeDriver.findElement(By.xpath(getObject("harmburger_menu"))).click();
                System.out.println("HarmBurger has been clicked");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void clickSigInBtn() {

        try {

            /*if (nativeDriver.findElement(
                    By.xpath(getObject("signIn_text"))).isDisplayed()) {*/
             nativeDriver.findElement(By.xpath(getObject("signIn_Btn"))).click();
            //nativeDriver.findElement(By.xpath(getObject("signIn_Btn"))).click();
                System.out.println("Sign In Button has been clicked");

        } catch (NoSuchElementException e) {
            e.getLocalizedMessage();
        }
    }


    /**
     * This method is used to verify  the Sign In  is successful or not
     *
     * @throws NoSuchElementException
     */

    public void signIn(String TCID) {
        clickSigInBtn();

        try {
            boolean label = nativeDriver.findElement(By.xpath(getObject("Welcome_label"))).isDisplayed();
            if(label){

				nativeDriver.findElement(By.xpath(getObject("continue_Btn"))).click();
              boolean flag = nativeDriver.findElement(By.xpath(getObject("emailmissing_alert"))).isDisplayed();
                System.out.println("**********");
              System.out.println(flag);

			}

                nativeDriver.findElement(By.xpath(getObject("register_header"))).isDisplayed();
           // nativeDriver.findElement(By.xpath(getObject("sign-In_header"))).isDisplayed();
            System.out.println(nativeDriver.getPageSource());
            System.out.println(getTestData("Username",TCID));
            System.out.println(nativeDriver.getContextHandles());

              //  Set<String> contextNames = nativeDriver.getContextHandles();
             //   String lastestContextView = (String) contextNames.toArray()[contextNames.size()-1];

             //   if (lastestContextView.contains("WEBVIEW_chrome") || lastestContextView.contains("WEBVIEW_com.amazon.mShop.android.shopping")){
            //        nativeDriver.context(lastestContextView);
             //   }
                nativeDriver.context("NATIVE_APP");

            System.out.println("&&&&&&&&&&&&&&&");
            nativeDriver.findElementByXPath("//android.widget.EditText[@resource-id='ap_email_login' and @index='1']").click();
            nativeDriver.findElementByXPath("//android.widget.EditText[@resource-id='ap_email_login' and @index='1']").sendKeys("mani.kubaran@gmail.com");

           // MobileElement el2 = (MobileElement) nativeDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText");
          //  el2.sendKeys("mani.kubaran@gmail.com");
            nativeDriver.findElement(By.xpath(getObject("continue_Btn"))).click();
           // MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.widget.Button");
           // el3.click();
            MobileElement el4 = (MobileElement) nativeDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[8]/android.view.View[2]/android.widget.EditText");
            el4.sendKeys(getTestData("Password",TCID));

            MobileElement el6 = (MobileElement) nativeDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[8]/android.view.View[11]/android.view.View/android.widget.Button");
            el6.click();
               // nativeDriver.findElement(By.xpath(getObject("email_login"))).sendKeys(getTestData("Username", TCID));
             //   nativeDriver.findElement(By.xpath(getObject("continue_Btn"))).click();
             //   nativeDriver.findElement(By.xpath(getObject("password"))).sendKeys(getTestData("Password",TCID));
              //  boolean showPassword=nativeDriver.findElement(By.id(getObject("showpassowrd_toggle"))).isEnabled();
              //  if(showPassword==true){
               //     nativeDriver.findElement(By.xpath(getObject("showpassowrd_toggle"))).click();
               // }
                nativeDriver.findElement(By.xpath(getObject("sigIn_Submit"))).click();
                nativeDriver.navigate().back();
            System.out.println("Sigin has been completed");



        } catch (Exception e) {
            e.getMessage();

        }
    }


    /**
     * This method is used to verify after login the Menu screen is present or
     * not
     *
     * @throws NoSuchElementException
     */

    public void verifyMyMenuScreen() {
        try {
            if (nativeDriver.findElement(
                    By.xpath(getObject("harmburger_menu"))).isDisplayed()) {
                System.out.println("My Menu screen Validated");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to login the APP not
     *
     * @throws NoSuchElementException
     */

    public void login(String TCID) {
        try {
            nativeDriver.findElement(By.xpath(getObject("home_customerID")))
                    .click();
            String usenamr = getTestData("Username", TCID);
            String password = getTestData("Password", TCID);
            System.out.println(usenamr + password);
            nativeDriver
                    .findElement(By.xpath(getObject("login_UserNameField")))
                    .sendKeys(usenamr);
            nativeDriver.findElement(By.xpath(getObject("login_ContinueBtn")))
                    .click();

            nativeDriver.manage().timeouts()
                    .implicitlyWait(14, TimeUnit.SECONDS);

            nativeDriver
                    .findElement(By.xpath(getObject("login_PasswordField")))
                    .sendKeys(password);
            nativeDriver.findElement(
                    By.xpath(getObject("login_ConfirmCheckBox"))).click();
            nativeDriver.findElement(By.xpath(getObject("login_LoginBtn")))
                    .click();
            System.out.println("Login Clicked");
            nativeDriver.manage().timeouts()
                    .implicitlyWait(14, TimeUnit.SECONDS);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    /* Common method to tap the Back Button */

    public void clickBackBtn() throws InterruptedException {
        nativeDriver.findElement(By.xpath(getObject("backButton"))).click();
        nativeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    /**
     * This method is used to click and view List of beneficiaries Accounts.
     *
     * If the fund button object is not present
     *
     * @throws NoSuchElementException
     *
     */

    /**
     * Function name    : scroll_down | Input  : String | Output  : String
     * Description      : To scroll element using width and height
     */
    public static int scroll_down(String scrollview) {
        int i = 0;
        WebElement element2 = get_object(scrollview);
        int x = element2.getLocation().getX();
        int y = element2.getLocation().getY();
        int width = element2.getSize().getWidth();
        int height = element2.getSize().getHeight();

        System.out.println("X location: " + x);
        System.out.println("Y location: " + y);
        System.out.println("Y location: " + (y - 40));
        System.out.println(width);
        System.out.println(height);
        new TouchAction(nativeDriver).press(PointOption.point((width / 2), (height + y) - 150)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1200)))
                .moveTo(PointOption.point((width / 2), height / 8)).release().perform();
        return i;
    }

    //##########################################################################################################
    // METHOD NAME        : get_object
    // METHOD DESCRIPTION : Method which returns WebElement based on the locator types(such as id's,Xpath,text)
    //##########################################################################################################
    public static WebElement get_object(String element) {
        String[] element1;
        WebElement elem = null;
        element1 = element.split("~");
        String type = element1[0];
        String value = element1[1];
        nativeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        switch (type) {
            case "id":
                System.out.println(value);
                elem = (nativeDriver.findElement(By.id(value)));
                break;
            case "xpath":
                System.out.println("second elem: " + value);
                elem = (nativeDriver.findElement(By.xpath(value)));
                break;
            case "name":
                elem = (nativeDriver.findElement(By.name(value)));
                break;
            case "text":
                elem = nativeDriver.
                        findElement(MobileBy.
                                AndroidUIAutomator(".text(\"" + value + "\")"));
                break;
            default:
                System.out.println("check the object defined syntax");
        }
        return elem;
    }


    /**
     * This method is used to Verify the list of beneficiaries
     *
     * @throws NoSuchElementException
     */

    public void verifyBeneficiaryDetails(String TCID) {
        try {
            String[] accNoXL = getTestData("BeneficiaryAccounts", TCID)
                    .split(":");
            String[] accNameXL = getTestData("BeneficiaryName", TCID).split(":");
            System.out.println(accNameXL);

            for (int i = 0; i < accNoXL.length; i++) {
                String accountNumber = "//android.view.View[@content-desc='" + accNoXL[i] + "']";
                System.out.println(accNoXL[i]);
                System.out.println(accountNumber);
                String accountName = "//android.view.View[@content-desc='" + accNameXL[i] + "']";
                System.out.println(accNameXL[i]);
                System.out.println(nativeDriver.findElement(By.xpath(accountNumber)).isDisplayed());
                System.out.println(nativeDriver.findElement(By.xpath(accountName)).isDisplayed());
                i++;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
			/*for (int j = 0; j <= accountName.length; j++) {
				if (i == j) {
					if (accountName[j].equals(valueofAccountname)) {
						System.out
								.println("Benificiary Account Number and Name is dispalyed Properly");
					} else {
						System.out
								.println("Benificiary Account Number and Name displayed wrongly");
					}*/


    /**
     * This method is used to logout the app
     *
     * @throws NoSuchElementException
     */
    public void logout() {

        try {
            nativeDriver.findElement(By.xpath(getObject("logout"))).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
