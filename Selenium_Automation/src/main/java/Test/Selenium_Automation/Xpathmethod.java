package Test.Selenium_Automation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Xpathmethod {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		driver.findElement(By.xpath("//div/input")).sendKeys("riya");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}}