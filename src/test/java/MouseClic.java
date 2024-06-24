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

public class MouseClic {
    private static WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/";
    String elemento1 = "//a[text()='Navigation']";
    String elemento2 = "//a[text()='Next']";
    String elemento3 = "//a[text()='3']";
    String elemento4 = "//a[text()='2']";
    String elemento5 = "//a[text()='Previous']";
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
    public void mouseClic(){
        driver.get(url);
        WebElement element1 = driver.findElement(By.xpath(elemento1));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath(elemento2));
        element2.click();
        WebElement element3 = driver.findElement(By.xpath(elemento3));
        element3.click();
        WebElement element4 = driver.findElement(By.xpath(elemento4));
        element4.click();
        WebElement element5 = driver.findElement(By.xpath(elemento5));
        element5.click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText).contains("Back to index");
    }
    @AfterAll
    public static void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }
}
