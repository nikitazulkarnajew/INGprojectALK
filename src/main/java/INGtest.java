import Data.StronaGlownaData;
import Data.StronaGlownaFirmowaData;
import Data.UslugiNarzedziaData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class INGtest {


    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    }

    @Test(priority = 1)

    public void wyslaniePrzelewu() {
        WebDriver driver = new ChromeDriver();
        //String path = "D:\\chromedriver\\chromedriver.exe";
        // System.setProperty("webdriver.chrome.driver", path);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login.ingbank.pl/mojeing/demo/#home");
        driver.manage().window().maximize();
        StronaGlownaData StronaGlownaData = new StronaGlownaData(driver);
        StronaGlownaData.przejdzDoZwyklegoPrzelewu();
        StronaGlownaData.wypelnijKwotePrzelewu("500");
        StronaGlownaData.wypelnijNazweAdresOdbiorcy("Urząd Miasta, Al. Marszałka Piłsudskiego 52/54 81-382 Gdynia");
        StronaGlownaData.wypelnijTytulPrzelewu("To jest tytul przelewu ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        StronaGlownaData.zatwierdzPrzelewZwykly();


        //Sprawdzenie czy komunikat wyświetla się na stronie
        Assert.assertEquals(StronaGlownaData.getPrzelewWyslanyKomunikat().isDisplayed(), true);

        //Sprawdzenie czy komunikat przelewu wyświetla się poprawnie na ekranie sukcesu
        Assert.assertEquals(StronaGlownaData.getPrzelewWyslanyKomunikat().getText(), "Przelew został wykonany");

        //Sprawdzenie czy wprowadzony tytul przelewu wyświetla się poprawnie na ekranie sukcesu
        Assert.assertEquals(StronaGlownaData.getPrzelewWyslanyTytul().getText(), "To jest tytul przelewu");

        StronaGlownaData.wrocNaStroneGlowna();
        driver.quit();

    }


    @Test(priority = 2)

    public void dodanieOdbiorcy() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login.ingbank.pl/mojeing/demo/#home");
        driver.manage().window().maximize();
        UslugiNarzedziaData UslugiNarzedziaData = new UslugiNarzedziaData(driver);
        UslugiNarzedziaData.przejdzDoListyOdbiorcow();
        UslugiNarzedziaData.przejdzDoFormatkiDodajOdbiorce();
        UslugiNarzedziaData.wypelnijNazweOdbiorcy("Rafał Mazur");
        UslugiNarzedziaData.wypelnijNazweAdresOdbiorcy("Kantorowa 23/11 21-008 Lublin");
        UslugiNarzedziaData.wypelnijNumerKonta("08105014326360222607826307");
        UslugiNarzedziaData.wypelnijNumerTelefonu("502605311");
        UslugiNarzedziaData.akceptujDodajOdbiorce();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        UslugiNarzedziaData.potwierdzDodajOdbiorce();

        //Przejście do listy odbiorców i sprawdzenie czy odbiorca którego dodaliśmy jest na liście.
        UslugiNarzedziaData.przejdzDoOdbiorcow();
        UslugiNarzedziaData.wyszukajOdbiorce("Rafał");
        Assert.assertEquals(UslugiNarzedziaData.getNazwaDodanegoOdbiorcy().getText(), "Rafał");

        //Usunięcie dodanego odbiorcy
        UslugiNarzedziaData.getNazwaDodanegoOdbiorcy().click();
        UslugiNarzedziaData.usunOdbiorce();

        driver.quit();
    }


    @Test(priority = 3)
    public void wyslaniePrzelewuDoZus() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login.ingbank.pl/mojeing/demo/#home");
        driver.manage().window().maximize();
        StronaGlownaFirmowaData StronaGlownaFirmowaData = new StronaGlownaFirmowaData(driver);
        StronaGlownaFirmowaData.przejdzDoKontekstuFirmowego();
        StronaGlownaFirmowaData.przejdzDoFirmowegoPrzelewu();
        //JavascriptExecutor jsx = (JavascriptExecutor)driver;
        //jsx.executeScript("window.scrollBy(0,450)", "");
        StronaGlownaFirmowaData.przejdzDoPrzelewuDoZus();
        StronaGlownaFirmowaData.wypelnijKwotyZus("111", "222",
                "333", "444");
        StronaGlownaFirmowaData.wypelnijDeklaracje("02", "06", "2022");
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,350)", "");
        StronaGlownaFirmowaData.wypelnijNazwePlatnika("Janusz Tracz");
        StronaGlownaFirmowaData.akceptujPrzelewDoZus();
        driver.quit();

    }


}



