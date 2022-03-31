package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CarList {
    private WebDriver driver;
    public  CarList(WebDriver driver)
    {

        this.driver = driver;
    }
    private By AllCars = By.xpath("//div//img[@class='card-img-top']");
    public boolean is_Allcars_present() {
        List<WebElement> hrefs = driver.findElements(AllCars);
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
}
