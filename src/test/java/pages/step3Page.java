package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class step3Page {

    @FindBy(xpath = "//button[@class = 'btn btn-red order clickhide']")
    private WebElement orderButton;
}
