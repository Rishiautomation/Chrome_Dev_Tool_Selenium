import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetwork_Requests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ChromeDriver driver=new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		devtools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		long starttime=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn-lg")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Enable/Disable Buying')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Check Availability')]")).click();
	long endtime=System.currentTimeMillis();
		
		System.out.println(starttime-endtime);
		
	}

}
