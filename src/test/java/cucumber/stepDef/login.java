package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://saucedemo.com";

    @Given("Login page Swag Labs")
    public void loginPageSwagLabs() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
        String productsText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productsText, "Products");
        driver.close();
    }

    @And("Input Invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("dummy_pass");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
