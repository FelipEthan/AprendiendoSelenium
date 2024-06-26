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

public class TestSelenium {
    static WebDriver driver;
    static Actions actions;
    String url = "https://jqueryui.com/droppable/";
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setUpChrome(){
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get(url);
        WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.build();
        actions.dragAndDrop(source,target).perform();
    }
    @AfterAll
    public static void closeBrowser(){
        if (driver != null) {
          driver.quit();
       }
    }
}
