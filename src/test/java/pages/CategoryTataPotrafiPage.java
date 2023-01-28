package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.elements.BasicPage;
import pages.elements.ProductList;

public class CategoryTataPotrafiPage extends BasicPage {

    private WebDriver driver;
    private ProductList productList;
    public static String url = "https://www.kasiaubranka.pl/Tata-Potrafi";

    public CategoryTataPotrafiPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productList = new ProductList(driver);
        PageFactory.initElements(driver, this);
        driver.get(url);
        closePopUp(driver);
    }

    public ProductDetailsPage addTestProduct(){
        productList.addProductToBasket("Selenium TEST");
        return new ProductDetailsPage(driver);
    }

}
