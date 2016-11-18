package ru.sber.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.abstracts.Page;

/**
 * Элемент поисковой строки маркета
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class SearchElement extends Page {

    @FindBy(css = "#header-search")
    private WebElement searchRequestField;
    @FindBy(css = ".search2__button>button")
    private WebElement searchButton;

    public SearchElement(WebDriver driver) {
        super(driver);
    }

    /**
     * Вводить поисковый запрос в поле
     * @param searchRequest
     */
    public void setSearchRequest(String searchRequest) {
        searchRequestField.sendKeys(searchRequest);
    }

    /**
     * Нажимает кнопку Найти
     */
    public void clickSearchButton() {
        searchButton.click();
    }
}
