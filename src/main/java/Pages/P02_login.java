//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class P02_login extends PageBase {
    By EmailInput = By.xpath("//*[@id=\"Email\"]");
    By PasswordInput = By.xpath("//*[@id=\"Password\"]");
    By LoginBtn = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
    By LogoutBtn = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    By ErrorMessage = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[1]");
    By MyAccountTab = By.className("ico-account");

    public P02_login(WebDriver driver) {
        super(driver);
    }

    public void EnterEmail(String Email) {
        this.driver.findElement(this.EmailInput).sendKeys(new CharSequence[]{Email});
    }

    public void EnterPassword(String Password) {
        this.driver.findElement(this.PasswordInput).sendKeys(new CharSequence[]{Password});
    }

    public void ClickOnLoginBtn() {
        this.driver.findElement(this.LoginBtn).click();
    }

    public void ClickOnLogoutBtn() {
        this.driver.findElement(this.LogoutBtn).click();
    }

    public void VerifySuccessfulLogin() {
        this.softAssert.assertTrue(this.driver.findElement(this.LogoutBtn).isDisplayed(), "Expected: True, Actual: " + this.driver.findElement(this.LogoutBtn).isDisplayed());
        this.softAssert.assertTrue(this.driver.findElement(this.MyAccountTab).isDisplayed(), "Expected: True, Actual: " + this.driver.findElement(this.MyAccountTab).isDisplayed());
        this.softAssert.assertTrue(this.driver.findElement(this.LogoutBtn).getText().contains("Log out"), "Expected: Log out, Actual: " + this.driver.findElement(this.LogoutBtn).getText());
        this.softAssert.assertTrue(this.driver.getCurrentUrl().contains("https://demo.nopcommerce.com"), "Expected: https://demo.nopcommerce.com, Actual: " + this.driver.getCurrentUrl());
        this.softAssert.assertAll();
    }

    public void VerifyUnSuccessfulLogin() {
        this.softAssert.assertTrue(this.driver.findElement(this.ErrorMessage).isDisplayed(), "Expected: True, Actual: " + this.driver.findElement(this.ErrorMessage).isDisplayed());
        this.softAssert.assertTrue(this.driver.findElement(this.ErrorMessage).getText().contains("Login was unsuccessful."), "Expected: Login was unsuccessful., Actual: " + this.driver.findElement(this.ErrorMessage).getText());
        SoftAssert var10000 = this.softAssert;
        String var10001 = Color.fromString(this.driver.findElement(this.ErrorMessage).getCssValue("color")).asHex();
        WebElement var10003 = this.driver.findElement(this.ErrorMessage);
        var10000.assertEquals(var10001, "#e4434b", "Expected: #e4434b, Actual: " + Color.fromString(var10003.getCssValue("color")).asHex());
        this.softAssert.assertAll();
    }
}
