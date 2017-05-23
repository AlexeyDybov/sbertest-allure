package ru.sber.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.pageobject.Steps;
import ru.sber.data.Category;
import ru.sber.pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Шаги для работы со страницей маркета
 * @author Alexey Dybov
 * @created 17.11.16
 */
public class MarketSteps extends Steps {

    private MarketPage marketPage;

    public MarketSteps(WebDriver driver) {
        super(driver);
        marketPage = PageFactory.initElements(driver, MarketPage.class);
    }

    /**
     * Проверяет что открылась страница
     */
    @Step
    public void marketPageShouldBeOpened() {
        Assert.assertTrue("Не открылась страница яндекс маркета", marketPage.isPageOpened());
    }

    /**
     * Проверяет что открыта страница маркета для конкретной категории
     * @param category
     */
    @Step
    public void marketPageShouldBeOpened(Category category) {
        Assert.assertTrue(String.format("Не открылась страница яндекс маркета для категории товаров [%s]", category),
            marketPage.isPageOpened(category));
    }
}
