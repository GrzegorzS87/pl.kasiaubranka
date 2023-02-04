package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.BasicPage;

import java.util.List;

public class SummaryPage extends BasicPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'delivery-details']/p")
    private List<WebElement> deliveryDetailsP;

    public SummaryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verify( Object[] client){
        if(deliveryDetailsP.size() == 0 ) return false;
        String name = deliveryDetailsP.get(0).getText();
        String address = deliveryDetailsP.get(1).getText();
        String zipAndCity = deliveryDetailsP.get(2).getText();
        String country = deliveryDetailsP.get(3).getText();
        String phone = deliveryDetailsP.get(4).getText();

        String expectedName = client[1].toString().replace(" ","");
        String expectedLastName = client[2].toString().replace(" ","");

        boolean correctName = name.equals(expectedName+ " " + expectedLastName);
        boolean correctAddress = address.equals(client[5]);
        boolean correctZipAndCity = zipAndCity.contains(client[6].toString())
                && zipAndCity.contains(client[7].toString());
        boolean correctCountry = country.equals("Polska");
        boolean correctPhone = phone.equals(client[3].toString().replace(" ",""));

        return correctAddress && correctCountry && correctName && correctZipAndCity && correctPhone;
    }
}
