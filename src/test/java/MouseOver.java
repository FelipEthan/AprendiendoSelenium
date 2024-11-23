import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
public class MouseOver {
    // Declaración de variables estáticas para el WebDriver y las acciones del mouse
    public static WebDriver driver;
    public static Actions actions;
    // URL del sitio web que se va a probar
    String url = "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";
    // Configuración inicial, se ejecuta antes de todas las pruebas
    @BeforeAll
    public static void setUp() {
        // Configura el ChromeDriver automáticamente
        WebDriverManager.chromedriver().setup();
    }
    // Inicialización del WebDriver y de las acciones antes de cada prueba
    @BeforeEach
    public void initDriver() {
        // Inicia una nueva instancia del navegador Chrome
        driver = new ChromeDriver();
        // Inicializa las acciones del mouse
        actions = new Actions(driver);
        // Maximiza la ventana del navegador
        driver.manage().window().maximize();
    }
    // Prueba principal que verifica la funcionalidad de "mouse over"
    @Test
    public void testMouseOver() {
        // Abre la página web especificada
        driver.get(url);
        // Lista de nombres de imágenes que se van a probar
        List<String> imagenes = Arrays.asList("compass", "calendar", "award", "landscape");
        // Bucle que recorre cada imagen de la lista
        for (String nombreImagen : imagenes) {
            // Genera un XPath dinámico para localizar la imagen basada en su nombre
            String xpath = String.format("//img[@src='img/%s.png']", nombreImagen);
            WebElement imagen = driver.findElement(By.xpath(xpath));
            // Mueve el mouse sobre la imagen
            actions.moveToElement(imagen).build().perform();
            // Busca el subtítulo (caption) cercano a la imagen utilizando un localizador relativo
            WebElement caption = driver.findElement(RelativeLocator.with(By.tagName("div")).near(imagen));
            // Verifica que el texto del subtítulo contenga el nombre de la imagen (ignorando mayúsculas y minúsculas)
            assertThat(caption.getText()).containsIgnoringCase(nombreImagen);
        }
    }
    // Limpieza, se ejecuta después de todas las pruebas
    @AfterAll
    public static void closeBrowser() {
        // Cierra el navegador si la instancia del WebDriver no es nula
        if (driver != null) {
            driver.quit();
        }
    }
}
