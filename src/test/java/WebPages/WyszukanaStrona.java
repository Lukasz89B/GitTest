package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WyszukanaStrona {
    WebDriver driver;

    @FindBy(name = "q")
    private WebElement poleNaDrugiejStronie;

    public  WyszukanaStrona(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void grafiki(String pole2){
        poleNaDrugiejStronie.clear();
        poleNaDrugiejStronie.sendKeys(pole2);
        poleNaDrugiejStronie.submit();
    }
}
