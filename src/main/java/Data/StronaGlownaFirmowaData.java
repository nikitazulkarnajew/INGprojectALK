package Data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//*[@name=\"Przelew do ZUS\"]")
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




    public void przejdzDoKontekstuFirmowego() {
        zakladkaFirmowa.click();

    }

    public void przejdzDoFirmowegoPrzelewu() {
        WykonajTransakcje.click();
        MojeKontoFirmowe.click();
        //KD_WykonajTransakcje.click();
        //PrzelewZwykly.click();
    }
    public void przejdzDoPrzelewuDoZus() {
        //finanseFirmoweTab.click();
        //mojeKontoFirmowe.click();
        //wykonajTransakcjeButton.click();
        przelewDoZusButton.click();

    }

    public void wypelnijKwotyZus(String FunduszEmeryturPomostowych, String FunduszPracy, String UbezpieczenieZdrowotne,
                                 String UbezpieczenieSpoleczne) {
        funduszEmeryturPomostowychField.sendKeys(FunduszEmeryturPomostowych);
        funduszPracyField.sendKeys(FunduszPracy);
        ubezpieczeniZdrowotneField.sendKeys(UbezpieczenieZdrowotne);
        ubezpieczeniSpoleczneField.sendKeys(UbezpieczenieSpoleczne);

    }

    public void wypelnijDeklaracje(String NumerDeklaracji, String Miesiac, String Rok) {
        deklaracjaNumer.sendKeys(NumerDeklaracji);
        deklaracjaMiesiac.sendKeys(Miesiac);
        deklaracjaRok.sendKeys(Rok);


    }

    public void wypelnijNazwePlatnika(String NazwaPlatnika){
        nazwaPlatnika.sendKeys(NazwaPlatnika);
    }


    public void akceptujPrzelewDoZus() {
        przelewDoZusDalejButton.click();
        przelewDoZusPotwierdzButton.click();

    }


}
