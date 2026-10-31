
package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CartSteps {

	@When("user adds {string} to the cart")
	public void user_adds_product_to_the_cart(String productName) {
		String productCode = productName.toLowerCase().replace(" ", "-");

		LoginSteps.driver.findElement(By.cssSelector("[data-test='add-to-cart-" + productCode + "']")).click();
	}

	@When("user removes {string} from the cart")
	public void user_removes_product_from_the_cart(String productName) {
		String productCode = productName.toLowerCase().replace(" ", "-");

		LoginSteps.driver.findElement(By.cssSelector("[data-test='remove-" + productCode + "']")).click();
	}

	@Then("the cart badge should display {string}")
	public void the_cart_badge_should_display(String count) {
		Assert.assertEquals(LoginSteps.driver.findElement(By.className("shopping_cart_badge")).getText(), count);
		LoginSteps.driver.quit();
	}

	@Then("the cart badge should not be displayed")
	public void the_cart_badge_should_not_be_displayed() {
		Assert.assertTrue(LoginSteps.driver.findElements(By.className("shopping_cart_badge")).isEmpty(),
				"Cart badge is still displayed");
		LoginSteps.driver.quit();
	}
}
