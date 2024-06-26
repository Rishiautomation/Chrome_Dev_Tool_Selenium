import java.util.Optional;

import org.asynchttpclient.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.Response;

public class Network_Log {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		
	DevTools devtools=driver.getDevTools();
	devtools.createSession();
	devtools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
	
	devtools.addListener(Network.requestWillBeSent(), request ->
	
	{
		    
		org.openqa.selenium.devtools.v108.network.model.Request req = request.getRequest();
		System.out.println(req.getUrl());
	});
	
	

	devtools.addListener(Network.responseReceived(), response->
	
	{
		Response res = response.getResponse();
		System.out.println(res.getUrl());
		System.out.println(res.getStatus());
	}
	);	
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
	
	
	
	
	
	
	
	
	
			
		
		
		
		
		
		
		
		
		
	}

}
