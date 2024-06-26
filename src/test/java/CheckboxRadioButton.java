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

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxRadioButton {
    private static WebDriver driver;
    private static WebDriverWait wait;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    String elemento = "my-check-2";
    String elemento2 = "my-radio-2";


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
    public void testCheckBoxAndRadioButton() {
        driver.get(url);
        WebElement check = driver.findElement(By.id(elemento));
        check.click();
        assertThat(check.isSelected()).isTrue();
        WebElement radio = driver.findElement(By.id(elemento2));
        assertThat(radio.isDisplayed()).isTrue();

    }


}
