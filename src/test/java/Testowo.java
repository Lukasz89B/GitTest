import org.apache.commons.io.FileUtils;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Testowo {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lukas\\OneDrive\\Pulpit\\selenium\\chromedriver_win32\\2\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.pl/");

    }
    @Test
    public void wyszukiwanie() throws IOException {
        BasePage basePage = new BasePage(driver);
        basePage.search("test");
        WyszukanaStrona wyszukanaStrona = new WyszukanaStrona(driver);
        wyszukanaStrona.grafiki("dom");

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\lukas\\OneDrive\\Pulpit\\selenium\\skriny\\pliczek.jpg"));
    }
    @After
    public void tangoDown(){
        driver.quit();
    }

}
