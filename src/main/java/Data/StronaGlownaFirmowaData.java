package Data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StronaGlownaFirmowaData {

    public StronaGlownaFirmowaData(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\" context--company\"]")
    private WebElement zakladkaFirmowa;

    @FindBy(xpath = "//*[@id=\"menu-products\"]")
    private WebElement finanseFirmoweTab;

    @FindBy(xpath = "//*[@class=\"name row_name--C\"]")
    private WebElement mojeKontoFirmowe;

    @FindBy(xpath = "//*[@class=\"js-transaction-button link\"]")
    private WebElement wykonajTransakcjeButton;

    @FindBy(xpath = "//*[@class=\"tile_icon tile_icon--small glyphicon-ing type-icon glyphicon-ing-zus\"]/../../div")
    private WebElement przelewDoZusButton;

    @FindBy(xpath = "//*[@id=\"transfer-amount-68101010230000261395400000\"]")
    private WebElement funduszEmeryturPomostowychField;

    @FindBy(xpath = "//*[@id=\"transfer-amount-73101010230000261395300000\"]")
    private WebElement funduszPracyField;

    @FindBy(xpath = "//*[@id=\"transfer-amount-78101010230000261395200000\"]")
    private WebElement ubezpieczeniZdrowotneField;

    @FindBy(xpath = "//*[@id=\"transfer-amount-83101010230000261395100000\"]")
    private WebElement ubezpieczeniSpoleczneField;

    @FindBy(xpath = "//*[@id=\"transfer-declaration-id-number\"]")
    private WebElement deklaracjaNumer;

    @FindBy(xpath = "//*[@id=\"transfer-declaration-id-month\"]")
    private WebElement deklaracjaMiesiac;

    @FindBy(xpath = "//*[@id=\"transfer-declaration-id-year\"]")
    private WebElement deklaracjaRok;

    @FindBy(xpath = "//*[@id=\"payerName\"]")
    private WebElement nazwaPlatnika;

    @FindBy(xpath = "//*[@class=\"btn btn-primary btn-block btn-lg js-further\"]")
    private WebElement przelewDoZusDalejButton;

    @FindBy(xpath = "//*[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement przelewDoZusPotwierdzButton;

    @FindBy(xpath = "//*[@class=\"move-money\"]")
    private WebElement WykonajTransakcje;
    @FindBy(xpath = "//*[@class=\"product-tile__container ing-hover\"]")
    private WebElement MojeKontoFirmowe;

    @FindBy(xpath = "//*[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement zamknijCookies;

    @FindBy(xpath = "//*[@class=\"ing-history\"]")
    private WebElement kliknijHistoria;

    @FindBy(xpath = "//*[@class=\"module-header ui-title\"]")
    private WebElement HistoriaTransakcji;

    @FindBy(xpath = "//*[@class=\"nav-user__logout\"]")
    private WebElement kliknijLogout;

    @FindBy(xpath = "//*[@class=\"h2-pwa\"]")
    private WebElement LogoutMessage;


    public StronaGlownaFirmowaData przejdzDoKontekstuFirmowego() {
        zakladkaFirmowa.click();
        return this;
    }

    public StronaGlownaFirmowaData przejdzDoFirmowegoPrzelewu() {
        WykonajTransakcje.click();
        MojeKontoFirmowe.click();
        closeCookies();
        return this;
    }


    public StronaGlownaFirmowaData przejdzDoPrzelewuDoZus() {
        przelewDoZusButton.click();
        return this;
    }

    public StronaGlownaFirmowaData wypelnijKwotyZus(String FunduszEmeryturPomostowych, String FunduszPracy, String UbezpieczenieZdrowotne,
                                 String UbezpieczenieSpoleczne) {
        funduszEmeryturPomostowychField.sendKeys(FunduszEmeryturPomostowych);
        funduszPracyField.sendKeys(FunduszPracy);
        ubezpieczeniZdrowotneField.sendKeys(UbezpieczenieZdrowotne);
        ubezpieczeniSpoleczneField.sendKeys(UbezpieczenieSpoleczne);
        return this;

    }

    public StronaGlownaFirmowaData wypelnijDeklaracje(String NumerDeklaracji, String Miesiac, String Rok) {
        deklaracjaNumer.sendKeys(NumerDeklaracji);
        deklaracjaMiesiac.sendKeys(Miesiac);
        deklaracjaRok.sendKeys(Rok);
        return this;
    }

    public StronaGlownaFirmowaData wypelnijNazwePlatnika(String NazwaPlatnika) {
        nazwaPlatnika.sendKeys(NazwaPlatnika);
        return this;
    }


    public StronaGlownaFirmowaData akceptujPrzelewDoZus() {
        przelewDoZusDalejButton.click();
        przelewDoZusPotwierdzButton.click();
        closeCookies();
        return this;

    }

    public static boolean waitAndCheckIfElementIsClickable(WebDriver driver, WebElement element, int durationInSec) {
        try {
            waitForElementToBeClickable(driver, element, durationInSec);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int durationInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(durationInSec))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void przejdzDoHistorii() {
        closeCookies();
        kliknijHistoria.click();
    }

    public WebElement getHistoriaTransakcji() {
        return HistoriaTransakcji;
}

    public StronaGlownaFirmowaData wyswietlenieHistorii() {
        closeCookies();
        kliknijHistoria.click();
        return this;
    }

    public StronaGlownaFirmowaData przejdzDoLogout() {
        closeCookies();
        kliknijLogout.click();
        return this;
    }

    public WebElement getSafeLogout() {
        return LogoutMessage;
    }

    private void closeCookies() {
        zamknijCookies.click();
    }



}
