// Importar las bibliotecas necesarias
import static org.assertj.core.api.Assertions.assertThat; // Importar métodos de AssertJ para aserciones
import org.junit.jupiter.api.AfterEach; // Importar anotación para métodos que se ejecutan después de cada prueba
import org.junit.jupiter.api.BeforeAll; // Importar anotación para métodos que se ejecutan una vez antes de todas las pruebas
import org.junit.jupiter.api.BeforeEach; // Importar anotación para métodos que se ejecutan antes de cada prueba
import org.junit.jupiter.api.Test; // Importar anotación para métodos de prueba
import org.openqa.selenium.WebDriver; // Importar la interfaz WebDriver
import org.openqa.selenium.chrome.ChromeDriver; // Importar la implementación de WebDriver para Chrome
import io.github.bonigarcia.wdm.WebDriverManager; // Importar WebDriverManager para gestionar los controladores

public class WebdriverManager {


    // Declarar una variable de instancia WebDriver
    WebDriver driver;

    // Configurar el controlador de Chrome antes de ejecutar cualquier prueba
    @BeforeAll
    static void setupClass() {

        WebDriverManager.chromedriver().setup(); // Descargar y configurar el controlador de Chrome
    }

    // Inicializar WebDriver antes de cada prueba
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver(); // Crear una nueva instancia de ChromeDriver
    }

    // Cerrar el navegador después de cada prueba
    @AfterEach
    void teardown() {
        driver.quit(); // Cerrar el navegador y liberar los recursos
    }

    // Definir un caso de prueba
    @Test
    void test() {
        // Ejercicio: Navegar a la URL especificada
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/"); // Abrir la página web
        String title = driver.getTitle(); // Obtener el título de la página

        // Verificación: Comprobar que el título contiene la palabra "Selenium"
        assertThat(title).contains("Selenium"); // Verificar que el título contiene "Selenium"

        // Imprimir el título en la consola
        System.out.println(title); // Imprimir el título de la página en la consola
    }
}
