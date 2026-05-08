package Test.Selenium_Automation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class GUI_Testing {

	public static void main(String args[])throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("name")).sendKeys("Shweta Khule");
		driver.findElement(By.id("email")).sendKeys("ShwetaKhule2@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9876543210");
		driver.findElement(By.id("textarea")).sendKeys("Narhe, Pune, Pin-411041");
		Thread.sleep(2000);
		driver.findElement(By.id("female")).click();
		driver.findElement(By.id("monday")).click();
		
		Select sel = new Select(driver.findElement(By.id("country")));
		sel.selectByVisibleText("India");
		
		Select sel2 = new Select(driver.findElement(By.id("colors")));
		sel2.selectByVisibleText("Red");
		
		Select sel3 = new Select(driver.findElement(By.id("animals")));
		sel3.selectByVisibleText("Cat");
		
		driver.findElement(By.id("datepicker")).sendKeys("02/06/2026");
		driver.findElement(By.id("txtDate")).click();
		Thread.sleep(1000);
		
        driver.findElement(By.xpath("//a[text()='16']")).click();
        
		driver.findElement(By.id("start-date")).sendKeys("20/06/2026");
		
		driver.findElement(By.id("end-date")).sendKeys("26/06/2026");
		driver.findElement(By.className("submit-btn")).click();
		
		driver.findElement(By.linkText("Posts (Atom)")).click(); 
		String parent = driver.getWindowHandle();
		driver.findElement(By.linkText("Posts (Atom)")).click();
		for(String win : driver.getWindowHandles())
		{
		    driver.switchTo().window(win);
		}
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(parent);
		
		
		driver.findElement(By.id("singleFileInput"))
	    .sendKeys("C:\\Users\\Shweta\\Downloads\\resume\\Shweta_Madhukar_Khule_SoftwareTesting.pdf");
        driver.findElement(By.xpath("//button[text()='Upload Single File']")).click();
        Thread.sleep(2000);
		
        driver.findElement(By.id("multipleFilesInput"))
        .sendKeys("C:\\Users\\Shweta\\Downloads\\resume\\Shweta_Madhukar_Khule_SoftwareTesting.pdf" + "\n" +
                  "C:\\Users\\Shweta\\Downloads\\resume\\Shweta_Khule_Hardware.pdf");
        driver.findElement(By.xpath("//button[text()='Upload Multiple Files']")).click();
        Thread.sleep(2000);

		  List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
      	for(int i=1; i<=pages.size(); i++)
      	{
      	    driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='"+i+"']")).click();
      	    List<WebElement> checks = driver.findElements(By.xpath("//table[@id='productTable']//input[@type='checkbox']"));
      	    for(WebElement chk : checks)
      	    {
      	        chk.click();
      	    }
      	}

		
        WebElement se = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
        WebElement button = driver.findElement(By.xpath("//input[@class='wikipedia-search-button']"));
        se.sendKeys("Selenium");
        driver.findElement(By.className("wikipedia-search-button")).click();
        button.click();Thread.sleep(2000);

        driver.findElement(By.className("start")).click();
        driver.findElement(By.className("stop")).click();
        
        driver.findElement(By.xpath("//button[@onclick='myFunctionAlert()']")).click();
        Alert al = driver.switchTo().alert();
        al.accept();
        
        driver.findElement(By.xpath("//button[@onclick='myFunctionConfirm()']")).click();
        Alert al2 = driver.switchTo().alert();
        Thread.sleep(2000);
        al2.dismiss();
        
        driver.findElement(By.xpath("//button[@onclick='myFunctionPrompt()']")).click();
        Alert al3 = driver.switchTo().alert();
        al3.sendKeys("Shweta Khule");
        Thread.sleep(2000);
        al3.accept(); 
        
        String parent2 = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        Thread.sleep(3000);
        for(String win : driver.getWindowHandles())
        {
            if(!win.equals(parent2))
            {
                driver.switchTo().window(win);
            }
        }
        driver.close();
        driver.switchTo().window(parent2);
       
        
		String parent3 = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@onclick='return popup()']")).click();
		Thread.sleep(3000);
		for(String win : driver.getWindowHandles())
		{
		    if(!win.equals(parent3))
		    {
		        driver.switchTo().window(win);
		        driver.close(); // close popup window
		    }
		}
		driver.switchTo().window(parent); // back to parent window
        
		WebElement pointme = driver.findElement(By.xpath("//button[text()='Point Me']"));
          Actions act = new Actions(driver);
        act.moveToElement(pointme).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		
		WebElement copybtn = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
		Actions act2 = new Actions(driver);
		act.doubleClick(copybtn).perform();
        
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions act3 = new Actions(driver);
        act.dragAndDrop(drag,drop).build().perform();
        Thread.sleep(2000);
          
          WebElement sldr = driver.findElement(By.id("slider-range"));
          act.dragAndDropBy(sldr, 91, 0).build().perform();
          Thread.sleep(2000);
          
          driver.findElement(By.id("comboBox")).click();
          WebElement dropdown = driver.findElement(By.id("dropdown"));
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("arguments[0].scrollTop=500", dropdown);
          Thread.sleep(3000);
          driver.findElement(By.xpath("//div[text()='Item 80']")).click();
    
          driver.findElement(By.id("apple")).click();
          Thread.sleep(2000);
          driver.navigate().back();
          
          driver.findElement(By.id("lenovo")).click();
          Thread.sleep(1000);
          driver.navigate().back();
          
          driver.findElement(By.id("dell")).click();
          Thread.sleep(1000);
          driver.navigate().back();
          
          List<WebElement> links1 = driver.findElements(By.xpath("//div[@id='broken-links']//a"));
        	for(int i=0; i<links1.size(); i++)
        	{
        	    links1 = driver.findElements(By.xpath("//div[@id='broken-links']//a"));
        	    links1.get(i).click();
        	    Thread.sleep(1000);
        	    driver.navigate().back();
        	    Thread.sleep(1000);
        	}
      
          driver.findElement(By.id("input1")).sendKeys("Shweta Madhukar Khule");
          driver.findElement(By.id("btn1")).click();    Thread.sleep(1000);
          
          driver.findElement(By.id("input2")).sendKeys("Software Testing is ensures the product is bug free, deliver on time with customer satisfaction,Quality of product should meets user requirements");
          driver.findElement(By.id("btn2")).click();     Thread.sleep(1000);
          
          driver.findElement(By.id("input3")).sendKeys("SDLC,STLC, Defect life cycle is important");
          driver.findElement(By.id("btn3")).click();      Thread.sleep(1000);
          
          driver.findElement(By.xpath("//a[text()='Home']")).click();
          
            driver.findElement(By.linkText("Hidden Elements & AJAX")).click();
            driver.findElement(By.id("input1")).sendKeys("Shweta");
            driver.findElement(By.id("toggleInput")).click();
            driver.findElement(By.id("input2")).sendKeys("Khule");
            driver.findElement(By.id("toggleCheckbox")).click();
            driver.findElement(By.id("checkbox1")).click();
            driver.findElement(By.id("checkbox2")).click();
            driver.findElement(By.id("loadContent")).click();
            Thread.sleep(1000);
          
            driver.findElement(By.xpath("//a[text()='Download Files']")).click();
            driver.findElement(By.id("inputText")).sendKeys("This is a sample file. We will generate it for downdoading....");
            driver.findElement(By.id("generateTxt")).click();
            driver.findElement(By.linkText("Download Text File")).click(); 
            Thread.sleep(1000);
            driver.findElement(By.id("generatePdf")).click();
            driver.findElement(By.linkText("Download PDF File")).click(); 
            Thread.sleep(1000);
          
          driver.findElement(By.xpath("//a[text()='Blog']")).click();
          driver.navigate().back();
          
          WebElement text = (WebElement) js.executeScript(
         "return document.querySelector('#shadow_host').shadowRoot.querySelector(\"input[type=text]\")");
          text.sendKeys("Read All Documents");
          
          WebElement check = (WebElement) js.executeScript(
         "return document.querySelector('#shadow_host').shadowRoot.querySelector(\"input[type=checkbox]\")");
        		  check.click();
        		  
          WebElement file = (WebElement) js.executeScript(
 	     "return document.querySelector('#shadow_host').shadowRoot.querySelector(\"input[type='file']\")");
         file.sendKeys("C:\\Users\\Shweta\\Downloads\\resume\\Shweta_Madhukar_Khule_SoftwareTesting.pdf");
         Thread.sleep(1000);
         
        driver.findElement(By.xpath("//a[text()='Youtube']")).click();
      	driver.navigate().back();
         
          driver.findElement(By.linkText("merrymoonmary")).click();
          String parent4 = driver.getWindowHandle();
          driver.findElement(By.linkText("merrymoonmary")).click();
          for (String win : driver.getWindowHandles()) {
              driver.switchTo().window(win);
          }
          Thread.sleep(5000);
          driver.close();
          driver.switchTo().window(parent4);
          
          driver.findElement(By.linkText("Blogger")).click();
          String parent5 = driver.getWindowHandle();
          driver.findElement(By.linkText("Blogger")).click();
          for (String win : driver.getWindowHandles()) {
              driver.switchTo().window(win);
          }
          Thread.sleep(5000);
          driver.close();
          driver.switchTo().window(parent5);
          
//          List<WebElement> links = driver.findElements(
//  		        By.xpath("//div[@class='widget-content']//ul//a"));
//  		int size = links.size();
//  		for (int i = 0; i < size; i++)
//  		{
//  		    links = driver.findElements(
//  		            By.xpath("//div[@class='widget-content']//ul//a"));
//  		    WebElement link = links.get(i);
//  		    String url = link.getAttribute("href");
//  		    driver.get(url);
//  		    Thread.sleep(2000);
//  		    driver.navigate().back();
//  		    Thread.sleep(2000);
//  		}
          
   driver.close();
          }
        }



