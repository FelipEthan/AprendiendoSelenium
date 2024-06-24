import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SliderActions {
    private static WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    String elemento = "my-range";
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
    public void testSlider(){
        driver.get(url);
        WebElement slider = driver.findElement(By.name(elemento));
        String init = slider.getAttribute("value");
        System.out.println("El elemento inicia en: " + init);
        for (int i = 0; i < 5; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        String fin = slider.getAttribute("value");
        System.out.println("El elemento finaliza en: " + fin);
        assertThat(slider.getAttribute(init)).isNotEqualTo(fin);

    }
    @AfterAll
    public static void closeBrowser(){
        if (driver != null){
          driver.quit();
        }
    }
}
