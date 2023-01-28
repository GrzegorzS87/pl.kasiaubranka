package tests;

import org.testng.annotations.Test;
import pages.CategoryTataPotrafiPage;


public class PurchaseNoRegisterTest extends BaseTest{

    @Test
    public void purchaseTest(){
        new CategoryTataPotrafiPage(driver)
                .addTestProduct()
                .pickSize(0)
                .addToBasket()
                .proceedToCheckout()
                .pickCourierInpost()
                .pickPaymentTraditional()
                .confirmOrder()
                .clickNoRegisterPurchase();
    }
}
