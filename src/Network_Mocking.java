import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.fetch.Fetch;

public class Network_Mocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		
		DevTools devtools=driver.getDevTools();
		
		devtools.createSession();
		//here we will use fetch domain to mock the Api request
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devtools.addListener(Fetch.requestPaused(), request->
		{
			if(request.getRequest().getUrl().contains("shetty")){
				
				String Mockurl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				//https://rahulshettyacademy.com/Library/GetBook.php?AuthorName=BadGuy we are changing to BadGuy so to get only one record.
				// And our Aim is to get the message displayed "Oops only 1 Book available" when only one record is present so that's why we are mocking our APi.
				System.out.println(Mockurl);
				
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(Mockurl),Optional.of(request.getRequest().getMethod()), 
						Optional.empty(), Optional.empty(),Optional.empty()));
				
			}
			else {
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),Optional.of(request.getRequest().getMethod()), 
						Optional.empty(), Optional.empty(),Optional.empty()));
			}
		}
				
				
				);
		
		
		
		
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
		
	}

}
