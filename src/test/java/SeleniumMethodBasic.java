import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumMethodBasic {
    private static WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/";
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void chromeDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testHands(){
        //URL
        driver.get(url);
        //Obtener titulo
        String title = driver.getTitle();
        //Metodo para obtener el ID Sesion
        SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
        //Comparar si no es nulo
        assertThat(sessionId).isNotNull();
        //Imprimir la sesion
        System.out.println("El Id de sesion es: " + sessionId);
        //Obtener titulo y comparar
        assertThat(driver.getTitle()).isEqualTo("Hands-On Selenium WebDriver with Java");
        //Obtener source y validar si contiene
        assertThat(driver.getPageSource()).contains("html");
        //Obtener url actual y comparar con url
        assertThat(driver.getCurrentUrl()).isEqualTo(url);
        //Obtener titulo y comparar
        assertThat(driver.getTitle()).isEqualTo(title);
        //Capturar elemento y hacer clic
        driver.findElement(By.linkText("Web form")).click();
        //Capturar elemento
        WebElement element = driver.findElement(By.tagName("textarea") );
        //Devuelve el valor del atributo
        assertThat(element.getDomAttribute("rows")).isEqualTo("3");

    }
    @AfterAll
    public static void closeBrowser(){
        driver.close();
    }
}