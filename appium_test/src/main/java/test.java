/**

import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class test {

    private AppiumDriver<WebElement> appiumDriver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","192.168.71.101:5555");
        capabilities.setCapability("appPackage","com.nowcoder.app.florida");
        capabilities.setCapability("appActivity",".activity.home.SplashActivity");


        appiumDriver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

//    @After
//    public void quit(){
//        appiumDriver.quit();
//    }

    @Test
    public void test_demo() throws InterruptedException {
        Thread.sleep(5000);
        appiumDriver.findElementById("gotoLoginView").click();
        Thread.sleep(5000);
        appiumDriver.findElementByXPath("//*[@resource-id='com.nowcoder.app.florida:id/loginnumber_phones']").sendKeys("17888809053");
        Thread.sleep(3000);
        appiumDriver.findElementById("loginnumber_password").sendKeys("tl1995925");
        Thread.sleep(3000);
        appiumDriver.findElementByXPath("//*[@resource-id='com.nowcoder.app.florida:id/go_numberlogin']").click();
        Thread.sleep(10000);
    }

//    public WebElement getLocator(String text) {
//        if (text.matches("//*")){
//            return appiumDriver.findElementByXPath(text);
//        }else{
//            return appiumDriver.findElementById(text);
//        }
//    }

}

*/