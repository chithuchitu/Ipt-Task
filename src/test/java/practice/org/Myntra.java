package practice.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Myntra {
	public static WebDriver driver;
	public static int totalProducts;
	public static Integer minPrice;
	public static Integer maxPrice;
	public static WebElement brandName;
	public static WebElement subBrandName;
	public static List<WebElement> allProducts;
	

@Test
	private static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.myntra.com/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false");
		driver.manage().window().maximize();
		System.out.println("Browser launched");

	}
@Test
	private static void productCount() {
		allProducts = driver.findElements(By.xpath("//div[@class='product-price']"));
		int totalProducts = allProducts.size();
		System.out.println("Total Product count is:" + totalProducts);
	}
@Test
	private static void minimumPriceOfAllProducts() {
		List<Integer> priceList = new ArrayList<Integer>();
		List<WebElement> allPrices = driver.findElements(By.xpath("//li[@class='product-base']//descendant::span[@class='product-discountedPrice']"));
		for (WebElement price : allPrices) {
			String priceText = price.getText().replaceAll("Rs. ", "");
			int priceValue = Integer.parseInt(priceText);
			priceList.add(priceValue);
		}
		minPrice = Collections.min(priceList);
		System.out.println("The minimum Price product is:" + minPrice);
		maxPrice = Collections.max(priceList);
		System.out.println("The Maximum Product price is: " + maxPrice);
	}
@Test
	private static void getBrandName(Integer Price) throws InterruptedException {
		WebElement brandName = driver.findElement(
				By.xpath("//li[@class='product-base']//descendant::span[text()='"+Price+"']//ancestor::div[@class='product-productMetaInfo']//h3[@class='product-brand']"));
		Thread.sleep(3000);
		String typeOfBrand = brandName.getText();
		System.out.println(typeOfBrand);
	}
@Test
	private static void getsubBrandName(Integer Price) {
		WebElement subBrandName = driver.findElement(
				By.xpath("//li[@class='product-base']//descendant::span[text()='"+Price+"']//ancestor::div[@class='product-productMetaInfo']//h4[@class='product-product']"));
		String typeOfSubBrand = subBrandName.getText();
		System.out.println(typeOfSubBrand);	
	}
	public static void main(String[] args) throws InterruptedException {
		browserLaunch();
		productCount();
		minimumPriceOfAllProducts();
		System.out.println("Minimum Price Brand Name:");
		getBrandName(minPrice);
		System.out.println("Minimum Price Sub Brand Name:");
		getsubBrandName(minPrice);

	}

}
