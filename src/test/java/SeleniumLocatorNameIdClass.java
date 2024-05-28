import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumLocatorNameIdClass {
    // Declaración del WebDriver como una variable estática
    private static WebDriver driver;
    // URL de la página web que se va a probar
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";

    @BeforeAll
    public static void setUp(){
        // Imprime un mensaje en la consola indicando el inicio de la automatización
        System.out.println("Automatizando con Selenium - Locator Id, Class y Name");
        // Configura el WebDriver para Chrome utilizando WebDriverManager
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void chromeDriver(){
        // Inicializa una nueva instancia de ChromeDriver
        driver = new ChromeDriver();
        // Maximiza la ventana del navegador
        driver.manage().window().maximize();
    }

    @Test
    public void testLocator(){
        // Navega a la URL especificada
        driver.get(url);

        // Localiza un elemento por su atributo 'name' y verifica que está habilitado
        WebElement element = driver.findElement(By.name("my-text"));
        assertThat(element.isEnabled()).isTrue();

        // Localiza un elemento por su atributo 'id' y realiza varias comprobaciones
        WebElement element1 = driver.findElement(By.id("my-text-id"));
        // Verifica que el atributo 'type' es igual a "text"
        assertThat(element1.getAttribute("type")).isEqualTo("text");
        assertThat(element1.getDomAttribute("type")).isEqualTo("text");
        assertThat(element1.getDomProperty("type")).isEqualTo("text");

        // Verifica que el atributo 'myprop' es igual a "myvalue"
        assertThat(element1.getAttribute("myprop")).isEqualTo("myvalue");
        assertThat(element1.getDomAttribute("myprop")).isEqualTo("myvalue");
        // Verifica que la propiedad 'myprop' es nula
        assertThat(element1.getDomProperty("myprop")).isNull();

        // Localiza elementos por su nombre de clase y realiza comprobaciones
        List<WebElement> byClassName = driver.findElements(By.className("form-control"));
        // Verifica que el tamaño de la lista de elementos es positivo
        assertThat(byClassName.size()).isPositive();
        System.out.println(byClassName.size());
        // Verifica que el atributo 'name' del primer elemento es igual a "my-text"
        assertThat(byClassName.get(0).getAttribute("name")).isEqualTo("my-text");
    }

    @AfterEach
    public void closeBrowser(){
        // Cierra el navegador
        driver.quit();
    }
}
