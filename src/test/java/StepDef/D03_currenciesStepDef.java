//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P03_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D03_currenciesStepDef {
    P03_homePage p03_homePage;

    public D03_currenciesStepDef() {
    }

    @Before
    public void preConditions() {
        this.p03_homePage = new P03_homePage(TestBase.driver);
    }

    @Given("user go to home page")
    public void userGoToHomePage() {
        TestBase.driver.navigate().to("https://demo.nopcommerce.com");
    }

    @When("user should select {string} currency from the dropdown list")
    public void userShouldSelectCurrencyFromTheDropdownList(String Currency) {
        this.p03_homePage.ChangeCurrency(Currency);
    }

    @Then("user get the new price by the changed currency {string} successfully")
    public void userGetTheNewPriceByTheChangedCurrencySuccessfully(String Currency) {
        this.p03_homePage.VerifyChangeCurrencyResults(Currency);
    }
}
