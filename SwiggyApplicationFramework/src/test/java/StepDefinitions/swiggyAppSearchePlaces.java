package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class swiggyAppSearchePlaces {
	WebDriver driver=null;	
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

	@When("user enter place name")
	public void user_enter_place_name() {
		driver.findElement(By.xpath("//*[@id=\"location\"]")).sendKeys("Mumbai , Maharashtra, India");
		
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"location\"]")).click();	
	Thread.sleep(3000);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() throws InterruptedException {
		driver.getPageSource().contains("restaurants");
		
		driver.close();
	}
}
