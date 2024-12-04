package upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class UdemyGoogleLoginAutomation {

    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the Udemy website
        driver.get("https://www.udemy.com/");

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click the "Sign In" button
        WebElement signInButton = driver.findElement(By.xpath("//span[@class='ud-btn-label' and text()='Log in']"));
        signInButton.click();

        // Wait for the sign-in page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        // Find the Google Sign-In button (Check for Google sign-in availability)
        WebElement googleSignInButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'Sign in with Google')]"));
        googleSignInButton.click();

        // Switch to the Google login page if necessary
        // Wait for email input to be visible
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        emailField.sendKeys("your-email@gmail.com"); // Replace with your Google email

        // Click Next to proceed to the password field
        driver.findElement(By.id("identifierNext")).click();

        // Wait for the password input to be visible
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("your-password"); // Replace with your Google password

        // Click Next to sign in
        driver.findElement(By.id("passwordNext")).click();

        // Wait until the Udemy home page or logged-in page is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ud-app-loader ud-app-loader--is-hidden']")));

        // Now you should be logged into Udemy successfully via your Google account
        System.out.println("Logged in successfully via Google on Udemy!");

        // Close the browser after the task is completed
        driver.quit();
    }
}
