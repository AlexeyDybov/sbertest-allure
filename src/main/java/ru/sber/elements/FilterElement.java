package ru.sber.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.pageobject.Page;
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
    @FindBy(css = ".n-filter-panel-aside_type_default>div>.n-filter-block:nth-of-type(4) button")
    private WebElement moreVendorsButton;

    private String vendorCheckboxLocator = "//*[contains(@class,'n-filter-panel-aside_type_default')]/div/*[contains(@class,'n-filter-block')][4]//span[contains(@class,'checkbox')][./label[text()='%s']]";
    private String vendorLocator = "//div[contains(@class,'n-filter-block__item')][.//label[text()='%s']]";

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
        String vendorLocatora = String.format(vendorLocator, vendor.name());
        scrollPageToElement(By.xpath(vendorLocatora), true);
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
