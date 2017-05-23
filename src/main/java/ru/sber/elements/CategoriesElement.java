package ru.sber.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import qa.pageobject.Page;
import ru.sber.data.Category;

/**
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class CategoriesElement extends Page {

    private String mainCategoryHoverSelector = ".topmenu__item_opened_yes";
    private String mainCategorySelector = ".topmenu__link[href*='/catalog/%s']";
    private String subCategorySelector = ".topmenu__subitem[href*='%s']";

    public CategoriesElement(WebDriver driver) {
        super(driver);
    }

    /**
     * Наводить фокус на главную категорию
     * @param category
     */
    public void hoverOnMainCategory(Category category) {
        String selector = String.format(mainCategorySelector, category.getId());
        new Actions(driver).moveToElement(element(By.cssSelector(selector))).perform();
    }

    /**
     * Кликает по вложенной категории
     * @param category
     */
    public void clickOnSubCategory(Category category) {
        String selector = String.format(subCategorySelector, category.getId());
        element(By.cssSelector(selector)).click();
    }

    /**
     * Проверяет что отображается список вложенных категорий
     */
    public boolean isSubCategoriesPresent() {
        return waitForElementPresent(By.cssSelector(mainCategoryHoverSelector));
    }
}
