//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P02_login;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D02_loginStepDef {
    P02_login p02_login;

    public D02_loginStepDef() {
    }

    @Before
    public void preConditions() {
        this.p02_login = new P02_login(TestBase.driver);
    }

    @Given("user go to login page")
    public void userGoToLoginPage() {
        TestBase.driver.navigate().to("https://demo.nopcommerce.com/login");
    }

    @When("user login with {string} email and password")
    public void userLoginWithValidEmailAndPassword(String type) {
        if (type.contains("invalid")) {
            this.p02_login.EnterEmail("ahmad.abdelhafeez@dxwand.com");
            this.p02_login.EnterPassword("TestBase.generatedPassword");
        } else {
            this.p02_login.EnterEmail(TestBase.generatedEmail);
            this.p02_login.EnterPassword(TestBase.generatedPassword);
        }

    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        this.p02_login.ClickOnLoginBtn();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        this.p02_login.VerifySuccessfulLogin();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        this.p02_login.VerifyUnSuccessfulLogin();
    }
}
