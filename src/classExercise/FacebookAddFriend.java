package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAddFriend {
	static WebDriver driver;
	public static void main(String[] args) {
		//Configurar el navegador
		setUp("chrome","https://facebook.com");
		
		//Iniciar sesion
		login("onavarro@kueski.com","Test@1234");
		
		//Buscar a la persona
		findPerson("Marcela Alegria");
		
		//Validar que existe la persona
		//validatePerson("Marcela Alegria");
		
		//Enviarle solicitud
		//sendRequest();
		
	}

	private static void setUp(String browser, String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();  //driver de chrome
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(url);//navegar a la pagina de IMDB.com
		
	}

	private static void login(String username, String password) {
		// TODO Auto-generated method stub
		WebElement userBox = driver.findElement(By.id("email"));
		WebElement passBox = driver.findElement(By.xpath("//input[@id='pass']"));
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
		userBox.clear();
		userBox.sendKeys(username);
		passBox.clear();
		passBox.sendKeys(password);
		loginButton.click();
		
	}

	private static void findPerson(String name) {
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.clear();
		searchBar.sendKeys(name);
		searchBar.submit();
	}

	private static void validatePerson(String string) {
		// TODO Auto-generated method stub
		
	}

	private static void sendRequest() {
		// TODO Auto-generated method stub
		
	}
	


}
