package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.io.InputStream;

public class SeleniumTutorial {
    private static String youtubeURL;
    private static String searchboxxpath;
    private static String searchtext;
    private static String firstvideoxpath;

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

        WebElement filterBtn = driver.findElement(By.xpath("//div[@id='filter-button']"));
        filterBtn.click();
        Thread.sleep(2000);

        WebElement videoFilter = driver.findElement(By.xpath("//div[@id='label' and @title='Search for Video']"));
        videoFilter.click();
        Thread.sleep(2000);

        filterBtn.click();
        Thread.sleep(2000);

        WebElement filterMin=driver.findElement(By.xpath("//div[@id='label' and @title='Search for Over 20 minutes']"));
        filterMin.click();
        Thread.sleep(2000);

        WebElement firstVideo = driver.findElement(By.xpath(firstvideoxpath));
        firstVideo.click();
    }
}