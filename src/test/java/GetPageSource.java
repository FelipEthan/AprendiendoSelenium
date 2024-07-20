import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageSource {
    static WebDriver driver;

    @BeforeAll
    public static void ajustarDriver() {
        WebDriverManager.chromedriver().setup();

    }
    @BeforeEach
    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGetPageSource() {
        driver.get("https://www.raileurope.com/es");//Ingresa a la url
        String pageSource = driver.getPageSource();//Obtiene codigo fuente
        System.out.println(pageSource);  // Imprimir el código fuente de la página
        int pageSourceLength = pageSource.length(); // Almacenamiento de la longitud de la fuente de la página en la variable int
        System.out.println("El tamaño de la pagina es de: " + pageSourceLength);//Imprimir variable pageSourceLength
    }

    @Test
    public void testGetPageSource1() {
        driver.get("https://www.xbox.com/es-ES/?xr=mebarnav");
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);
        String tamaño = driver.getPageSource();
        int convertido = tamaño.length();
        System.out.println("El tamaño de la pagina es: " + convertido);
    }

    @AfterAll
    public static void cerrarDriver() {
        if (driver != null) {
            driver.quit();//Cierra la ventana de driver
        }
    }
}
