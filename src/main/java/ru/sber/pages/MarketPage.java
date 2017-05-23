package ru.sber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.pageobject.Page;
import ru.sber.data.Category;

/**
 * Страница Маркет
 * @author Alexey Dybov
 * @created 17.11.16
 */
public class MarketPage extends Page {

    @FindBy(css = "body[data-bem*='market']")
    private WebElement mainElement;

    private String mainElementCategorySelector= "body[data-bem*='market'][data-bem*='%s']";

    public MarketPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Проверяет что страница открылась
     * @return
     */
    public boolean isPageOpened() {
        return waitForElementPresent(mainElement);
    }

    public boolean isPageOpened(Category category) {
        return waitForElementPresent(By.cssSelector(String.format(mainElementCategorySelector, category.getId())));
    }
}
