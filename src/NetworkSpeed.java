import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.devtools.v106.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		ChromeDriver driver=new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		
		devtools.send(Network.emulateNetworkConditions(false, 3000, 2000, 100000, Optional.of(ConnectionType.WIFI)));//this will reduce the net speed so that we can check the flakyness in test.
		devtools.addListener(Network.loadingFailed(),loadingFailed ->
		{//This block of code will only be executed when above condition is true matlab net connection na ho;
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		}
				);
		long starttime=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn-lg")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Enable/Disable Buying')]")).click();
		long endtime=System.currentTimeMillis();
		System.out.println(starttime-endtime);
		driver.close();
		
	}

}
