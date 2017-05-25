package ru.sber.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.pageobject.Steps;
import ru.sber.pages.HomePage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Шаги для работы с главной
 * @author Alexey Dybov
 * @created 17.11.16
 */
public class HomeSteps extends Steps {

    private HomePage homePage;

    public HomeSteps(WebDriver driver) {
        super(driver);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    /**
     * Открывает главную страницу с проверкой
     */
    public void openHomePage() {
        openPageUnchecked();
        homePageShouldBeOpened();
    }

    /**
     * Открывает главную страницу
     */
    @Step
    public void openPageUnchecked() {
        homePage.open();
    }

    /**
     * Проверяет что открылась главная страница
     */
    @Step
    public void homePageShouldBeOpened() {
        Assert.assertTrue("Не открылась главная страница", homePage.isOpened());
    }

    /**
     * Клик по кнопке яндекс маркет
     */
    @Step
    public void clickMarket() {
        homePage.clickMarketButton();
    }
}
