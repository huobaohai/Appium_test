package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Welcome {

    @FindBy(xpath = "//*[@text='跳过']")
    public WebElement 跳过;

}
