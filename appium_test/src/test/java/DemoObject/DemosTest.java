package DemoObject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DemosTest {

    private AndroidDriver<WebElement> appiumDriver;
//    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","android");
//        capabilities.setCapability("deviceName","WTK7N17104000438");
        capabilities.setCapability("deviceName","192.168.71.101:5555");
        capabilities.setCapability("appPackage","io.appium.android.apis");
        capabilities.setCapability("appActivity",".ApiDemos");
        capabilities.setCapability("showChromedriverlog",true);
        //定位tosat只能使用uiautomator2
        capabilities.setCapability("automationName","uiautomator2");
//
//        capabilities.setCapability("platformName","android");
////        capabilities.setCapability("deviceName","WTK7N17104000438");
//        capabilities.setCapability("deviceName","192.168.71.101:5555");
//        capabilities.setCapability("appPackage","com.nowcoder.app.florida");
//        capabilities.setCapability("appActivity",".activity.home.SplashActivity");
//        //定位tosat只能使用uiautomator2
//        capabilities.setCapability("automationName","uiautomator2");

        appiumDriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void close(){
        appiumDriver.quit();
    }

//    @Test
    public void test3() throws InterruptedException{
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        appiumDriver.findElementByXPath("//*[@text='Views']").click();
        WebElement list = appiumDriver.findElementById("android:id/list");
        WebElement webview = list.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WebView\"));"));
        webview.click();
//        String text = "//*[@text='WebView']";
//        Dimension screen = appiumDriver.manage().window().getSize();
//        while(!isElementExist(appiumDriver,text)){
//            (new TouchAction(appiumDriver)).press(new PointOption().withCoordinates((int)(screen.width*0.5),(int)(screen.height*0.8)))
//                    .moveTo(new PointOption().withCoordinates((int)(screen.width*0.5),(int)(screen.height*0.2)))
//                    .release().perform();
//        }
//        appiumDriver.findElementByXPath(text).click();
        for (WebElement e : appiumDriver.findElementsByXPath("//*")){
            System.out.println(e.getTagName());
            System.out.println(e.getText());
        }

        System.out.println(appiumDriver.getContextHandles());
        appiumDriver.context(appiumDriver.getContextHandles().toArray()[1].toString());
        for (WebElement e : appiumDriver.findElementsByXPath("//*")){
            System.out.println(e.getTagName());
            System.out.println(e.getText());
        }

    }

    @Test
    public void test1() throws InterruptedException {
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(appiumDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Views']"))).click();
        Thread.sleep(1000);
        String text = "//*[@text='Popup Menu']";
        Dimension screen = appiumDriver.manage().window().getSize();
        while(!isElementExist(appiumDriver,text)){
            (new TouchAction(appiumDriver)).press(new PointOption().withCoordinates((int)(screen.width*0.5),(int)(screen.height*0.8)))
                    .moveTo(new PointOption().withCoordinates((int)(screen.width*0.5),(int)(screen.height*0.2)))
                    .release().perform();
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(text))).click();
        appiumDriver.navigate().back();
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
        appiumDriver.openNotifications();
        appiumDriver.navigate().back();
        appiumDriver.rotate(ScreenOrientation.PORTRAIT);
    }

    @Test
    public void test2() throws Exception {
        System.out.println(appiumDriver.manage().logs().getAvailableLogTypes());
        for (Object s : appiumDriver.manage().logs().get("logcat").getAll().toArray()){
//            System.out.println(s);
        }

        System.out.println(appiumDriver.getSupportedPerformanceDataTypes());
//        System.out.println(appiumDriver.getPerformanceData("io.appium.android.apis", "cpuinfo", 10));
    }

    public boolean isElementExist(AndroidDriver driver,String text){
        try{
            driver.findElementByXPath(text);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);
        locator(3,"Views").click();
        (new TouchAction(appiumDriver)).press(new PointOption().withCoordinates(700,1700)).moveTo(new PointOption().withCoordinates(700,100)).release().perform();
        locator(3,"Popup Menu").click();
        Thread.sleep(3000);
        locator(2,"//*[@text='MAKE A POPUP!']").click();
        Thread.sleep(3000);
        locator(2,"//*[@text='Search']").click();
        System.out.println("Toast_Text = " + locator(2,"//*[@class='android.widget.Toast']").getText());
    }

    private WebElement locator(int i , String text){
        try{
            switch (i){
                case 1:
                    return appiumDriver.findElementById(text);
                case 2:
                    return appiumDriver.findElementByXPath(text);
                case 3:
                    return appiumDriver.findElementByAccessibilityId(text);
                default:
                    return appiumDriver.findElementByXPath(text);
            }
        }
        finally {
//            System.out.println(appiumDriver.getPageSource());
//            for (WebElement e:appiumDriver.findElementsByXPath("//*")){
//                System.out.println();
//                System.out.println( "This Tag is < " + e.getTagName() + " > , content is < " + e.getText() + " >");
////                System.out.println(e.getAttribute("resource-id"));
//            }
        }
    }

}
