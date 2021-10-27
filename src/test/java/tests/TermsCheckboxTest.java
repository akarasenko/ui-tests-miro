package tests;

import helpers.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TermsCheckboxTest extends BaseTest {

    @Parameters("expectedMessage")
    @Test
    public void TermsCheckedTest(String expectedMessage) {
        String login = DataGenerator.generateLogin();
        String email = DataGenerator.generateEmail();
        String password = DataGenerator.generatePasswordWithEigthCharacters();

        app.registrationPage().open();
        app.registrationPage().fillLogin(login);
        app.registrationPage().fillEmail(email);
        app.registrationPage().fillPassword(password);
        app.registrationPage().getStartedNow();

        Assert.assertEquals(app.registrationPage().getErrorMessageTerms(), expectedMessage);
    }

    // successful registration with terms checked is tested in other scenarios
}
