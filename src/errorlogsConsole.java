

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class errorlogsConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("a[role='button']")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);//here we are trying to get the logs.
		
		List<LogEntry> logs = entry.getAll();
		// now we will print the logs
		for(LogEntry a:logs) {
			
		   System.out.println(a.getMessage());
		}
		driver.close();
	}

}
