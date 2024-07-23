import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloWorldChromeJupiterTest {
static WebDriver driver;;
String url = "https://bonigarcia.dev/selenium-webdriver-java/";
String title = "Hands-On Selenium WebDriver with Java";
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
    public void testHelloWord(){
    driver.get(url);
    String titulo = driver.getTitle();
    assertThat(titulo).isEqualTo(title);
    System.out.println("Hello word " +  titulo);

}
@AfterAll
    public static void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }
}