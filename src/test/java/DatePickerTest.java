import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerTest{
    private static WebDriver driver;

    // Configuración inicial para descargar e instalar el driver de Chrome
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    // Inicialización del driver de Chrome antes de cada prueba
    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testDatePicker() {
        // Navegar a la página web de prueba
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        // Obtener la fecha de hoy
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        int currentDay = today.getDayOfMonth();

        // Encontrar y hacer clic en el campo de selección de fecha
        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.click();

        // Seleccionar el año actual en el calendario
        WebElement monthElement = driver.findElement(By.xpath(
                String.format("//th[contains(text(),'%d')]", currentYear)));
        monthElement.click();

        // Hacer clic en la flecha izquierda para retroceder un año
        WebElement arrowLeft = driver.findElement(RelativeLocator.with(By.tagName("th")).toRightOf(monthElement));
        arrowLeft.click();

        // Seleccionar el mes del año anterior
        WebElement monthPastYear = driver.findElement(RelativeLocator
                .with(By.cssSelector("span[class$=focused]")).below(arrowLeft));
        monthPastYear.click();

        // Seleccionar el día del mes en el calendario
        WebElement dayElement = driver.findElement(By.xpath(String.format(
                "//td[@class='day' and contains(text(),'%d')]", currentDay)));
        dayElement.click();

        // Obtener la fecha seleccionada del campo de selección de fecha
        String oneYearBack = datePicker.getAttribute("value");
        System.out.println("Final date in date picker: " + oneYearBack);

        // Calcular la fecha esperada (un año atrás desde hoy)
        LocalDate previousYear = today.minusYears(1);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String expectedDate = previousYear.format(dateFormat);

        // Comprobar que la fecha seleccionada es la esperada
        // (aquí faltaría una aserción para comparar `oneYearBack` con `expectedDate`)
    }
}
