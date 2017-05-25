package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * @author Alexey Dybov <a.dybov@corp.mail.ru>
 */
public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static String webDriverName = System.getProperty("webdriver.driver");
    private static String remoteUrl = System.getProperty("webdriver.remote.url");

    public static WebDriver getDriver() {
//        if (driverThreadLocal.get() == null) {
//            driverThreadLocal.set(getInstance());
//        }
//        return driverThreadLocal.get();

        return getInstance();
    }

    private static WebDriver getInstance() {
        if (remoteUrl != null) {
            return getRemoteDriver();
        }
        return getLocalDriver();
    }

    private static WebDriver getLocalDriver() {
        switch (webDriverName) {
            case "chrome":
                return getChromeDriver();
            case "firefox":
                return getFirefoxDriver();
            default:
                return getChromeDriver();
        }
    }

    private static WebDriver getRemoteDriver() {
        switch (webDriverName) {
            case "chrome":
                return getRemoteChromeDriver();
            case "firefox":
                return getRemoteFirefoxDriver();
            default:
                return getRemoteChromeDriver();
        }
    }

    private static WebDriver getRemoteFirefoxDriver() {
        return null;
    }

    private static WebDriver getRemoteChromeDriver() {
        return null;
    }

    private static WebDriver getChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver() {
        return null;
    }
}
