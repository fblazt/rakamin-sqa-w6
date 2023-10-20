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

public class stepdef {
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
    }

    @And("Input Invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("dummy_pass");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }

    @And("Click the product")
    public void clickTheProduct() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();
    }

    @Then("Product detail shown")
    public void productDetailShown() {
        String addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(addToCart, "Add to cart");
    }

    @And("Click add to cart")
    public void clickAddToCart() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Then("Added to the cart")
    public void addedToTheCart() {
        String cartValue = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(cartValue, "1");
    }

    @And("User click logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
    }

    @Then("User on login page")
    public void userOnLoginPage() {
        String usernameText = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/h4")).getText();
        Assert.assertEquals(usernameText, "Accepted usernames are:");
    }

    @And("User open cart")
    public void userOpenCart() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @And("User on cart page")
    public void userOnCartPage() {
        String yourCartTxt = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(yourCartTxt, "Your Cart");
    }

    @And("User click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @And("User on fill information page")
    public void userOnFillInformationPage() {
        String yourInfoTxt = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(yourInfoTxt, "Checkout: Your Information");
    }

    @And("Input first name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("John");
    }

    @And("Input last name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Doe");
    }

    @And("Input zip code")
    public void inputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("00000");
    }

    @And("User click continue")
    public void userClickContinue() {
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @And("User on overview page")
    public void userOnOverviewPage() {
        String yourInfoTxt = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(yourInfoTxt, "Checkout: Overview");
    }

    @And("User click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }

    @Then("Order completed")
    public void orderCompleted() {
        String checkoutCompleteTxt = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assert.assertEquals(checkoutCompleteTxt, "Thank you for your order!");
    }
}
