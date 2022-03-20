package tests;

import config.BasePage;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.CarsCategoriesPage;
import pages.MercadoLibreMainPage;

public class TestGoToVehiclesPageCars extends BasePage {

    @Test(groups = {"ML Regression"})
    public void test_go_to_vehicles_page() {
        goTo(base_url);
        MercadoLibreMainPage mercadoLibreMainPage = new MercadoLibreMainPage(driver);
        mercadoLibreMainPage.clickOnAcceptCookiesButton();
        mercadoLibreMainPage.clickOnCategoriesMenuLink();
        CarsCategoriesPage carsCategoriesPage;
        carsCategoriesPage = mercadoLibreMainPage.clickOnCarsOptionFromDropDownMenu();
        Assert.assertTrue(carsCategoriesPage.vehiclesPageIsLoaded());
    }

}
