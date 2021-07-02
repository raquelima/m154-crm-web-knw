import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ch.ilv.crm.web.CrmApp;

public class WebTest {

private WebDriver driver;
	
	@BeforeClass
	public static void startUp() {
		CrmApp.main(null);
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();	
	}

	@Test
	public void createAndFindProduct() {
		driver.get("http://localhost:7070/");

		driver.findElement(By.xpath("//a[@href='/products']")).click();

		WebElement description = driver.findElement(By.name("description"));
		description.sendKeys("New");

		WebElement save = driver.findElement(By.cssSelector("form:nth-child(3) > p > input"));

		save.click();

		WebElement confirmationElement = driver.findElement(By.xpath("//span[.='Product New saved!']"));


		String confirmation = confirmationElement.getText();
		String confirmationSuccess = "Product New saved!";

		assertEquals(confirmation, confirmationSuccess);
		
		WebElement find = driver.findElement(By.name("id"));
		find.sendKeys("0");
		
		WebElement search = driver.findElement(By.cssSelector("form:nth-child(9) > p > input"));
		search.click();

		WebElement idElement = driver.findElement(By.cssSelector("span:nth-child(4)"));
		String idElementTry = idElement.getText();
		String idElementSuccess = "Id 0";
		assertEquals(idElementTry, idElementSuccess);

		WebElement confirmationElement2 = driver.findElement(By.cssSelector("span:nth-child(6)"));
		String confirmationTry2 = confirmationElement2.getText();
		String confirmationSuccess2 = "Description: New";
		assertEquals(confirmationTry2, confirmationSuccess2);

	}

	@After
	public void finish() {
		driver.quit();
	}



}
