import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsVoyagePage extends Footer{


    public void choixClasseVoyageAller(WebDriver driver, String classe){
        String nbre;
        if(classe == "light")
            nbre = "00";
        else if(classe == "standard")
            nbre = "01";
        else
            nbre = "02";


        String adresse = "//*[@id='productTitle" + nbre +"']/span[1]";
        driver.findElement(By.xpath(adresse)).click();
        System.out.println("hello");
    }

    public void choixClasseVoyageRetour(WebDriver driver){
        driver.findElement(By.cssSelector("#label_productSelect10")).click();
    }

    public DonneesPersonnellesPage continuer( WebDriver driver){

        driver.findElement(By.id("idValidateFormButtonCustom")).click();
        DonneesPersonnellesPage donneesPersonnelles = new DonneesPersonnellesPage(driver);
        return donneesPersonnelles;
    }


    public DetailsVoyagePage(WebDriver driver) {
        super(driver);
    }








}
