//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/Features"},
        glue = {"StepDef"},
        tags = "@smoke",
        plugin = {"pretty", "html:target/cucumber-reports/dsalgo.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class smokeTest extends AbstractTestNGCucumberTests {
    public smokeTest() {
    }
}
