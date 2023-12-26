package org.unibl.etf.ip.test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.function.Try;
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

@DisplayName("Update Tests")
public class StudentUpdateTest {
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
  @DisplayName("Update Student Name Test")
  @Test
  public void updateStudent1() {
    driver.get("http://localhost:4200/");
    driver.manage().window().setSize(new Dimension(1062, 812));
    driver.findElement(By.linkText("Add Student")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(1) > .form-control")).click();
    driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[1]/input")).sendKeys("student1");
    driver.findElement(By.cssSelector(".ng-invalid:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).sendKeys("student1@mail.com");
    driver.findElement(By.cssSelector(".ng-untouched")).click();
    {
      WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[3]/select"));
      dropdown.findElement(By.xpath("//option[. = 'M-Tech']")).click();
    }
    driver.findElement(By.cssSelector(".btn-success")).click();
    driver.findElement(By.linkText("View Student")).click();
    {
      WebElement element = driver.findElement(By.linkText("View Student"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".btn-info")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
    driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/form/div[2]/div[1]/div[1]/input")).sendKeys("student123");
    driver.findElement(By.cssSelector(".btn-success")).click();
    driver.findElement(By.cssSelector(".btn-danger")).click();
    vars.put("size", driver.findElements(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr")).size());
    assertEquals(vars.get("size").toString(), "1");
    vars.put("x", driver.findElement(By.xpath("//*[@id=\"DataTables_Table_1\"]/tbody/tr/td[1]")).getText());
    assertEquals("student123", vars.get("x").toString());
  }
  
  @DisplayName("After Name Mail Delete")
  @Test
  public void updateStudent2() {
    driver.get("http://localhost:4200/");
    driver.manage().window().setSize(new Dimension(1062, 812));
    vars.put("x", driver.findElement(By.cssSelector("td:nth-child(2)")).getText());
    assertEquals("M-Tech", vars.get("x").toString());
  }
  
  @DisplayName("Update Branch Test")
  @Test
  public void updateStudent3() {
    driver.get("http://localhost:4200/");
    driver.manage().window().setSize(new Dimension(1062, 812));
    driver.findElement(By.linkText("View Student")).click();
    {
      WebElement element = driver.findElement(By.linkText("View Student"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".btn-info")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
    driver.findElement(By.cssSelector(".ng-invalid:nth-child(2)")).sendKeys("B-Tech");
    driver.findElement(By.cssSelector(".btn-success")).click();
    driver.findElement(By.cssSelector(".btn-danger")).click();
    vars.put("size", driver.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr")).size());
    assertEquals(vars.get("size").toString(), "1");
    vars.put("x", driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[3]")).getText());
    assertEquals("B-Tech", vars.get("x").toString());
  }
  
  @DisplayName("Update Email Test")
  @Test
  public void updateStudent4() {
    driver.get("http://localhost:4200/");
    driver.manage().window().setSize(new Dimension(1062, 812));
    driver.findElement(By.linkText("View Student")).click();
    {
      WebElement element = driver.findElement(By.linkText("View Student"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".btn-info")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(3) > .form-control")).sendKeys("novimejl@mail.com");
    driver.findElement(By.cssSelector(".btn-success")).click();
    driver.findElement(By.cssSelector(".btn-danger")).click();
    /*try {
    	Thread.sleep(5000);
    } catch(Exception e) {
    	e.printStackTrace();
    }*/
    
    vars.put("size", driver.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr")).size());
    assertEquals(vars.get("size").toString(), "1");
    vars.put("x", driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[2]")).getText());
    assertEquals("novimejl@mail.com", vars.get("x").toString());
  }
  

}
