package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.Properties;
import java.io.InputStream;

public class SeleniumTutorial {

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();

        //try to run code section,if there is any error, it goes to catch section.
        //config.properties file load set as a string in input variable.
        // files always load as a string by default.

        String youtubeurl;
        String searchboxxpath;
        String searchtext;
        String firstvideoxpath;
        String filterbuttonxpath;
        String videofilterbutton;
        String filtermin;
        try (InputStream input = SeleniumTutorial.class.getClassLoader().getResourceAsStream("config.properties")) {
            //error handling
            if (input == null) {
                System.out.println("Unable to find config.properties");
                return;
            }
            // string converted into key value pair.
            properties.load(input);

            youtubeurl = properties.getProperty("youtube.url");
            searchboxxpath = properties.getProperty("search.box.xpath");
            searchtext = properties.getProperty("search.text");
            firstvideoxpath = properties.getProperty("first.video.xpath");
            filterbuttonxpath =properties.getProperty("filter.button.xpath");
            videofilterbutton =properties.getProperty("video.filter.button");
            filtermin =properties.getProperty("filter.min");

        } catch (Exception e) { //used to access information about the exception.
            e.printStackTrace(); //stack trace provides information about where the exception occurred
            return;
        }

        WebDriver driver = new ChromeDriver();

        driver.get(youtubeurl);
        waits.waitForPageToLoad(driver, 10);
        driver.manage().window().maximize();

        String expectedTitle = "YouTube"; // Example expected title
        String actualTitle = driver.getTitle();
        assert expectedTitle.equals(actualTitle) : "Title mismatch! Expected: " + expectedTitle + ", but got: " + actualTitle;

        WebElement searchBox = waits.waitForElementToBeClickable(driver, searchboxxpath, 10);
        searchBox.sendKeys(searchtext);
        searchBox.submit();
        assert searchBox.isDisplayed() : "Search box is not displayed on the page.";

        Thread.sleep(1000);
        WebElement filterBtn = waits.waitForElementToBeClickable(driver, filterbuttonxpath, 10);
        filterBtn.click();
        Thread.sleep(1000);
        assert filterBtn.isEnabled() : "Filter button is not clickable.";

        WebElement videoFilter = waits.waitForElementToBeVisible(driver, videofilterbutton, 10);
        videoFilter.click();
        Thread.sleep(1000);
        assert videoFilter.isDisplayed() : "Video filter button is not displayed.";
        assert videoFilter.isEnabled() : "Minutes filter option is not clickable.";

        filterBtn.click();
        Thread.sleep(1000);

        WebElement filterMin = waits.waitForElementToBeVisible(driver, filtermin, 10);
        filterMin.click();
        assert filterMin.isDisplayed() : "Video filter button is not displayed.";
        assert filterMin.isEnabled() : "Minutes filter option is not clickable.";
        Thread.sleep(1000);


        // Wait for the page to reload and validate that the minutes filter is applied
        waits.waitForPageToLoad(driver, 10);
        assert Objects.requireNonNull(driver.getPageSource()).contains("minutes") : "Minutes filter was not applied correctly.";

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstVideo = waits.waitForElementToBeClickable(driver, firstvideoxpath, 10);
        firstVideo.click();
        assert firstVideo.isDisplayed() : "First video is not visible or available to click.";
        waits.waitForPageToLoad(driver, 10);

    }
}