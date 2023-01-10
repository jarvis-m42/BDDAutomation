package com.carnera.StepDef;

import com.carnera.Utility.PropertyFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Properties;

public class CarneraHomepageStepDef {

    public  static WebDriver driver;

    PropertyFileReader obj = new PropertyFileReader();

    @Given("Open chrome browser and enter URL")
    public void openChromeBrowserAndEnterURL() throws Throwable{
        Properties properties=obj.getProperty();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("browser.baseURL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @When("See on homepage verify title")
    public void seeOnHomepageVerifyTitle() throws Throwable{
        Assert.assertEquals(driver.getTitle(),"Hire Remote Software Engineering Teams, on-demand | Carnera");
    }

    @And("Verify homepage index of various pages")
    public void verifyHomepageIndexOfVariousPages() throws  Throwable{
        Thread.sleep(3000);
        driver.quit();
    }
//verbose="2" preserve-order="true"
    ///Users/harender/IdeaProjects/BDDAutomation/src/test/java/com/carnera/TestRunner/TestRunner.java
}
