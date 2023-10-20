package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class login {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com";

    @Given("Login page Swag Labs")
    public void loginPageSwagLabs() {
        driver = new FirefoxDriver();
        driver.get(baseUrl);
    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User logged in")
    public void userLoggedIn() {
    }

    @And("Input Invalid Password")
    public void inputInvalidPassword() {
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
    }
}
