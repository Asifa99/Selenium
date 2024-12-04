package practice;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;
import java.io.InputStream;

public class SeleniumTutorial {
    private static String youtubeURL;
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

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        WebDriver driver = new ChromeDriver();

        driver.get(youtubeURL);
        Thread.sleep(1000);

        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By.xpath(searchboxxpath));
        searchBox.sendKeys(searchtext);
        searchBox.submit();
        Thread.sleep(2000);

        WebElement filterBtn = driver.findElement(By.xpath(filterbuttonxpath));
        filterBtn.click();
        Thread.sleep(2000);

        WebElement videoFilter = driver.findElement(By.xpath(videofilterbutton));
        videoFilter.click();
        Thread.sleep(2000);

        filterBtn.click();
        Thread.sleep(2000);

        WebElement filterMin=driver.findElement(By.xpath(filtermin));
        filterMin.click();
        Thread.sleep(2000);

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

        WebElement firstVideo = driver.findElement(By.xpath(firstvideoxpath));
        firstVideo.click();


    }
}