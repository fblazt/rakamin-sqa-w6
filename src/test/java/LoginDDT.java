import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT {
    @Test
    public void loginDDT() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com";

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opt = new FirefoxOptions();
        opt.setHeadless(false);

        String csvDir = System.getProperty("user.dir")+"/src/test/data/test-data.csv";

        try(CSVReader reader = new CSVReader((new FileReader(csvDir)))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null){
                String username = nextLine[0];
                String password = nextLine[1];
                String status = nextLine[2];

                driver = new FirefoxDriver(opt);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(baseUrl);

                driver.findElement(By.id("user-name")).sendKeys(username);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.id("login-button")).click();

                if(status.equals("success")){
                    String productsText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
                    Assert.assertEquals(productsText, "Products");
                } else {
                    String errorLogin = driver.findElement(By.tagName("h3")).getText();
                    Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
                }
                driver.close();
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
