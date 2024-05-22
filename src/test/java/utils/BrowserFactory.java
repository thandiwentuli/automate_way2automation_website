package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver driver;

    public static WebDriver startBrowser(String browserChoice, String url) {
        if ("chrome".equalsIgnoreCase(browserChoice)) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless"); //Do the same with other browsers, insert this line
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);//For the code to run headless you must intergrate it 1st, insert the "options" in ln19
        } else if ("firefox".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("edge".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

}
