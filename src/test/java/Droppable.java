import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
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
    String elementoIframe = "//*[@id=\"post-2669\"]/div[2]/div/div/div[1]/p/iframe";
    String elemento = "//*[@id=\"gallery\"]/li[1]";
    String elemento1 = "//div[@id='trash']";
    String elemento2 = "//*[@id=\"gallery\"]/li[2]";
    String elemento3 = "//*[@id=\"gallery\"]/li[3]";
    String elemento4 = "//*[@id=\"gallery\"]/li[4]";
    String elemento6 = "//*[@id=\"angular\"]";
    String elemento7 = "//div[@id='droparea']";
    String elemento8 = "//*[@id=\"mongo\"]";
    String elemento9 = "//*[@id=\"node\"]";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testDragAndDrop() {
        driver.get("https://jqueryui.com/droppable/");
        WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));
        actions.build();
        actions.dragAndDrop(source, target).perform();
    }

    @Test
    public void testDragAndDrop1() {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
        WebElement iframe = driver.findElement(By.xpath(elementoIframe));
        String pageSource = driver.getPageSource();
        int tamaño = pageSource.length();
        System.out.println(tamaño);
        String atributo = iframe.getAttribute("class");
        System.out.println(atributo);
        String atributo1 = iframe.getAttribute("src");
        System.out.println(atributo1);
        driver.switchTo().frame(iframe);
        WebElement element = driver.findElement(By.xpath(elemento));
        String atributo2 = element.getAttribute("class");
        System.out.println(atributo2);
        WebElement element1 = driver.findElement(By.xpath(elemento1));
        WebElement element2 = driver.findElement(By.xpath(elemento2));
        WebElement element3 = driver.findElement(By.xpath(elemento3));
        WebElement element4 = driver.findElement(By.xpath(elemento4));
        actions.build();
        actions.dragAndDrop(element, element1).perform();
        actions.dragAndDrop(element2, element1).perform();
        actions.dragAndDrop(element3, element1).perform();
        actions.dragAndDrop(element4, element1).perform();
    }

    @Test
    public void testDragAndDrop2() {
        driver.get("https://demo.automationtesting.in/Dynamic.html");

        WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento6)));
        WebElement element7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento7)));
        WebElement element8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento8)));
        WebElement element9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento9)));
        actions.build();
        actions.dragAndDrop(element6, element7).perform();
        actions.dragAndDrop(element8, element7).perform();
        actions.dragAndDrop(element9, element7).perform();

    }

    @AfterAll
    static void tearDown() {
       if (driver != null){
           driver.quit();
       }
    }
}