//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    public static WebDriver driver;
    public static String generatedEmail;
    public static String generatedPassword;

    public TestBase() {
    }

    @BeforeAll
    public static void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void closeBrowser() {
        driver.close();
    }

    @AfterStep
    public static void takeScreenshots(Scenario scenario) {
        byte[] screenShot = (byte[])((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenShot, "image/png", "SCREENSHOT");
    }
}
