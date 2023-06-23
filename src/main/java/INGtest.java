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


public class INGtest extends BaseTest {




    @Test(priority = 1)

    public void wyslaniePrzelewu() {
        StronaGlownaData stronaGlownaData = new StronaGlownaData(driver);
        stronaGlownaData.
                przejdzDoZwyklegoPrzelewu().
                wypelnijKwotePrzelewu("500").
                wypelnijNazweAdresOdbiorcy("Urząd Miasta, Al. Marszałka Piłsudskiego 52/54 81-382 Gdynia").
                wypelnijTytulPrzelewu("To jest tytul przelewu ").
                zatwierdzPrzelewZwykly();


        //Sprawdzenie czy komunikat wyświetla się na stronie
        Assert.assertEquals(stronaGlownaData.getPrzelewWyslanyKomunikat().isDisplayed(), true);

        //Sprawdzenie czy komunikat przelewu wyświetla się poprawnie na ekranie sukcesu
        Assert.assertEquals(stronaGlownaData.getPrzelewWyslanyKomunikat().getText(), "Przelew został wykonany");

        //Sprawdzenie czy wprowadzony tytul przelewu wyświetla się poprawnie na ekranie sukcesu
        Assert.assertEquals(stronaGlownaData.getPrzelewWyslanyTytul().getText(), "To jest tytul przelewu");

        //stronaGlownaData.wrocNaStroneGlowna();

    }


    @Test(priority = 2)

    public void dodanieOdbiorcy() {
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

    }


    @Test(priority = 3)
    public void wyslaniePrzelewuDoZus() {
        StronaGlownaFirmowaData StronaGlownaFirmowaData = new StronaGlownaFirmowaData(driver);
        StronaGlownaFirmowaData.przejdzDoKontekstuFirmowego();
        StronaGlownaFirmowaData.przejdzDoFirmowegoPrzelewu();
        StronaGlownaFirmowaData.przejdzDoPrzelewuDoZus();
        StronaGlownaFirmowaData.wypelnijKwotyZus("111", "222",
                "333", "444");
        StronaGlownaFirmowaData.wypelnijDeklaracje("02", "06", "2022");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        StronaGlownaFirmowaData.wypelnijNazwePlatnika("Janusz Tracz");
        StronaGlownaFirmowaData.akceptujPrzelewDoZus();




    }



    @Test(priority = 2)
    public void przejdzDoHistorii(){
        StronaGlownaFirmowaData StronaGlownaFirmowaData = new StronaGlownaFirmowaData(driver);
        StronaGlownaFirmowaData.przejdzDoKontekstuFirmowego();
        StronaGlownaFirmowaData.wyswietlenieHistorii();

        //Sprawdzenie czy komunikat wyświetla się na stronie
        Assert.assertEquals(StronaGlownaFirmowaData.getHistoriaTransakcji().isDisplayed(), true);

        //Sprawdzenie czy tekst Historia transakcji wyświetla się poprawnie na ekranie
        Assert.assertEquals(StronaGlownaFirmowaData.getHistoriaTransakcji().getText(), "Historia transakcji");


        driver.quit();
    }


    @Test(priority = 2)
    public void przejdzDoLogout() {
        StronaGlownaFirmowaData stronaGlownaFirmowaData = new StronaGlownaFirmowaData(driver);
        stronaGlownaFirmowaData.
                przejdzDoKontekstuFirmowego().
                przejdzDoLogout();

        Assert.assertEquals(stronaGlownaFirmowaData.getSafeLogout().isDisplayed(), true);

        Assert.assertEquals(stronaGlownaFirmowaData.getSafeLogout().getText(), "Bezpiecznie wylogowaliśmy Cię z Mojego ING. Do zobaczenia!");
    }

}



