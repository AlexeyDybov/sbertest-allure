package ru.sber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.abstracts.Page;

/**
 * Страница просмотра товара
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class ItemPage extends Page {

    @FindBy(css= ".n-product-summary")
    private WebElement productInfo;
    @FindBy(css= "[itemprop='name']")
    private WebElement productName;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Проверяет что открыта страница
     * @return
     */
    public boolean isPageOpened() {
        return waitForElementPresent(productInfo);
    }

    /**
     * Возвращает имя товара
     * @return
     */
    public String getItemName() {
        return productName.getText();
    }
}
