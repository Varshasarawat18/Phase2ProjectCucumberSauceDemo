	package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefination {
	
	WebDriver driver=HookClassSauceDemo.driver;				
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	 driver.get("https://www.saucedemo.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);

	}

	@When("I enter the correct username and password")
	public void i_enter_the_correct_username_and_password() {
		WebElement Username= driver.findElement(By.id("user-name"));
		Username.sendKeys("standard_user");
		WebElement Password =driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");
		
	}

	@When("Click on Login Button")
	public void click_on_Login_Button() {
	    // Write code here that turns the phrase above into concrete actions

		WebElement LoginButtonClicked= driver.findElement(By.id("login-button"));
		LoginButtonClicked.click();
	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(4000);
		WebElement HomePage=driver.findElement(By.xpath("//span[@class='title']"));
		String ActError= HomePage.getText();
		String ExpError = "PRODUCTS";
		Assert.assertEquals(ActError,ExpError);
		
	}

	@When("I enter the incorrect username and password")
	public void i_enter_the_incorrect_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement Username= driver.findElement(By.id("user-name"));
		Username.sendKeys("standard_use");
		WebElement Password =driver.findElement(By.id("password"));
		Password.sendKeys("secret_suce");

	}

	@Then("I should get the error message {string}")
	public void i_should_get_the_error_message(String ExpError) {
	    // Write code here that turns the phrase above into concrete actions		
		WebElement Error= driver.findElement(By.xpath("//h3[@data-test='error']"));
		String ActError= Error.getText();
		Assert.assertEquals(ExpError,ActError);
		
	}





}
