package MavenLearning.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	
	public void config()
	{
	//There are two class name 
		//1. ExtentReport
		//2. ExtentSparkReporter

		String path = System.getProperty("user.dir")+"\\reoprts\\index.html";
				
		 ExtentSparkReporter reporter= new  ExtentSparkReporter(path);
		 reporter.config().setReportName("Automation Test Report");
		 reporter.config().setDocumentTitle("TestProject");
		 
		 // Create main classs to use above object
		 ExtentReports extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 // Set tester Name
		 extent.setSystemInfo("Tester", "Akhilesh");
	}
	
   @Test
	public void reoprtsDemo()
	{
	      ExtentTest test= extent.createTest("Test Reports");
			System.setProperty("Webdriver.chrome.driver","C:\\chromedriver.exe");
			
			WebDriver driver=new ChromeDriver();
			
			driver.get("https:google.com");
			System.out.println(driver.getTitle());
			
			// can screenshot of that object and can do lot
			extent.flush();

		}

}

