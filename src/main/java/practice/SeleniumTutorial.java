package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Properties;
import java.io.InputStream;

public class SeleniumTutorial {
    private static String searchboxxpath;
    private static String searchtext;
    private static String firstvideoxpath;
    private static String filterbuttonxpath;
    private static String videofilterbutton;
    private static String filtermin;
    private static String sortbydropdown;
    private static String uploaddateoption;


    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        //try to run code section,if there is any error, it goes to catch section.
        //config.properties file load set as a string in input variable.
        // files always load as a string by default.

        String youtubeURL;
        try (InputStream input = SeleniumTutorial.class.getClassLoader().getResourceAsStream("config.properties")) {
            //error handling
            if (input == null) {
                System.out.println("Unable to find config.properties");
                return;
            }
            // string converted into key value pair.
            properties.load(input);

            youtubeURL = properties.getProperty("youtube.url");
            searchboxxpath = properties.getProperty("search.box.xpath");
            searchtext = properties.getProperty("search.text");
            firstvideoxpath = properties.getProperty("first.video.xpath");
            filterbuttonxpath=properties.getProperty("filter.button.xpath");
            videofilterbutton=properties.getProperty("video.filter.button");
            filtermin=properties.getProperty("filter.min");
            sortbydropdown=properties.getProperty("sort.by.dropdown");
            uploaddateoption=properties.getProperty("upload.date.option");

        } catch (Exception e) { //used to access information about the exception.
            e.printStackTrace(); //stack trace provides information about where the exception occurred
            return;
        }

        WebDriver driver = new ChromeDriver();

        driver.get(youtubeURL);
        waits.waitForPageToLoad(driver, 10);
        driver.manage().window().maximize();

        WebElement searchBox = waits.waitForElementToBeClickable(driver, searchboxxpath, 10);
        searchBox.sendKeys(searchtext);
        searchBox.submit();
        waits.waitForPageToLoad(driver, 10);

        WebElement filterBtn = waits.waitForElementToBeClickable(driver, filterbuttonxpath, 10);
        filterBtn.click();

        WebElement videoFilter = waits.waitForElementToBeClickable(driver, videofilterbutton, 10);
        videoFilter.click();

        filterBtn.click();

        WebElement filterMin = waits.waitForElementToBeClickable(driver, filtermin, 10);
        filterMin.click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Interact with Sort by Dropdown
//        filterBtn.click();
//        Thread.sleep(2000);
//
//        WebElement sortByDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sortbydropdown)));
//        sortByDropdown.click();
//
//        // Select "Upload date" from the dropdown
//        WebElement uploadDateOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(uploaddateoption)));
//        uploadDateOption.click();

        WebElement firstVideo = waits.waitForElementToBeClickable(driver, firstvideoxpath, 10);
        firstVideo.click();
        waits.waitForPageToLoad(driver, 10);

    }
}