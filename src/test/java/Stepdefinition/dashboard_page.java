package Stepdefinition;

import Pages.Dashboard;
import Utilities.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import static junit.framework.TestCase.assertEquals;

public class dashboard_page {
    static final Logger logger = LogManager.getLogger("dashboard_page");
    String log_file_name = "/Users/firdi/Library/CloudStorage/OneDrive-Deloitte(O365D)/TR_Training/src/log_config.xml";
    private Dashboard d = new Dashboard(DriverFactory.getDriver());

    @Given("launching application & validate the title of the page")
    public void validateTheTitleOfThePage() {
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
}}