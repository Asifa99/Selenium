package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Youtubevideo {
    private WebDriver driver;

    public void setUp() {
        // This is like a key, location of ChromeDriver file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
    }
    public void searchVideo() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until the search box is visible and type the search term
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
            searchBox.sendKeys("selenium tutorial");

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='search-icon-legacy']")));
            searchButton.click();

            WebElement filterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//yt-formatted-string[text()='FILTER']")));
            filterButton.click();


            WebElement typeFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//yt-formatted-string[text()='Video']")));
            typeFilter.click();


            WebElement durationFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//yt-formatted-string[text()='Over 20 minutes']")));
            durationFilter.click();

            Thread.sleep(5000);  // Wait for 5 seconds after applying filters

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Youtubevideo test = new Youtubevideo();
        test.setUp();
        test.searchVideo();
    }
}
