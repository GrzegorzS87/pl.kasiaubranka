package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterMenu {

    @FindBy(id = "box_filter")
    private WebElement filterDiv;

    @FindBy(xpath = "//div[@id = 'box_filter']//div[@class = 'multiselect']")
    private List<WebElement> filterOptionSelectDiv;

    @FindBy(xpath = "//ul[@style='display: block;']//a")
    private List<WebElement> filterOptionLink;
}
