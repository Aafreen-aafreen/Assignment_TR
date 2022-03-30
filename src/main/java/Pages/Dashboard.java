package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;


public class Dashboard {
    private WebDriver driver;

    // 1. By Locators: OR
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By my_profile = By.linkText("MY PROFILE");
    private By search_button = By.xpath("//*[text()='SEARCH'])[2])");
    private By search_box= By.xpath("(//input[@placeholder='Enter car name...'])[2]");
    private By footer_links = By.xpath("//footer//a");

    // 2. Constructor of the page class:
    public  Dashboard(WebDriver driver)
    {

        this.driver = driver;
    }


    public String getDashboardPageTitle()
    {
        return driver.getTitle();
    }

    public boolean is_my_profileExist() {
        return driver.findElement(my_profile).isDisplayed();
    }

    public boolean is_my_profile_clickable() {

        return driver.findElement(my_profile).isEnabled();
    }

    public boolean is_FooterLinks_clickable() {
        List<WebElement> hrefs = driver.findElements(footer_links);
        boolean c;
        if(hrefs.size() > 0) {
            System.out.println("=> The href is present..."+hrefs.size());
            System.out.println(hrefs);
            hrefs.get(0).click();
            c = true;

        } else {
            System.out.println("=> The href is not present...");
            c = false;
        }
return c;
    }

    public void entercarname() {
        WebDriverWait wait=  new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(search_box));
        driver.findElement(search_box).sendKeys("Maruti");

    }


    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void click_myProfile() {

        driver.findElement(my_profile).click();
    }
    public void click_search_car() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(search_button));
        driver.findElement(search_button).click();
        Thread.sleep(3000);

    }



    }



