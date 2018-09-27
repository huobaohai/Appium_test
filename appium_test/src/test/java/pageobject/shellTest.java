package pageobject;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class shellTest {
    private AndroidDriver<WebElement> driver;

  //  @Before
    public void setUp() throws MalformedURLException {
        System.out.println("---> "+System.getenv("deviceName"));
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName","android");
        cap.setCapability("deviceName",System.getenv("deviceName"));
        cap.setCapability("noReset",true);
        cap.setCapability("fullReset",false);
        cap.setCapability("appPackage","com.xueqiu.android");
        cap.setCapability("appActivity",".view.WelcomeActivityAlias");
        cap.setCapability("dontStopAppOnReset",true);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }

//    @Test
    public void test() throws InterruptedException {
        Welcome wel = new Welcome();
        PageFactory.initElements(driver,wel);
        MainActivity mainActivity = new MainActivity();
        PageFactory.initElements(driver,mainActivity);

//        Thread.sleep(5000);
//        wel.跳过.click();
        Thread.sleep(10000);
        mainActivity.自选.click();
        mainActivity.美股.click();
    }
}
