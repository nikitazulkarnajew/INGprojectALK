package Data;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StronaGlownaData {


    //public StronaGlownaData(WebDriver driver) {
     //   PageFactory.initElements(driver, this);
    //}


    @FindBy(xpath = "//*[@id=\"menu-products\"]")
    private WebElement MojeFinanse;

    @FindBy(xpath = "//*[@class=\"name row_name--C\"]")
    private WebElement Konto_Direct;

    @FindBy(xpath = "//*[@class=\"js-transaction-button link\"]")
    private WebElement KD_WykonajTransakcje;

    @FindBy(xpath = "//*[@class=\"tile_icon tile_icon--small glyphicon-ing type-icon glyphicon-ing-transactions\"]")
    private WebElement PrzelewZwykly;

    @FindBy(xpath = "//*[@id=\"transfer-recipient-name\"]")
    private WebElement NazwaIadresOdbiorcy;

    @FindBy(xpath = "//*[@id=\"amount\"]")
    private WebElement KwotaPrzelewZwykly;

    @FindBy(xpath = "//*[@id=\"title\"]")
    private WebElement TytulPrzelewu;

    @FindBy(xpath = "//*[@aria-labelledby=\"further-label\"]")
    private WebElement DalejPrzelewZwykly;

    @FindBy(xpath = "//*[@class=\"btn btn-primary btn-block btn-lg js-send\"]")
    private WebElement PotwierdzPrzelewZwykly;

    @FindBy(xpath = "//*[@class=\"logo__img\"]")
    private WebElement logoING;

    @FindBy(xpath = "//*[@class=\"sum_title no-outline-on-focus\"]")
    private WebElement PrzelewWyslanyKomunikat;

    @FindBy(xpath = "//*[@class=\"product-tile__title\"]")
    private WebElement PrzelewWyslanyTytul;

    @FindBy(xpath = "//*[@class=\"cookie-policy_close js-close-cookie glyphicon glyphicon-ing-close\"]")
    private WebElement zamknijCookies;


    private WebDriver driver;
    public StronaGlownaData(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }




    public StronaGlownaData przejdzDoZwyklegoPrzelewu() {
        MojeFinanse.click();
        closeCookies();
        Konto_Direct.click();
        KD_WykonajTransakcje.click();
        PrzelewZwykly.click();
        return this;
    }

    public StronaGlownaData wypelnijNazweAdresOdbiorcy(String nazwaAdresOdbiorcy) {

        NazwaIadresOdbiorcy.click();
        NazwaIadresOdbiorcy.sendKeys(nazwaAdresOdbiorcy);
        return this;

    }

    public StronaGlownaData wypelnijKwotePrzelewu(String kwotaPrzelewu) {

        KwotaPrzelewZwykly.click();
        KwotaPrzelewZwykly.sendKeys(kwotaPrzelewu);
        return this;

    }

    public StronaGlownaData wypelnijTytulPrzelewu(String tytul) {

        TytulPrzelewu.click();
        TytulPrzelewu.sendKeys(tytul);
        return this;

    }

    public StronaGlownaData zatwierdzPrzelewZwykly() {
        DalejPrzelewZwykly.click();
        PotwierdzPrzelewZwykly.click();
        return this;
    }


    public void wrocNaStroneGlowna() {

        logoING.click();
    }



    public WebElement getPrzelewWyslanyKomunikat() {
        return PrzelewWyslanyKomunikat;
    }

    public WebElement getPrzelewWyslanyTytul() {
        return PrzelewWyslanyTytul;
    }

    private void closeCookies() {
        zamknijCookies.click();
    }

}

