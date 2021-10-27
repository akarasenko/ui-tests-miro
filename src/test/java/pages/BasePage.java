package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Properties properties;
    public String pageName;
    public String pageUrl;

    public BasePage(WebDriver driver, WebDriverWait wait, Properties properties) {
        this.driver = driver;
        this.wait = wait;
        this.properties = properties;
        this.pageName = this.getClass().getSimpleName() + "Url";
        this.pageUrl = this.properties.getProperty(pageName);

        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
       return this.pageUrl;
    }

    public void open() {
        driver.navigate().to(pageUrl);
    }
}
