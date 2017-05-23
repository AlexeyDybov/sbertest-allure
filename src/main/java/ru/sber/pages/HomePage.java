package ru.sber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.pageobject.Page;

/**
 * Главная страница
 * @author Alexey Dybov
 * @created 17.11.16
 */
public class HomePage extends Page {

    @FindBy(css="form.search2")
    private WebElement searchForm;
    @FindBy(css="[data-id='market']")
    private WebElement marketButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openAt();
    }

    public boolean isOpened() {
        return waitForElementPresent(searchForm);
    }

    public void clickMarketButton() {
        marketButton.click();
    }
}
