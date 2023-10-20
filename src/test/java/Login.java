import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
    @Test
    public void open_browser() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com";

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
}
