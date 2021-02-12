package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    @FindBy(name = "q")
    private WebElement poleTekstowe;

    @FindBy(name ="btnK")
    private WebElement szukaj;

    public  BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void search(String pole) {
        poleTekstowe.clear();
        poleTekstowe.sendKeys(pole);
        poleTekstowe.submit();
    }

}


