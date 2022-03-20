package pages;

import config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MercadoLibreMainPage extends BasePage {

    //All the objects page are instanced
    public MercadoLibreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Accept cookies button
    @FindBy(xpath = "//button[@data-testid='action:understood-button']")
    WebElement accept_cookies_button;

    //Notify after saving cookies
    @FindBy(xpath = "//button[@class='cookie-consent-snackbar__close']")
    WebElement notify_personal_data_saved;

    //Link that opens menu with categories
    @FindBy(className = "nav-menu-categories-link")
    WebElement menu_categories_link;

    //Dropdown menu with categories
    @FindBy(xpath = "//ul[@class='nav-categs-departments']")
    WebElement menu_categories;

    //Overlay after click on link menu with categories
    @FindBy(xpath = "//div[@class='nav-categs-overlay']")
    WebElement overlay;

    //Cars option from dropdown menu
    @FindBy(xpath = "//ul//li//a[.='Vehículos']")
    WebElement category_option_cars;

    //Car option from page
    @FindBy(xpath = "//p[.='Autos, Motos y Otros']")
    WebElement car_option_page;

    //Accept cookies
    public void clickOnAcceptCookiesButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(accept_cookies_button));
        accept_cookies_button.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(notify_personal_data_saved));
        notify_personal_data_saved.click();
    }

    //Click on categories menu
    public void clickOnCategoriesMenuLink() {
        webDriverWait.until(ExpectedConditions.visibilityOf(menu_categories_link));
        menu_categories_link.click();
    }

    //It expects that dropdown menu is loaded and selects cars option
    public CarsCategoriesPage clickOnCarsOptionFromDropDownMenu() {
        CarsCategoriesPage carsCategoriesPage = new CarsCategoriesPage(driver);
        webDriverWait.until(ExpectedConditions.visibilityOf(menu_categories));
        webDriverWait.until(ExpectedConditions.visibilityOf(overlay));
        webDriverWait.until(ExpectedConditions.visibilityOf(category_option_cars));
        category_option_cars.click();
        return carsCategoriesPage;
    }

}
