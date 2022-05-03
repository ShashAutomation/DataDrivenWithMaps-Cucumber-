package Stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {
	WebDriver driver;
	@Given("User in google home page")
	public void user_in_google_home_page() {
		System.setProperty("webdriver.chrome.driver", "F:\\selenium projects\\seleniumtestngprojects\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		
	}
		@Given ("google title test")
		public void google_title_test() {
			String title=driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Google");
		}
		@When ("user in dropbox loginpage")
		public void user_in_instagram_home_page()  {
			driver.navigate().to("https://www.dropbox.com/login");
			boolean b=driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).isDisplayed();
			 Assert.assertTrue(b);
        }
		@When ("dropbox title test")
		public void Instagram_title_test() throws InterruptedException  {
		    System.out.println(driver.getTitle());
		   
		}


		@When("user enters email and password")
		public void user_enters_details(DataTable details)
		{
		for(Map<String,String> data:details.asMaps(String.class,String.class))
		{
		
			driver.findElement(By.name("login_email")).sendKeys(data.get("email"));
			driver.findElement(By.name("login_password")).sendKeys(data.get("password"));
			driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).click();
			driver.navigate().refresh();
			
		}
		}

	    @Then ("user close the browser")
	    public void close()
		{
	
			driver.quit();
		}
}
