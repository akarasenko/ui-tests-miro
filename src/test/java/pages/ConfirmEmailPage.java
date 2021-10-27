package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.server.ExportException;
import java.util.Properties;

public class ConfirmEmailPage extends BasePage {

    @FindBy(xpath = "//*[text()='Check your email']")
    WebElement title;

    @FindBy(xpath = "//*[@id='code']")
    WebElement codeInput;

    public ConfirmEmailPage(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }

    public boolean isCodeInputClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(codeInput));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
