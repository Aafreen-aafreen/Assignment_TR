package Stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import Utilities.*;
import testRunner.TestRunner;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private PropertyFileReader configReader;
    Properties prop;
    String log_file_name = "/Users/firdi/Library/CloudStorage/OneDrive-Deloitte(O365D)/TR_Training/src/log_config.xml";
    static final Logger logger = LogManager.getLogger("ApplicationHooks");



    @Before(order = 0)
    public void getProperty() {
        configReader = new PropertyFileReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() throws InterruptedException {
        DOMConfigurator.configure(log_file_name);
        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("url");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
        logger.info("Launching browser");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Entering the url.....");
        Thread.sleep(3000);

    }




    @After(order = 0)
    public void quitBrowser() throws InterruptedException {
        DOMConfigurator.configure(log_file_name);
        Thread.sleep(3000);
        logger.info("closing the browser");
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
                String screenshotName = scenario.getName().replaceAll(" ", "_");
                logger.info("Screen"+screenshotName);
                byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                //String des="/Users/firdi/Library/CloudStorage/OneDrive-Deloitte(O365D)/TR_Training/test-output/Capture/"+screenshotName+".png";
                scenario.attach(sourcePath, "image/png", screenshotName);
               /* TakesScreenshot ts = (TakesScreenshot) driver;
                File sourcePath1 = ts.getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
                File destinationPath = new File(des);
                FileUtils.copyFile(sourcePath1, destinationPath);
                //Reporter.addScreenCaptureFromPath(destinationPath.toString()); */

            } catch (Exception e) {
                logger.info("Exception occurred while capturing screenshot");
                logger.error(e.toString());
            }
        }


        }}

