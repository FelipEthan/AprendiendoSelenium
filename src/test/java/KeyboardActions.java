import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class KeyboardActions {
    private static WebDriver driver;
    String textValue = "Hello World";
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    String url1 = "https://docs.google.com/forms/d/e/1FAIpQLSfWzyrAPuDbxfcJsBULR14KV9sg9dERj6abjEPSrBc2-n0C-A/viewform";
    String correo = "//*[@type='email']";
    String nombre = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input";
    String numero = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/input";
    String telefono = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div[1]/div/div[1]/input";
    String line = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div/span/div/div[2]/label/div/div[2]/div/span";
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void sendKeys(){
        driver.get(url);
        WebElement input = driver.findElement(By.name("my-text"));
        input.sendKeys(textValue);
        assertThat(input.getAttribute("value")).isEqualTo(textValue);
        input.clear();
        assertThat(input.getAttribute("value")).isEmpty();
    }
    @Test
    public void testSendsKeys(){
        driver.get(url1);
        WebElement element = driver.findElement(By.xpath(correo));
        element.sendKeys("andrestyle.21@hotmail.com");
        assertThat(element.getAttribute("value")).isEqualTo("andrestyle.21@hotmail.com");
        String mail = element.getAttribute("value");
        System.out.println(mail);
        WebElement element1 = driver.findElement(By.xpath(nombre));
        element1.sendKeys("Andres Felipe Quimbayo");
        assertThat(element1.getTagName()).contains("input");
        String name = element1.getAttribute("value");
        System.out.println(name);
        WebElement element2 = driver.findElement(By.xpath(numero));
        element2.sendKeys("1073253202");
        String number = element2.getAttribute("value");
        System.out.println(number);
        Dimension tamaño = element2.getSize();
        System.out.println(tamaño);
        assertThat(element2.isDisplayed()).isTrue();
        WebElement element3 = driver.findElement(By.xpath(telefono));
        element3.sendKeys("3102137408");
        String telephone = element3.getAttribute("value");
        System.out.println(telephone);
        assertThat(element3.getAttribute("autocomplete")).contains("off");
        WebElement element4 = driver.findElement(By.xpath(line));
        element4.click();
    }
    @AfterAll
    public static void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }

}
