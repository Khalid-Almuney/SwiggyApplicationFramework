import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SwiggyApplication {
	public static void main(String[] args) throws InterruptedException {
		String projectpath=System.getProperty("user.dir");
			
		System.setProperty("webdriver.chrome.driver",projectpath+"/drivers/chromedriver/chromedriver.exe");
			
		WebDriver driver=new ChromeDriver();
			
		driver.get("https://www.swiggy.com");
		
		
		
		System.out.print("Completed");
		
		Thread.sleep(3000);
		
		//driver.close();
	}
}
