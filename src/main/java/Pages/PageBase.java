//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class PageBase {
    public WebDriver driver;
    public SoftAssert softAssert;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
    }
}
