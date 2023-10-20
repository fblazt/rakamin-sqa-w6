import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
    @Test
    public void success_login() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com";

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        String logoutText = driver.findElement(By.id("logout_sidebar_link")).getText();
        Assert.assertEquals(logoutText, "Logout");
    }
}
