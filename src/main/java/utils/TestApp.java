package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;

public class TestApp {
    private WebDriver driver;
    private static TestApp myObj;
    // public static WebDriver driver;
    PropertyFileReader property = new PropertyFileReader();
    String selectopenBrowser = property.getProperty("config","Browser");

    public static TestApp getInstance() {
        if (myObj == null) {
            myObj = new TestApp();
            return myObj;
        } else {
            return myObj;
        }
    }

    //get the selenium driver
    public WebDriver getDriver() {
        return driver;
    }

    //when selenium opens the browsers it will automatically set the web driver
    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static void setMyObj(TestApp myObj) {
        TestApp.myObj = myObj;
    }

    public void openBrowser() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        try {
            switch (selectopenBrowser){
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "EDGE":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    //to execute using firefox driver we need this brwoser in out matchine as installed. other wise this not get work
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void navigateToURL() {
        String url = property.getProperty("config", "url");
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public WebElement waitUntilNextElementAppears(By locator, Duration timeout) {
        WebElement element = new WebDriverWait(TestApp.getInstance().getDriver(), timeout).until
                (ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }


    public void setText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    private String getChromeDriverFilePath() {
        URL res = getClass().getClassLoader().getResource("chromedriver");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }


    public void takeScreenshot(){
        File screenshot = ((TakesScreenshot) TestApp.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("Screenshot.png"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
