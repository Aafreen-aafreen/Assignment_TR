package Stepdefinition;

import Pages.Booking;
import Pages.CarList;
import Pages.Dashboard;
import Utilities.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;

public class dashboard_page {
    static final Logger logger = LogManager.getLogger("dashboard_page");
    private WebDriver driver = DriverFactory.getDriver();
    String log_file_name = "/Users/firdi/Library/CloudStorage/OneDrive-Deloitte(O365D)/TR_Training/src/log_config.xml";
    private Dashboard d = new Dashboard(driver);
    private CarList c = new CarList(driver);
    private Booking b = new Booking(driver);

    @Given("launching application & validate the title of the page")
    public void validateTheTitleOfThePage() {
        System.out.println("Step");
        System.out.println(driver);
        DOMConfigurator.configure(log_file_name);
        String title = d.getDashboardPageTitle();
        assertEquals(title, "Home");
        logger.info("Successfully landed on the application");
    }

    @Then("validate my profile button exists")
    public void validateTheMYProfileLink() {
        boolean a;
        a = d.is_my_profileExist();
        assert a;
        logger.info("My Profile link exists on the dashboard");

    }

    @Then("validate the details of my profile page")
    public void validateTheDetailsOfThePage() {
        try {
        boolean b;
        b = d.is_my_profileExist();
        assert b;
        logger.info("My Profile link is enabled on the dashboard");
        logger.info("Testcase Validate_My_Profile passed");
        } catch (Exception e) {
            logger.info("Testcase Validate_My_Profile failed");
            logger.error(e);
        }

    }


    @And("validate search results")
    public void validateSearchResults() {


    }

    @Then("search for a car")
    public void searchForACar() throws InterruptedException {
        try {
            d.entercarname();
            d.click_search_car();
            logger.info("Testcase Validate Search functionality is pass");
        }
        catch(Exception e)
        {
            logger.info("Testcase Validate Search functionality is failed");
            logger.error(e);
        }
    }

    @Then("validate links in the Footer")
    public void validateLinksInTheFooter() {
        try{
      boolean c=  d.is_FooterLinks_clickable();
      System.out.println(c);
      assertEquals(c, true);
      logger.info("Testcase Validate Footer link validation is pass");

    }
        catch(Exception e)
        {
            logger.info("Testcase Validate Footer link  is failed");
            logger.error(e);
        }
}

    @And("validate if all cars are listed on car listing page")
    public void validateIfAllCarsAreListedOnCarListingPage() {
        try{
       boolean res = c.is_Allcars_present();
       assert res;
       logger.info("Testcase Validate Car listing is pass");
        }
        catch(Exception e)
        {
            logger.info("Testcase Validate Car listing  is failed");
            logger.error(e);
    }}

    @Then("click on view all cars button on dashboard")
    public void clickOnViewAllCarsButtonOnDashboard() throws InterruptedException {
        logger.info("Navigating to car listing page");
        d.click_ViewAll();

    }
    //Saleem's code////////////////////////////
    



    @Then("Click on Book Now")
    public void clickOnBookNow() throws InterruptedException {
        c.click_bookButton();
    }

  

   

    @Then("Check the terms and conditions")
    public void checkTheTermsAndConditions() {
        b.selectTerms();
    }

    @Then("Click on Submit button")
    public void clickOnSubmitButton() {
        b.submit();
    }

    

    @Then("Validate the booking is successful")
    public void validateTheBookingIsSuccessful() {
        b.validateBooking();
    }

    @Then("Enter the name in username textbox on Booking page")
    public void enterTheNameInUsernameTextboxOnBookingPage() {
        b.enterName();
    }

    @Then("Enter the Contact No in contact number texbox on Booking page")
    public void enterTheContactNoInContactNumberTexboxOnBookingPage() {
        b.enterContactNumber();
    }

    @Then("Enter the City in city textbox on Booking page")
    public void enterTheCityInCityTextboxOnBookingPage() {
        b.enterCity();
    }

    @And("Click the Car  you want to book")
    public void clickTheCarYouWantToBook() throws InterruptedException {
        d.bookCar();
    }

    @Then("Validate the car details of in car details page")
    public void validateTheCarDetailsOfInCarDetailsPage() {
        c.validateDetails();
    }

    @Then("Validate the car details of selected car on booking page")
    public void validateTheCarDetailsOfSelectedCarOnBookingPage() {
        b.validateDetailsonBooking();
    }
}
