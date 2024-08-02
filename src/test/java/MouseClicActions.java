import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.assertj.core.api.Assertions.assertThat;

public class MouseClicActions {
    private static WebDriver driver;
    private static Actions actions;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html";
    String elemento = "my-dropdown-2";
    String elemento2 = "context-menu-2";
    String elemento3 = "my-dropdown-3";
    String elemento4 = "context-menu-3";
    String elemento5 = "my-dropdown-1";
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void initDriver(){
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }
    @Test
    public void testContextAndDoubleClick() {
        driver.get(url);
        WebElement element0 = driver.findElement(By.id(elemento5));
        actions.click(element0).build().perform();
        assertThat(element0.isDisplayed()).isTrue();
        WebElement element = driver.findElement(By.id(elemento));
        actions.contextClick(element).build().perform();
        WebElement element1 = driver.findElement(By.id(elemento2));
        assertThat(element1.isDisplayed()).isTrue();
        WebElement element3 = driver.findElement(By.id(elemento3));
        actions.doubleClick(element3).build().perform();
        WebElement element4 = driver.findElement(By.id(elemento4));
        assertThat(element4.isDisplayed()).isTrue();
    }
}





