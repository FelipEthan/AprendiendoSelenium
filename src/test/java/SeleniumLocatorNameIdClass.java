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
        driver = new ChromeDriver(); // Inicializa una nueva instancia de ChromeDriver
        driver.manage().window().maximize();// Maximiza la ventana del navegador

    }
    @Test
    public void testLocator(){

        driver.get(url);// Navega a la URL especificada
        WebElement element = driver.findElement(By.name("my-text")); // Localiza un elemento por su atributo 'name' y verifica que está habilitado
        assertThat(element.isEnabled()).isTrue();
        WebElement element1 = driver.findElement(By.id("my-text-id")); // Localiza un elemento por su atributo 'id' y realiza varias comprobaciones
        assertThat(element1.getAttribute("type")).isEqualTo("text");// Verifica que el atributo 'type' es igual a "text"
        assertThat(element1.getDomAttribute("type")).isEqualTo("text");
        assertThat(element1.getDomProperty("type")).isEqualTo("text");
        assertThat(element1.getAttribute("myprop")).isEqualTo("myvalue"); // Verifica que el atributo 'myprop' es igual a "myvalue"
        assertThat(element1.getDomAttribute("myprop")).isEqualTo("myvalue");
        assertThat(element1.getDomProperty("myprop")).isNull();// Verifica que la propiedad 'myprop' es nula
        List<WebElement> byClassName = driver.findElements(By.className("form-control"));// Localiza elementos por su nombre de clase y realiza comprobaciones
        assertThat(byClassName.size()).isPositive();// Verifica que el tamaño de la lista de elementos es positivo
        System.out.println(byClassName.size());
        assertThat(byClassName.get(0).getAttribute("name")).isEqualTo("my-text");// Verifica que el atributo 'name' del primer elemento es igual a "my-text"
        String atribut = element1.getAttribute("id"); //Obtiene el valor del atributo 'id'
        System.out.println("El atributo tiene el valor : " + atribut);
        String atribut1 = element1.getDomAttribute("class"); // Obtiene el valor actual del atributo 'class' en el DOM
        System.out.println("El atributo DOM tiene el valor: " + atribut1);
        String atribt2 = element1.getDomProperty("name"); // Obtiene el valor de la propiedad 'value'
        System.out.println("La propiedad tiene valor: " + atribt2);
    }

    @AfterEach
    public void closeBrowser(){
        driver.quit();// Cierra el navegador
    }
}
