import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.emulation.Emulation;

public class Settring_Different_Loations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		//devTools.send(Emulation.setGeolocationOverride(Optional.of(17), Optional.of(78),Optional.of(1)));
		Map <String,Object> Coordinates = new HashMap <String,Object>();
		
		Coordinates.put("latitude",40);
		Coordinates.put("longitude",3);
		Coordinates.put("accuracy",1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", Coordinates);                   
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Amazon",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();                //.LC20lb
	String Text=driver.findElement(By.cssSelector("h1[data-uia='hero-title']")).getText();
		System.out.println(Text);
		
	}

}
