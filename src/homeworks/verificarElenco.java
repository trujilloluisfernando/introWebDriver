package homeworks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verificarElenco {
	static WebDriver driver;
	public static void main(String[] args) {
		setUp("chrome","https://www.imdb.com/");
		searchMovie("Rápido y furioso");
		searchMovie("Rápidos y furiosos");
		//busqueda de pelicula 2 veces (caracteristicas)
		
		//comparativa
	}
	
	private static void setUp(String browser, String url) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();  //driver de chrome
			break;
		default:
			System.out.println("Error");
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(url);//navegar a la pagina de IMDB.com
		
	}
	
	public static void searchMovie(String movie) {
		WebElement navigationBar = driver.findElement(By.id("navbar-query"));
		navigationBar.clear();
		navigationBar.sendKeys(movie);
		navigationBar.submit();
		WebElement link = driver.findElement(By.xpath("//td[@class='result_text']/a"));
		link.click();
		String [] actors = {"","",""};
		
		for (int i = 0; i < 3; i++) {
			WebElement actor = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[3]/div[1]/div[4]/span[" + (i+1) + "]/a/span"));
			actors[i] = actor.getText();
			System.out.println(actors[i]);
		}
		
		

	}


}
