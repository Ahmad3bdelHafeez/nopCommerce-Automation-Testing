//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P03_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D05_hoverCategoriesStepDef {
    P03_homePage p03_homePage;

    public D05_hoverCategoriesStepDef() {
    }

    @Before
    public void preConditions() {
        this.p03_homePage = new P03_homePage(TestBase.driver);
    }

    @When("user hover the category {string} and click on {string}")
    public void userHoverTheCategoryAndClickOn(String Category, String SubCategory) {
        this.p03_homePage.ClickOnSubCategory(Category, SubCategory);
    }

    @Then("user get sub categories that clicked on before {string}")
    public void userGetSubCategoriesThatClickedOnBefore(String SubCategory) {
        this.p03_homePage.VerifySubCategoryMatchItsPage(SubCategory);
    }
}
