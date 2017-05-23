package ru.sber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.pageobject.Steps;
import ru.sber.data.Vendor;
import ru.sber.elements.FilterElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Шаги для работы с элементом фильтр
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class FilterSteps extends Steps {

    private FilterElement filterElement;

    public FilterSteps(WebDriver driver) {
        super(driver);
        filterElement = PageFactory.initElements(driver, FilterElement.class);
    }

    /**
     * Выставляет минимальную цену
     * @param price
     */
    @Step
    public void setMinPrice(String price) {
        filterElement.setMinPrice(price);
    }

    /**
     * Выставляет максимальную цену
     * @param price
     */
    @Step
    public void setMaxPrice(String price) {
        filterElement.setMaxPrice(price);
    }

    /**
     * Выставляет производителя
     */
    @Step
    public void setVendor(Vendor vendor) {
        filterElement.setVendor(vendor);
    }

    /**
     * Нажимает кнопку применить
     */
    @Step
    public void clickApplyButton() {
        filterElement.clickApplyButton();
    }

    /**
     * Нажимает Еще для производителей
     */
    @Step
    public void clickMoreVendorButton() {
        filterElement.clickMoreVendorButton();
    }
}
