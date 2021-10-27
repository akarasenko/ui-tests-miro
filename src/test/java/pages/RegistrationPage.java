package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@data-autotest-id='mr-form-signup-name-1']")
    private WebElement login;

    @FindBy(xpath = "//input[@data-autotest-id='mr-form-signup-email-1']")
    private WebElement email;

    @FindBy(xpath = "//input[@data-autotest-id='mr-form-signup-password-1']")
    private WebElement password;

    @FindBy(xpath = "//div[@data-autotest-id='mr-form-signup-terms-1']//span//label")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//div[@data-autotest-id='mr-form-signup-subscribe-1']//span//label")
    private WebElement subscribeCheckbox;

    @FindBy(xpath = "//button[@data-autotest-id='mr-form-signup-btn-start-1']")
    private WebElement getStarted;

    @FindBy(xpath = "//label[@id='nameError']")
    private WebElement errorMessageLogin;

    @FindBy(xpath = "//label[@id='emailError']")
    private WebElement errorMessageEmail;

    @FindBy(xpath = "//div[@data-autotest-id='please-enter-your-password-1']")
    private WebElement hintMessageEmptyPassword;

    @FindBy(xpath = "//div[@id='signup-form-password'][contains(@class,'hint-text')]")
    private WebElement hintMessagePassword;

    @FindBy(xpath = "//label[@id='termsError']")
    private WebElement errorMessageTerms;

    public RegistrationPage(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }

    public void fillLogin(String login) {
        this.login.sendKeys(login);
    }

    public String getTextInLoginField() {
        return this.login.getAttribute("value");
    }

    public boolean noLoginError() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(errorMessageLogin));
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public void fillEmail(String email) {
        this.email.sendKeys(email);
    }

    public boolean noEmailError() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(errorMessageEmail));
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    public void agreeWithTerms() {
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
    }

    public void subscribe() {
        if (!subscribeCheckbox.isSelected()) {
            subscribeCheckbox.click();
        }
    }

    public void getStartedNow() {
        getStarted.click();
    }

    public String getErrorMessageLogin() {
        this.wait.until(ExpectedConditions.visibilityOf(errorMessageLogin));
        return errorMessageLogin.getText();
    }

    public String getErrorMessageEmail() {
        this.wait.until(ExpectedConditions.visibilityOf(errorMessageEmail));
        return errorMessageEmail.getText();
    }

    public String getHintMessagePassword() {
        WebElement hint;
        try {
            this.wait.until(ExpectedConditions.visibilityOf(hintMessagePassword));
            hint = hintMessagePassword;
        }
        catch(Exception e) {
            this.wait.until(ExpectedConditions.visibilityOf(hintMessageEmptyPassword));
            hint = hintMessageEmptyPassword;
        }

        return hint.getText();
    }

    public String getErrorMessageTerms() {
        this.wait.until(ExpectedConditions.visibilityOf(errorMessageTerms));
        return errorMessageTerms.getText();
    }
}

