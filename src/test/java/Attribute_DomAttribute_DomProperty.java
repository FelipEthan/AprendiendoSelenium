import io.github.bonigarcia.wdm.WebDriverManager; // Importación del WebDriverManager para manejar la configuración del driver
import org.junit.jupiter.api.AfterAll; // Importación de AfterAll para ejecutar código después de todas las pruebas
import org.junit.jupiter.api.BeforeAll; // Importación de BeforeAll para ejecutar código antes de todas las pruebas
import org.junit.jupiter.api.BeforeEach; // Importación de BeforeEach para ejecutar código antes de cada prueba
import org.junit.jupiter.api.Test; // Importación de Test para definir métodos de prueba
import org.openqa.selenium.By; // Importación de By para localizar elementos en la página
import org.openqa.selenium.WebDriver; // Importación de WebDriver para interactuar con el navegador
import org.openqa.selenium.WebElement; // Importación de WebElement para representar elementos en la página
import org.openqa.selenium.chrome.ChromeDriver; // Importación de ChromeDriver para controlar el navegador Chrome
import static org.assertj.core.api.Assertions.assertThat; // Importación de AssertJ para realizar verificaciones en las pruebas

public class Attribute_DomAttribute_DomProperty {
    private static WebDriver driver; // Declaración del driver como una variable estática para su uso en todos los métodos
    private String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html"; // URL de la página a probar
    String elemento0 = "my-password"; // Nombre del primer elemento a localizar
    String elemento1 = "textarea"; // Nombre del segundo elemento a localizar
    String elemento2 = "my-disabled"; // Nombre del tercer elemento a localizar
    String elemento3 = "my-readonly"; // Nombre del cuarto elemento a localizar
    String elemento4 = "my-date"; // Nombre del quinto elemento a localizar
    String atribut0 = "autocomplete"; // Nombre del primer atributo a verificar
    String atribut1 = "rows"; // Nombre del segundo atributo a verificar
    String atribut2 = "placeholder"; // Nombre del tercer atributo a verificar
    String atribut3 = "value"; // Nombre del cuarto atributo a verificar
    String atribut5 = "type";// Nombre del quinto atributo a verificar
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup(); // Configuración del WebDriver para Chrome
    }
    @BeforeEach
    public void chromeSetUp() {
        driver = new ChromeDriver(); // Inicialización del driver de Chrome
        driver.manage().window().maximize(); // Maximización de la ventana del navegador
        System.out.println("Automatizando con Selenium - Captura de valores en atributos HTML"); // Mensaje para indicar el inicio de la automatización
    }
    @Test
    public void testAtributte() {
        driver.get(url); // Navegación a la URL especificada
        // Localización y verificación del primer elemento
        WebElement element0 = driver.findElement(By.name(elemento0));
        assertThat(element0.getAttribute(atribut0)).isEqualTo("off");
        String valor0 = element0.getAttribute(atribut0);
        System.out.println("El campo password, su atributo es " + atribut0 + " contiene el valor: " + valor0);
        // Localización y verificación del segundo elemento
        WebElement element1 = driver.findElement(By.tagName(elemento1));
        assertThat(element1.getDomAttribute(atribut1)).isEqualTo("3");
        String valor1 = element1.getDomAttribute(atribut1);
        System.out.println("El campo textarea, su atributo es " + atribut1 + " tiene el valor: " + valor1);
        // Localización y verificación del tercer elemento
        WebElement element2 = driver.findElement(By.name(elemento2));
        assertThat(element2.getDomProperty(atribut2)).isEqualTo("Disabled input");
        String valor2 = element2.getDomProperty(atribut2);
        System.out.println("El campo Disabled input, su atributo es " + atribut2 + " tiene el valor: " + valor2);
        // Localización y verificación del cuarto elemento
        WebElement element3 = driver.findElement(By.name(elemento3));
        assertThat(element3.getAttribute(atribut3)).isEqualTo("Readonly input");
        String valor3 = element3.getAttribute(atribut3);
        System.out.println("El campo Readonly, su atributo es: " + atribut3 + " su valor es: " + valor3);
        // Localización y verificación del cuarto elemento
        WebElement element4 = driver.findElement(By.name(elemento4));
        assertThat(element4.getAttribute(atribut5)).isEqualTo("text");
        String valor = element4.getAttribute(atribut5);
        System.out.println("El campo Readonly, su atributo es: " + atribut5 + " su valor es: " + valor);
    }
    @AfterAll
    public static void closeBrowser() {
        driver.quit(); // Cierre del navegador después de todas las pruebas
    }
}
