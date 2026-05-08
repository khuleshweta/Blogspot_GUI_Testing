package Test.Selenium_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class N_Login_TC02 {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter wrong username
        driver.findElement(By.name("username")).sendKeys("incorrectUser");

        // Enter password
        driver.findElement(By.name("password")).sendKeys("Password123");

        // Click submit button
        driver.findElement(By.id("submit")).click();

        // Verify error message displayed
        boolean errorMsg =
            driver.findElement(By.id("error")).isDisplayed();

        if (errorMsg) {
            System.out.println("Error message is displayed");
        } else {
            System.out.println("Error message is not displayed");
        }

        // Verify error text
        String actualText =
            driver.findElement(By.id("error")).getText();

        if (actualText.equals("Your username is invalid!")) {
            System.out.println("Error text test passed");
        } else {
            System.out.println("Error text test failed");
        }

     
    }
}