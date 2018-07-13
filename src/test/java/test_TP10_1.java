import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class test_TP10_1 {

    WebDriver driver;
    AccueilPage homepage;

    @Before
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.airFrance.fr");
        homepage = new AccueilPage(driver);
    }

    @Test
    public void test1(){
        String contactFooter = "#idLink_footer_tab1_0 > span:nth-child(1)";
        String contactHeader = "#idContactLink";

        homepage.openAccueilPage(driver);
        homepage.openContactPage(contactFooter, driver);
        homepage.openEnregistrementPage();
        EnregistrementPage enregistrementpage = new EnregistrementPage(driver);
        homepage.openContactPage(contactHeader, driver);
        WebDriverWait wait = new WebDriverWait(driver, 10 );
        wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.cssSelector("#headerStandardDiv > div > h1"))));
        ArrayList<String> listHandles = new ArrayList<>(driver.getWindowHandles());
        ContactPage pagecontact = new ContactPage(driver);
        WebElement contact = driver.findElement(By.cssSelector("#headerStandardDiv > div > h1"));
        Assert.assertEquals("NOUS CONTACTER", pagecontact.getTitle(contact));
        homepage.changerPage(driver, listHandles.get(0));
        homepage.openAchatBilletPage(driver);
        homepage.changerPage(driver,listHandles.get(1));
        homepage.closeContactPage(driver);
        homepage.changerPage(driver, listHandles.get(0));
        homepage.openReservationPage(driver);
        homepage.openAchatEnLigne(driver);
        homepage.openAPropos(driver);
        homepage.openAutreSite(driver);
        homepage.openDestination(driver);
        homepage.openAccueilPage(driver);

    }



    @Test
    public void test2(){

        homepage.allerRetour(driver);
        homepage.villeDepart(driver, "CDG");
        homepage.villeArrivee(driver, "CCS");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homepage.dateDepart(driver, "21/12/2018");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homepage.dateRetour(driver, "11/01/2019");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homepage.nbAdulte(driver, 2);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HorairesTarifPage horaireTarif = homepage.rechercher(driver);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        horaireTarif.meilleurTarifAller(driver, 1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        horaireTarif.meilleurTarifRetour(driver, 1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DetailsVoyagePage detailVoyage = horaireTarif.rechercher(driver);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        detailVoyage.choixClasseVoyageAller(driver, "light");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        detailVoyage.choixClasseVoyageRetour(driver);
        /*DonneesPersonnellesPage donneesPersonnelles1 = detailVoyage.continuer(driver);
        donneesPersonnelles1.setCivilite(1, "M.");
        donneesPersonnelles1.setNom(1, "Plouf");
        donneesPersonnelles1.setPrenom(1, "Toto");
        donneesPersonnelles1.setDateNaissance(1, "01/01/1980");
        donneesPersonnelles1.setPays();
        donneesPersonnelles1.setTelephone();
        donneesPersonnelles1.setEmail();
        donneesPersonnelles1.setConfirmationEmail();
        DonneesPersonnellesPage donneesPersonnelles2 = detailVoyage.continuer(driver);
        donneesPersonnelles2.setCivilite(2, "Mme.");
        donneesPersonnelles2.setNom(2, "Plaf");
        donneesPersonnelles2.setPrenom(2, "Tata");
        donneesPersonnelles2.setDateNaissance(2, "02/02/1990");
        donneesPersonnelles1.choixAssurance();
        donneesPersonnelles1.conditionsGenerales();
        PaiementPage paiement = donneesPersonnelles1.payer(driver);
        Assert.assertEquals("2368.00", driver.findElement(By.id("idAmountTotal")));
   */ }

    /*

@Test
public void test3(){

    homepage.aller("ORY", "NCE");
    homepage.dateDepart("16/08/2018");
    homepage.nbAdulte("1");
    HorairesTarifPage horaireTarif = homepage.rechercher(driver);
    horaireTarif.meilleurTarifAller(5);
    DetailsVoyagePage detailVoyage = horaireTarif.rechercher(driver);
    detailVoyage.choixClasseVoyageAller();
    DonneesPersonnellesPage donneesPersonnelles1 = detailVoyage.continuer(driver);
    donneesPersonnelles1.setCivilite(1, "M.");
    donneesPersonnelles1.setNom(1, "Plouf");
    donneesPersonnelles1.setPrenom(1, "Toto");
    donneesPersonnelles1.setDateNaissance(1, "01/01/1980");
    donneesPersonnelles1.setPays();
    donneesPersonnelles1.setTelephone();
    donneesPersonnelles1.setEmail();
    donneesPersonnelles1.setConfirmationEmail();
    donneesPersonnelles1.choixAssurance();
    donneesPersonnelles1.conditionsGenerales();
    donneesPersonnelles1.choixSiege();
    PaiementPage paiement = donneesPersonnelles1.payer(driver);
    Assert.assertEquals("2368.00", driver.findElement(By.id("idAmountTotal")));
}
*/
    @After
    public void tearDown(){
        driver.quit();
    }
}
