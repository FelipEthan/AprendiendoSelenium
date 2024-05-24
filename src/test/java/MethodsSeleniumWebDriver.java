import io.github.bonigarcia.wdm.WebDriverManager;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodsSeleniumWebDriver {
    WebDriver driver;
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
    public void testChrome(){
        String url = "https://www.selenium.dev/documentation/";
        driver.get(url);
        String title = driver.getTitle();
        System.out.println(title);
        assertThat(driver.getTitle()).isEqualTo("The Selenium Browser Automation Project | Selenium");
        assertThat(driver.getCurrentUrl()).isEqualTo(url);
        assertThat(driver.getPageSource()).contains("</html>");
    }
    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }
}
