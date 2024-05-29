import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class TestLocatorTagNameLinkTestCssXpath {
    private static WebDriver driver;
    String url = "https://thefreerangetester.github.io/sandbox-automation-testing/";
    String elemento = "input";
    String elemento1 = "[type=checkbox]"; //CSS Basic
    String elemento2 = "input#checkbox-1"; // CSS Advanced
    String elemento3 = "[type=button]"; //CSS Advanced

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void chromeSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Automatizando con Selenium - Locators");
    }
    @Test
    public void testLocators(){
        driver.get(url);
        WebElement element = driver.findElement(By.tagName(elemento));
        element.sendKeys("Hola");
        WebElement element1 = driver.findElement(By.cssSelector(elemento1));
        element1.click();
        assertThat(element1.isSelected()).isTrue();
        WebElement element2 = driver.findElement(By.cssSelector(elemento2));
        assertThat(element2.isSelected()).isFalse();
        element2.click();
        assertThat(element2.isSelected()).isTrue();
        WebElement element3 = driver.findElement(By.cssSelector(elemento3));
        element3.click();
        assertThat(element3.getAttribute("type")).isEqualTo("button");



    }
    @AfterAll
    public static void closeBrowser(){
        driver.quit();
    }
}

