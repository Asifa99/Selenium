package Grid;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumCourseTest {

    @ParameterizedTest
    @CsvSource({
            "standard_user, secret_sauce",  // Test case 1
//            "locked_out_user, secret_sauce" // Test case 2
    })
    @Tag("login")
    public void loginTest(String email, String password) throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
        assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed. Redirect to inventory page did not occur.");

//        2 Start
//        WebElement add_item_1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
//        add_item_1.click();
//        WebElement add_item_2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
//        add_item_2.click();
//        WebElement add_item_3 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
//        add_item_3.click();
//        WebElement remove_item_2 = driver.findElement(By.id("remove-sauce-labs-bike-light"));
//        remove_item_2.click();
//        WebElement remove_item_3 = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
//        remove_item_3.click();
//        WebElement cartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge"));
//        assertEquals("1", cartBadge.getText(), "Cart count should be 1 after adding an item.");
//        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
//        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
//
//        assertTrue(driver.findElements(By.cssSelector(".shopping_cart_badge")).isEmpty(), "Cart badge should disappear after removing the item.");
        // 3 End

//        4 Start
//        driver.get("https://www.saucedemo.com/inventory.html");
//        driver.findElement(By.id("item_4_title_link")).click();
//        WebElement add_btn = driver.findElement(By.id("add-to-cart"));
//        add_btn.click();
//        assertEquals("1", cartBadge.getText(), "Cart count should be 1 after adding an item.");
//        WebElement removeButton = waitForElementToBeVisible(driver, "//button[@id='remove' and @data-test='remove']", 10);
//        System.out.println(removeButton.isDisplayed());
//        removeButton.click();
//        assertTrue(driver.findElements(By.cssSelector(".shopping_cart_badge")).isEmpty(), "Cart badge should disappear after removing the item.");
//        Remove Button Not Working Here......

//      4 End

//        5 Start
//        driver.get("https://www.saucedemo.com/inventory.html");
//        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
//
//        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
//        driver.findElement(By.id("checkout")).click();
////        Checkout Information Page
//        driver.findElement(By.id("first-name")).sendKeys("Garry");
//        driver.findElement(By.id("last-name")).sendKeys("Jones");
//        driver.findElement(By.id("postal-code")).sendKeys("34000");
//        driver.findElement(By.id("continue")).click();
//        driver.findElement(By.id("finish")).click();
//        5 End

//        6 Start
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        Thread.sleep(1000);
        logout(driver);
        assertTrue(driver.getCurrentUrl().contains("saucedemo.com"), "Logout failed. Did not return to login page.");

        driver.findElement(By.id("user-name")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000);
        assertEquals("1", driver.findElement(By.cssSelector(".shopping_cart_badge")).getText(), "Cart count should be 1 after adding an item.");
//        6 End
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, String xpath, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    private void logout(WebDriver driver) {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

    }
}

