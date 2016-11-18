package ru.sber.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.abstracts.Page;

import java.util.List;

/**
 * Элемент рузультаты поиска
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class ResultsElement extends Page {

    @FindBy(css = ".filter-applied-results")
    private WebElement resultsElement;
    @FindBy(css = ".snippet-card")
    private List<WebElement> results;

    private String resultNameSelector = ".snippet-card__header-text";

    public ResultsElement(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getResultsElement() {
        return elements(By.cssSelector(".snippet-card"));
    }

    /**
     * Проверяет что отображаются результаты поиска
     * @return
     */
    public boolean isResultsPresent() {
        return waitForElementPresent(resultsElement);
    }

    /**
     * Возвращает ко-во результатов
     * @return
     */
    public int getResultCount() {
        return results.size();
    }

    public String getResultName(int i) {
        return results.get(i).findElement(By.cssSelector(resultNameSelector)).getText();
    }
}
