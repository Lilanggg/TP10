import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage extends Header{

    public String getTitle(WebElement titre){

        return titre.getText();

    }

    public ContactPage(WebDriver driver){
        super(driver);
    }

}
