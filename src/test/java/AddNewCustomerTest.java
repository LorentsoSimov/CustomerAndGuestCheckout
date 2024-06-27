import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddNewCustomerTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAddCustomer() {
        driver.get("https://shop.pragmatic.bg/admin/");
        WebElement usernameInputField = driver.findElement(By.id("input-username"));
        usernameInputField.sendKeys("admin");
        WebElement passwordInputField = driver.findElement(By.id("input-password"));
        passwordInputField.sendKeys("parola123!");
        WebElement loginButton = driver.findElement(By.cssSelector(".btn"));
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement customerMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-customer")));
        customerMenu.click();
        WebElement customersOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-customer']//li[1]/a")));
        customersOption.click();
        WebElement addButton = driver.findElement(By.xpath("//*[@class='fa fa-plus']/ .."));
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname"))).sendKeys("Milen");
        driver.findElement(By.id("input-lastname")).sendKeys("Bozhinov");
        WebElement emailInputField = driver.findElement(By.id("input-email"));
        String prefix = RandomStringUtils.randomAlphanumeric(7);
        String sufix = RandomStringUtils.randomAlphabetic(5);
        String emailAddress = prefix + "@" + sufix + ".com";
        emailInputField.sendKeys(emailAddress);
        WebElement telephoneInputField = driver.findElement(By.id("input-telephone"));
        String sufixx = RandomStringUtils.randomNumeric(9);
        String TelephoneNumber = "+359" + sufixx;
        telephoneInputField.sendKeys(TelephoneNumber);
        driver.findElement(By.id("input-password")).sendKeys("qwerty123");
        driver.findElement(By.id("input-confirm")).sendKeys("qwerty123");
        WebElement newsletterDropdown = driver.findElement(By.id("input-newsletter"));
        Select newsletterSelect = new Select(newsletterDropdown);
        newsletterSelect.selectByValue("1");
        WebElement statusDropdown = driver.findElement(By.id("input-status"));
        Select statusSelect = new Select(statusDropdown);
        statusSelect.selectByValue("0");
        WebElement safeDropdown = driver.findElement(By.id("input-safe"));
        Select safeSelect = new Select(safeDropdown);
        safeSelect.selectByValue("1");
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-primary"));
        saveButton.click();





    }
}
