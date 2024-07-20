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

import static org.assertj.core.api.Assertions.assertThat;

public class HandlingBrowser {
    static WebDriver driver;
    WebDriverWait wait;
    String url = "https://www.eurail.com/en";
    String elemento1 = "//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]";
    String elemento2 = "//*[@id=\"navigation-menu\"]/li[4]/button";
    String elemento3 = "//*[@id=\"navigation-menu\"]/li[4]/div/div/div[1]/div/a/span";
    String esperaURL = "https://www.eurail.com/en/help";
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
    public void testHanlingBrowser() {
        driver.get(url);
        String actualTitulo = driver.getTitle();
        System.out.println(actualTitulo);
        //Verificar titulo
        assertThat(actualTitulo).isEqualTo("Discover Europe by Train | Best Rail Pass in Europe | Eurail.com®");
        //Navegar a la pantalla de ayuda
        String tituloinicial = driver.getCurrentUrl();
        System.out.println("El titulo inicial es " + tituloinicial);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento1)));
        element.click();
        WebElement element1 = driver.findElement(By.xpath(elemento2));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath(elemento3));
        element2.click();
        String titulofinal = driver.getCurrentUrl();
        System.out.println("El titulo final es " + titulofinal);//Recupera la URL de la página web actual que está cargada en el navegador
        assertThat(titulofinal).isEqualTo(esperaURL);
    }
    @AfterAll
    public static void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }
}
