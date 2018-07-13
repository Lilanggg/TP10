import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DonneesPersonnellesPage extends Footer {


    public void setCivilite(){

    }

    public void setNom(){

    }

    public void setPrenom(){

    }

    public void setDateNaissance(){

    }

    public void setPays(){

    }

    public void setTelephone(){

    }

    public void setEmail(){

    }

    public void setConfirmationEmail(){

    }

    public void choixAssurance(){

    }

    public void acceptTarif(){


    }

    public void paiement(){

    }

    public void conditionsGenerales() {

    }

    public void choixSiege(){

    }

    public PaiementPage payer( WebDriver driver){

        driver.findElement(By.id("idValidateFormButtonDPA")).click();
        PaiementPage paiement = new PaiementPage(driver);
        return paiement;
    }

    public DonneesPersonnellesPage(WebDriver driver) {
        super(driver);
    }

}
