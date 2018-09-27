package xueqiuObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainActivity {

    @FindBy(xpath = "//*[@text='自选']")
    public WebElement 自选;

    @FindBy(xpath = "//*[@text='美股']")
    public WebElement 美股;
}
