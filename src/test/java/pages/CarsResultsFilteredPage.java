package pages;

import config.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarsResultsFilteredPage extends BasePage {

    public CarsResultsFilteredPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Filter input maximum price
    @FindBy(id = "Maximum-price")
    WebElement maximum_price_input;

    //Maximum price filter submit
    @FindBy(xpath = "//button[@data-testid='submit-price']")
    WebElement maximum_price_submit_button;

    //Maximum price filter applied button
    @FindBy(xpath = "//div[@class='andes-tag__label'][.='Hasta $ 2.000.000']")
    WebElement maximum_price_set_button;

    //Filter location
    @FindBy(xpath = "//span[@class='ui-search-filter-name'][.='Córdoba']")
    WebElement location_button_filter;

    //Location filter applied button
    @FindBy(xpath = "//div[@class='andes-tag__label'][.='Córdoba']")
    WebElement location_set_button;

    //Sort main price button
    @FindBy(xpath = "//button[@aria-label='Más relevantes']")
    WebElement sort_main_price_button;

    //Sort lowest price button
    @FindBy(xpath = "//div[@class='andes-list__item-primary'][.='Menor precio']")
    WebElement sort_lowest_price_button;

    //Number of results filtered
    @FindBy(xpath = "//span[@class='ui-search-search-result__quantity-results']")
    WebElement results_number;

    //Check if vehicles page results is loaded
    public Boolean vehiclesPageResultsIsLoaded() {
        return webDriverWait.until(ExpectedConditions.urlContains("AUTOS-Y-CAMIONETAS"));
    }

    //Check if maximum price is applied
    public Boolean checkIfMaximumPriceFilterIsApplied() {
        webDriverWait.until(ExpectedConditions.visibilityOf(maximum_price_set_button));
        return true;
    }

    //Set maximum price of cars to show
    public void filterCarsByMaximumPrice() throws InterruptedException {
        JavascriptExecutor jsExecutor;
        Actions action = new Actions(driver);
        webDriverWait.until(ExpectedConditions.visibilityOf(maximum_price_input));
        maximum_price_input.click();
        Thread.sleep(1000);
        maximum_price_input.sendKeys("2000000");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(maximum_price_submit_button));
        maximum_price_submit_button.click();
    }

    //Filter by location Córdoba
    public void filterCarsByLocation() {
        webDriverWait.until(ExpectedConditions.visibilityOf(location_button_filter));
        location_button_filter.click();
    }

    //Check if location filter is applied
    public Boolean checkIfLocationFilterIsApplied() {
        webDriverWait.until(ExpectedConditions.visibilityOf(location_set_button));
        return true;
    }

    //Sort results from lowest to highest price
    public void sortResultsFromLowstToHighestPrice() {
        webDriverWait.until(ExpectedConditions.visibilityOf(sort_main_price_button));
        sort_main_price_button.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(sort_lowest_price_button));
        sort_lowest_price_button.click();
    }

    //Show results
    public void showNumberOfResults() {
        webDriverWait.until(ExpectedConditions.visibilityOf(results_number));
        System.out.println("Se encontraron: " + results_number.getText());
    }
}
