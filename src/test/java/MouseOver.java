import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MouseOver {
    public static WebDriver driver;
    public static Actions actions;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }
    @Test
    public void testMouseOver() {
        driver.get(url);
        List<String> imagenes = Arrays.asList("compass", "calendar", "award","landscape");
        for (String nombreImagen : imagenes){
            String xpath = String.format("//img[@src='img/%s.png']", nombreImagen);
            WebElement imagen = driver.findElement(By.xpath(xpath));
            actions.moveToElement(imagen).build().perform();
            WebElement caption = driver.findElement(RelativeLocator.with(By.tagName("div")).near(imagen));
            assertThat(caption.getText()).containsIgnoringCase(nombreImagen);

        }
    }

    @AfterAll
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
