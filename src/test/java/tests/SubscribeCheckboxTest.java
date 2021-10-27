package tests;

import helpers.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeCheckboxTest extends BaseTest {

    @Test
    public void TermsCheckedTest () {
        String login = DataGenerator.generateLogin();
        String email = DataGenerator.generateEmail();
        String password = DataGenerator.generatePasswordWithEigthCharacters();

        app.registrationPage().open();
        app.registrationPage().fillLogin(login);
        app.registrationPage().fillEmail(email);
        app.registrationPage().fillPassword(password);
        app.registrationPage().agreeWithTerms();
        app.registrationPage().subscribe();
        app.registrationPage().getStartedNow();

        Assert.assertTrue(app.confirmEmailPage.isCodeInputClickable());
    }

    // successful registration with subscribe UNchecked is tested in other scenarios
}
