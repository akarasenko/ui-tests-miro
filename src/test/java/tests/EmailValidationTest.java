
package tests;

import helpers.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmailValidationTest extends BaseTest {

    @Parameters({"email","expectedMessage"})
    @Test
    public void ErrorInEmailTest (String email, String expectedMessage) {
        app.registrationPage().open();
        app.registrationPage().fillLogin("login");
        app.registrationPage().fillEmail(email);
        app.registrationPage().fillPassword("password");
        app.registrationPage().agreeWithTerms();
        app.registrationPage().getStartedNow();

        Assert.assertEquals(app.registrationPage().getErrorMessageEmail(), expectedMessage);
    }

    @Parameters("email")
    @Test
    public void SuccessfulRegistrationEmailTest (String email) {
        String unicEmail = email + DataGenerator.generateRandomNumberPart() + ".com";

        app.registrationPage().open();
        app.registrationPage().fillLogin("login");
        app.registrationPage().fillEmail(unicEmail);
        app.registrationPage().fillPassword("password");
        app.registrationPage().agreeWithTerms();
        app.registrationPage().getStartedNow();

        Assert.assertTrue(app.confirmEmailPage.isCodeInputClickable());
    }
}
