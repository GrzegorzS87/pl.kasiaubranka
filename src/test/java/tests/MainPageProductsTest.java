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
                .productList
                .numberOfProductsListed();

        // number of products presented on first page should be equal to number set in shop settings
        boolean correctNumber = numberOfProductsListed == ShopSettings.PRODUCTS_ON_PAGE;
        logHtml.toPass(correctNumber,"Number of products on page is matching settings", driver);
        Assert.assertTrue(correctNumber);
    }

    @Test
    public void allProductsHavePhoto(){
        HomePage page = new HomePage(driver);

        int numberOfProductsListed = page.productList.numberOfProductsListed();
        int numberOfPhotos = page.productList.numberOfProductsWithImageListed();

        //all listed should have photo
        boolean allHavePhoto = numberOfPhotos == numberOfProductsListed;
        logHtml.toPass(allHavePhoto,"All listed products have photo", driver);
        Assert.assertTrue(allHavePhoto);
    }

    @Test
    public void allProductsHaveName(){
        HomePage page = new HomePage(driver);

        int numberOfProductsListed = page.productList.numberOfProductsListed();
        int numberOfNames = page.productList.numberOfProductNamesListed();

        //all listed should have name
        boolean allHaveName = numberOfNames == numberOfProductsListed;
        logHtml.toPass(allHaveName,"All listed products have name", driver);
        Assert.assertTrue(allHaveName);
    }

    @Test
    public void allProductsHaveAddToBasketButton(){
        HomePage page = new HomePage(driver);

        int numberOfProductsListed = page.productList.numberOfProductsListed();
        int numberOfAddToBasketButtons = page.productList.numberOfAddToBasketButtons();

        //all listed should have add to basket button
        boolean allHaveAddToBasketButton = numberOfAddToBasketButtons == numberOfProductsListed;
        logHtml.toPass(allHaveAddToBasketButton,"All listed products have add to basket button", driver);
        Assert.assertTrue(allHaveAddToBasketButton);
    }

    @Test
    public void allProductsHaveSizes(){
        HomePage page = new HomePage(driver);

        int numberOfProductsListed = page.productList.numberOfProductsListed();
        int numberOfPickSize = page.productList.numberOfProductsWithSizeListed();

        //all listed should have sizes
        boolean allHaveSize = numberOfPickSize == numberOfProductsListed;
        logHtml.toPass(allHaveSize,"All listed products have sizes", driver);
        Assert.assertTrue(allHaveSize);
    }

    @Test (dataProvider = "productNames")
    public void addToBasketToCorrectDetailsPage(String productName){

        ProductDetailsPage page = new HomePage(driver).addProductToBasket(productName);
        int numberOfH1 = page.h1HeadersNumber();
        String actualProductName = page.h1Text();

        //Product name should be used as H1 in details page, there should be only one H1
        boolean correctRedirection = productName.equals(actualProductName);
        Assert.assertEquals(numberOfH1, 1);
        Assert.assertTrue(correctRedirection);
        logHtml.toPass(correctRedirection,"Proper details page", driver);
    }

    @DataProvider (name = "productNames")
    public Object[][] prodNames(){
        //max is to save time if You happen to review this
        return new DataStorage().homePageProductNames(3);
    }

    @Test
    public void printnames(){

    }
}
