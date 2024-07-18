//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class P01_register extends PageBase {
    By SelectMaleInput = By.id("gender-male");
    By SelectFemaleInput = By.id("gender-female");
    By FirstNameInput = By.id("FirstName");
    By LastNameInput = By.id("LastName");
    By DayInput = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]");
    By MonthInput = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]");
    By YearInput = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]");
    By EmailInput = By.id("Email");
    By CompanyNameInput = By.id("Company");
    By PasswordInput = By.id("Password");
    By ConfirmPasswordInput = By.id("ConfirmPassword");
    By RegisterBtn = By.id("register-button");
    By LogoutBtn = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    By ContinueBtn = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[2]/a");
    By SuccessfulMessage = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]");
    Select dropd;

    public P01_register(WebDriver driver) {
        super(driver);
    }

    public void SelectGender(String Gender) {
        if (Gender.contains("Female")) {
            this.driver.findElement(this.SelectFemaleInput).click();
        } else {
            this.driver.findElement(this.SelectMaleInput).click();
        }

    }

    public void EnterName(String FirstName, String LastName) {
        this.driver.findElement(this.FirstNameInput).sendKeys(new CharSequence[]{FirstName});
        this.driver.findElement(this.LastNameInput).sendKeys(new CharSequence[]{LastName});
    }

    public void EnterFirstName(String FirstName) {
        this.driver.findElement(this.FirstNameInput).sendKeys(new CharSequence[]{FirstName});
    }

    public void EnterLastName(String LastName) {
        this.driver.findElement(this.LastNameInput).sendKeys(new CharSequence[]{LastName});
    }

    public void EnterDate(String Day, String Month, String Year) {
        this.dropd = new Select(this.driver.findElement(this.DayInput));
        this.dropd.selectByVisibleText(Day);
        this.dropd = new Select(this.driver.findElement(this.MonthInput));
        this.dropd.selectByVisibleText(Month);
        this.dropd = new Select(this.driver.findElement(this.YearInput));
        this.dropd.selectByVisibleText(Year);
    }

    public void EnterDay(String Day) {
        this.dropd = new Select(this.driver.findElement(this.DayInput));
        this.dropd.selectByVisibleText(Day);
    }

    public void EnterMonth(String Month) {
        this.dropd = new Select(this.driver.findElement(this.MonthInput));
        this.dropd.selectByVisibleText(Month);
    }

    public void EnterYear(String Year) {
        this.dropd = new Select(this.driver.findElement(this.YearInput));
        this.dropd.selectByVisibleText(Year);
    }

    public void EnterEmail(String Email) {
        this.driver.findElement(this.EmailInput).sendKeys(new CharSequence[]{Email});
    }

    public void EnterCompanyName(String CompanyName) {
        this.driver.findElement(this.CompanyNameInput).sendKeys(new CharSequence[]{CompanyName});
    }

    public void EnterPasswordFields(String Password, String ConfirmPassword) {
        this.driver.findElement(this.PasswordInput).sendKeys(new CharSequence[]{Password});
        this.driver.findElement(this.ConfirmPasswordInput).sendKeys(new CharSequence[]{ConfirmPassword});
    }

    public void EnterPassword(String Password) {
        this.driver.findElement(this.PasswordInput).sendKeys(new CharSequence[]{Password});
    }

    public void EnterConfirmPassword(String ConfirmPassword) {
        this.driver.findElement(this.ConfirmPasswordInput).sendKeys(new CharSequence[]{ConfirmPassword});
    }

    public void ClickOnRegisterBtn() {
        this.driver.findElement(this.RegisterBtn).click();
    }

    public void ClickOnContinueBtn() {
        this.driver.findElement(this.ContinueBtn).click();
    }

    public void ClickOnLogoutBtn() {
        this.driver.findElement(this.LogoutBtn).click();
    }

    public void VerifySuccessfulRegistration() {
        this.softAssert.assertTrue(this.driver.findElement(this.SuccessfulMessage).getText().contains("Your registration completed"), "Expected: Your registration completed, Actual: " + this.driver.findElement(this.SuccessfulMessage).getText());
        SoftAssert var10000 = this.softAssert;
        String var10001 = this.driver.findElement(this.SuccessfulMessage).getCssValue("color");
        WebElement var10003 = this.driver.findElement(this.SuccessfulMessage);
        var10000.assertEquals(var10001, "rgba(76, 177, 124, 1)", "Expected: rgba(76, 177, 124, 1), Actual: " + var10003.getCssValue("color"));
        this.softAssert.assertTrue(this.driver.findElement(this.LogoutBtn).getText().contains("Log out"), "Expected: Log out, Actual: " + this.driver.findElement(this.LogoutBtn).getText());
        this.softAssert.assertTrue(this.driver.findElement(this.ContinueBtn).isDisplayed(), "Expected: True, Actual: " + this.driver.findElement(this.ContinueBtn).isDisplayed());
        this.softAssert.assertAll();
    }
}
