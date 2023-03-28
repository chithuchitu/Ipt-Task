package practice.org;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task {
	public static WebDriver driver;

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.fatface.com/");
		driver.manage().window().maximize();
		System.out.println("Browser launched");

	}
	public static  void noOfLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int totalCount = links.size();
		System.out.println("The number of links in page:"+totalCount);
		for (WebElement lists : links) {
		System.out.println(lists.getText());
			
			
		}

	}
public static void main(String[] args) {
	browserLaunch();
	noOfLinks();
}
}
