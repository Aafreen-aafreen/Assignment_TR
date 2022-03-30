package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.apache.log4j.PropertyConfigurator;



public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
    static final Logger logger = LogManager.getLogger("DriverFactory");



    /**
     * This method is used to initialize the thradlocal driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return tldriver.
     */
    public WebDriver init_driver(String browser) {
        DOMConfigurator.configure("/Users/firdi/Library/CloudStorage/OneDrive-Deloitte(O365D)/TR_Training/src/log_config.xml");
        try {
            System.out.println("browser value is: " + browser);
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
                logger.info("Setting browser value");
            } else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
            } else if (browser.equals("safari")) {
                tlDriver.set(new SafariDriver());
            } else {
                System.out.println("Please pass the correct browser value: " + browser);
            }

            getDriver().manage().deleteAllCookies();
            getDriver().manage().window().maximize();
            return getDriver();
        } catch (Exception e) {
            logger.info("Exception occured while raising the browser");
            logger.error(e.toString());
            return getDriver();
        }

    }
    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver()
    {
        return tlDriver.get();
    }
}

