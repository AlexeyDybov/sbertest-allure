package qa.abstracts;

import org.openqa.selenium.WebDriver;

/**
 * @author Alexey Dybov
 * @created 18.11.16
 */
public class AbstractClass {

    protected WebDriver driver;
    protected final int implicitWait = Integer.parseInt(System.getProperty("webdriver.timeouts.implicitlywait"));

    public AbstractClass(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Явное ожидание
     * @param timeout милисекунды
     */
    public void waitFor(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
