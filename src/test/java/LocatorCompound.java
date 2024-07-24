import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
public class LocatorCompound {
    private static WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    String url1 = "https://demo.guru99.com/test/newtours/register.php";
    String elemento = "my-file";
    String elemento1 = "my-password";
    String elemento2 = "email";

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setUpChrome(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testLocatorCompusedByIdOrName(){
        driver.get(url);
        // Declara una variable llamada 'element' de tipo WebElement
        // Utiliza el driver para encontrar un elemento en la página web
        // mediante el criterio ByIdOrName con el valor 'elemento'.
        WebElement element = driver.findElement(new ByIdOrName(elemento));
        //Verifica que el atributo 'id' del elemento esté en blanco.
        assertThat(element.getAttribute("id")).isBlank();
        // Verifica que el atributo 'name' del elemento no esté en blanco.
        assertThat(element.getAttribute("name")).isNotBlank();

        WebElement element1 = driver.findElement(new ByIdOrName(elemento1));
        assertThat(element1.getAttribute("class")).isEqualTo("form-control");
        assertThat(element1.getAttribute("id")).isBlank();
    }
    @Test
    public void testLocatorCompuseByIdOrName2(){
        driver.get(url1);
        WebElement element = driver.findElement(new ByIdOrName(elemento2));
        element.sendKeys("ANDRES@GMAIL.COM");
        assertThat(element.getAttribute("name")).isEqualTo("email");
        String atributo = element.getAttribute("name");
        System.out.println(atributo);

    }
    @Test
    public void testLocatorCompusedByChained(){
        driver.get(url);

        // Declara una lista llamada 'rowsInForm' que contendrá objetos WebElement.
        // Utiliza el driver para encontrar todos los elementos que cumplan con los criterios de búsqueda.
        // new ByChained(By.tagName("form"), By.className("row")) especifica que se buscan elementos con la clase 'row'
        // que están dentro de un elemento con la etiqueta 'form'.
        List<WebElement> rowsInForm = driver.findElements(new ByChained(By.tagName("form"),By.className("row")));
        assertThat(rowsInForm.size()).isEqualTo(1);

        // Verifica que el tamaño de la lista 'rowsInMenu' sea igual a 3.
        // Esto significa que se espera encontrar exactamente tres elementos 'form-check' dentro de un 'form'.
        List<WebElement> rowsInMenu = driver.findElements(new ByChained(By.tagName("form"),By.className("form-check")));
        assertThat(rowsInMenu.size()).isEqualTo(3);
    }
    @Test
    public void testLocatorByChained(){
        driver.get(url1);
        List<WebElement> input = driver.findElements(new ByChained(By.tagName("form"),By.tagName("input")));
        Integer tamaño = input.size();
        System.out.println("La cantidad de input son:  " + tamaño);
        assertThat(input.size()).isEqualTo(13);

        List<WebElement> submit = driver.findElements(new ByChained(By.tagName("form"),By.name("submit")));
        Integer cantidad = submit.size();
        System.out.println("La cantidad de submit son: " + cantidad);
        assertThat(submit.size()).isEqualTo(1);
    }
    @Test
    public void testLocatorCompusedByAll(){
        driver.get(url);
        List<WebElement> rowsInForm = driver.findElements(new ByAll(By.tagName("form"),By.className("row")));
        assertThat(rowsInForm.size()).isEqualTo(5);

        List<WebElement> select = driver.findElements(new ByAll(By.tagName("form"),By.cssSelector("[type='submit']")));
        assertThat(select.size()).isEqualTo(2);
    }
        @Test
        public void testLocatorCompusedByAll2(){
            driver.get(url1);
            List<WebElement> cantidad = driver.findElements(new ByAll(By.tagName("td"),By.tagName("option")));
            Integer numero = cantidad.size();
            System.out.println(numero);
            System.out.println(cantidad.get(329).getText());
            assertThat(cantidad.size()).isEqualTo(331);
        }
}
