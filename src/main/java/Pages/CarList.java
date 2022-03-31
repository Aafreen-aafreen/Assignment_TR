package Pages;

import Utilities.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Properties;

public class CarList
{
    private WebDriver driver;
    private By CarName=By.xpath("//p[@class='heading']");
    private By BookNow=By.xpath("//button[text()='BOOK NOW']//parent::a");
    private By AllCars = By.xpath("//div//img[@class='card-img-top']");

    PropertyFileReader configReader = new PropertyFileReader();
    Properties prop = configReader.init_prop();
    private Master_page master ;

    public  CarList(WebDriver driver)
    {

        this.driver = driver;
        master = new Master_page(this.driver);
    }


    public boolean is_Allcars_present()
    {
        List<WebElement> hrefs = master.get_list_webelements(AllCars);
        boolean c;
        if(hrefs.size() == 12) {
            System.out.println("=> All cars are present...and number of cars in listing page is"+hrefs.size());
            System.out.println(hrefs);
            c = true;
        } else {
            System.out.println("=> The href is not present...");
            c = false;
        }
        return c;
    }

    public void validateDetails()
    {
        String name= master.get_text(CarName);
        String actualcar = prop.getProperty("carname");
        System.out.println(name);
        master.assert_ignorecase(actualcar,name);
    }

    public void click_bookButton() throws InterruptedException
    {
        master.scroll_operation("1700");
        Thread.sleep(3000);
        master.click_action(BookNow);
        Thread.sleep(3000);
    }
}
