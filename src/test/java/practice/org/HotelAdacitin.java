package practice.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelAdacitin {
	public static WebDriver driver;

	private static void browserLaunch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Browser launched..");
	}

	private static void loginPage() {
		driver.findElement(By.name("username")).sendKeys("Shahishahii");
		driver.findElement(By.name("password")).sendKeys("Shahi@123");
		WebElement login = driver.findElement(By.xpath("//input[@type='Submit']"));
		login.click();
		System.out.println("Login Success");
	}

	private static void Registraion() throws InterruptedException {
		WebElement location = driver.findElement(By.name("location"));
		Select s = new Select(location);
		s.selectByIndex(1);
		WebElement hotel = driver.findElement(By.id("hotels"));
		Select s1 = new Select(hotel);
		s1.selectByValue("Hotel Creek");
		WebElement type = driver.findElement(By.name("room_type"));
		Select s2 = new Select(type);
		s2.selectByIndex(2);
		WebElement no = driver.findElement(By.name("room_nos"));
		Select s3 = new Select(no);
		s3.selectByIndex(2);
		WebElement checkIn = driver.findElement(By.name("datepick_in"));
		checkIn.sendKeys("04/08/2022");
		WebElement checkOut = driver.findElement(By.name("datepick_out"));
		checkOut.sendKeys("05/08/2022");
		WebElement room1 = driver.findElement(By.name("adult_room"));
		Select s6 = new Select(room1);
		s6.selectByIndex(2);
		WebElement room2 = driver.findElement(By.name("child_room"));
		Select s7 = new Select(room2);
		s7.selectByIndex(3);
		WebElement search = driver.findElement(By.xpath(" //input[@id='Submit']"));
		search.click();
		Thread.sleep(2000);
		System.out.println("Registered Successfully");
		Thread.sleep(2000);
	}

	private static void bookingHotel() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("continue")).click();
		driver.findElement(By.name("first_name")).sendKeys("shahi");
		driver.findElement(By.name("last_name")).sendKeys("shahi");
		driver.findElement(By.name("address")).sendKeys("Sydney");
		driver.findElement(By.name("cc_num")).sendKeys("7894561231236547");
		WebElement card = driver.findElement(By.name("cc_type"));
		Select s8 = new Select(card);
		s8.selectByIndex(2);
		WebElement month = driver.findElement(By.name("cc_exp_month"));
		Select s9 = new Select(month);
		s9.selectByIndex(9);
		WebElement year = driver.findElement(By.name("cc_exp_year"));
		Select s10 = new Select(year);
		s10.selectByIndex(12);
		driver.findElement(By.name("cc_cvv")).sendKeys("211");
		WebElement bookNow = driver.findElement(By.id("book_now"));
		bookNow.click();
		Thread.sleep(80000);
		System.out.println("Hotel Booked");
	}

	private static void generateTicket() throws InterruptedException {
		WebElement text1 = driver.findElement(By.xpath("//input[@name='order_no']"));
		String outvalue = text1.getAttribute("Value");
		System.out.println("The Generated ticket order no:" + outvalue);
		Thread.sleep(60000);
	}

	public static void main(String[] args) throws InterruptedException {
		browserLaunch();
		loginPage();
		Registraion();
		bookingHotel();
		generateTicket();

	}

}
