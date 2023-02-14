package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import utils.DataStorage;

public class MainPageProductsTest extends BaseTest{


    @Test
    public void cookiePopUpVisibleAfterOpenNoCookies() {
        driver.manage().deleteAllCookies();
        driver.get(HomePage.url);
        WebElement closePopup = driver.findElement(By.xpath("//span[@class='close fa fa-times']"));

        //cookie popup should be visible
        boolean cookiePopupVisible = closePopup.isDisplayed();
        logHtml.toPass(cookiePopupVisible,"Cookie popup visible on fresh open with clear cookies", driver);
        Assert.assertTrue(cookiePopupVisible);
    }

    @Test
    public void productListDisplayedOnMainPage(){
        boolean isDisplayed = new HomePage(driver)
                .open()
                .productList
                .mainProductsDiv
                .isDisplayed();

        //should be displayed
        logHtml.toPass(isDisplayed,"Products are displayed on homepage", driver);
        Assert.assertTrue(isDisplayed);
    }

    @Test
    public void clickFirstProductOnListFirstSizeHighlited(){
        boolean isHighlighted = new HomePage(driver)
                .open()
                .firstProductFirstSizeClick()
                .sizeIdIsActive(0);

        // after picking first product by clicking first size,
        // first available size should be highlighted on product page after redirection
        logHtml.toPass(isHighlighted,"Highlighted correct size", driver);
        Assert.assertTrue(isHighlighted);
    }

    @Test
    public void productListLenght(){

        int numberOfProductsListed = new HomePage(driver)
                .open()
                .productList
                .numberOfProductsListed();

        // number of products presented on first page should be equal to number set in shop settings
        boolean correctNumber = numberOfProductsListed == ShopSettings.PRODUCTS_ON_PAGE;
        logHtml.toPass(correctNumber,"Number of products on page is matching settings", driver);
        Assert.assertTrue(correctNumber);
    }

    @Test
    public void allProductsHavePhoto(){
        HomePage page = new HomePage(driver)
                .open();

        int numberOfProductsListed = page.productList.numberOfProductsListed();
        int numberOfPhotos = page.productList.numberOfProductsWithImageListed();

        //all listed should have photo
        boolean allHavePhoto = numberOfPhotos == numberOfProductsListed;
        logHtml.toPass(allHavePhoto,"All listed products have photo", driver);
        Assert.assertTrue(allHavePhoto);
    }

    @Test
    public void allProductsHaveName(){
        HomePage page = new HomePage(driver)
                .open();

        int numberOfProductsListed = page.productList.numberOfProductsListed();
        int numberOfNames = page.productList.numberOfProductNamesListed();

        //all listed should have name
        boolean allHaveName = numberOfNames == numberOfProductsListed;
        logHtml.toPass(allHaveName,"All listed products have name", driver);
        Assert.assertTrue(allHaveName);
    }

    @Test
    public void allProductsHaveAddToBasketButton(){
        HomePage page = new HomePage(driver)
                .open();

        int numberOfProductsListed = page.productList.numberOfProductsListed();
        int numberOfAddToBasketButtons = page.productList.numberOfAddToBasketButtons();

        //all listed should have add to basket button
        boolean allHaveAddToBasketButton = numberOfAddToBasketButtons == numberOfProductsListed;
        logHtml.toPass(allHaveAddToBasketButton,"All listed products have add to basket button", driver);
        Assert.assertTrue(allHaveAddToBasketButton);
    }

    @Test
    public void allProductsHaveSizes(){
        HomePage page = new HomePage(driver)
                .open();

        int numberOfProductsListed = page.productList.numberOfProductsListed();
        int numberOfPickSize = page.productList.numberOfProductsWithSizeListed();

        //all listed should have sizes
        boolean allHaveSize = numberOfPickSize == numberOfProductsListed;
        logHtml.toPass(allHaveSize,"All listed products have sizes", driver);
        Assert.assertTrue(allHaveSize);
    }

    @DataProvider (name = "productNames")
    public Object[][] prodNames(){
        //passing max value to save time if You happen to review this code
        //You could use ShopSettings.PRODUCTS_ON_HOME_PAGE to check all
        return new DataStorage().homePageProductNames(ShopSettings.PRODUCTS_TO_TEST);
    }

    @Test (dataProvider = "productNames")
    public void productsOnList(String productName){
        boolean isOnList = new HomePage(driver)
                .open()
                .productList.productIsOnList(productName);
        logHtml.toPass(isOnList, productName + " is listed", driver);
        Assert.assertTrue(isOnList);
    }

    @Test (dataProvider = "productNames")
    public void addToBasketToCorrectDetailsPage(String productName){

        ProductDetailsPage page = new HomePage(driver)
                .open()
                .addProductToBasket(productName);

        int numberOfH1 = page.h1HeadersNumber();
        String actualProductName = page.h1Text();

        //Product name should be used as H1 in details page, there should be only one H1
        boolean correctRedirection = productName.equals(actualProductName);
        logHtml.toPass(correctRedirection,productName + " has proper details page, h1 count: " + numberOfH1, driver);
        Assert.assertEquals(numberOfH1, 1);
        Assert.assertTrue(correctRedirection);
    }

    @Test
    public void productHasImage(){
        boolean allImagesDisplayed = new HomePage(driver)
                .open()
                .productList
                .productImages()
                .stream()
                .filter(element -> element.getAttribute("naturalWidth").equals(0))
                .toList() //list of broken img's
                .size() == 0;

        logHtml.toPass(allImagesDisplayed, "All listed products have images.", driver);
        Assert.assertTrue(allImagesDisplayed);
    }
}

