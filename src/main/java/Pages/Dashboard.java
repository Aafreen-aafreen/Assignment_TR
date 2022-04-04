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
    private By logo_home = By.xpath("//span[text()='XTREME']");
    private By logo_home_2 = By.xpath("//b[text()='CARS']");
    private By New_Car = By.xpath("//a[text()='NEW CAR']");
    private By Used_Car = By.xpath("//a[text()='USED CAR']");
    private By popular_section = By.xpath("//*[text()='Popular']");
    private By upcoming_section = By.xpath("//*[text()='Just Launched']");
    private By just_launched = By.xpath("//*[text()='Upcoming']");
    private By Find_Car = By.xpath("//*[text()='FIND YOUR DREAM CAR']");
    private By logo_button = By.xpath("//*[text()='XTREME']/parent::span");


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
        boolean c=true;
        for(int i=0;i<5;i++)
        {
            System.out.println("loop iteration is"+i);
            if(i==1)
            {driver.get("http://localhost:3000/all-cars/viewall");}
            else if(i==2)
            {driver.get("http://localhost:3000/booking-confirm");}
            else if(i==3)
            {driver.get("http://localhost:3000/car-detail/toyotacamry");}
            else if(i==4)
            {driver.get("http://localhost:3000/book-car");}
            else
            {}
            List<WebElement> hrefs = master.get_list_webelements(footer_links);
            if (hrefs.size() > 0) {
                System.out.println("=> The href is present..." + hrefs.size());
                System.out.println(hrefs);
                c = true;
            } else {
                System.out.println("=> The href is not present...");
                c = false;
            }

        }
    return c;
    }

    public void entercarname()
    {
        String s = prop.getProperty("carname");
        master.explicit_wait(search_box,20);
        boolean s2 = master.is_displayed(search_box);
        assert s2;
        master.sendKeys_action(search_box,s);
    }

    public void click_myProfile()
    {
        master.click_action(my_profile);

    }

    public void click_search_car() throws InterruptedException
    {
        master.explicit_wait(search_button,30);
        boolean x= master.is_displayed(search_button);
        assert x;
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

    public void validate_logo_presence()
    {
        boolean a = master.is_displayed(logo_home);
        assert a;
        boolean b = master.is_displayed(logo_home_2);
        assert b;
        driver.get("http://localhost:3000/all-cars/viewall");
        a = master.is_displayed(logo_home);
        assert a;
        b = master.is_displayed(logo_home_2);
        assert b;
        driver.get("http://localhost:3000/car-detail/toyotacamry");
        a = master.is_displayed(logo_home);
        assert a;
        b = master.is_displayed(logo_home_2);
        assert b;
        driver.get("http://localhost:3000/book-car");
        a = master.is_displayed(logo_home);
        assert a;
        b = master.is_displayed(logo_home_2);
        assert b;
        driver.get("http://localhost:3000/booking-confirm");
        a = master.is_displayed(logo_home);
        assert a;
        b = master.is_displayed(logo_home_2);
        assert b;
    }
    public void validate_newcar_usedcar_exists()
    {
        boolean a =master.is_displayed(New_Car);
        assert a;
        boolean b =master.is_displayed(Used_Car);
        assert b;
        driver.get("http://localhost:3000/all-cars/viewall");
        a = master.is_displayed(New_Car);
        assert a;
        b = master.is_displayed(Used_Car);
        assert b;
        driver.get("http://localhost:3000/car-detail/toyotacamry");
        a = master.is_displayed(New_Car);
        assert a;
        b = master.is_displayed(Used_Car);
        assert b;
        driver.get("http://localhost:3000/book-car");
        a = master.is_displayed(New_Car);
        assert a;
        b = master.is_displayed(Used_Car);
        assert b;
        driver.get("http://localhost:3000/booking-confirm");
        a = master.is_displayed(New_Car);
        assert a;
        b = master.is_displayed(Used_Car);
        assert b;

    }
    public void elements_static_validation ()
    {
        master.is_displayed(popular_section);
        master.is_displayed(upcoming_section);
        master.is_displayed(just_launched);
        master.is_displayed(Find_Car);
    }

    public void logo_functionality ()
    {
        driver.get("http://localhost:3000/all-cars/viewall");
        master.click_action(logo_button);
        String title = master.getTitle();
        master.assert_ignorecase(title,"Home");
        driver.get("http://localhost:3000/car-detail/toyotacamry");
        master.click_action(logo_button);
        title = master.getTitle();
        master.assert_ignorecase(title,"Home");
        driver.get("http://localhost:3000/book-car");
        master.click_action(logo_button);
        title = master.getTitle();
        master.assert_ignorecase(title,"Home");
        driver.get("http://localhost:3000/booking-confirm");
        master.click_action(logo_button);
        title = master.getTitle();
        master.assert_ignorecase(title,"Home");


    }

}



