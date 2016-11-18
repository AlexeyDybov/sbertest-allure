package ru.sber;

import org.junit.After;
import org.openqa.selenium.WebDriver;

/**
 * Абстрактный тест
 * Created by Alexey Dybov on 27.10.16.
 */
public class BaseTest {

    protected WebDriver driver;

    @After
    public void tearDown() {
        driver.quit();
    }
}
