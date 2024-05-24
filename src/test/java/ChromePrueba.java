import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChromePrueba {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver","C:\\Users\\andre\\Documentos\\Selenium\\software\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Duration tiempo = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver,  tiempo);

        String texto = "Es posible que el navegador o la aplicación no sean seguros. Más información";
//Es posible que el navegador o la aplicación no sean seguros. Más información
        //Es posible que el navegador o la aplicación no sean seguros. Más información
        driver.manage().window().maximize();
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

        if (textoActual.equals(texto)){
            System.out.println("Los textos son iguales ");
        }else {
            System.out.println("Los textos no son iguales ");

        }

    }
}