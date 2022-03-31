package Pages;

import Utilities.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Booking
    {

        private By NameBox = By.xpath("//input[@placeholder='Enter Name']");
        private By ContactBox = By.xpath("//input[@placeholder='Enter Contact No']");
        private By CityBox = By.xpath("//input[@placeholder='Enter city']");
        private By Terms = By.xpath("//input[@type='checkbox']");
        private By Submit = By.xpath("//button[text()='SUBMIT']");
        private By RecieptDownload = By.xpath("//a[text()='Download']//following-sibling::b");
        private WebDriver driver;

        PropertyFileReader configReader = new PropertyFileReader();
        Properties prop = configReader.init_prop();
        private Master_page master;


        public  Booking(WebDriver driver)
        {
            this.driver = driver;
            master = new Master_page(this.driver);
        }


        public void validateDetailsonBooking()
        {
            String s = prop.getProperty("carname");
            String name = driver.findElement(By.xpath("//*[text()='"+s+"']")).getText();
            master.assert_ignorecase(s,name);

        }

        public void enterName()
        {
            String s = prop.getProperty("username");
            master.sendKeys_action(NameBox,s);
        }

        public void enterContactNumber()
        {
            String s = prop.getProperty("contact");
            master.sendKeys_action(ContactBox,s);
        }

        public void enterCity()
        {
            String s = prop.getProperty("city");
            master.sendKeys_action(CityBox,s);
        }

        public void selectTerms()
        {
           master.click_action(Terms);
        }

        public void submit()
        {
           master.click_action(Submit);
        }

        public void validateBooking()
        {
            String receipt= master.get_text(RecieptDownload);
            System.out.println(receipt);
            String s = prop.getProperty("validateBooking_msg");
            master.assert_ignorecase(receipt,s);
        }

    }

