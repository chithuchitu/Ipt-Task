package practice.org;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	public static WebDriver driver;
	private static  void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

	}
	private  static void allData() {
		System.out.println("All Data");
		System.out.println("==========");
		List<WebElement> allData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
		for (WebElement tableData : allData) {
			System.out.println(tableData.getText());

		}
	}

	private  static void rowData() {
		System.out.println("Row Data");
		System.out.println("==========");

		List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[3]/td"));
		for (WebElement row : rowData) {
			System.out.println(row.getText());
		}
	}
	private static void columnData() {
		System.out.println("Column Data");
		System.out.println("==========");

		List<WebElement> columnData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[3]"));
		for (WebElement column : columnData) {
			System.out.println(column.getText());
		}
	}
	private static void particularData() {
		System.out.println("Particular data");
		System.out.println("===============");
		WebElement particularData = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[2]"));
		System.out.println(particularData.getText());
	}
	public static void main(String[] args) {
		browserLaunch();
		allData();
		rowData();
		columnData();
		particularData();
		driver.quit();


	}

}
