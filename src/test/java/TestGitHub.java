import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestGitHub {
    private static WebDriver driver;
    private String url = "https://github.com/FelipEthan";
@BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void chromeSetUp(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    }
    @Test
    public void testGit(){
    driver.get(url);
    }
    @AfterAll
    public static void closeBrowser(){
   if (driver != null){
       driver.quit();
   }
    }
}

