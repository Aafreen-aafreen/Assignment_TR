package Stepdefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/java/Feature/Dashboard.feature"},
        glue = {"Stepdefinition"},
        plugin = {"pretty","json:target/cucumber-reports/Cucumber_3.json"})
//"json:target/cucumber-reports/Cucumber.json"
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
public class TestRunner_3 extends AbstractTestNGCucumberTests {
@Override
@DataProvider(parallel = true)
public Object[][] scenarios() {
    return super.scenarios();
}




}