import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Droppable {
    static WebDriver driver;
    static Actions actions;
    static WebDriverWait wait;
    String texto = "Es posible que el navegador o la aplicación no sean seguros. Más información";
    @BeforeAll
    public static void ajusteDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\andre\\Documentos\\Selenium\\software\\chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        Duration tiempo = Duration.ofSeconds(20);
        wait = new WebDriverWait(driver, tiempo);
        driver.manage().window().maximize();
    }
    @Test
    void testDragAndDrop() {
        driver.get("https://jqueryui.com/droppable/");
        WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));

        actions.build();
        actions.dragAndDrop(source, target).perform();
    }
    @Test
    void testGoogle() {
        driver.get("https://www.google.com/");
        //CSS class name
        driver.findElement(By.className("gb_Kd")).click();
        //CSS tag name
        driver.findElement(By.tagName("INPUT")).sendKeys("andrestyle.21@hotmail.com");
        //XPath selector
        WebElement boton = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
        boton.click();
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dMNVAe")));
        String textoActual = text.getText();
        System.out.println(textoActual);

        if (textoActual.equals(texto)) {
            System.out.println("Los textos son iguales ");
        } else {
            System.out.println("Los textos no son iguales ");
        }
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}