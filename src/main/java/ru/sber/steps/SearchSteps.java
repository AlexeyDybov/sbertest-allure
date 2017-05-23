package ru.sber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.pageobject.Steps;
import ru.sber.elements.SearchElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Шаги для работы с элементом поиска
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class SearchSteps extends Steps {

    private SearchElement searchElement;

    public SearchSteps(WebDriver driver) {
        super(driver);
        searchElement = PageFactory.initElements(driver, SearchElement.class);
    }

    /**
     * Вводит поисковый запрос в поле
     * @param searchRequest
     */
    @Step
    public void setSearchRequest(String searchRequest) {
        searchElement.setSearchRequest(searchRequest);
    }

    /**
     * Нажимает кнопку Найти
     */
    @Step
    public void clickSearchButton() {
        searchElement.clickSearchButton();
    }
}
