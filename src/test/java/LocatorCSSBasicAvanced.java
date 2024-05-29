import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opentest4j.AssertionFailedError;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocatorCSSBasicAvanced {
    private static WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    String elemento = "[type=hidden]";
    String elemento1 = "[type=checkbox]:checked";
    String elemento2 = "[type=checkbox]:not(:checked)";
    String elemento3 = "[type=radio]:checked";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void chromeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void testLocatorCSS() {
        System.out.println("1. Automatizando con Selenium - Locator CSS Basic");
        driver.get(url);
        WebElement element = driver.findElement(By.cssSelector(elemento));
        assertThat(element.isDisplayed()).isFalse();
        assertThat(element.isEnabled()).isTrue();
        assertThat(element.isSelected()).isFalse();
    }

    @Test
    @Order(2)
    public void testLocatorAdvance() {
        System.out.println("2. Automatizando con Selenium - Locator CSS Advanced");
        driver.get(url);
        WebElement element = driver.findElement(By.cssSelector(elemento1));
        assertThat(element.getAttribute("id")).isEqualTo("my-check-1");
        assertThat(element.isSelected()).isTrue();

        WebElement element1 = driver.findElement(By.cssSelector(elemento2));
        assertThat(element1.getAttribute("id")).isEqualTo("my-check-2");
        assertThat(element1.isSelected()).isFalse();
    }

    @Test
    @Order(3)
    public void testLocatorAdvancedMy() {
        System.out.println("3. Automatizando con Selenium - Locator CSS Advanced - Mi test");
        driver.get(url);
        try {
            WebElement element = driver.findElement(By.cssSelector(elemento3));
            assertThat(element.getAttribute("class")).isEqualTo("form-check-input");
            assertThat(element.isDisplayed()).isTrue();
            assertThat(element.isSelected()).isTrue();
        } catch (AssertionFailedError e) {
            e.printStackTrace();
            Assertions.fail("Test fallo debido a una excepción: " + e.getMessage());
        } finally {
            closeBrowser();
        }
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}

