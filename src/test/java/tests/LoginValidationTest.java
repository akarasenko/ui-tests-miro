package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginValidationTest extends BaseTest {

    @Parameters({"login","expectedMessage"})
    @Test
    public void EmptyLoginTest(String login, String expectedMessage) {

        app.registrationPage().open();
        app.registrationPage().fillLogin(login);
        app.registrationPage().getStartedNow();

        Assert.assertEquals(app.registrationPage().getErrorMessageLogin(), expectedMessage);
    }

    @Parameters("login")
    @Test
    public void MaxCharactersLoginTest(String login) {

        app.registrationPage().open();
        app.registrationPage().fillLogin(login);

        String actual = app.registrationPage().getTextInLoginField();

        Assert.assertEquals(actual,login);
    }

    @Parameters("login")
    @Test
    public void MoreThanMaxCharactersLoginTest(String login) {

        app.registrationPage().open();
        app.registrationPage().fillLogin(login);

        String expected = login.substring(0, login.length()-1);
        String actual = app.registrationPage().getTextInLoginField();

        Assert.assertEquals(actual,expected);
    }

    @Parameters("login")
    @Test
    public void AllowedCharactersLoginTest(String login) {

        app.registrationPage().open();
        app.registrationPage().fillLogin(login);
        app.registrationPage().getStartedNow();

        Assert.assertTrue(app.registrationPage().noLoginError());
    }
}
