package qa.pageobject;

import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.WebDriver;
import qa.annotations.At;

import java.net.URISyntaxException;

/**
 * Общий класс страниц, общие методы
 * Created by Alexey Dybov on 27.10.16.
 */
public class Page extends AbstractPage {

    public Page(WebDriver driver) {
        super(driver);
    }

    protected void openAt() {
        String pageUrl;
        String baseUrl = System.getProperty("webdriver.base.url");
        String path = "";
        if (this.getClass().isAnnotationPresent(At.class)) {
            path = this.getClass().getAnnotation(At.class).value();
        }
        try {
            URIBuilder pageUrlBuilder = new URIBuilder(baseUrl);
            pageUrlBuilder.setPath(path);
            pageUrl = pageUrlBuilder.build().toString();
        } catch (URISyntaxException e) {
            throw new Error("Incorrect Url to open");
        }
        driver.get(pageUrl);
    }
}
