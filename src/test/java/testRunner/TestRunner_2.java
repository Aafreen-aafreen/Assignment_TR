package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/java/Feature"},
            glue = {"Stepdefinition"},
            plugin = {"pretty","json:target/cucumber-reports/Cucumber.json"})

//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
    public class TestRunner_2 {




}
