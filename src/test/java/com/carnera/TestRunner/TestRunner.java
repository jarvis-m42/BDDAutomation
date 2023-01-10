package com.carnera.TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "features/CarneraHomepage.feature",
        glue = {"com.carnera.StepDefs"},
        tags = "@UATTesting",plugin = {"pretty",
        "html:target/site/cucumber-pretty.html",
        "json:target/cucumber.json"},
        monochrome = true)
public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass()throws Exception{
        testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "scenarios")
    public void feature(PickleWrapper pickle, FeatureWrapper cucumberFeature){
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception{
        testNGCucumberRunner.finish();
    }





}
