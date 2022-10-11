package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;

public class swiggyAppSearchePlaces {
	ExtentSparkReporter spark=new ExtentSparkReporter("extent.html");
	ExtentReports extent=new ExtentReports();
	 private static Logger LOGGER = LoggerFactory.getLogger(swiggyAppSearchePlaces.class);
	WebDriver driver=null;	
	@BeforeSuite
	public void setUp() {
		spark=new ExtentSparkReporter("extent.html");
	    extent=new ExtentReports();
		extent.attachReporter(spark);
	}
	
	@Test
	public void test() throws InterruptedException {
		ExtentTest test=extent.createTest("first test","simple one");
		
		this.browser_is_open();
		this.user_on_swigg_application();
		this.user_enter_place_name();
		this.hits_enter();
		this.user_is_navigated_to_search_results();
		test.pass("done");
		test.log(Status.INFO, "this step to show case");
		test.info("this is info");
		test.addScreenCaptureFromBase64String("pictuer.png");
	}
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("inside step-browser is open");
		String projectpath=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver",projectpath+"/drivers/chromedriver/chromedriver.exe");
			
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
  
	@And("user on swiggApplication")
	public void user_on_swigg_application() throws InterruptedException {
		driver.navigate().to("https://www.swiggy.com");
        Thread.sleep(3000);
	}

	@When("user enter name of place")
	public void user_enter_place_name() {
		driver.findElement(By.xpath("//*[@id=\"location\"]")).sendKeys("Mumbai , Maharashtra, India");
		
	}
    
	@And("hits enter")
	public void hits_enter() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]/button[1]")).click();	
	
	Thread.sleep(3000);
	}
    @AfterTest
	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() throws InterruptedException {
		driver.getPageSource().contains("restaurants");
		
		//driver.close();
	}
    public void tearDown() {
    	extent.flush();
    }
	
}
