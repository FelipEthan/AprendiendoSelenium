import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDrivers {
    public static void main(String[] args) {
        String nombreAnimal = "becerro";
        System.setProperty("webdriver.chromedriver","C:\\Users\\andre\\Documentos\\Selenium\\CursoSeleniumAprendiendo\\software\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.className("gLFyf")).sendKeys("BECERRO");
        driver.findElement(By.className("lnXdpd")).click();
        driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]")).click();
        WebElement texto = driver.findElement(By.cssSelector("span[data-dobid='hdw']"));
        String textoActual = texto.getText();
        System.out.println("El texto dice: " + textoActual);
        if (textoActual.equals(nombreAnimal)){
            System.out.println("Los nombres son iguales caso exitoso");
        }else {
            System.out.println("Los nombres no son iguales caso fallido se esperaba " + nombreAnimal + " pero se capturo " + textoActual );
        }
        driver.quit();

    }
}
