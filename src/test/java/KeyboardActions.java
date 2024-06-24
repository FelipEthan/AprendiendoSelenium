import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class KeyboardActions {
    private static WebDriver driver;
    String textValue = "Hello World";
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void sendKeys(){
        driver.get(url);
        WebElement input = driver.findElement(By.name("my-text"));
        input.sendKeys(textValue);
        assertThat(input.getAttribute("value")).isEqualTo(textValue);
        input.clear();
        assertThat(input.getAttribute("value")).isEmpty();
    }
    @AfterAll
    public static void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }

}
