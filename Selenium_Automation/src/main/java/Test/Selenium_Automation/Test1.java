package Test.Selenium_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) {

//        ChromeDriver driver = new ChromeDriver();
//
//        driver.get("https://www.facebook.com/login");
//
//        driver.findElement(By.name("email")).sendKeys("adminn");
//        driver.findElement(By.name("pass")).sendKeys("adminn123");
        
        ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
//		1.ID=done
//		driver.findElement(By.id("username")).sendKeys("student"); 
//		2.name=done
//		driver.findElement(By.name("username")).sendKeys("student");
		// 3.classname=done
//		driver.findElement(By.className("btn")).click();
		//4.tagname=done
		//driver.findElement(By.tagName("input")).sendKeys("student");
		//5.linktext=done
		//driver.findElement(By.linkText("COURSES")).click();
		//6.partiallinkText
//		driver.findElement(By.partialLinkText("COUR")).click();
//		xpath(//tagname[@attribute='value')=done
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("student");
		//cssselector(tagname[attribute='value'])
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Password123");
    }
}