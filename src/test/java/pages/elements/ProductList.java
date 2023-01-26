package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.ProductDetailsPage;

import java.util.List;

public class ProductList {

    private final WebDriver driver;

    @FindBy(id = "box_mainproducts")
    public WebElement mainProductsDiv;

    @FindBy(xpath = "//div[@class = 'product s-grid-3 product-main-wrap']")
    private List<WebElement> listProductDivs;

    @FindBy(xpath = "//a[@class='prodimage f-row']/span/img")
    private List<WebElement> listProductImages;

    @FindBy(xpath = "//a/span[@class='productname']")
    private List<WebElement> listProductNames;

    @FindBy(xpath = "//button[@class='addtobasket btn btn-red']")
    private List<WebElement> listButtonsAddToBasket;

    @FindBy(xpath = "//div[@class='f-row sizes']")
    private List<WebElement> listProductSizesDiv;

    By byProductSizeLinks = By.xpath("//a[@class = 'size']");
    //to use as listRozmiaryDiv.get(productNumber).findElements(productSizeLinks)...

    @FindBy(xpath = "//ul[@class='paginator']//a")
    private List<WebElement> paginatorList; // only active links, last is "next page" >> sign

    public ProductList(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int numberOfProductsListed(){
        return listProductDivs.size();
    }

    public int numberOfProductsWithImageListed(){
        return listProductImages.size();
    }

    public int numberOfProductNamesListed(){
        return listProductNames.size();
    }

    public void printProdNames(){
        for(WebElement e : listProductNames)
            System.out.println(e.getText());
    };

    public int numberOfAddToBasketButtons(){
        return listButtonsAddToBasket.size();
    }

    public int numberOfProductsWithSizeListed(){
        return listProductSizesDiv.size();
    }

    public ProductDetailsPage addProductToBasket(int productNumber){
        // productNumber should be 0 to ShopSettings.PRODUCTS_ON_PAGE
        listButtonsAddToBasket.get(productNumber).click();
        return new ProductDetailsPage(driver);
    }

    public ProductDetailsPage addProductToBasket(String productName){
        listProductNames.stream()
                .filter( element -> element.getText().equals(productName) )
                .findFirst()
                .get()
                .click();
        return new ProductDetailsPage(driver);
    }

    public ProductDetailsPage clickProductImage(int productNumber){
        // productNumber should be 0 to ShopSettings.PRODUCTS_ON_PAGE
        listButtonsAddToBasket.get(productNumber-1).click();
        return new ProductDetailsPage(driver);
    }

    public void addProductToBasketBySize(int productNumber, int sizeLinkNumber ){
        listProductSizesDiv.get(productNumber).findElements(byProductSizeLinks).get(sizeLinkNumber).click();
    }

    public boolean productIsOnList(String productName){
        boolean isOnList = listProductNames.stream()
                .filter( element -> element.getText().equals(productName) )
                .toList()
                .size() > 0;
        return isOnList;
    }
}
