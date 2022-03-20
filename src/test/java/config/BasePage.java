package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage {

    public static WebDriver driver;
    public static String base_url = "https://www.mercadolibre.com.ar";
    public static WebDriverWait webDriverWait;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void afterClass() { driver.quit();}

    public void goTo(String url) {
        driver.get(url);
    }
}
