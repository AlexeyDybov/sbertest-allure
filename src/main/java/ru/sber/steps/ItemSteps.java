package ru.sber.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.abstracts.Steps;
import ru.sber.pages.ItemPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Шаги для работы со страницей товара
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class ItemSteps extends Steps {

    private ItemPage itemPage;

    public ItemSteps(WebDriver driver) {
        super(driver);
        itemPage = PageFactory.initElements(driver, ItemPage.class);
    }

    /**
     * Проверяет что открыта страница товара
     */
    @Step
    public void itemPageShouldBeOpened() {
        Assert.assertTrue("Должна быть открыта страница товара", itemPage.isPageOpened());
    }

    /**
     * Проверяет имя товара
     * @param itemName
     */
    @Step
    public void itemNameShouldBeEqual(String itemName) {
        Assert.assertEquals("Неверное имя товара", itemName, itemPage.getItemName());
    }
}
