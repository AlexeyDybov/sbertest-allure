package ru.sber.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.abstracts.Page;
import ru.sber.data.Vendor;

/**
 * Элемент Фильтр
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class FilterElement extends Page {

    @FindBy(css = "[name='glf-pricefrom-var']")
    private WebElement minPrice;
    @FindBy(css = "[name='glf-priceto-var']")
    private WebElement maxPrice;
    @FindBy(css = ".button_action_n-filter-apply")
    private WebElement applyButton;
    @FindBy(css = ".vendors-list__top>button")
    private WebElement moreVendorsButton;

    private String vendorCheckboxLocator = "//*[contains(@class,'vendors-list')]//span[contains(@class,'checkbox')][./label[text()='%s']]//input";

    public FilterElement(WebDriver driver) {
        super(driver);
    }

    /**
     * Выставляет минимальную цену
     * @param price
     */
    public void setMinPrice(String price) {
        minPrice.sendKeys(price);
    }

    /**
     * Выставляет максимальную цену
     * @param price
     */
    public void setMaxPrice(String price) {
        maxPrice.sendKeys(price);
    }

    public void setVendor(Vendor vendor) {
        String locator = String.format(vendorCheckboxLocator, vendor.name());
        element(By.xpath(locator)).click();
    }

    /**
     * Нажимает кнопку применить
     */
    public void clickApplyButton() {
        applyButton.click();
    }

    /**
     * Нажимает Еще для производителей
     */
    public void clickMoreVendorButton() {
        moreVendorsButton.click();
    }
}
