package metoda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import stranice.Main;
import stranice.PrvaStranica;



public class Metoda {

	/*Test Selenium
Zadatak
Napisati program na programskom jeziku Java koji sluzi za testiranje sajta https://www.saucedemo.com/
 Pokusati logovanje prvo sa nevalidnim, a potom sa validnim kredencijalima i proveriti da li se nakon 
 toga korisnik nalazi na odgovarajucoj staranici. Na stranici https://www.saucedemo.com/inventory.html 
 sortirati proizvode po ceni (od najnize ka najvisoj). Proveriti da li je sortiranje ispravno. 
Program pisati postujuci page object model. Koristiti Test NG za proveru ispravnosti testova. 
Kredencijale procitati iz datoteke data.xlsx. Resenje okaciti na GitHub nalog i svoj folder na google
 drive-u.
*/
	WebDriver driver;
	 InputStream inp;
	 XSSFWorkbook wb;
	 Sheet sheet;
	// Cell c2;
	// String search2;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();				
	}
	
	@Test(priority=1)
	public void FailTest() {
		File f=new File ("data.xlsx");
		try {
		inp = new FileInputStream(f);			// Citanje iz fajla
		wb = new XSSFWorkbook(inp); 			// Pretvaranje fajla u odgovarajuci format
		Sheet sheet = wb.getSheetAt(0);	
		// Dohvata sheet
		Row row = sheet.getRow(6); 				// Dohvata red
		Cell c1=row.getCell(0);
		String fusername=c1.toString();
		System.out.println(fusername);
		
		Row row1 = sheet.getRow(7);
		Cell c2=row1.getCell(0);
		String fpassword=c2.toString();
		System.out.println(fpassword);
		driver.navigate().to(Main.URL);	
		Main.falseRegister(driver,fusername,fpassword);
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected= Main.URL;
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=1)
	public void PassTest()
	{
	File f=new File ("data.xlsx");
	try {
		inp = new FileInputStream(f);			// Citanje iz fajla
		wb = new XSSFWorkbook(inp); 			// Pretvaranje fajla u odgovarajuci format
		Sheet sheet = wb.getSheetAt(0);			// Dohvata sheet
		Row row1 = sheet.getRow(8); 				// Dohvata red
		Cell c1=row1.getCell(0);
		String username=c1.toString();
		System.out.println(username);
		
		Row row2 = sheet.getRow(9);
		Cell c2=row2.getCell(0);
		String password=c2.toString();
		System.out.println(password);
		driver.navigate().to(Main.URL);
		Main.trueRegister(driver, username , password);
		wb.close();
	} catch (IOException  e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		String actual = driver.getCurrentUrl();
		String expected= PrvaStranica.URL;
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=2)
	
	public void TestSortiranje() {
		driver.navigate().to(PrvaStranica.URL);	
		PrvaStranica.SortiranjeP(driver);
		String actual = driver.getCurrentUrl();
		String expected= PrvaStranica.SORTIRANJE_URL;
		Assert.assertEquals(actual, expected);
		
	}
	
	@AfterClass
	public void zatvaranje() {
		driver.quit();
	}
	/*
	@Test
	public void Upisivanje() {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(7);
		Cell cell = row.createCell(9);
		cell.setCellValue(123);
		
		try {
			OutputStream out = new FileOutputStream("data.xlsx");
			wb.write(out);
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	*/	
		
			
	}	
		

	
		
	
	

