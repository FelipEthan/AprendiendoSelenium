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
    String elemento3 = "Aspirantes";
    String elemento4 = "INICIO";
    String elemento5 = "Funcionarios";
    String elemento6 = "Bienestar";
    String elemento7 = "Salud";
    String elemento8 = "Contactos";
    String elemento9 = "//div[contains(text(),'Kelly Fernanda Aguilar Otalora')]";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void chromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Automatizando con Selenium - Locator linktext");
    }

    @Test
    public void testLocatorLinkTest() {
        driver.get(url);
        WebElement element = driver.findElement(By.linkText(elemento));
        assertThat(element.getTagName()).isEqualTo("a");
        assertThat(element.getCssValue("box-sizing")).isEqualTo("border-box");

        WebElement element1 = driver.findElement(By.partialLinkText(elemento1));
        assertThat(element1.getLocation()).isEqualTo(element.getLocation());
        assertThat(element1.getRect()).isEqualTo(element.getRect());
    }

    @Test
    public void testLocatorPartialLinktest() {
        driver.get(url);
        WebElement element = driver.findElement(By.linkText(elemento2));
        assertThat(element.getTagName()).isEqualTo("a");
        assertThat(element.getCssValue("cursor")).isEqualTo("pointer");

    }

    @Test
    public void testLocatorLinkText() {
        driver.get("http://www.ut.edu.co/");
        WebElement element = driver.findElement(By.linkText(elemento3));
        element.click();
        WebElement element1 = driver.findElement(By.linkText(elemento4));
        element1.click();
        WebElement element2 = driver.findElement(By.linkText(elemento5));
        element2.click();
        WebElement element3 = driver.findElement(By.linkText(elemento6));
        element3.click();
        WebElement element4 = driver.findElement(By.linkText(elemento7));
        element4.click();
        WebElement element5 = driver.findElement(By.linkText(elemento8));
        element5.click();
        WebElement element6 = driver.findElement(By.xpath(elemento9));
        String texto = element6.getText();
        System.out.println(texto);
        assertThat(element6.getText()).isEqualTo(texto);


    }

    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
