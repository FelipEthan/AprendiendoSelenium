import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ChromeDrivers {
    private static WebDriver driver;
    private String nombreAnimal = "becerro";
    private String url = "https://www.google.com";
    private String elemento1 = "gLFyf";
    private String elemento2 = "lnXdpd";
    private String elemento3 = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]";
    private String elemento4 = "span[data-dobid='hdw']";
    private String elemento5 = "//div[contains(text(),'Noticias')]";
    private String elemento6 = ".n0jPhd.ynAwRc.MBeuO.nDgy9d";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogle() {
        driver.get(url);
        WebElement element1 = driver.findElement(By.className(elemento1));
        element1.sendKeys("BECERRO");
        WebElement element2 = driver.findElement(By.className(elemento2));
        element2.click();
        WebElement element3 = driver.findElement(By.xpath(elemento3));
        element3.click();
        WebElement element4 = driver.findElement(By.cssSelector(elemento4));
        String texto = element4.getText();
        System.out.println("El texto dice: " + texto);
        assertThat(element4.getText()).isEqualTo(nombreAnimal);
        WebElement element5 = driver.findElement(By.xpath(elemento5));
        element5.click();
        List<WebElement> elements = driver.findElements(By.cssSelector(elemento6));
        System.out.println("La cantidad de paginas es de " + elements.size());

    }
    @AfterAll
    public static void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }

}
