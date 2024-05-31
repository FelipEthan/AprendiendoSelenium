import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.assertj.core.api.Assertions.assertThat;

public class LocatorRelative {
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    String elemento = "";
    String elemento1 = "";
    private static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void chromeSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testLocatorRelative(){
        driver.get(url);
        // Encuentra el elemento del enlace que tiene el texto "Return to index"
        WebElement link = driver.findElement(By.cssSelector("input[name='my-readonly'][readonly]"));
        // Crea un objeto RelativeBy con el selector base By.tagName("input")
        // Esto se usará para encontrar elementos <input> en relación con otro elemento
        RelativeLocator.RelativeBy relativeBy = RelativeLocator.with(By.tagName("input"));
        // Encuentra un elemento <input> que esté por encima del enlace encontrado anteriormente
        WebElement readOnly = driver.findElement(relativeBy.above(link));
        // Verifica que el atributo "name" del elemento <input> encontrado sea igual a "my-readonly"
        assertThat(readOnly.getAttribute("name")).isEqualTo("my-disabled");
    }
    @Test
    public void testLocatorRelative2(){
        driver.get(url);
        WebElement link = driver.findElement(By.cssSelector("input[name='my-file'][type='file']"));
        RelativeLocator.RelativeBy relativeBy = RelativeLocator.with(By.tagName("input"));
        WebElement read = driver.findElement(relativeBy.above(link));
        assertThat(read.getAttribute("name")).isEqualTo("my-datalist");


    }
    @AfterAll
    public static void closeBrowser(){
        driver.quit();
    }
}
