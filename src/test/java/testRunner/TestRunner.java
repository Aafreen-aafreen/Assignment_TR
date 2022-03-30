package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.DataProvider;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Feature"},
        glue = {"Stepdefinition"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"})

//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
public class TestRunner {
    }


