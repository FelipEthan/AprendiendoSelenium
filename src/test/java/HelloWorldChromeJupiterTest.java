import io.github.bonigarcia.wdm.WebDriverManager;
import static org.assertj.core.api.Assertions.assertThat; // Importar métodos de AssertJ para aserciones
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach; // Importar anotación para métodos que se ejecutan después de cada prueba
class HelloWorldChromeJupiterTest {
    private WebDriver driver;
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }
    @Test
    void test() {
// Exercise
        String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(sutUrl);
        String title = driver.getTitle();
// Verify
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    }
    @AfterEach
    void teardown() {
        driver.quit();
    }
}