import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxRadioButton {
    private static WebDriver driver;
    private String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    private  String elemento1 = "#my-check-2";
    private String elemento2 = "#my-radio-2";
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

    }
    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void checkboxRadio(){
    driver.get(url);
    WebElement element = driver.findElement(By.cssSelector(elemento1));
    element.click();
    assertThat(element.isSelected()).isTrue();
    WebElement element2 = driver.findElement(By.cssSelector(elemento2));
    assertThat(element2.isDisplayed()).isTrue();
    }
    @AfterAll
    public static void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }
}
