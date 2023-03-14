//package executionEngine;
//
//import java.io.FileInputStream;
//import java.lang.reflect.Method;
//import java.util.Properties;
//
//import org.apache.log4j.PropertyConfigurator;
//
//import org.apache.log4j.xml.DOMConfigurator;
//
//import config.ActionKeywords;
//import config.Constants;
//import utility.ExcelUtils;
//import utility.Log;
//
//import java.util.Iterator; 
//import java.util.Set; 
//import org.openqa.selenium.By; 
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
// 
//public class WindowHandler {
//	
//	public static void main (String[] args) {
//		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			WebDriver driver=new ChromeDriver();
//			driver.manage().window().maximize();
//			
//			driver.get("https://dwer-test-eo.powerappsportals.com/");
//			
//			
//			String parent = driver.getWindowHandle();
//			System.out.println("Parent window is" +parent);
//			driver.findElement(By.xpath("")).click();
//			
//			Set<String> allWindows= driver.getWindowHandles();
//			int count = allWindows.size();
//			System.out.println("Total Window" +count);
//			
//			for (String child:allWindows) {
//				if(!parent.equalsIgnoreCase(child)) {
//					
//					driver.switchTo.window(child);
//					//Perform some action
//					js.executeScript("window.scrollBy(0, 400);");
//					
//					Thread.sleep(4000);
//					
//					js.executeScript("window.scrollBy(0, -400);");
//					
//					Thread.sleep(4000);
//					
//					driver.close();
//					
//				}	
//			}
//			
//			driver.switchTo().window(parent);
//			
//    public static void main(String[] args) throws Exception {
//    	
//    }
//}

