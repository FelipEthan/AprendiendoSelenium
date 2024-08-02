import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.opentest4j.AssertionFailedError;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocatorCSSBasicAvanced {
    private static WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
    String elemento = "[type=hidden]";
    String elemento1 = "[type=checkbox]:checked";
    String elemento2 = "[type=checkbox]:not(:checked)";
    String elemento3 = "[type=radio]:checked";
    String elemento5 = "Signup";
    String elemento6 = "[name='name']";
    String elemento7 = "[data-qa='signup-email']";
    String elemento8 = "[data-qa='signup-button']";
    String elemento9 = "[for='id_gender1']";
    String elemento10 = "[id='password']";
    String elemento11 = "[id='days']";
    String elemento12 = "[id='months']";
    String elemento13 = "[name='years']";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void chromeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    public void testLocatorCSS() {
        System.out.println("1. Automatizando con Selenium - Locator CSS Basic");
        driver.get(url);
        WebElement element = driver.findElement(By.cssSelector(elemento));
        assertThat(element.isDisplayed()).isFalse();
        assertThat(element.isEnabled()).isTrue();
        assertThat(element.isSelected()).isFalse();
    }

    @Test
    @Order(2)
    public void testLocatorAdvance() {
        System.out.println("2. Automatizando con Selenium - Locator CSS Advanced");
        driver.get(url);
        WebElement element = driver.findElement(By.cssSelector(elemento1));
        assertThat(element.getAttribute("id")).isEqualTo("my-check-1");
        assertThat(element.isSelected()).isTrue();

        WebElement element1 = driver.findElement(By.cssSelector(elemento2));
        assertThat(element1.getAttribute("id")).isEqualTo("my-check-2");
        assertThat(element1.isSelected()).isFalse();
    }

    @Test
    @Order(3)
    public void testLocatorAdvancedMy() {
        System.out.println("3. Automatizando con Selenium - Locator CSS Advanced - Mi test");
        driver.get(url);
        try {
            WebElement element = driver.findElement(By.cssSelector(elemento3));
            assertThat(element.getAttribute("class")).isEqualTo("form-check-input");
            assertThat(element.isDisplayed()).isTrue();
            assertThat(element.isSelected()).isTrue();
        } catch (AssertionFailedError e) {
            e.printStackTrace();
            Assertions.fail("Test fallo debido a una excepción: " + e.getMessage());
        } finally {
            closeBrowser();
        }
    }

    @Test
    public void testLocatorCSS2() {
        driver.get("https://www.automationexercise.com/");
        WebElement element = driver.findElement(By.partialLinkText(elemento5));
        element.click();
        WebElement element1 = driver.findElement(By.cssSelector(elemento6));
        element1.sendKeys("Andres Quimbayo");
        WebElement element2 = driver.findElement(By.cssSelector(elemento7));
        element2.sendKeys("afquimbayo@gmail.com");
        WebElement element3 = driver.findElement(By.cssSelector(elemento8));
        element3.submit();
        WebElement element4 = driver.findElement(By.cssSelector(elemento9));
        element4.click();
        WebElement element5 = driver.findElement(By.cssSelector(elemento10));
        element5.sendKeys("Ethan");
        WebElement element6 = driver.findElement(By.cssSelector(elemento11));
        element6.sendKeys("21");
        String actualdays = element6.getAttribute("value");
        System.out.println("El día seleccionado es: " + actualdays);
        WebElement dias = driver.findElement(By.cssSelector(elemento11));
        Select select = new Select(dias);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        WebElement meses = driver.findElement(By.cssSelector(elemento12));
        meses.sendKeys("April");
        String actualMonth = meses.getAttribute("value");
        System.out.println("El mes seleccionado es " + actualMonth);
        Select select1 = new Select(meses);
        List<WebElement> options1 = select1.getOptions();
        for (WebElement option2 : options1) {
            System.out.println(option2.getText());
        }
        WebElement year = driver.findElement(By.cssSelector(elemento13));
        year.sendKeys("1999");
        String actualyear = year.getAttribute("value");
        System.out.println("Año seleccionada: " + actualyear);
        System.out.println("La fecha seleccionada es: " + actualdays + "/" + actualMonth + "/" + actualyear);


    }

    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

