package com.amazon.tc;

import io.appium.java_client.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import com.amazon.driverPackage.TestRunner;
import org.openqa.selenium.Dimension;

public class BusinessLogic extends TestRunner {

    public BusinessLogic() {

    }

    private static final By amazon_logo = By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_home_logo']");
    private static final By harmburger_menu = By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_burger_icon']");
    private static final By search_bar = By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']");

    //Sigin Locators
    private static final By signIn_Btn = By.xpath("//*[contains(@text,'Already a customer? Sign in')]");
    private static final By skip_SignIn_Btn = By.xpath("//*[contains(@text,'Skip sign in')]");
    private static final By signIn_text = By.xpath("//*[@text='Sign in for the best experience']");
    private static final By Welcome_label = By.xpath("//*[@text='Welcome']");
    private static final By emailmissing_alert = By.xpath("//*[@text='Enter your email or mobile phone number']");
    private static final By register_header = By.xpath("//*[contains(@text,'Create account')]");
    private static final By sign_In_header = By.xpath("//*[@text='Sign-In. Already a customer?']");
    private static final By email_login = By.xpath("//android.widget.EditText[@resource-id='ap_email_login' and @index='1']");
    private static final By continue_Btn = By.xpath("//android.widget.Button[@text='Continue']");
    private static final By termsAndConditions = By.xpath("//android.view.View[contains(@text,'By continuing')]");
    private static final By password = By.xpath("//*[@resource-id='ap_password']");
    private static final By showpassowrd_toggle = By.xpath("//*[@resource-id='auth-show-password-checkbox-container']");
    private static final By sigIn_Submit = By.xpath("//*[@resource-id='signInSubmit']");

    /**
     * This method is used to verify whether the home screen is present or not
     *
     * @throws NoSuchElementException
     */
    public void verifyHomeScreen() {
        try {
            if (nativeDriver.findElement(amazon_logo).isDisplayed()) {
                //    By.xpath(getObject("amazon_logo"))).isDisplayed()) {
                System.out.println("Amazon screen Header");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * This method is used to verify whether the hambruger menu is present or not
     *If element is present,will click
     *
     * @throws NoSuchElementException
     */

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
            nativeDriver.findElement(By.xpath(getObject("signIn_Btn"))).click();
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
            if (label) {
                nativeDriver.findElement(By.xpath(getObject("continue_Btn"))).click();
                boolean flag = nativeDriver.findElement(By.xpath(getObject("emailmissing_alert"))).isDisplayed();
                System.out.println("**********");
                System.out.println(flag);
            }

            nativeDriver.findElement(By.xpath(getObject("register_header"))).isDisplayed();
            System.out.println(nativeDriver.getPageSource());
            System.out.println(getTestData("Username", TCID));
            System.out.println(nativeDriver.getContextHandles());

            nativeDriver.context("NATIVE_APP");

            System.out.println("&&&&&&&&&&&&&&&");
            nativeDriver.findElementByXPath("//android.widget.EditText[@resource-id='ap_email_login' and @index='1']").click();
            nativeDriver.findElementByXPath("//android.widget.EditText[@resource-id='ap_email_login' and @index='1']").sendKeys("mani.kubaran@gmail.com");


            nativeDriver.findElement(By.xpath(getObject("continue_Btn"))).click();

            MobileElement el4 = (MobileElement) nativeDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[8]/android.view.View[2]/android.widget.EditText");
            el4.sendKeys(getTestData("Password", TCID));

            MobileElement el6 = (MobileElement) nativeDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[8]/android.view.View[11]/android.view.View/android.widget.Button");
            el6.click();
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

    public void search(String TCID) throws Exception {
        nativeDriver.findElementByXPath(getObject("skip_SignIn_Btn")).click();
        nativeDriver.findElementByXPath(getObject("search_bar")).click();
        Thread.sleep(5000);
        MobileElement searchBar = nativeDriver.findElementByXPath(getObject("search_bar"));
        searchBar.sendKeys(getTestData("Search", TCID));
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(5);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        System.out.println("^^^^^^^^^^^^^");
        Thread.sleep(5000);
        System.out.println(nativeDriver.getPageSource());
        swipeScreen(Direction.UP);
    }


    /**
     * This method is used to Verify the list of beneficiaries
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

    /**
     * Performs swipe from the center of screen
     *
     * @param dir the direction of swipe
     * @version java-client: 7.3.0
     **/
    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 600; // ms

        final int PRESS_TIME = 600; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = nativeDriver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(nativeDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

}
