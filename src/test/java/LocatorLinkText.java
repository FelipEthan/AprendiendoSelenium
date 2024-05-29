import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class LocatorLinkText {
    private static WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    String elemento = "Return to index";
    String elemento1 = "index";
    String elemento2 = "Boni García";
    String elemento3 = "Boni";
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void chromeDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Automatizando con Selenium - Locator linktext");
    }
    @Test
    public void testLocatorLinkTest(){
        driver.get(url);
        WebElement element = driver.findElement(By.linkText(elemento));
        assertThat(element.getTagName()).isEqualTo("a");
        assertThat(element.getCssValue("box-sizing")).isEqualTo("border-box");

        WebElement element1 = driver.findElement(By.partialLinkText(elemento1));
        assertThat(element1.getLocation()).isEqualTo(element.getLocation());
        assertThat(element1.getRect()).isEqualTo(element.getRect());
    }
    @Test
    public void testLocatorPartialLinktest(){
        driver.get(url);
        WebElement element = driver.findElement(By.linkText(elemento2));
        assertThat(element.getTagName()).isEqualTo("a");
        assertThat(element.getCssValue("cursor")).isEqualTo("pointer");

    }
    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }
}
