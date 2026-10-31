
package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

//	public static WebDriver driver;

//	@Given("browser is opened")
//	public void browser_is_opened() {
//		driver = new EdgeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//	}
//
//	@Given("user is on the SauceDemo login page")
//	public void user_is_on_the_sauce_demo_login_page() {
//		driver.get("https://www.saucedemo.com/");
//	}

	@Given("user is logged in to SauceDemo")
	public void user_is_logged_in_to_sauce_demo() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		driver.findElement(By.id("user-name")).sendKeys(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("user should be redirected to the inventory page")
	public void user_should_be_redirected_to_the_inventory_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Inventory page was not displayed");
	}

	@Then("an error message should be displayed")
	public void an_error_message_should_be_displayed() {
		Assert.assertTrue(driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed(),
				"Error message was not displayed");
	}

	@Then("user should get {string}")
	public void user_should_get(String string) {
		System.out.println("login : " + string);
	}

//	@Then("browser should be closed")
//	public void browser_should_be_closed() {
//		driver.quit();
//	}
}
