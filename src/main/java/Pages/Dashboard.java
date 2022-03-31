package Pages;


import Utilities.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Properties;


public class Dashboard
{
    private WebDriver driver;
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By my_profile = By.linkText("MY PROFILE");
    private By search_button = By.xpath("//*[text()='SEARCH'])[2])");
    private By search_box= By.xpath("(//input[@placeholder='Enter car name...'])[2]");
    private By footer_links = By.xpath("//footer//a");
    private By ViewAll = By.xpath("//a[@class='link-viewall']");


    PropertyFileReader configReader = new PropertyFileReader();
    Properties prop = configReader.init_prop();
    private Master_page master;


    // 2. Constructor of the page class:
    public  Dashboard(WebDriver driver)
    {
        this.driver = driver;
        master = new Master_page(this.driver);
    }



    public String getDashboardPageTitle()
    {

        String title = master.getTitle();
        return title;
    }

    public boolean is_my_profileExist()
    {

        boolean c = master.is_displayed(my_profile);
        return c;
    }

    public boolean is_my_profile_clickable()
    {
        boolean c = master.is_enabled(my_profile);
        return c;
    }

    public boolean is_FooterLinks_clickable()
    {
       List<WebElement>  hrefs = master.get_list_webelements(footer_links);
        boolean c;
        if(hrefs.size() > 0) {
            System.out.println("=> The href is present..."+hrefs.size());
            System.out.println(hrefs);
            hrefs.get(0).click();
            c = true;
        }
        else
        {
            System.out.println("=> The href is not present...");
            c = false;
        }
    return c;
    }

    public void entercarname()
    {
        String s = prop.getProperty("carname");
        master.explicit_wait(search_box,10);
        master.sendKeys_action(search_box,s);
    }

    public void click_myProfile()
    {
        master.click_action(my_profile);

    }

    public void click_search_car() throws InterruptedException
    {
        master.explicit_wait(search_button,20);
        master.click_action(search_button);
        Thread.sleep(3000);
    }

    public void click_ViewAll() throws InterruptedException
    {
        master.scroll_operation("600");
        Thread.sleep(3000);
        master.click_action(ViewAll);
    }

    public void bookCar() throws InterruptedException
    {
        String s = prop.getProperty("carname");
        master.scroll_operation("750");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='"+s+"']//parent::div//a/img")).click();
    }

    }



