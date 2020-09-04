import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;

public class verifyAwards {
static WebDriver driver;
public static void main(String[] args) 
{
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Adisha\\Desktop\\Selenium\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.dbs.com/about-us/who-we-are/awards-accolades/default.page?productId=jxeawnvl");
	driver.findElement(By.xpath("//h2[contains(text(),'A World First')]")).click();
	List<WebElement> list = driver.findElements(By.className("row mBot-20"));
	int itemsCount = list.size();
	System.out.println(itemsCount);
	}
}
