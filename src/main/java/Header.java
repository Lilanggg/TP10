import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Header extends Footer {

    public void openAccueilPage(WebDriver driver){
        WebElement accueil = driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li[1]/a/span"));
        accueil.click();

    }

    public void openAchatBilletPage(WebDriver driver){
        driver.findElement(By.cssSelector("#idNavBookLink > span:nth-child(1)")).click();

    }

    public void openEnregistrementPage(){

    }

    public void openReservationPage(WebDriver driver){
        driver.findElement(By.cssSelector(".nav__label__resa"));

    }

    public void openContactPage(String cssSelector, WebDriver driver){
        WebElement contact = driver.findElement(By.cssSelector(cssSelector));
        contact.click();

    }

    public Header(WebDriver driver){
        super(driver);
    }
}
