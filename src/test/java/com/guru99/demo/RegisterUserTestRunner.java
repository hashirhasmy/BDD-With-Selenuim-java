package com.guru99.demo;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestApp;

@CucumberOptions(

        //we can use koma mark and specify multiple feature file locations inside the same sagala varahan
        //as a best practice follow in same package incluse stepdef classes and the testrunner class. Because onlycan have one test runner class
        features = {"src/test/resources/features/RegisterUser.feature"},
        glue = {"com.guru99.demo"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty/mercury-tours-RegisterUserTest",
                "json:target/cucumber-reports/json-reports/mercury-tours-RegisterUserTest.json",
        }


)
public class RegisterUserTestRunner{

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass()throws Exception{
        testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleWrapper pickleWrapper,FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][]features(){
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass()throws Exception{
         TestApp.getInstance().closeBrowser();
        testNGCucumberRunner.finish();
    }

}

