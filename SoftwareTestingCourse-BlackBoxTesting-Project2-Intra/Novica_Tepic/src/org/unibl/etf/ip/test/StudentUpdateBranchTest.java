package org.unibl.etf.ip.test;

//Generated by Selenium IDE
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

@DisplayName("Student Update Branch")
public class StudentUpdateBranchTest {
private WebDriver driver;
private Map<String, Object> vars;
JavascriptExecutor js;
@Before
public void setUp() {
 driver = new ChromeDriver();
 js = (JavascriptExecutor) driver;
 vars = new HashMap<String, Object>();
}
@After
public void tearDown() {
 driver.quit();
}

@DisplayName("Update branch after insert")
@Test
public void updtStu() {
 driver.get("http://localhost:4200/");
 driver.manage().window().setSize(new Dimension(1062, 812));
 driver.findElement(By.linkText("Add Student")).click();
 driver.findElement(By.cssSelector(".form-group:nth-child(1) > .form-control")).click();
 driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[1]/input")).sendKeys("st1");
 {
   WebElement element = driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control"));
   Actions builder = new Actions(driver);
   builder.moveToElement(element).clickAndHold().perform();
 }
 {
   WebElement element = driver.findElement(By.cssSelector(".ng-invalid:nth-child(1)"));
   Actions builder = new Actions(driver);
   builder.moveToElement(element).release().perform();
 }
 driver.findElement(By.cssSelector(".ng-invalid:nth-child(1)")).click();
 driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).sendKeys("st1@mail.com");
 driver.findElement(By.cssSelector(".ng-untouched")).click();
 {
   WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[3]/select"));
   dropdown.findElement(By.xpath("//option[. = 'MCA']")).click();
 }
 driver.findElement(By.cssSelector(".btn-success")).click();
 driver.findElement(By.linkText("View Student")).click();
 driver.findElement(By.cssSelector(".btn-info")).click();
 driver.findElement(By.cssSelector(".ng-invalid:nth-child(2)")).click();
 {
   WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/form/div[2]/div[1]/div[3]/select"));
   dropdown.findElement(By.xpath("//option[. = 'BCA']")).click();
 }
 driver.findElement(By.cssSelector(".btn-success")).click();
 driver.findElement(By.cssSelector(".btn-danger")).click();
 vars.put("y", driver.findElement(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[2]")).getText());
 assertEquals(vars.get("y").toString(), "BCA");
 vars.put("x", driver.findElement(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[1]")).getText());
 assertEquals("st1", vars.get("x").toString());
}
}

