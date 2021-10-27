package tests;

import helpers.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PasswordValidationTest extends BaseTest {

    @Parameters({"password","expectedMessage"})
    @Test
    public void ImpossibleToRegisterWithIncorrectPasswordTest (String password, String expectedMessage) {
        String login = DataGenerator.generateLogin();
        String email = DataGenerator.generateEmail();

        app.registrationPage().open();
        app.registrationPage().fillLogin(login);
        app.registrationPage().fillEmail(email);
        app.registrationPage().fillPassword(password);
        app.registrationPage().agreeWithTerms();

        app.registrationPage().getStartedNow();

        Assert.assertEquals(app.registrationPage().getHintMessagePassword(), expectedMessage);
    }

    @Parameters({"password","expectedMessage"})
    @Test
    public void ValidationPasswordTest (String password, String expectedMessage) {
        app.registrationPage().open();
        app.registrationPage().fillPassword(password);
        app.registrationPage().agreeWithTerms();

        Assert.assertEquals(app.registrationPage().getHintMessagePassword(), expectedMessage);
    }

    @Parameters("password")
    @Test
    public void SuccessfulRegistrationWithPassword (String password) {
        String login = DataGenerator.generateLogin();
        String email = DataGenerator.generateEmail();

        app.registrationPage().open();
        app.registrationPage().fillLogin(login);
        app.registrationPage().fillEmail(email);
        app.registrationPage().fillPassword(password);
        app.registrationPage().agreeWithTerms();

        app.registrationPage().getStartedNow();

        Assert.assertTrue(app.confirmEmailPage.isCodeInputClickable());
    }
}
