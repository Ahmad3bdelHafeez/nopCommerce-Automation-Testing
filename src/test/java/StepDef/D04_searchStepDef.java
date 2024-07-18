//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P03_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D04_searchStepDef {
    P03_homePage p03_homePage;

    public D04_searchStepDef() {
    }

    @Before
    public void preConditions() {
        this.p03_homePage = new P03_homePage(TestBase.driver);
    }

    @When("user enter word {string}")
    public void userEnterWord(String Word) {
        this.p03_homePage.EnterSearchWord(Word);
    }

    @And("user click on search button")
    public void userClickOnSearchButton() {
        this.p03_homePage.ClickOnSearchBtn();
    }

    @Then("user get products that contains the word {string} successfully")
    public void userGetProductsThatContainsTheWordSuccessfully(String Word) {
        this.p03_homePage.VerifySearchResultsByProductName(Word);
    }

    @When("user enter sku {string}")
    public void userEnterSku(String SKU) {
        this.p03_homePage.EnterSearchWord(SKU);
    }

    @And("user click on the product after clicking on search button")
    public void userClickOnTheProductAfterClickingOnSearchButton() {
        this.p03_homePage.ClickOnSearchResult();
    }

    @Then("user get the product that contains the sku {string} successfully")
    public void userGetTheProductThatContainsTheSkuSuccessfully(String SKU) {
        this.p03_homePage.VerifySearchResultsBySKU(SKU);
    }
}
