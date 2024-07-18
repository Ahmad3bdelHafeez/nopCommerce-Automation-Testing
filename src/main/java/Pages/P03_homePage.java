//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class P03_homePage extends PageBase {
    By RegisterBtn = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    By LoginBtn = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    By CurrencyInput = By.id("customerCurrency");
    By SearchInput = By.id("small-searchterms");
    By SearchBtn = By.xpath("//*[@id=\"small-search-box-form\"]/button");
    By SearchResult = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a");
    By SearchResults = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div");
    By SearchResultItems = By.className("product-title");
    By CurrencyResultItems = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]");
    By CurrencyResultPrice = By.className("price");
    By SKUItemResult = By.className("additional-details");
    By SKUItemResultValue = By.className("value");
    By TopMenu = By.xpath("/html/body/div[6]/div[2]/ul[1]/li");
    String mainWindowHandle;
    By Wishlist = By.className("wishlist-qty");
    By HomePageItems = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div");

    public P03_homePage(WebDriver driver) {
        super(driver);
    }

    public void ChangeCurrency(String Currency) {
        System.out.println(Currency.toLowerCase().contains("us"));
        if (Currency.toLowerCase().contains("us")) {
            this.driver.navigate().to("https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F");
        } else {
            this.driver.navigate().to("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
        }

    }

    public void EnterSearchWord(String Word) {
        this.driver.findElement(this.SearchInput).sendKeys(new CharSequence[]{Word});
    }

    public void ClickOnSearchBtn() {
        this.driver.findElement(this.SearchBtn).click();
    }

    public void ClickOnSearchResult() {
        this.driver.findElement(this.SearchResult).click();
    }

    public void VerifySearchResultsByProductName(String Word) {
        WebElement results = this.driver.findElement(this.SearchResults);
        List<WebElement> items = results.findElements(this.SearchResultItems);
        Iterator var4 = items.iterator();

        while(var4.hasNext()) {
            WebElement item = (WebElement)var4.next();
            System.out.println(item.getText());
            this.softAssert.assertTrue(this.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="), "Expected: https://demo.nopcommerce.com/search?q=, Actual: " + this.driver.getCurrentUrl());
            this.softAssert.assertTrue(item.getText().toLowerCase().contains(Word.toLowerCase()), "Expected: " + Word + ", Actual: " + item.getText());
            this.softAssert.assertAll();
        }

    }

    public void VerifySearchResultsBySKU(String SKU) {
        WebElement item = this.driver.findElement(this.SKUItemResult);
        String value = item.findElement(this.SKUItemResultValue).getText();
        Assert.assertTrue(value.toLowerCase().contains(SKU.toLowerCase()), "Expected: " + SKU + ", Actual: " + value);
    }

    public void VerifyChangeCurrencyResults(String Currency) {
        if (Currency.toLowerCase().contains("us")) {
            Currency = "$";
        } else {
            Currency = "€";
        }

        WebElement results = this.driver.findElement(this.CurrencyResultItems);
        List<WebElement> items = results.findElements(this.CurrencyResultPrice);
        System.out.println(items.size());
        Iterator var4 = items.iterator();

        while(var4.hasNext()) {
            WebElement item = (WebElement)var4.next();
            System.out.println(item.getText());
            Assert.assertTrue(item.getText().toLowerCase().contains(Currency), "Expected: " + Currency + ", Actual: " + item.getText().toLowerCase());
        }

    }

    public void ClickOnSubCategory(String Category, String SubCategory) {
        List<WebElement> categories = this.driver.findElements(this.TopMenu);
        Actions action = new Actions(this.driver);
        System.out.println(categories.size());
        int categoryNumber = 1;

        for(Iterator var6 = categories.iterator(); var6.hasNext(); ++categoryNumber) {
            WebElement category = (WebElement)var6.next();
            String categoryName = category.getText();
            if (categoryName.toLowerCase().trim().contains(Category.toLowerCase().trim())) {
                System.out.println("Category Name: " + categoryName);
                action.moveToElement(category).perform();
                List<WebElement> subCategories = this.driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[" + categoryNumber + "]/ul/li"));
                System.out.println("Size of SubCategories: " + subCategories.size());
                if (categoryName.toLowerCase().trim().contains(SubCategory.toLowerCase().trim())) {
                    System.out.println("Chosen Category: " + categoryName);
                    category.click();
                } else if (subCategories.size() <= 1) {
                    System.out.println("Chosen Category: " + categoryName);
                    category.click();
                } else {
                    Iterator var10 = subCategories.iterator();

                    WebElement sub;
                    String subCategoryName;
                    do {
                        if (!var10.hasNext()) {
                            return;
                        }

                        sub = (WebElement)var10.next();
                        System.out.println(sub.getTagName());
                        subCategoryName = sub.getText();
                        System.out.println(subCategoryName);
                    } while(!subCategoryName.toLowerCase().trim().contains(SubCategory.toLowerCase().trim()));

                    System.out.println("Chosen SubCategory: " + subCategoryName);
                    sub.findElement(By.tagName("a")).click();
                }
                break;
            }
        }

    }

    public void VerifySubCategoryMatchItsPage(String SubCategory) {
        System.out.println("Current URL: " + this.driver.getCurrentUrl());
        String pageHeader = this.driver.findElement(By.cssSelector("#main > div > div.center-2 > div > div.page-title > h1")).getText();
        System.out.println(pageHeader);
        Assert.assertTrue(pageHeader.toLowerCase().trim().contains(SubCategory.toLowerCase().trim()), "Expected: " + SubCategory + ", Actual: " + pageHeader);
    }

    public void ClickOnSliderItem(String Item, String ItemNumber) {
        try {
            Thread.sleep(2000L);
            List<WebElement> sliderItems = this.driver.findElements(By.className("nivo-imageLink"));
            String displayValue = ((WebElement)sliderItems.get(Integer.parseInt(ItemNumber) - 1)).getCssValue("display");
            if (displayValue.contains("block")) {
                for(int i = 1; i < sliderItems.size(); ++i) {
                    if (Integer.parseInt(ItemNumber) == i) {
                        try {
                            ((WebElement)sliderItems.get(i - 1)).click();
                            Thread.sleep(2000L);
                        } catch (Exception var7) {
                            Exception e = var7;
                            System.out.println("Could not click on item: " + e.getMessage());
                        }
                        break;
                    }
                }
            }
        } catch (Exception var8) {
            Exception e = var8;
            System.out.println("Get an error: " + e.getMessage());
        }

    }

    public void VerifySliderItemURL(String URL) {
        System.out.println("Current URL: " + this.driver.getCurrentUrl());
        Assert.assertEquals(URL.toLowerCase().trim(), this.driver.getCurrentUrl().toLowerCase().trim(), "Expected: " + URL + ", Actual: " + this.driver.getCurrentUrl());
    }

    public void ClickOnChannel(String Channel) {
        try {
            WebElement link = this.driver.findElement(By.className(Channel));
            System.out.println(link.getText());
            this.mainWindowHandle = this.driver.getWindowHandle();
            link.click();
            Thread.sleep(4000L);
        } catch (Exception var3) {
            Exception e = var3;
            System.out.println("Get an error: " + e.getMessage());
        }

    }

    public void VerifyChannelLinks(String Link) {
        Set<String> allWindowHandles = this.driver.getWindowHandles();
        if (allWindowHandles.size() == 1) {
            Assert.assertEquals(Link.toLowerCase().trim(), this.driver.getCurrentUrl().toLowerCase().trim(), "Expected: " + Link + ", Actual: " + this.driver.getCurrentUrl());
        } else {
            Iterator var3 = allWindowHandles.iterator();

            while(var3.hasNext()) {
                String windowHandle = (String)var3.next();
                if (!windowHandle.equals(this.mainWindowHandle)) {
                    this.driver.switchTo().window(windowHandle);
                    System.out.println("Switched to new window: " + windowHandle);
                    String currentWindow = this.driver.getCurrentUrl();
                    System.out.println("Current URL: " + currentWindow);
                    this.driver.close();
                    this.driver.switchTo().window(this.mainWindowHandle);
                    Assert.assertEquals(Link.toLowerCase().trim(), currentWindow.toLowerCase().trim(), "Expected: " + Link + ", Actual: " + currentWindow);
                    break;
                }
            }
        }

    }

    public void ClickOnLoveIconOfSpecificProduct(String Product) {
        List<WebElement> Items = this.driver.findElements(this.HomePageItems);
        System.out.println(Items.size());
        int i = 0;

        for(Iterator var4 = Items.iterator(); var4.hasNext(); ++i) {
            WebElement item = (WebElement)var4.next();
            String productName = item.findElement(By.className("product-title")).getText();
            System.out.println(productName);
            if (productName.toLowerCase().trim().equals(Product.toLowerCase().trim())) {
                System.out.println("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[" + (i + 1) + "]/div/div[2]/div[3]/div[2]/button[3]");
                item.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[" + (i + 1) + "]/div/div[2]/div[3]/div[2]/button[3]")).click();
                break;
            }
        }

    }

    public void VerifyDisplayASuccessfullMessageWhenClickOnAddToWishList() {
        try {
            Thread.sleep(2000L);
            System.out.println(this.driver.getCurrentUrl());
            if (!this.driver.getCurrentUrl().equals("https://demo.nopcommerce.com/")) {
                Assert.assertEquals(this.driver.getCurrentUrl(), "https://demo.nopcommerce.com/", "Expected: https://demo.nopcommerce.com/, Actual: " + this.driver.getCurrentUrl());
                this.driver.navigate().to("https://demo.nopcommerce.com/");
            } else {
                WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(5000L));
                WebElement notificationDiv = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));
                String successMessageText = notificationDiv.getText();
                System.out.println(successMessageText);
                WebElement successMessageBgColorElement = notificationDiv.findElement(By.tagName("div"));
                this.softAssert.assertTrue(successMessageBgColorElement.isDisplayed(), "Expected: True, Actual: " + successMessageBgColorElement.isDisplayed());
                String successMessageBgColor = Color.fromString(successMessageBgColorElement.getCssValue("background-color")).asHex();
                System.out.println(successMessageBgColor);
                this.softAssert.assertTrue(successMessageText.contains("The product has been added to your wishlist"), "Expected: The product has been added to your wishlist, Actual: " + successMessageText);
                this.softAssert.assertEquals(successMessageBgColor, "#4bb07a", "Expected: #4bb07a, Actual: " + successMessageBgColor);
            }

        } catch (InterruptedException var6) {
            InterruptedException e = var6;
            throw new RuntimeException(e);
        }
    }

    public void VerifyTheWishlistCounter() {
        try {
            Thread.sleep(3000L);
            WebElement wishlist = this.driver.findElement(this.Wishlist);
            String wishlistCounter = wishlist.getText();
            wishlistCounter = wishlistCounter.replace("(", "");
            wishlistCounter = wishlistCounter.replace(")", "");
            Assert.assertTrue(Integer.parseInt(wishlistCounter) > 0, "Expected: More than 0, Actual: " + Integer.parseInt(wishlistCounter));
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            throw new RuntimeException(e);
        }
    }
}
