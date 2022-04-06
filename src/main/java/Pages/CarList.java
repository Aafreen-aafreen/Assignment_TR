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
    private By ViewAll=By.xpath("//b[text()='View all']/following-sibling::img");
    private By totalNumberOfCar=By.xpath("//div[@class='mt-3 row']/h6");
    private By Sedan=By.xpath("//a[text()='Sedan']");
    private By totalNumberOfSedan=By.xpath("//div[@class='mt-3 row']/h6");
    private By SUV=By.xpath("//a[text()='SUV']");
    private By totalNumberOfSUV=By.xpath("//div[@class='mt-3 row']/h6");
    private By HatchBack=By.xpath("//a[text()='HatchBack']");
    private By totalNumberOfHatchBack=By.xpath("//div[@class='mt-3 row']/h6");
    private By Coupe=By.xpath("//a[text()='Coupe']");
    private By totalNumberOfCoupe=By.xpath("//div[@class='mt-3 row']/h6");

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
    public void click_ViewAllButton() throws InterruptedException {
        master.scroll_operation("500");
        Thread.sleep(3000);
        master.click_action(ViewAll);
        Thread.sleep(3000);
    }

    public void countTheTotalCars() throws InterruptedException {
        master.scroll_operation("-500");
        Thread.sleep(3000);
        String totalNumber=master.get_text(totalNumberOfCar);
        int a= Integer.parseInt(totalNumber.replaceAll("[\\D]", ""));
        System.out.println(totalNumber);
        System.out.println(a);
        Thread.sleep(3000);
        master.click_action(Sedan);
        String sedanNumber=master.get_text(totalNumberOfSedan);
        int a1= Integer.parseInt(sedanNumber.replaceAll("[\\D]", ""));
        System.out.println(sedanNumber);
        System.out.println(a1);
        Thread.sleep(3000);
        master.click_action(SUV);
        String SUVNumber=master.get_text(totalNumberOfSUV);
        int a2= Integer.parseInt(SUVNumber.replaceAll("[\\D]", ""));
        System.out.println(SUVNumber);
        System.out.println(a2);
        Thread.sleep(3000);
        master.click_action(HatchBack);
        String hatchNumber=master.get_text(totalNumberOfHatchBack);
        int a3= Integer.parseInt(hatchNumber.replaceAll("[\\D]", ""));
        System.out.println(hatchNumber);
        System.out.println(a3);
        Thread.sleep(3000);
        master.click_action(Coupe);
        String CoupeNumber=master.get_text(totalNumberOfCoupe);
        int a4= Integer.parseInt(CoupeNumber.replaceAll("[\\D]", ""));
        System.out.println(CoupeNumber);
        System.out.println(a4);
        Thread.sleep(3000);
        int total=a1+a2+a3+a4;
        System.out.println("total "+total);
        assert a1==total;

    }
}
