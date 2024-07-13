import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ChromePrueba {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private String url = "https://www.google.com/?hl=es";
    private String elemento1 = "Iniciar sesión";
    private String elemento2 = "//span[contains(text(),'Crear cuenta')]";
    private String elemento3 = "gNVsKb";
    private String elemento4 = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[3]/div/div[2]/div/div/div[2]/div/ul/li[1]";
    private String elemento5 = "whsOnd";
    private String elemento6 = "//*[@id=\"lastName\"]";
    private String elemento7 = "VfPpkd-vQzf8d";
    private String elemento8 = "//*[@id=\"day\"]";
    private String elemento9 = "//*[@id=\"month\"]";
    private String elemento10 = "//*[@id=\"year\"]";
    private String elemento11 = "gender";
    private String elemento12 = "//*[@id=\"birthdaygenderNext\"]/div/button/span";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testCreateAccount() {
        driver.get(url);
        WebElement element1 = driver.findElement(By.linkText(elemento1));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath(elemento2));
        element2.click();
        List<WebElement> elements = driver.findElements(By.className(elemento3));
        System.out.println("En la lista hay " + elements.size() + " opciones");
        WebElement element4 = driver.findElement(By.xpath(elemento4));
        element4.click();
        WebElement element5 = driver.findElement(By.className(elemento5));
        element5.sendKeys("Andres Felipe");
        WebElement element6 = driver.findElement(By.xpath(elemento6));
        element6.sendKeys("Quimbayo Trujillo");
        WebElement element7 = driver.findElement(By.className(elemento7));
        element7.click();
        WebElement element8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento8)));
        element8.sendKeys("16");
        WebElement element9 = driver.findElement(By.xpath(elemento9));
        element9.sendKeys("Marzo");
        WebElement element10 = driver.findElement(By.xpath(elemento10));
        element10.sendKeys("1999");
        WebElement element11 = driver.findElement(By.id(elemento11));
        element11.sendKeys("Hombre");
        WebElement element12 = driver.findElement(By.xpath(elemento12));
        element12.click();
    }

    @AfterAll
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}