import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HorairesTarifPage extends Footer{



    public void meilleurTarifAller(WebDriver driver, int i){
        int chiffre = i-1;
        String adresse = "#bound_0_reco_" + chiffre + "_fare_ICALIGHT";
        driver.findElement(By.cssSelector(adresse)).click();
    }

    public void meilleurTarifRetour(WebDriver driver, int i){
        int chiffre = i-1;
        String adresse = "#bound_1_reco_" + chiffre + "_fare_ICALIGHT";
        driver.findElement(By.cssSelector(adresse)).click();
    }

    public DetailsVoyagePage rechercher( WebDriver driver){

       driver.findElement(By.id("idValidateFormButtonFlight")).click();
       DetailsVoyagePage detailVoyage = new DetailsVoyagePage(driver);

       return detailVoyage;
    }

    public HorairesTarifPage(WebDriver driver) {
        super(driver);
    }
}
