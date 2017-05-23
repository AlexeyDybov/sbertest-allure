package ru.sber;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.annotations.Driver;
import qa.runners.FetaRunner;
import ru.sber.data.Category;
import ru.sber.data.Vendor;
import ru.sber.steps.*;

import java.util.List;

/**
 * Фильтры в маркете
 */
@RunWith(FetaRunner.class)
public class MarketFilter_Test {

    private HomeSteps homeSteps;
    private MarketSteps marketSteps;
    private CategoriesSteps categoriesSteps;
    private FilterSteps filterSteps;
    private ResultsSteps resultsSteps;
    private SearchSteps searchSteps;
    private ItemSteps itemSteps;

    @Driver
    public WebDriver driver;



    @Before
    public void setUp() {
//        driver = WebDriverFactory.getDriverInstance();
        homeSteps = new HomeSteps(driver);
        marketSteps = new MarketSteps(driver);
        categoriesSteps = new CategoriesSteps(driver);
        filterSteps = new FilterSteps(driver);
        resultsSteps = new ResultsSteps(driver);
        searchSteps = new SearchSteps(driver);
        itemSteps = new ItemSteps(driver);
    }

    @Test
    public void marketFilter() {
        homeSteps.openHomePage();
        homeSteps.clickMarket();
        marketSteps.marketPageShouldBeOpened();

        categoriesSteps.hoverOnMainCategories(Category.Computers);
        categoriesSteps.subCategoriesListShouldBePresent();
        categoriesSteps.clickOnSubCategories(Category.Notebooks);
        marketSteps.marketPageShouldBeOpened(Category.Notebooks);

        resultsSteps.resultsShouldBePresent();
        List<WebElement> webElement = resultsSteps.getResultsElement();
        filterSteps.setMaxPrice("30000");
        filterSteps.setVendor(Vendor.HP);
        filterSteps.setVendor(Vendor.Lenovo);
        filterSteps.clickApplyButton();
        resultsSteps.waitForResultsRefreshed(webElement);
        resultsSteps.resultCountShouldBeEqual(12);
        String itemName = resultsSteps.getItemName(1);

        searchSteps.setSearchRequest(itemName);
        searchSteps.clickSearchButton();

        itemSteps.itemPageShouldBeOpened();
        itemSteps.itemNameShouldBeEqual(itemName);
    }

    @Test
    public void marketFilter1() {
        homeSteps.openHomePage();
        homeSteps.clickMarket();
        marketSteps.marketPageShouldBeOpened();

        categoriesSteps.hoverOnMainCategories(Category.Computers);
        categoriesSteps.subCategoriesListShouldBePresent();
        categoriesSteps.clickOnSubCategories(Category.Tablet);
        marketSteps.marketPageShouldBeOpened(Category.Tablet);

        resultsSteps.resultsShouldBePresent();
        List<WebElement> webElement = resultsSteps.getResultsElement();
        filterSteps.setMinPrice("20000");
        filterSteps.setMaxPrice("25000");
        filterSteps.clickMoreVendorButton();
        filterSteps.setVendor(Vendor.Acer);
        filterSteps.setVendor(Vendor.DELL);
        filterSteps.clickApplyButton();
        resultsSteps.waitForResultsRefreshed(webElement);
        resultsSteps.resultCountShouldBeEqual(12);
        String itemName = resultsSteps.getItemName(1);

        searchSteps.setSearchRequest(itemName);
        searchSteps.clickSearchButton();

        itemSteps.itemPageShouldBeOpened();
        itemSteps.itemNameShouldBeEqual(itemName);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
