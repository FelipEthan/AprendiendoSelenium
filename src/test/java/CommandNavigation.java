import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommandNavigation {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testAmazon() {
        driver.get("https://www.mercadolibre.com.co/categorias");
        driver.findElement(By.xpath("//header/div[1]/div[6]/a[1]/i[1]")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.mercadolibre.com.co/gz/home/navigation#nav-header");
        System.out.println("Prueba exitosa");
    }
    @AfterAll
    public static void cerrarDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
