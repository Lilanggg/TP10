import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Footer extends AirFrancePage {

    public void openServiceClient(){

    }

    public void openContactPage(){

    }

    public void openAchatEnLigne(WebDriver driver){
        driver.findElement(By.cssSelector("#idLink_footer_tab2"));

    }

    public void openAPropos(WebDriver driver){
        driver.findElement(By.cssSelector("#idLink_footer_tab3"));

    }

    public void openAutreSite(WebDriver driver){
        driver.findElement(By.cssSelector("#idLink_footer_tab4"));
    }

    public void openDestination(WebDriver driver){
        driver.findElement(By.cssSelector("#idLink_footer_tab5"));

    }

    public Footer(WebDriver driver){
        super(driver);
    }
}
