package pages;

import config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarsCategoriesPage extends BasePage {

    public CarsCategoriesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Cars subcategory item
    @FindBy(xpath = "//div[@data-index='0']//div[@class='carousel__item']//child::h3[.='Autos y Camionetas']")
    WebElement subcategory_cars;

    //Check if vehicles page is loaded
    public Boolean vehiclesPageIsLoaded() {
        return BasePage.webDriverWait.until(ExpectedConditions.urlContains("autos-motos-y-otros"));
    }

    //Select vehicles subcategory
    public CarsResultsFilteredPage selectVanAndCarsSubcategory() {
        CarsResultsFilteredPage carsResultsFilteredPage = new CarsResultsFilteredPage(driver);
        webDriverWait.until(ExpectedConditions.visibilityOf(subcategory_cars));
        subcategory_cars.click();
        return carsResultsFilteredPage;
    }

}
