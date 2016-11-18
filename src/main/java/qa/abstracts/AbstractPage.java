package qa.abstracts;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.waiting.InvisibilityOfElement;
import qa.waiting.VisibilityOfElement;
import qa.waiting.VisibilityOfElementLocated;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Вспомогательный класс страниц
 * Created by Alexey Dybov on 28.10.16.
 */
public class AbstractPage extends AbstractClass {

    public AbstractPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Set implicity wait in second
     * @param second
     */
    private void setImplicitTimeout(int second) {
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    /**
     * Reset implicity wait to default
     */
    private void resetImplicitTimeout() {
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

    /**
     * Ожидание видимого элемента
     * @param element
     * @return
     */
    protected boolean waitForElementPresent(WebElement element) {
        setImplicitTimeout(0);
        Boolean result = true;
        WebDriverWait wait = new WebDriverWait(driver, implicitWait, 500);
        try {
            wait.until(new VisibilityOfElement(element));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    /**
     * Ожидание видимого элемента
     * @param by локатор
     * @return
     */
    protected boolean waitForElementPresent(By by) {
        setImplicitTimeout(0);
        Boolean result = true;
        WebDriverWait wait = new WebDriverWait(driver, implicitWait, 500);
        try {
            wait.until(new VisibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    /**
     * Ожидание отсутвия видимого элемента
     * @param element
     * @return
     */
    protected boolean waitForElementNotPresent(WebElement element) {
        setImplicitTimeout(0);
        Boolean result = true;
        WebDriverWait wait = new WebDriverWait(driver, implicitWait, 500);
        try {
            wait.until(new InvisibilityOfElement(element));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    protected WebElement element(By by){
        return driver.findElement(by);
    }

    protected List<WebElement> elements(By by){
        return driver.findElements(by);
    }
}
