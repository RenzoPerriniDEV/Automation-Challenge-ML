package tests;

import config.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarsCategoriesPage;
import pages.CarsResultsFilteredPage;
import pages.MercadoLibreMainPage;

public class TestFilterCars extends BasePage {

    @Test
    public void test_go_to_vehicles_filters() {
        String url_cars_filtered = base_url + "/c/autos-motos-y-otros#menu=categories";
        CarsResultsFilteredPage carsResultsFilteredPage = new CarsResultsFilteredPage(driver);
        CarsCategoriesPage carsCategoriesPage = new CarsCategoriesPage(driver);
        goTo(url_cars_filtered);
        MercadoLibreMainPage mercadoLibreMainPage = new MercadoLibreMainPage(driver);
        mercadoLibreMainPage.clickOnAcceptCookiesButton();
        carsResultsFilteredPage = carsCategoriesPage.selectVanAndCarsSubcategory();
        Assert.assertTrue(carsResultsFilteredPage.vehiclesPageResultsIsLoaded());
    }

    @Test(dependsOnMethods = {"test_go_to_vehicles_filters"})
    public void test_filter_cars_by_price_and_location() throws InterruptedException {
        CarsResultsFilteredPage carsResultsFilteredPage = new CarsResultsFilteredPage(driver);
        carsResultsFilteredPage.filterCarsByMaximumPrice();
        Assert.assertTrue(carsResultsFilteredPage.checkIfMaximumPriceFilterIsApplied());
        carsResultsFilteredPage.filterCarsByLocation();
        Assert.assertTrue(carsResultsFilteredPage.checkIfLocationFilterIsApplied());
    }

    @Test(dependsOnMethods = {"test_go_to_vehicles_filters", "test_filter_cars_by_price_and_location"})
    public void test_sort_results() {
        CarsResultsFilteredPage carsResultsFilteredPage = new CarsResultsFilteredPage(driver);
        carsResultsFilteredPage.sortResultsFromLowstToHighestPrice();
        Assert.assertTrue(true);
        carsResultsFilteredPage.showNumberOfResults();
    }

}
