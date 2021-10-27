package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ConfirmEmailPage;
import pages.RegistrationPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Application {

    public WebDriver driver;
    WebDriverWait wait;
    Properties properties;
    RegistrationPage registrationPage;
    public ConfirmEmailPage confirmEmailPage;

    public Application() throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 3);

        properties = new Properties();
        FileReader file = new FileReader(new File(String.format("src/test/resources/%s.properties", System.getProperty("target", "local"))));
        properties.load(file);

        registrationPage = new RegistrationPage(driver, wait, properties);
        confirmEmailPage = new ConfirmEmailPage(driver, wait, properties);
    }

    public RegistrationPage registrationPage () {
        return this.registrationPage;
    }
    public ConfirmEmailPage confirmEmailPage () {
        return this.confirmEmailPage;
    }

    public void quit() {
        driver.quit();
    }

    public void takeScreenshot(String fileName) {
        ScreenSaver.takeScreenshot(driver, fileName);
    }
}
