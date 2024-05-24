import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrowser {
    public static void main(String[] args) {
        // Establece la ubicación de ChromeDriver
        System.setProperty("webdriver.chromedriver","C:\\Users\\andre\\Documentos\\Selenium\\software\\chromedriver.exe");
        // Crea una instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();
        // String de la variable URL
        String url = "https://www.eurail.com/en";
        //Lanzar al sitio web
        driver.get(url);
        //Maximixa la ventana
        driver.manage().window().maximize();
        //Metodo para obtener titulo de la pagina
        String actualTitulo = driver.getTitle();
        System.out.println(actualTitulo);
        //Verificar titulo
        String verifica = "Discover Europe by Train | Best Rail Pass in Europe | Eurail.com®";
        if (actualTitulo.equals(verifica)){
            System.out.println("El titulo de la pagina es " + actualTitulo);
        }else{
            System.out.println("la verificacón fallo");
            System.out.println("El titulo actual es " + actualTitulo);
            System.out.println("El titulo que se esperaba es " + verifica);
        }
        //Navegar a la pantalla de ayuda
        driver.findElement(By.className("CybotCookiebotDialogBodyButton")).click();
        driver.findElement(By.xpath("//*[@id=\"container-86723db46b\"]/div/div/div[1]/div/div[3]/div[1]/div/div[3]/div/a/span")).click();
        String actualURL = driver.getCurrentUrl();//Recupera la URL de la página web actual que está cargada en el navegador
        String esperaURL = "https://www.eurail.com/en/eurail-passes";
        if (actualURL.equals(esperaURL)){
            System.out.println("El titulo de la pagina es " + actualURL);
        }else {
            System.out.println("la verificacón fallo");
            System.out.println("El titulo actual es " + actualURL);
            System.out.println("El titulo que se esperaba es " + esperaURL);
        }
        driver.quit();

    }
}
