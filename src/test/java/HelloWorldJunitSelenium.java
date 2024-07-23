import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloWorldJunitSelenium {
private WebDriver driver;
String url = "https://www.selenium.dev/documentation/";
String url1 = "https://ticjob.co/es/search";
String elemento = "//*[@id=\"search-form\"]/div[2]/div/h1";
@BeforeAll
    public static void setUp(){
    WebDriverManager.chromedriver().setup();
}
@BeforeEach
    public void chromeInit(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}
@Test
    public void testChrome(){
    driver.get(url);
    String title = driver.getTitle();
    assertThat(title).contains("Selenium");
    assertThat(title).isEqualTo("The Selenium Browser Automation Project | Selenium");
}
@Test
public void testTicJob(){
    driver.get(url1);
    WebElement element = driver.findElement(By.xpath(elemento));
    String texto = element.getText();
    System.out.println(texto);
    assertThat(texto).isEqualTo("96 Ofertas de informatica y teleco encontradas.");
    assertThat(texto).contains("Ofertas");
}

@AfterEach
    public void closeNavegate(){
    driver.quit();

}
    }
