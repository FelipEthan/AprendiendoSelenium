import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandNavigation {
    static WebDriver driver;
    static WebDriverWait wait;
    String url = "https://www.mercadolibre.com.co/categorias";
    String elemento1 = "//i[@class='nav-icon-cart']";
    String elemento2 = "//*[@id='user_id']";
    String elemento3 = "//h1[contains(text(),'Categorías para comprar y vender')]";
    String elemento4 = "//h1";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testMercadoLibre() {
        driver.get(url);
        WebElement element1 = driver.findElement(By.xpath(elemento1));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath(elemento2));
        element2.sendKeys("andrestyle.21@gmail.com");
        driver.navigate().back();
        WebElement element3 = driver.findElement(By.xpath(elemento3));
        String text = element3.getText();
        System.out.println(text);
        assertThat(element3.getText()).isEqualTo("Categorías para comprar y vender");
        driver.navigate().forward();
        WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento4)));
        String text1 = element4.getText();
        System.out.println(text1);
        assertThat(element4.getText()).isEqualTo("Ingresa tu e‑mail, teléfono o usuario de Mercado Libre");
        driver.navigate().to("https://www.mercadolibre.com.co/ofertas/supermercado#nav-header");
        driver.navigate().refresh();
    }

    @AfterAll
    public static void cerrarDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
