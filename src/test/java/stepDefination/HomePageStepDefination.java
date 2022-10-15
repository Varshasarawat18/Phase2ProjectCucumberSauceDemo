package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefination {
	
WebDriver driver=HookClassSauceDemo.driver;

@When("I click on Add to card for product {string}")
public void i_click_on_Add_to_card_for_product(String string) {
    // Write code here that turns the phrase above into concrete actions
	
	WebElement addToCart=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//following::button[1]"));
	addToCart.click();
}

@Then("cart bucket count should be one")
public void cart_bucket_count_should_be_one() {
    // Write code here that turns the phrase above into concrete actions

	WebElement CartClick=driver.findElement(By.xpath("//div/a/span[@class='shopping_cart_badge']"));
	String ActError=CartClick.getText();
	Assert.assertEquals(ActError,"1");
	
}
}
