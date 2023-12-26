package example.moodle;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginFailTest {
	@Test
	public void testGoogleSearch() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.get("http://el.etfbl.net/");
		Assert.assertEquals("ETFBL E-Learning: Pristup sistemu", webdriver.getTitle());
		Thread.sleep(2000);
		List<WebElement> elements = webdriver.findElements(By.id("username"));
		Assert.assertEquals(1, elements.size());
		elements = webdriver.findElements(By.id("password"));
		Assert.assertEquals(1, elements.size());
		elements = webdriver.findElements(By.id("loginbtn"));
		Assert.assertEquals(1, elements.size());
		webdriver.findElement(By.id("username")).sendKeys("korisnik");
		webdriver.findElement(By.id("password")).sendKeys("$1fr@");
		//webdriver.findElement(By.id("password")).submit();
		Thread.sleep(2000);
		webdriver.findElement(By.id("loginbtn")).click();
		Assert.assertEquals(1, webdriver.findElements(By.className("loginerrors")).size());
		Assert.assertEquals("PogreÅ¡no korisniÄ�ko ime ili lozinka. Molimo pokuÅ¡ajte ponovo.",
				webdriver.findElement(By.id("loginerrormessage")).getText());

		Assert.assertEquals(1, webdriver.findElements(By.xpath("//input[@id='username']")).size());
		
		List<WebElement> elements1 = webdriver.findElements(By.xpath("//div[@class='loginerrors mt-3']/a"));
		System.out.println(elements1.get(0).getText());
		System.out.println(elements1.get(0).getTagName());
		
		Thread.sleep(1000);
		webdriver.quit();
	}

}
