//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P03_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D07_followUsStepDef {
    P03_homePage p03_homePage;

    public D07_followUsStepDef() {
    }

    @Before
    public void preConditions() {
        this.p03_homePage = new P03_homePage(TestBase.driver);
    }

    @When("user opens {string} link")
    public void userOpensLink(String Channel) {
        this.p03_homePage.ClickOnChannel(Channel);
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String Link) {
        this.p03_homePage.VerifyChannelLinks(Link);
    }
}
