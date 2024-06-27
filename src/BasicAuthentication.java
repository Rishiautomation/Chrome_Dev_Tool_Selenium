import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;
public class BasicAuthentication {

	public static void main(String[] args) {
	//this is the changes i made to see in github.

		ChromeDriver driver=new ChromeDriver();
		
		Predicate<URI>UriPredicate = Uri->Uri.getHost().contains("httpbin.org");
		((HasAuthentication)driver).register(UriPredicate,UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
	}
//yeh woh code hai jaise ki hum website per jaate hai aur woh wha per user name aur password maang tah hai tab fir woh enter kar neh dehtah hai
	// uss samaysya kaa solution hai yeh code joh ki automatically enter kar deta hai username and password.
}
