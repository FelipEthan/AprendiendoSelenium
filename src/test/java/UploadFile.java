import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UploadFile {
    private static WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
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
    public void uploadFile() throws IOException {
        driver.get(url);
        WebElement archivo = driver.findElement(By.name("my-file"));
        Path tempFile = Files.createTempFile("Selenium",".pdf");
        String filename = tempFile.toAbsolutePath().toString();
        archivo.sendKeys(filename);
        driver.findElement(By.tagName("form")).submit();
    }

}

