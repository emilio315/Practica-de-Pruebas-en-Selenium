package SeleniumTecNM;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrimerTestSelenium {
	private WebDriver driver;
	private static final String URL_SITE = "http://localhost:8081/";
	private static final int SLA = 100;
	
	@BeforeClass
	public static void setupWebdriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver2.exe");
	}
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown( ) {
		if (driver != null) {
			driver.quit();
		}
	}
	
	/*@Test
	public void testLogoPresent() throws InterruptedException {
		driver.get(URL_SITE);
		
		WebElement logo = driver.findElement(By.cssSelector("#app > nav > ul > a > img"));
		
		assertThat(logo, notNullValue());
	}
	
	@Test
	public void testNavigatorPresent() throws InterruptedException {
        driver.get(URL_SITE);
		
		WebElement navBar = driver.findElement(By.cssSelector("#app > nav > ul"));
		
		assertThat(navBar, notNullValue());
	}
	
	@Test
	public void testFirstclick()  throws InterruptedException {
		driver.get(URL_SITE);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement pelicula = driver.findElement(By.id("moveShowcase__container--Netflix Originals--number--13"));
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", pelicula);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("moveShowcase__container--Netflix Originals--number--13"))).click();
		
		WebElement modalTitle = driver.findElement(By.cssSelector("#app > div:nth-child(3) > div.modal.show > div > h1"));
		WebElement buttonModal = driver.findElement(By.cssSelector("#app > div:nth-child(3) > div.modal.show > div > button.modal__btn.modal__btn--red"));
		buttonModal.click(); buttonModal.click();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		
		assertThat(pelicula, notNullValue());
		assertThat(modalTitle, notNullValue());
		assertThat(buttonModal, notNullValue());
		
	}*/

	@Test
	public void testSearchItem() throws InterruptedException {
        driver.get(URL_SITE);

		By searchInput = By.className("navigation__container--left__input");


		driver.findElement(searchInput).click();
		driver.findElement(searchInput).sendKeys("Terror");
		Thread.sleep(2000);
		WebElement pelicula = driver.findElement(By.xpath("//img[@src='https://image.tmdb.org/t/p/w500/ssyZgYScV9eClakZDwu4sPrgMmy.jpg']"));
		assertThat(pelicula, notNullValue());
		
	}

	@Test
	public void testImages() throws InterruptedException {
        driver.get(URL_SITE);

		Thread.sleep(2000);

		List<WebElement> imagenes = driver.findElements(By.className("movieShowcase__container--movie-image"));

		assertThat(imagenes, notNullValue());
		
	}
	
	@Test
	public void testModals() throws InterruptedException {
        driver.get(URL_SITE);
		Thread.sleep(2000);
		By swiper = By.id("moveShowcase__container--Netflix Originals--number--16");


		driver.findElement(swiper).click();
		
		Thread.sleep(2000);
		WebElement modal = driver.findElement(By.className("modal__title"));
		assertThat(modal, notNullValue());
		
	}
	
	/*
	@Test
	public void testMouseOver() throws InterruptedException {
		// Obtener la dirección url
		driver.get("http://localhost:8081/");
		
		Thread.sleep(500);
		
		// MouseOver
		Actions builder = new Actions(driver);
		WebElement nosotrosLink = driver.findElement(By.linkText("NOSOTROS"));
		builder.moveToElement(nosotrosLink).build().perform();
		
		driver.findElement(By.linkText("Docentes")).click();
		
		Thread.sleep(500);
		
		assertThat(driver.getTitle(), containsString("Sistemas y Computación | ITM"));
	}
	
	@Test
	public void testGoogle() throws InterruptedException {
		// Obtener la dirección url
		driver.get("http://localhost:8081/");
		
		Thread.sleep(500);
		
		WebElement cuadroBusqueda = driver.findElement(By.name("q"));
		cuadroBusqueda.sendKeys("UMSNH");
		cuadroBusqueda.submit();
		Thread.sleep(1000);
		
		WebElement divBusquedas = driver.findElement(By.id("rcnt"));
		
		List<WebElement> todosLosResultados = divBusquedas.findElements(By.className("g"));
		
		WebElement link = todosLosResultados.get(0).findElement(By.className("yuRUbf"));
		
		assertThat(link.getText(), containsString("https://www.morelia.tecnm.mx"));
	}
	*/
}
