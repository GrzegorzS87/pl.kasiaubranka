package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.elements.BasicPage;
import pages.elements.ProductList;

public class HomePage extends BasicPage {

    private WebDriver driver;
    public ProductList productList;
    public static String url = "https://www.kasiaubranka.pl";

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        productList = new ProductList(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage open(){
        driver.get(url);
        closePopUp(driver);
        return this;
    }

    public ProductDetailsPage firstProductFirstSizeClick(){
        productList.addProductToBasketBySize(0,0);

        return new ProductDetailsPage(driver);
    }

    public ProductDetailsPage addProductToBasket(String productName) {
        productList.addProductToBasket(productName);

        return new ProductDetailsPage(driver);
    }
}
