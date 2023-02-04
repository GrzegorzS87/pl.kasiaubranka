package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CategoryTataPotrafiPage;
import utils.DataStorage;


public class OrderNoRegisterTest extends BaseTest{

    @Test (dataProvider = "clients")
    public void purchaseTest(Object[] client){

        boolean correctDetails = new CategoryTataPotrafiPage(driver)
                .open()
                .addTestProduct()
                .pickRandomSize()
                .addToBasket()
                .proceedToCheckout()
                .pickCourierInpost()
                .pickPaymentTraditional()
                .confirmOrder()
                .clickNoRegisterPurchase()
                .fillInFormPrivate(client)
                .clickSummaryButton()
                .verify(client);

        boolean properStep = driver.getCurrentUrl().contains("step3");
        logHtml.toPass(correctDetails,
                "Test ended at '/step3' page. Correct client details displayed in summary. Client : "
                        + client[1] + client[2],driver);
        Assert.assertTrue(properStep);
        Assert.assertTrue(correctDetails);


    }

    @DataProvider (name = "clients")
    public Object[][] clientsProvider(){
        return new DataStorage().exampleClients();

    }
}
