package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Фабрика драйверов
 * Created by Alexey Dybov on 28.10.16.
 */
public class WebDriverFactory {

    public static WebDriver getDriverInstance() {
        String browser = System.getProperty("webdriver.driver", "chrome");
        WebDriver driver;
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        int implicitlyWait = Integer.parseInt(System.getProperty("webdriver.timeouts.implicitlywait"));
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

}
