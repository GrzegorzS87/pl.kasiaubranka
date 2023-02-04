package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.BasicPage;

public class basketNoRegPage extends BasicPage {

    private WebDriver driver;

    @FindBy (id = "input_mail")
    private WebElement emailInput;

    @FindBy (id = "input_name")
    private WebElement nameInput;

    @FindBy (id = "input_surname")
    private WebElement surnameInput;

    @FindBy (id = "input_phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//label[text() = 'osoba prywatna']")
    private WebElement clientTypePrivate;

    @FindBy (id = "input_other_address")
    private WebElement addressInput;

    @FindBy (id = "input_zip")
    private WebElement zipCodeInput;

    @FindBy (id = "input_city")
    private WebElement cityInput;

    @FindBy (id = "input_country")
    private WebElement countrySelect;

    @FindBy (xpath = "//textarea[@name = 'comment']")
    private WebElement commentTextarea;

    @FindBy (xpath = "//label[@for = 'additional_2']")
    private WebElement termsCheckbox;

    @FindBy (xpath = "//button[@class = 'important summary btn-red btn']")
    private WebElement summaryButton;

    public basketNoRegPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public basketNoRegPage fillInFormPrivate(Object[] client){
        emailInput.sendKeys(client[0].toString());
        nameInput.sendKeys(client[1].toString());
        surnameInput.sendKeys(client[2].toString());
        phoneInput.sendKeys(client[3].toString());
        clientTypePrivate.click();
        addressInput.sendKeys(client[5].toString());
        zipCodeInput.click();
        String zipcodeToInsert = client[6].toString().replace("-","");
        zipCodeInput.sendKeys(zipcodeToInsert);
        cityInput.sendKeys(client[7].toString());
        commentTextarea.sendKeys("Test purchase, delete plz");
        termsCheckbox.click();

        return this;
    }

    public SummaryPage clickSummaryButton(){
        summaryButton.click();
        return new SummaryPage(driver);
    }
}
