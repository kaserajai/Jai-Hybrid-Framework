package config;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static executionEngine.DriverScript.OR;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import executionEngine.DriverScript;
import utility.Log;
import org.openqa.selenium.Keys;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class ActionKeywords {
	
		public static WebDriver driver;
			
	public static void openBrowser(String object,String data){		
		Log.info("Opening Browser");
		try{				
			if(data.equals("Mozilla")){
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				Log.info("Mozilla browser started");				
				}
			else if(data.equals("IE")){
				//Dummy Code, Implement you own code
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				Log.info("IE browser started");
				}
			else if(data.equals("Chrome")){
				//Dummy Code, Implement you own code
				System.setProperty("webdriver.chrome.driver", "/Users/JayDwerProject/src/utility/chromedriver");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				Log.info("Chrome browser started");
				}
			
			int implicitWaitTime=(10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		}catch (Exception e){
			Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
	
	public static void navigate(String object, String data){
		try{
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}

	public static void current_Date(String object, String data){
		try{
			Log.info("Entering current date " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.now();
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(dtf.format(localDate));
			
		 }catch(Exception e){
			 Log.error("Not able to Enter current date --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}

	
	public static void future_Date(String object, String data){
		try{
			Log.info("Entering current date " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.of(2025, 12, 23);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(dtf.format(localDate));
			
		 }catch(Exception e){
			 Log.error("Not able to Enter current date --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	
	public static void navigatetoDynamic(String object, String data){
		try{
			Log.info("Navigating to dynamics URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL1);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
	
	public static void navigatetoAPP(String object, String data){
		try{
			Log.info("Navigating to dynamics Application");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(data);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
	public static void click(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	
	
	public static void clickCSS(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			driver.manage().timeouts().implicitlyWait(18, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	
	
	
	public static void get_Dialogbox(String object, String data){
		try{
		//Log.info("Fetching the text associated to" + object);
		//Constants.APPLICATION_ID= driver.findElement(By.xpath(OR.getProperty(object))).getText();
		//og.info("Fetching the text associated to" + Constants.APPLICATION_ID);
		//driver.quit();
		String dialog_text = driver.switchTo().alert().getText();
		System.out.println(dialog_text);
		}catch(Exception e){
		Log.error("Not able to Fetching the associated text --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}
	
	public static void iFrameDMA(String object, String data){
		try{
			Log.info("iFrameDMA" + object);
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create']")));
			driver.findElement(By.xpath("//button[@id='btnCreateNewDMA']")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//driver.switchTo().frame(driver.findElement(By.xpath("//button[normalize-space()='Select']")));
			//driver.switchTo().frame(driver.findElement(By.xpath("//*[@class = 'modal fade modal-lookup in']")));
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//driver.findElement(By.cssSelector("button[title='Select']"));

			driver.switchTo().parentFrame();
			//driver.switchTo().activeElement();
			
			//driver.switchTo().parentFrame();
			//driver.switchTo().frame(driver.findElement(By.xpath("//section[@aria-label='Edit']//iframe")));
			//driver.switchTo().defaultContent();
			//driver.switchTo().frame("(//iframe)[3]");
			//driver.findElement(By.xpath("//td[@aria-label='Agency - Aboriginal Heritage Act 1972']")).click();
			//driver.findElement((By.cssSelector("button[title='Select']"))).click();
		}catch(Exception e){
		Log.error("Not able to switch to iFrame --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}
	
	public static void iFrameCreateDMA(String object, String data){
		try{
			Log.info("iFrameDMA" + object);
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create']")));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='eo_dmaname']")).sendKeys("Automation Testing DMA");
			driver.findElement(By.xpath("//input[@id='eo_email']")).sendKeys("Test-user-eo-5@dwer.wa.gov.au");
			driver.findElement(By.xpath("//input[@id='eo_agency']")).sendKeys("Department of Nature");
			driver.findElement(By.xpath("//input[@id='eo_role']")).sendKeys("License for Nature");
			driver.findElement(By.xpath("//input[@id='eo_legislation']")).sendKeys("Nature Resources Management Act 1994");
			driver.findElement(By.xpath("//textarea[@id='eo_approvalrequired']")).sendKeys("Preparation of applications for permits to remove native vegetation");
			driver.findElement(By.xpath("//textarea[@id='eo_mitigationofimpacts']")).sendKeys("Automation Mitigation");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.switchTo().parentFrame();
		}catch(Exception e){
		Log.error("Not able to switch to iFrame --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}
	
	public static void iFrameTenure(String object, String data){
		try{
		
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create']")));
			driver.findElement(By.xpath("//input[@id='eo_activity']")).sendKeys("Activity");
			driver.findElement(By.xpath("//input[@id='eo_landtenureaccess']")).sendKeys("Land Tenure");
			driver.findElement(By.xpath("//textarea[@id='eo_legislation']")).sendKeys("Type of Approval");
			driver.findElement(By.xpath("//input[@id='InsertButton']")).click();
			driver.switchTo().parentFrame();
		}catch(Exception e){
		Log.error("Not able to switch to iFrame --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}
	public static void iFrameAspect(String object, String data){
		try{
			Log.info("iFrame "+ object);
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create']")));	
			Select dropdownCat = new Select(driver.findElement(By.xpath("//select[@id='eo_elementcategoryid']")));  
			dropdownCat.selectByVisibleText("ELE-0001709 - Open pit");  
			Select dropdownAct = new Select(driver.findElement(By.xpath("//select[@id='eo_elementactivityid']")));  
			dropdownAct.selectByVisibleText("ELA-0001461 - Clearing - Open pit"); 
			driver.findElement(By.xpath("//input[@id='InsertButton']")).click();
			driver.switchTo().parentFrame();
		}catch(Exception e){
		Log.error("Not able to switch to iFrame Aspect --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}
	
	public static void iFrameMitgation(String object, String data){
		try{
			Log.info("iFrame "+ object);
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create']")));	
			Select dropdownMit = new Select(driver.findElement(By.xpath("//select[@id='eo_aspectid']")));  
			dropdownMit.selectByVisibleText("Noise");  
			driver.findElement(By.xpath("//input[@id='InsertButton']")).click();
			driver.switchTo().parentFrame();
		}catch(Exception e){
		Log.error("Not able to switch to iFrame Aspect --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}


	public static void iFrameStake(String object, String data){
		try{
			Log.info("iFrame "+ object);
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Create']")));	
			driver.findElement(By.xpath("//input[@id='eo_stakeholdername']")).sendKeys("Name");
			driver.findElement(By.xpath("//input[@id='eo_stakeholderorganisation']")).sendKeys("Organisation");
			driver.findElement(By.xpath("//input[@id='eo_stakeholderrole']")).sendKeys("Role");
			driver.findElement(By.xpath("//input[@id='InsertButton']")).click();
			driver.switchTo().parentFrame();
		}catch(Exception e){
		Log.error("Not able to switch to iFrame --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}
	
	
	public static void iFrameProject(String object, String data){
		try{
			Log.info("iFrame "+ object);
			
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='modal-body']//iframe")));
     	    driver.findElement(By.xpath("//input[@id='eo_projecttitle']")).sendKeys("Automation Testing");
		  //driver.findElement(By.xpath("//input[@id='eo_projecttitle']")).sendKeys(data);
		    driver.findElement(By.xpath("//textarea[@id='eo_shortdescription']")).sendKeys("Jay Created automation");
			driver.findElement(By.xpath("//input[@id='InsertButton']")).click();
			driver.switchTo().parentFrame();
		}catch(Exception e){
		Log.error("Not able to switch to iFrame --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}
	
	//this code to create the new numbers every time
	public static String generateRandomVariabe(int len, String object, String data ) {
//		String project_name = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
//          +"lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(data.charAt(rnd.nextInt(data.length())));
		return sb.toString();
	}
	
	public static void popupYes(String object, String data){
		try{
		
			driver.switchTo().activeElement();
			driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			
			
		}catch(Exception e){
		Log.error("Not able to switch to iFrame --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}
	
	public static void linkclick(String object, String data){
		try{
			Log.info("Clicking on link txt "+ object);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.partialLinkText(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	public static void input(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			//driver.findElement(By.cssSelector(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	public static void input_number(String object, String data){
		try{
			int count = 23;
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(""+count);
			//driver.findElement(By.cssSelector(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void deshapefileupload(String object, String Data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys("C:/Users/nagra/Desktop/UAT Shapefiles DE (1).zip");
			//driver.findElement(By.cssSelector(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	

	public static void dfshapefileupload(String object, String Data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys("C:/Users/nagra/Desktop/UAT Shapefile DF (1).zip");
			//driver.findElement(By.cssSelector(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	public static void inputCSS(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			driver.findElement(By.cssSelector(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	
	public static void selectPartyDropDown(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement web =driver.findElement(By.xpath(OR.getProperty(object)));
			web.click();
			web.sendKeys(data);
			Thread.sleep(5000);
			driver.findElement(By.xpath(("(//ul[contains(@id,'fieldControl-LookupResultsDropdown_eo_partyid')])[1]"))).click();				
		 }catch(Exception e){
			 Log.error("Not able to Select value from Drop Down --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void selectPersonDropDown(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement web =driver.findElement(By.xpath(OR.getProperty(object)));
			web.click();
			web.sendKeys(data);
			Thread.sleep(5000);
			driver.findElement(By.xpath(("(//ul[contains(@id,'fieldControl-LookupResultsDropdown_eo_personid')])[1]"))).click();				
		 }catch(Exception e){
			 Log.error("Not able to Select value from Drop Down --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void selectDropDown(String object, String data)
	{
		Log.info("Entering the text in Dropdown" + object);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select drpCountry = new Select(driver.findElement(By.xpath(OR.getProperty(object))));
		drpCountry.selectByVisibleText(data);
	
	}
	
	// Drop down menu on type of enquiry
	public static void selectDropDownEnq(String object, String data)
	{
		Log.info("Entering the text in Dropdown" + object);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Select drpCountry = new Select(driver.findElement(By.xpath(OR.getProperty(object))));
		//drpCountry.selectByVisibleText(data);
		Select dropdown = new Select(driver.findElement(By.id("eo_enquirytype")));  
		dropdown.selectByVisibleText("General");  
	
	}
	
	// Drop down menu on type of enquiry
		public static void selectDropDownProp(String object, String data)
		{
			
			Select dropdown = new Select(driver.findElement(By.id("eo_proposalid")));  
			dropdown.selectByVisibleText("PRO-0001172");  
		
		}
		
		// Drop down menu on type of alternative
				public static void selectDropDownAlt(String object, String data)
				{
					
					Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='eo_alternativetype']")));  
					dropdown.selectByVisibleText("No Development");  
				
				}
				
		// Drop down menu on type of aspect
				public static void selectDropDownAspect(String object, String data)
				{
					
					Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='eo_aspecttype']")));  
					dropdown.selectByVisibleText("Noise");  
				
				}
				
				public static void selectDropDownGreenHouse(String object, String data)
				{
					
					driver.findElement(By.xpath("((//td[@aria-label='action menu'])[1]")).click();  
					//dropdownGreen.selectByVisibleText("Edit");  
				
				}
				
				
	public static void waitFor(String object, String data) throws Exception{
		try{
			Log.info("Wait for 5 seconds");
			Thread.sleep(5000);
		 }catch(Exception e){
			 Log.error("Not able to Wait --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}

	public static void closeBrowser(String object, String data){
		try{
			Log.info("Closing the browser");
			driver.quit();
		 }catch(Exception e){
			 Log.error("Not able to Close the Browser --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}
	
	public static void get_Text(String object, String data){
		try{
			//Log.info("Fetching the text associated to" + object);
			Constants.APPLICATION_ID= driver.findElement(By.xpath(OR.getProperty(object))).getText();
			Log.info("Fetching the text associated to" + Constants.APPLICATION_ID);
			//System.out.println("APPLICATION_ID");
			//driver.quit();
		 }catch(Exception e){
			 Log.error("Not able to Fetching the associated text --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}
	
	public static void keys_down(String object, String data){
		try{
			WebElement dp_down = driver.findElement(By.xpath(OR.getProperty(object)));
			dp_down.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Log.info("Cannot get keys down" + object);		
		 }catch(Exception e){
			 Log.error("Not able to get  --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}


		
		//MASTER WORKED	
		public static void get_Table_content(String object, String excel_data){
			try{
				
				//fetch the enquiry from the table
				
				
				WebElement webTable = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody"));
				List<WebElement> rowElements = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr"));
				int rowSize = rowElements.size();
				
				List<WebElement> columnElements = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr/td"));
				int colSize = columnElements.size();
		
				
				String sColValue = excel_data;
				
				for (int i =1; i<rowSize; i++) {
					
					String table_data = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[6]")).getText();
					Log.info("Status reason for row "+ i +" is " + table_data);
					
					
		
						if (excel_data.equals("Submitted") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
								
								Thread.sleep(2000);
								
								driver.findElement(By.xpath("//*[@id='mainContent']//table/tbody/tr["+ i +"]/td[7]//a")).click();
								
								
								break;
								
							}
							
							break;	
				
						}
						
						
						else if (excel_data.equals("Draft") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
						
						else if (excel_data.equals("Closed") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
						
						else if (excel_data.equals("Withdrawn") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
						
						else if (excel_data.equals("In Progress") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
					}
					
					
			}
			catch(Exception e){
				 Log.error("Not able to fetch the enquiry --- " + e.getMessage());
				 DriverScript.bResult = false;
	         	}
		}			

		//Need to complete this code if required
		public static void myEnquiryNextButton(String object, String data) {
			try {
				//Pagination code//
				//List<WebElement> pagination =driver.findElements(By.xpath("//*[@class='pagination']")); 
				WebElement pagination_table = driver.findElement(By.xpath("//*[@id='mainContent']//div[6]")); 
				
				List<WebElement> pagination =pagination_table.findElements(By.xpath("//*[@id='mainContent']//div[6]//ul")); 
				int pagination_size = pagination.size();
				
				WebElement nextButton= driver.findElement(By.xpath(".//*[@aria-label= 'Next page']"));
				
				WebElement last_Page= driver.findElement(By.xpath("//*[@id='mainContent']/div//ul/li[7]/a"));
				String last_Page_text = last_Page.getText();
				int last_Page_no = Integer.parseInt(last_Page_text);
				
				// check if pagination link exists
				
				if(pagination_size>0) {
					
					Log.info("pagination exists and size is " + pagination_size);
					
					// click on pagination link 
					
					for(int k=3; k <= pagination_size; k++) {
						//Check if next button is enable or not.
						String page_number = (driver.findElement(By.xpath("//*[@id=\"mainContent\"]//div[6]//ul/li["+ k +"]"))).getText();
						
						
						Log.info("current page number is " + page_number);
						
						driver.findElement(By.xpath("//*[@id='mainContent']/div//ul/li["+ k +"]/a")).click();
						
					
						
//						if(nextButton.isEnabled()) {
//							nextButton.click();
//							Log.info("Clicked on Next button");
//						}
						
					}
				}
							 
				else {
							Log.info("pagination does not exist"); 
					}
				
			}
				catch(Exception e){
					 Log.error("pagination not exists --- " + e.getMessage());
					 DriverScript.bResult = false;
		         	}
		}
		
		
//get table data with pagination
		
		public static void get_Table_content_with_pagination(String object, String excel_data){
			try{
				
				//fetch the enquiry from the table
				
				
				WebElement webTable = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody"));
				List<WebElement> rowElements = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr"));
				int rowSize = rowElements.size();
				
				List<WebElement> columnElements = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr/td"));
				int colSize = columnElements.size();
		
				
				String sColValue = excel_data;
				
				for (int i =1; i<rowSize; i++) {
					
					String table_data = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[6]")).getText();
					Log.info("Status reason for row "+ i +" is " + table_data);
					
		
						if (excel_data.equals("Submitted") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
								
								break;
								
							}
							
							break;	
				
						}
						
						
						else if (excel_data.equals("Draft") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
						
						else if (excel_data.equals("Closed") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
						
						else if (excel_data.equals("Withdrawn") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
						
						else if (excel_data.equals("In Progress") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
					}
					
					
			}
			catch(Exception e){
				 Log.error("Not able to fetch the enquiry --- " + e.getMessage());
				 DriverScript.bResult = false;
	         	}
		}					


	public static void modalWindow(String object, String data){
		try{
			
			//driver.switchTo().frame(driver.findElement(By.className("modal-content")));
			//Alert alert = driver.switchTo().alert();
			//String alertMessage = driver.switchTo().alert().getText();
			//Log.info(alertMessage);
			//Thread.sleep(2000);
	
//			WebElement currentElement = driver.switchTo().activeElement();
//			String windowName = currentElement.getText();
//			Log.info(windowName);
			

			
			String windowName = driver.findElement(By.className("modal-title")).getText();
			Log.info(windowName);
			
			WebElement windowBody = driver.findElement(By.className("modal-body"));
			//driver.switchTo().frame(windowBody);
			Log.info(windowBody.getText());
			
			Thread.sleep(2000);
			
			WebElement new_iframe = windowBody.findElement(By.xpath("//iframe[@title=' Edit']"));
			//driver.switchTo().frame(windowBody).switchTo().frame(new_iframe);
			
			driver.switchTo().frame(new_iframe);
			Thread.sleep(2000);			
			
//			driver.findElement(By.xpath(".//*[@id='eo_enquirytitle']")).sendKeys("testing title");
//			Thread.sleep(2000);	
			
			//driver.switchTo().defaultContent();

		 }catch(Exception e){
			 Log.error("Not able to focus on modal window  --- " + e.getMessage());
			 DriverScript.bResult = false;
	     	}
		}
	

	public static void SwitchBackToDefault(String object, String data){
		try{
			
			driver.switchTo().defaultContent();

		 }catch(Exception e){
			 Log.error("Not able to close the window  --- " + e.getMessage());
			 DriverScript.bResult = false;
	     	}
		}
	
	
}




