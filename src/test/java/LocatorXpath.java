import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LocatorXpath {
    //Xpath Absoluto son fáciles de crear, pero tienen un inconveniente relevante: cualquier mínimo cambio en el diseño de la página haría fallar un localizador construido con esta estrategia. Por este motivo, como regla general, se desaconseja el uso de XPath absolutos /html/cuerpo/a
    //Xpath Relativo las consultas relativas son más convenientes. La sintaxis general para consultas XPath relativas es la siguiente: //nombre de etiqueta[@atributo='valor']
    private static WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    String elemento = "//input[@name='my-hidden']";
    String elemento1 = "//input[@id='my-radio-1']";
    String elemento2 = "//input[@id='my-radio-2']";
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
    public void testXpath(){
        driver.get(url);
        WebElement element = driver.findElement(By.xpath(elemento));
        assertThat(element.isDisplayed()).isFalse();
    }
    @Test
    public void testXpathAdvanced(){
        driver.get(url);
        WebElement element1 = driver.findElement(By.xpath(elemento1));
        assertThat(element1.getAttribute("id")).isEqualTo("my-radio-1");
        assertThat(element1.isSelected()).isTrue();

        WebElement element2 = driver.findElement(By.xpath(elemento2));
        assertThat(element2.getAttribute("id")).isEqualTo("my-radio-2");
        assertThat(element2.isSelected()).isFalse();
    }
    @AfterAll
    public static void closeBrowser(){
        driver.quit();
    }
}
