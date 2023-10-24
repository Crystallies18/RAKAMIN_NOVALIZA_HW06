package cucumber.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfig {
	
    private WebDriver driver;
    
    private static DriverConfig instance;

    public static synchronized DriverConfig getInstance() {
        if(instance == null)
            instance = new DriverConfig();
            
        return instance;
    }

    public DriverConfig() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--headless");

        driver = new ChromeDriver(opts);
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver() {
        if(driver != null)
            driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
