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
        try {
            System.out.println("Step");
            System.out.println(driver);
            DOMConfigurator.configure(log_file_name);
            String title = d.getDashboardPageTitle();
            assertEquals(title, "Home");
            logger.info("Successfully landed on the application");
        }
        catch (Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }
    }

    @Then("validate my profile button exists")
    public void validateTheMYProfileLink() {
        try {

            boolean a;
            a = d.is_my_profileExist();
            assert a;
            logger.info("My Profile link exists on the dashboard");
        }
        catch(Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }

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
            assert false;
        }

    }


    @And("validate search results")
    public void validateSearchResults() {


    }

    @Then("search for a car")
    public void searchForACar() throws InterruptedException {
        try {
            d.entercarname();
            logger.info("Search bar is validated");
        }
        catch(Exception e)
        {
            logger.info("Search bar validation is failed");
            logger.error(e);
            assert false;
        }
    }

    @Then("validate links in the Footer")
    public void validateLinksInTheFooter() {
        try{
      boolean c=  d.is_FooterLinks_clickable();
      logger.info("Number of footer links are" + c);
      assertEquals(c, true);
      logger.info("Testcase Validate Footer link validation is pass");

    }
        catch(Exception e)
        {
            logger.info("Testcase Validate Footer link  is failed");
            logger.error(e);
            assert false;
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
            assert false;
    }}

    @Then("click on view all cars button on dashboard")
    public void clickOnViewAllCarsButtonOnDashboard() throws InterruptedException {
        try {
            logger.info("Navigating to car listing page");
            d.click_ViewAll();
        }
        catch(Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }

    }
    //Saleem's code////////////////////////////
    



    @Then("Click on Book Now")
    public void clickOnBookNow() throws InterruptedException {
        try {
            c.click_bookButton();
        }
        catch(Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }
    }

  

   

    @Then("Check the terms and conditions")
    public void checkTheTermsAndConditions() {
        try {
            b.selectTerms();
        }
        catch(Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }
    }

    @Then("Click on Submit button")
    public void clickOnSubmitButton() {
        try{
            b.submit();
        }
        catch(Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }
    }

    

    @Then("Validate the booking is successful")
    public void validateTheBookingIsSuccessful() {
        try{
            b.validateBooking();
        }
        catch(Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }
    }

    @Then("Enter the name in username textbox on Booking page")
    public void enterTheNameInUsernameTextboxOnBookingPage() {
       try{
           b.enterName();
       }
       catch(Exception e)
       {
           logger.info("Exception occurred,please refer the details below");
           logger.error(e);
           assert false;
       }
    }

    @Then("Enter the Contact No in contact number texbox on Booking page")
    public void enterTheContactNoInContactNumberTexboxOnBookingPage() {
        try{
            b.enterContactNumber();
        }
        catch(Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }
    }

    @Then("Enter the City in city textbox on Booking page")
    public void enterTheCityInCityTextboxOnBookingPage() {
        try{
            b.enterCity();
        }
        catch(Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }
    }

    @And("Click the Car  you want to book")
    public void clickTheCarYouWantToBook() throws InterruptedException {
       try{
           d.bookCar();
       }
       catch(Exception e)
       {
           logger.info("Exception occurred,please refer the details below");
           logger.error(e);
           assert false;
       }
    }

    @Then("Validate the car details of in car details page")
    public void validateTheCarDetailsOfInCarDetailsPage() {
       try{
           c.validateDetails();
       }
       catch(Exception e)
       {
           logger.info("Exception occurred,please refer the details below");
           logger.error(e);
           assert false;
       }
    }

    @Then("Validate the car details of selected car on booking page")
    public void validateTheCarDetailsOfSelectedCarOnBookingPage() {
        try{
            b.validateDetailsonBooking();
        }
        catch(Exception e)
        {
            logger.info("Exception occurred,please refer the details below");
            logger.error(e);
            assert false;
        }
    }

    @And("validate search bar & search button are present")
    public void validateSearchBarSearchButtonArePresent() throws InterruptedException {
        try {
            d.click_search_car();
            logger.info("Testcase Validate Search functionality is pass");
        }
        catch(Exception e)
        {
            logger.info("Testcase Validate Search functionality is failed");
            logger.error(e);
            assert false;
        }
    }

    @And("validating if logo is present across the website")
    public void validatingIfLogoIsPresentAcrossTheWebsite() {
    try{
        d.validate_logo_presence();
    }
    catch(Exception e)
    {
        logger.info("Testcase validatingIfLogoIsPresentAcrossTheWebsite is failed");
        logger.error(e);
        assert false;
    }
    }

    @And("Validate New Car & Used car exists across all webpages")
    public void validateNewCarUsedCarExistsacrossallwebpages() {
        try{
            d.validate_newcar_usedcar_exists();
        }
        catch(Exception e)
        {
            logger.info("Testcase Validate New Car & Used car exists on homepage is failed");
            logger.error(e);
            assert false;
        }
    }

    @And("Validate Find your car , popular ,Just launched,upcoming static elements appear in home page")
    public void validateFindYourCarPopularJustLaunchedUpcomingStaticElementsAppearInHomePage() {
        try
        {
        d.elements_static_validation();
            logger.info("Testcase Validate Find your car , popular ,Just launched,upcoming static elements appear in home page is passed");

        }
        catch(Exception e)
        {
            logger.info("Testcase Validate Find your car , popular ,Just launched,upcoming static elements appear in home page is failed");
            logger.error(e);
            assert false;
        }
    }

    @And("Validate the on click of logo , user is taken to homepage")
    public void validateTheOnClickOfLogoUserIsTakenToHomepage() {
        try
        {
            d.logo_functionality();
            logger.info("Testcase Validate the on click of logo , user is taken to homepage is passed");

        }
        catch(Exception e)
        {
            logger.info("Testcase Validate the on click of logo , user is taken to homepage is failed");
            logger.error(e);
            assert false;
        }
    }
}
