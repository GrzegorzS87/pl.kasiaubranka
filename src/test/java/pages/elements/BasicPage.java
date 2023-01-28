package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasicPage {

    //header
    @FindBy(xpath = "//a[@class = 'link-logo link-logo-img']")
    private WebElement homeLink;

    @FindBy(name = "search")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='js__search-submit-btn search-btn search__input-area-item btn btn-red search__btn-search r--l-flex r--l-flex-vcenter r--l-flex-hcenter']")
    private WebElement serchButton;

    @FindBy(xpath = "//a[@href='/pl/basket' and @class='count']")
    private WebElement basketLink;

    @FindBy(xpath = "//a[contains(@id,'headlink')]//span[text()='Ubranka dziecięce']")
    private WebElement headerCategoryLinkUbranka;

    @FindBy(xpath = "//a[contains(@id,'headlink')]//span[text()='Kapcie dla dzieci']")
    private WebElement headerCategoryLinkKapcie;

    @FindBy(xpath = "//a[contains(@id,'headlink')]//span[text()='Akcesoria']")
    private WebElement headerCategoryLinkAkcesoria;

    @FindBy(xpath = "//a[contains(@id,'headlink')]//span[text()='Outlet']")
    private WebElement headerCategoryLinkOutlet;

    @FindBy(xpath = "//a[contains(@id,'headlink')]//span[text()='Tata potrafi']")
    private WebElement headerCategoryLinkTata_potrafi;

    @FindBy(xpath = "//a[contains(@id,'headlink')]//span[text()='Blog']")
    private WebElement headerCategoryLinkBlog;

    @FindBy(xpath = "//a[contains(@id,'headlink')]//span[text()='Opinie']")
    private WebElement headerCategoryLinkOpinie;

    @FindBy(xpath = "//a[contains(@id,'headlink')]//span[text()='Rozmiary / Pranie']")
    private WebElement headerCategoryLinkRozmiary_Pranie;

    @FindAll(@FindBy(tagName = "h1")) //there can be only one, more like "should", better check thou
    private List<WebElement> h1HeadersList;

    //footer
    @FindBy(xpath = "//a[@title='Zwroty i reklamacje']")
    private WebElement linkZwrotyIReklamacje;

    @FindBy(xpath = "//a[@title='Regulamin']")
    private WebElement linkRegulamin;

    @FindBy(xpath = "//a[@title='O Kapciach']")
    private WebElement linkOKapciach;

    @FindBy(xpath = "//a[@title='Rozmiary / Pranie']")
    private WebElement linkZwroty;

    @FindBy(xpath = "//a[@title='O Body EasyOn']")
    private WebElement linkOBodyEasyOn;

    @FindBy(xpath = "//a[@title='Opinie']")
    private WebElement linkOpinie;

    @FindBy(xpath = "//a[@title='Twoje zamówienia']")
    private WebElement linkTwojeZamowienia;

    @FindBy(xpath = "//a[@title='Ustawienia konta']")
    private WebElement linkUstawieniaKonta;

    @FindBy(xpath = "//a[@title='Przechowalnia']")
    private WebElement linkPrzechowalnia;

    @FindBy(xpath = "//a[@title='Formy płatności']")
    private WebElement linkFormyPlatnosci;

    @FindBy(xpath = "//a[@title='Czas i koszty dostawy']")
    private WebElement linkDostawa;

    @FindBy(xpath = "//a[@title='Polityka prywatności']")
    private WebElement linkPolitykaPrywatnosci;

    @FindBy(xpath = "//a[@title='Współpraca / Hurt']")
    private WebElement linkWspolpracaHurt;

    @FindBy(xpath = "//a[@title='Ciekawe miejsca']")
    private WebElement linkCiekaweMiejsca;

    @FindBy(xpath = "//a[@title='Kontakt i dane firmy']")
    private WebElement linkKontaktIDaneFirmy;

    @FindBy(xpath = "//a[@title='Sklep z ubrankami niemowlęcymi jest na sprzedaż.']")
    private WebElement linkSklepNaSprzedaz;

    @FindBy(xpath = "//a[@title='O Nas']")
    private WebElement linkONas;

    @FindBy(xpath = "//a[@title='Blog']")
    private WebElement linkBlog;

    public BasicPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void closePopUp(WebDriver driver){
        WebElement closePopup = driver.findElement(By.xpath("//span[@class='close fa fa-times']"));
        if(closePopup.isDisplayed()) {
            closePopup.click();
        }
    }

}
