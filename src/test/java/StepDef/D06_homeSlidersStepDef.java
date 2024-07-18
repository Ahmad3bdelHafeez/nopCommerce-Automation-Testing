//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P03_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D06_homeSlidersStepDef {
    P03_homePage p03_homePage;

    public D06_homeSlidersStepDef() {
    }

    @Before
    public void preConditions() {
        this.p03_homePage = new P03_homePage(TestBase.driver);
    }

    @When("user go to the slider section and click on item {string} {string}")
    public void userGoToTheSliderSectionAndClickOnItem(String ItemNumber, String Item) {
        this.p03_homePage.ClickOnSliderItem(Item, ItemNumber);
    }

    @Then("user should redirect to the item page URL {string}")
    public void userShouldRedirectToTheItemPageURL(String URL) {
        this.p03_homePage.VerifySliderItemURL(URL);
    }
}
