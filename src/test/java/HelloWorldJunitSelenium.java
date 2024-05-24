import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloWorldJunitSelenium {
private WebDriver driver;
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
    String url = "https://www.selenium.dev/documentation/";
    driver.get(url);
    String title = driver.getTitle();
    assertThat(title).contains("Selenium");
    assertThat(title).isEqualTo("The Selenium Browser Automation Project | Selenium");
}
@AfterEach
    public void closeNavegate(){
    driver.quit();

}
    }
