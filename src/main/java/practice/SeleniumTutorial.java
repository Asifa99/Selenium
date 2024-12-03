package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTutorial {

    public static void main(String[] args) {
        String youtubeURL = "https://www.youtube.com/";
        String searchBoxXpath = "//input[@id='search']";
        String searchtext = "Selenium tutorial";
        String firstVideoXpath = "//ytd-video-renderer[1]//a[@id='thumbnail']";

        WebDriver driver = new ChromeDriver();
        driver.get(youtubeURL);
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath(searchBoxXpath));
        searchBox.sendKeys(searchtext);
        searchBox.submit();
        WebElement firstVideo = driver.findElement(By.xpath(firstVideoXpath));
        firstVideo.click();
    }
}
//new