import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AirFrancePage {

    private WebDriver driver;

    public AirFrancePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
