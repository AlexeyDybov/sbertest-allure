package ru.sber.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.abstracts.Steps;
import ru.sber.data.Category;
import ru.sber.elements.CategoriesElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Шаги для работы с элементом выбора категорий
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class CategoriesSteps extends Steps {

    private CategoriesElement categoriesElement;

    public CategoriesSteps(WebDriver driver) {
        super(driver);
        categoriesElement = PageFactory.initElements(driver, CategoriesElement.class);
    }

    /**
     * Наводить фокус на главную категорию
     * @param category
     */
    @Step
    public void hoverOnMainCategories(Category category) {
        categoriesElement.hoverOnMainCategory(category);

    }

    /**
     * Кликает по вложенной категории
     * @param category
     */
    @Step
    public void clickOnSubCategories(Category category) {
        categoriesElement.clickOnSubCategory(category);
    }

    /**
     * Проверяет что отображается список вложенных категорий
     */
    @Step
    public void subCategoriesListShouldBePresent() {
        Assert.assertTrue("Не появился элемент с вложенными категориями",
            categoriesElement.isSubCategoriesPresent());
    }
}
