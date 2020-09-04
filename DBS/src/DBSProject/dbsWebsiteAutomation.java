package DBSProject;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.*;
import java.io.IOException;
import com.excel.utility.Xls_Reader;


public class dbsWebsiteAutomation {
	static WebDriver driver;
	
	public void accessSite() { 
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Adisha\\Desktop\\Selenium\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.dbs.com.sg/index/default.page");
		driver.findElement(By.xpath("//p[@class='dbs-group']//button[@class='btn btn-primary'][contains(text(),'Learn More')]")).click();
		driver.findElement(By.xpath("//div[@class='navbar-links-left']//a[contains(text(),'Sustainability')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Creating Social Impact')]")).click();
		driver.findElement(By.xpath("//body//div[7]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'DBS Stronger Together Fund')]")).click();
		driver.findElement(By.xpath("//div[@id='sideNav']")).click();
		//driver.findElement(By.xpath("//a[@class='nav-link hasDevice active']")).click();
		System.out.println("Reached the table for reading and writing values");		
	}
	public void readWrite() throws IOException {
				
		String beforexpath_column1 = "//body//tr[";
		String afterxpath_column1 = "]//td[1]";
		
		String beforexpath_column2 = "//body//tr[";
		String afterxpath_column2 = "]//td[2]";
		
		String beforexpath_column3 = "//body//tr[";
		String afterxpath_column3 = "]//td[3]";
		
		String beforexpath_column4 = "//body//tr[";
		String afterxpath_column4 = "]//td[4]";
		
		String beforexpath_column5 = "//body//tr[";
		String afterxpath_column5 = "]//td[5]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rich-text-box']//div//table//tr"));
		int rowcount = rows.size();
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Adisha\\eclipse-workspace\\DBS\\src\\DBSProject\\dataSample.xlsx");
		reader.addSheet("Data");
		reader.addColumn("Data","Column1");
		reader.addColumn("Data","Column2");
		reader.addColumn("Data","Column3");
		reader.addColumn("Data","Column4");
		reader.addColumn("Data","Column5");
				
	   for(int i=2; i<=rowcount; i++) {
		   String actualPath_column1= beforexpath_column1+i+afterxpath_column1;
		   String column1 = driver.findElement(By.xpath(actualPath_column1)).getText();
		   System.out.println(column1);
		   reader.setCellData("Data","Column1",i,column1);
		   
		   String actualPath_column2= beforexpath_column2+i+afterxpath_column2;
		   String column2 = driver.findElement(By.xpath(actualPath_column2)).getText();
		   System.out.println(column2);
		   reader.setCellData("Data","Column2",i,column2);
		   
		   String actualPath_column3= beforexpath_column3+i+afterxpath_column3;
		   String column3 = driver.findElement(By.xpath(actualPath_column3)).getText();
		   System.out.println(column3);
		   reader.setCellData("Data","Column3",i,column3);
		   
		   String actualPath_column4= beforexpath_column4+i+afterxpath_column4;
		   String column4 = driver.findElement(By.xpath(actualPath_column4)).getText();
		   System.out.println(column4);
		   reader.setCellData("Data","Column4",i,column4);
		   
		   String actualPath_column5= beforexpath_column5+i+afterxpath_column5;
		   String column5 = driver.findElement(By.xpath(actualPath_column5)).getText();
		   System.out.println(column5);
		   reader.setCellData("Data","Column5",i,column5);
		   
	   }
	}
	public void awardsCount() throws IOException {
		driver.get("https://www.dbs.com/about-us/who-we-are/awards-accolades/default.page?productId=jxeawnvl");
		driver.findElement(By.xpath("//div[@id='bodywrapper']")).click();
		List<WebElement> list = driver.findElements(By.className("row mBot-20"));
		int itemsCount = list.size();
		System.out.println(itemsCount);
	}
	public void verifyAwards() throws IOException {
		
		String awardName1 = driver.findElement(By.xpath("//div[3]//div[1]//div[2]//h3[1]//strong[1]")).getText();
		String Caption1 = driver.findElement(By.xpath("//h2[contains(text(),'A World First')]")).getText();
		System.out.println(awardName1);	
		System.out.println(Caption1);
		//	List<WebElement> list = driver.findElements(By.className("row mBot-20"));
		//System.out.println(list);
		//int itemsCount = list.size();
		//System.out.println(itemsCount);
	}																 
	
	public static void main(String[] args) throws IOException{
		
		dbsWebsiteAutomation obj=new dbsWebsiteAutomation();
		obj.accessSite();
		obj.readWrite();
		obj.awardsCount();
		obj.verifyAwards();
	}
}
