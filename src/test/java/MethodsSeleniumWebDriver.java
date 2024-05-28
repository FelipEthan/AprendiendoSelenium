import io.github.bonigarcia.wdm.WebDriverManager;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.remote.HttpSessionId.getSessionId;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.target.model.SessionID;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

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
    @Test
    public void testSession(){
        String url = "https://www.selenium.dev/documentation/";
        driver.get(url);
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        assertThat(sessionId).isNotNull();
        System.out.println("Session ID: " + sessionId.toString());
    }
    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }
}
