import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChromeDriver {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver", "C:\\Users\\andre\\Documentos\\Selenium\\CursoSeleniumAprendiendo\\software\\chromedriver.exe");
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");

        //Ejemplo locator Linktest
        driver.findElement(By.linkText("REGISTER")).click();
        //Ejemplo locator name
        driver.findElement(By.name("firstName")).sendKeys("Andres Felipe");
        driver.findElement(By.name("lastName")).sendKeys("Quimbayo Trujillo");
        driver.findElement(By.name("phone")).sendKeys("3102137408");

        //Ejemplo locator id
        driver.findElement(By.id("userName")).sendKeys("andre@gmail.com");
        driver.findElement(By.id("email")).sendKeys("FELIPE.21");
        //Ejemplo locator Linktest
        driver.findElement(By.partialLinkText("Des")).click();



    }
}
