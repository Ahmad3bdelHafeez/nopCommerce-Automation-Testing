//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P03_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D08_WishlistStepDef {
    P03_homePage p03_homePage;

    public D08_WishlistStepDef() {
    }

    @Before
    public void preConditions() {
        this.p03_homePage = new P03_homePage(TestBase.driver);
    }

    @When("add any product {string} to the wishlist by clicking on the love icon")
    public void addAnyProductToTheWishlistByClickingOnTheLoveIcon(String Product) {
        this.p03_homePage.ClickOnLoveIconOfSpecificProduct(Product);
    }

    @Then("success message is displayed on the top of the page")
    public void successMessageIsDisplayedOnTheTopOfThePage() {
        this.p03_homePage.VerifyDisplayASuccessfullMessageWhenClickOnAddToWishList();
    }

    @Then("wishlist counter is more than zero items")
    public void wishlistCounterIsMoreThanZeroItems() {
        this.p03_homePage.VerifyTheWishlistCounter();
    }
}
