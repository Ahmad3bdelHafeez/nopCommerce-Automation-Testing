//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P01_register;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D01_registerStepDef {
    P01_register p01_register;

    public D01_registerStepDef() {
    }

    @Before
    public void preConditions() {
        this.p01_register = new P01_register(TestBase.driver);
    }

    @Given("user go to register page")
    public void userGoToRegisterPage() {
        TestBase.driver.navigate().to("https://demo.nopcommerce.com/register");
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        this.p01_register.SelectGender("Male");
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        this.p01_register.EnterName(firstName, lastName);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        this.p01_register.EnterDate("18", "January", "2000");
    }

    @And("user enter email field")
    public void userEnterEmailField() {
        TestBase.generatedEmail = "user" + System.currentTimeMillis() + "@gmail.com";
        System.out.println("Generated Email: " + TestBase.generatedEmail);
        this.p01_register.EnterEmail(TestBase.generatedEmail);
    }

    @And("user fills Password fields")
    public void userFillsPasswordFields() {
        TestBase.generatedPassword = "user" + System.currentTimeMillis();
        System.out.println("Generated Password: " + TestBase.generatedPassword);
        this.p01_register.EnterPasswordFields(TestBase.generatedPassword, TestBase.generatedPassword);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        this.p01_register.ClickOnRegisterBtn();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        this.p01_register.VerifySuccessfulRegistration();
    }
}
