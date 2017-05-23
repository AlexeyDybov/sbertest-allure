package ru.sber.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import qa.pageobject.Steps;
import ru.sber.elements.ResultsElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Шаги для работы с элементом результаты поиска
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class ResultsSteps extends Steps {

    private ResultsElement resultsElement;

    public ResultsSteps(WebDriver driver) {
        super(driver);
        resultsElement = PageFactory.initElements(driver, ResultsElement.class);
    }

    /**
     * Проверяет что отображается элемент результатов поиска
     */
    @Step
    public void resultsShouldBePresent() {
        Assert.assertTrue("Не отображаются результаты поиска", resultsElement.isResultsPresent());
    }

    /**
     * Проверяет кол-во результатов
     * @param count
     */
    @Step
    public void resultCountShouldBeEqual(int count) {
        Assert.assertEquals("Неверное количество товаров на странице результатов поиска",
            count, resultsElement.getResultCount());
    }

    /**
     * Получает имя элемента по индексу
     * @param i
     * @return
     */
    public String getItemName(int i) {
        return resultsElement.getResultName(i - 1);
    }

    /**
     * Получает элемент результатов поиска
     * @return
     */
    public List<WebElement> getResultsElement() {
        return resultsElement.getResultsElement();
    }

    public void waitForResultsRefreshed(List<WebElement> webElement) {
        for (int i = 1; i <= implicitWait; i++) {
            if (!webElement.equals(resultsElement.getResultsElement())) return;
            waitFor(1000);
        }
        throw new AssertionError("Не обновились результаты поиска");
    }
}
