package Test.Selenium_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class P_Login_TC {
	public static void main (String []args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		  // Enter username
        driver.findElement(By.name("username")).sendKeys("student");

        // Enter password
        driver.findElement(By.name("password")).sendKeys("Password123");

        // Click Submit button
        driver.findElement(By.id("submit")).click();
     // Verify URL contains expected text
        String url = driver.getCurrentUrl();

        if (url.contains("practicetestautomation.com/logged-in-successfully/")) {
            System.out.println("URL Test Passed");
        } else {
            System.out.println("URL Test Failed");
        }
        // Verify page text
        String pageText = driver.getPageSource();

        if (pageText.contains("Congratulations") || pageText.contains("successfully logged in")) {
            System.out.println("Login Text Test Passed");
        } else {
            System.out.println("Login Text Test Failed");
        }
        // Verify Logout button displayed
        boolean logoutButton =
            driver.findElement(By.linkText("Log out")).isDisplayed();

        if (logoutButton) {
            System.out.println("Logout Button Displayed");
        } else {
            System.out.println("Logout Button Not Displayed");
        }

        logoutButton = driver.findElement(By.linkText("Log out")).isDisplayed();
        if (logoutButton) {
            System.out.println("Log out button is displayed");
        } else {
            System.out.println("Log out button is not displayed");
        }
	}

}
