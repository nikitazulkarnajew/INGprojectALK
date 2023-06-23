package Data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UslugiNarzedziaData {

    public UslugiNarzedziaData(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"menu-financemeter\"]")
    private WebElement UslugiNarzedzia;

    @FindBy(xpath = "//*[@id=\"servicesRecipient\"]")
    private WebElement Odbiorcy;

    @FindBy(xpath = "//*[@class=\"btn-sep hidden-xs ui-btn-text\"]")
    private WebElement DodajOdbiorceButton;

    @FindBy(xpath = "//*[@id=\"contact-name\"]")
    private WebElement TwojaNazwaOdbiorcy;

    @FindBy(xpath = "//*[@id=\"contact-recipient-name-and-address\"]")
    private WebElement NazwaAdresOdbiorcy;

    @FindBy(xpath = "//*[@id=\"recipient-account-number\"]")
    private WebElement NumerKonta;

    @FindBy(xpath = "//*[@id=\"contact-phone-number\"]")
    private WebElement TelefonKomorkowy;

    @FindBy(xpath = "//*[@class=\"btn btn-primary btn-block btn-lg js-save contact-form_button\"]")
    private WebElement DO_ZapiszButton;

    @FindBy(xpath = "//*[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement DO_PotwierdzButton;


    @FindBy(xpath = "//*[@class=\"link  js-summary-link js-link-id-2\"]")
    private WebElement WrocDoListyOdbiorcowButton;

    @FindBy(xpath = "//*[@class=\"form-control js-search-input contacts-search_input\"]")
    private WebElement ListaOdbiorcowSearchField;

    @FindBy(xpath = "//*[@class=\"ing-selected-text\"]")
    private WebElement NazwaDodanegoOdbiorcy;

    @FindBy(xpath = "//*[@class=\"glyphicon-ing glyphicon-ing-trash\"]")
    private WebElement UsunOdbiorceTrashIcon;

    @FindBy(xpath = "//*[@class=\"btn btn-primary btn-block btn-lg js-btn\"]")
    private WebElement UsunOdbiorceButton;

    @FindBy(xpath = "//*[@class=\"notification info\"]")
    private WebElement BrakWynikow;

    @FindBy(xpath = "//*[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement zamknijCookies;


    public UslugiNarzedziaData przejdzDoListyOdbiorcow() {
        UslugiNarzedzia.click();
        Odbiorcy.click();
        return this;

    }


    public UslugiNarzedziaData przejdzDoFormatkiDodajOdbiorce() {
        DodajOdbiorceButton.click();
        return this;

    }

    public UslugiNarzedziaData wypelnijNazweOdbiorcy(String nazwaOdbiorcy) {
        TwojaNazwaOdbiorcy.click();
        TwojaNazwaOdbiorcy.sendKeys(nazwaOdbiorcy);
        return this;

    }

    public UslugiNarzedziaData wypelnijNazweAdresOdbiorcy(String nazwaAdresOdbiorcy) {
        NazwaAdresOdbiorcy.click();
        NazwaAdresOdbiorcy.sendKeys(nazwaAdresOdbiorcy);
        return this;


    }


    public UslugiNarzedziaData wypelnijNumerKonta(String numerKonta) {
        NumerKonta.click();
        NumerKonta.sendKeys(numerKonta);
        return this;
    }

    public UslugiNarzedziaData wypelnijNumerTelefonu(String numerTelefonu) {
        TelefonKomorkowy.click();
        TelefonKomorkowy.sendKeys(numerTelefonu);
        return this;
    }

    public UslugiNarzedziaData akceptujDodajOdbiorce() {
        DO_ZapiszButton.click();
        return this;
    }

    public UslugiNarzedziaData potwierdzDodajOdbiorce() {
        closeCookies();
        DO_PotwierdzButton.click();
        return this;
    }

    public UslugiNarzedziaData przejdzDoOdbiorcow() {
        WrocDoListyOdbiorcowButton.click();
        return this;

    }

    public UslugiNarzedziaData wyszukajOdbiorce(String nazwaOdbiorcy) {
        ListaOdbiorcowSearchField.clear();
        ListaOdbiorcowSearchField.sendKeys(nazwaOdbiorcy);
        return this;
    }

    public WebElement getNazwaDodanegoOdbiorcy() {
        return NazwaDodanegoOdbiorcy;
    }

    public void usunOdbiorce() {
        UsunOdbiorceTrashIcon.click();
        UsunOdbiorceButton.click();

    }

    public WebElement getBrakWynikow() {
        return BrakWynikow;
    }

    private void closeCookies() {
        zamknijCookies.click();
    }


}
