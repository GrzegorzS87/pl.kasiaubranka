package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarMenu {

    private WebDriver driver;

    @FindBy(id = "box_menu")
    private WebElement sideMenuDiv;

    @FindBy(xpath = "//div/ul/li/a")
    private WebElement mainCategoriesLink;

    @FindBy(xpath = "//div/ul/li[@class = 'current']/a")
    private WebElement currentCategoryLink;

    @FindBy(xpath = "//ul[@class = 'standard']/li/ul/li/a")
    private List<WebElement> subCategoryLinks;

    public SidebarMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
