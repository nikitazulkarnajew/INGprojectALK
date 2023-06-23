import Data.StronaGlownaData;
import Data.StronaGlownaFirmowaData;
import Data.UslugiNarzedziaData;
import org.testng.Assert;
import org.testng.annotations.Test;


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


        Assert.assertEquals(stronaGlownaData.getPrzelewWyslanyKomunikat().isDisplayed(), true);

        Assert.assertEquals(stronaGlownaData.getPrzelewWyslanyKomunikat().getText(), "Przelew został wykonany");

        Assert.assertEquals(stronaGlownaData.getPrzelewWyslanyTytul().getText(), "To jest tytul przelewu");

    }


    @Test(priority = 2)

    public void dodanieOdbiorcy() {
        UslugiNarzedziaData uslugiNarzedziaData = new UslugiNarzedziaData(driver);
        uslugiNarzedziaData.
                przejdzDoListyOdbiorcow().
                przejdzDoFormatkiDodajOdbiorce().
                //przejdzDoFormatkiDodajOdbiorce().
                wypelnijNazweOdbiorcy("Rafał Mazur").
                wypelnijNazweAdresOdbiorcy("Kantorowa 23/11 21-008 Lublin").
                wypelnijNumerKonta("08105014326360222607826307").
                wypelnijNumerTelefonu("502605311").
                akceptujDodajOdbiorce().
                potwierdzDodajOdbiorce().
                przejdzDoOdbiorcow().
                wyszukajOdbiorce("Rafał");

        //Przejście do listy odbiorców i sprawdzenie czy odbiorca którego dodaliśmy jest na liście.
        Assert.assertEquals(uslugiNarzedziaData.getNazwaDodanegoOdbiorcy().getText(), "Rafał");

        //Usunięcie dodanego odbiorcy
        uslugiNarzedziaData.getNazwaDodanegoOdbiorcy().click();
        uslugiNarzedziaData.usunOdbiorce();

    }


    @Test(priority = 3)
    public void wyslaniePrzelewuDoZus() {
        StronaGlownaFirmowaData stronaGlownaFirmowaData = new StronaGlownaFirmowaData(driver);
        stronaGlownaFirmowaData.
                przejdzDoKontekstuFirmowego().
                przejdzDoFirmowegoPrzelewu().
                przejdzDoPrzelewuDoZus().
                wypelnijKwotyZus("111", "222", "333", "444").
                wypelnijDeklaracje("02", "06", "2022").
                wypelnijNazwePlatnika("Janusz Tracz").
                akceptujPrzelewDoZus();

    }



    @Test(priority = 2)
    public void przejdzDoHistorii(){
        StronaGlownaFirmowaData stronaGlownaFirmowaData = new StronaGlownaFirmowaData(driver);
        stronaGlownaFirmowaData.
                przejdzDoKontekstuFirmowego().
                wyswietlenieHistorii();

        Assert.assertEquals(stronaGlownaFirmowaData.getHistoriaTransakcji().isDisplayed(), true);

        Assert.assertEquals(stronaGlownaFirmowaData.getHistoriaTransakcji().getText(), "Historia transakcji");

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



