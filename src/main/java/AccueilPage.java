import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class AccueilPage extends Header{

    public void aller(){

    }

    public void allerRetour(WebDriver driver){
        driver.findElement(By.id("minibe__roundTrip--label")).click();

    }

    public void villeDepart(WebDriver driver, String aeroport){
        driver.findElement(By.id("minibe__od--out")).click();
        driver.findElement(By.id("minibe__od--out")).sendKeys(aeroport + Keys.ENTER);

    }

    public void villeArrivee(WebDriver driver, String aeroport){
        driver.findElement(By.id("minibe__od--in")).click();
        driver.findElement(By.id("minibe__od--in")).sendKeys(aeroport + Keys.ENTER);

    }

    public void dateDepart(WebDriver driver, String date){


        String values[]  = date.split("/");
        String anneeMois = values[2] + values[1];
        String idCalendar = "calendar--" + anneeMois + values[0];
        WebElement calendar = driver.findElement(By.id(idCalendar));

        WebDriverWait wait = new WebDriverWait(driver, 10 );
        wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//*[@id=\"calendar\"]/header/div[2]/button[2]/img"))));

        if(!calendar.isDisplayed()) {
            while (!calendar.isDisplayed()) {
                WebDriverWait wait3 = new WebDriverWait(driver, 10);
                wait3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"calendar\"]/header/div[2]/button[2]/img"))));
                driver.findElement(By.xpath("//*[@id=\"calendar\"]/header/div[2]/button[2]/img")).click();

            }
        }

        WebDriverWait wait2 = new WebDriverWait(driver, 10 );
        wait2.until(ExpectedConditions.visibilityOf( driver.findElement(By.id(idCalendar))));


        driver.findElement(By.id(idCalendar)).click();


    }
    public void dateRetour(WebDriver driver, String date){

        String values[]  = date.split("/");
        String anneeMois = values[2] + values[1];
        String idCalendar = "calendar--" + anneeMois + values[0];
        WebElement calendar = driver.findElement(By.id(idCalendar));

        WebDriverWait wait = new WebDriverWait(driver, 10 );
        wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//*[@id=\"calendar\"]/header/div[2]/button[2]/img"))));

        if(!calendar.isDisplayed()) {
            while (!calendar.isDisplayed()) {
                WebDriverWait wait3 = new WebDriverWait(driver, 10);
                wait3.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"calendar\"]/header/div[2]/button[2]/img"))));
                driver.findElement(By.xpath("//*[@id=\"calendar\"]/header/div[2]/button[2]/img")).click();

            }
        }

        WebDriverWait wait2 = new WebDriverWait(driver, 10 );
        wait2.until(ExpectedConditions.visibilityOf( driver.findElement(By.id(idCalendar))));


        driver.findElement(By.id(idCalendar)).click();



    }

    public void nbAdulte(WebDriver driver, int nbre){
        String adresseNbAdulte = "//*[@id='typology__paxNum']/div/label[" + nbre + "]";
        driver.findElement(By.id("pax__label")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10 );
        wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath(adresseNbAdulte))));
        driver.findElement(By.xpath(adresseNbAdulte)).click();


    }

    public void changerPage(WebDriver driver, String windowHandle){
        driver.switchTo().window(windowHandle);


    }

    public void closeContactPage(WebDriver driver){
        driver.close();
    }

    public HorairesTarifPage rechercher( WebDriver driver){

        driver.findElement(By.id("minibe__button--search")).click();
        HorairesTarifPage horaireTarif = new HorairesTarifPage(driver);
        return horaireTarif;
    }

    public AccueilPage(WebDriver driver){
        super(driver);
    }


}
