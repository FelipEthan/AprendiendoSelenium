import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeDrive {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver","C:\\Users\\andre\\Documentos\\Selenium\\CursoSeleniumAprendiendo\\software\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.raileurope.com/es");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        //Ejemplo locator xpath
        driver.findElement(By.xpath("//input[@id='search_start_station']")).sendKeys("Colombes");
        driver.findElement(By.xpath("//input[@id='search_finish_station']")).sendKeys("Asker");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.name("submit-search button-primary")).submit();
    }
}
