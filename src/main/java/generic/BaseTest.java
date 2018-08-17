package generic;



import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.pulse.Page.HomePage;
import com.pulse.Page.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public abstract class BaseTest implements IAutoConst{
	
	public WebDriver driver;
	
	public static int REPEAT_MINUS = 100;
	
Logger APP_LOGS = Logger.getLogger("BaseTest");
     
	
	public static String scrshotFolderLoc;
//	public String path = "C:\\Users\\rt\\workspace\\Talent Neuron - Gemini\\TestData\\preCondInput.xlsx";
	
	
	public String path ="C:\\Users\\ssrivastava4\\workspace\\PulseProject4\\data\\preCondInput.xlsx";
	
	
	
	static int testRunId=000000;
	
	  public static String logfiletimestamp;
	    
		BasePage b=new BasePage(driver);
		
		 
		 public static String downloadPath = null;
		
		public  ExtentReports extent;
		public  ExtentTest extentTest; 
		

		@BeforeTest
		public void setExtent(){
			extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/"+"AutomationLog_TestRunId-"+b.getlastRunid()+"ExtentReport.html", false);
			extent.addSystemInfo("Host Name", "Naveen Mac");
			extent.addSystemInfo("User Name", "Naveen Automation Labs");
			extent.addSystemInfo("Environment", "QA");
			
		}
		
	
		@BeforeMethod
	
	public void preCondition(Method method) throws Exception
	
	{
		
			extentTest =extent.startTest(method.getName());
			
		 String fileName=null;
		   
    	 Date d = new Date();
    	 
    	 
 	    SimpleDateFormat format = new SimpleDateFormat(  "dd.MMMMM.yyyy.hh.mm");
 	   

 	   logfiletimestamp = "AutomationLog_TestRunId-"+b.getlastRunid()+"_"+format.format(d);
 	   
	    System.setProperty("autologname",logfiletimestamp);

	      PropertyConfigurator.configure("Log4j.properties");
	    
	    	 
	    	 
		//scrshotFolderLoc=BasePage.createFolder();
		    
			Excel eLib = new Excel();
			
		//	String url = eLib.getCellValue(path,"PreCon", 1, 0);
			
		
			
			String browserType = eLib.getCellValue(path,"PreCon", 1, 1);
			
			
			int time = Integer.parseInt((eLib.getCellValue(path,"PreCon", 1, 2)).replace(".0", ""));
			
			
			
			if(browserType.equalsIgnoreCase("GC"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssrivastava4\\workspace\\PulseProject\\driver\\chromedriver_63.exe");
			
				
			     downloadPath=b.preInitialize();
				
			     driver = new ChromeDriver();
					
					APP_LOGS.info("Chrome Browser opened");
				
			//	String downloadFilepath = "C:\\Users\\ssrivastava4\\workspace\\filelocation";
				
				
				
				
				//**************************************			
							
							
							
							
							
											
				
		/*		
//		selenium 3.9
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 1);
		chromePrefs.put("download.default_directory", downloadPath);
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		//Enable Flash
//		chromePrefs.put("profile.default_content_setting_values.plugins", 1);
		chromePrefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
		chromePrefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
		
		// Hide save credentials prompt
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
	//	options.setExperimentalOption("prefs", chromePrefs);
	//	options.addArguments("--test-type");
	//	options.addArguments("chrome.switches","--disable-extensions");
	//	options.addArguments(Arrays.asList("allow-running-insecure-content", "ignore-certificate-errors"));
	//	options.addArguments("disable-infobars");
		
		
//		 options.addArguments("--start-maximized");
	//	 options.addArguments("--start-fullscreen");
		// options.addArguments("--proxy-server=10.32.120.120:8080");
		// taking fullscreenshot testing
		//options.setExperimentalOption("useAutomationExtension", false);
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		// cap.setCapability("chrome.switches", "--start-maximized");
		cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		  ExtractJSError method KR-15726
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER,Level.ALL);
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		 added for Js error collector testing 
		driver = new ChromeDriver(cap);
		// driver = new ChromeDriver(options);
		// driver = new ChromeDriver();
				*/
				
				
				
				
				
				
	//**************************************			
				
				
				
				
				
				
				
				
				
				
				
				
	//			old selenium 2.45
				
				/*
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 1);
				chromePrefs.put("download.default_directory", downloadPath);
				ChromeOptions options = new ChromeOptions();
				HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				//options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("--test-type");
				options.addArguments("chrome.switches","--disable-extensions");
				options.addArguments(Arrays.asList("allow-running-insecure-content", "ignore-certificate-errors"));
				options.addArguments("disable-infobars");
				// options.addArguments("--start-maximized");
				// options.addArguments("--proxy-server=10.32.120.120:8080");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				// cap.setCapability("chrome.switches", "--start-maximized");
				cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				  ExtractJSError method KR-15726
				LoggingPreferences logPrefs = new LoggingPreferences();
				logPrefs.enable(LogType.BROWSER,Level.ALL);
				cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
				 added for Js error collector testing 
				driver = new ChromeDriver(cap);
				
				
			     
			     
			     
			     
			     
			     */
			     
			     
			     
					/*	
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("download.default_directory", downloadPath);
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", chromePrefs);
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					cap.setCapability(ChromeOptions.CAPABILITY, options);
					WebDriver driver = new ChromeDriver(cap);
					
				
			     
			     
			     
				
		//		**************************************				
				
				/*HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadPath);
				ChromeOptions options = new ChromeOptions();
				//options.setExperimentalOption("prefs", chromePrefs);
				
				
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				WebDriver driver = new ChromeDriver(cap);
				*/
				
				
					
					
					
					
				
				//**************************************				
				
				
			/*	Map<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadFilepath);
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("--test-type");
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				WebDriver driver = new ChromeDriver(cap);
				*/
				
				
				//**************************************		
				
				
			/*	Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory", downloadPath);
				
				prefs.put("download.prompt_for_download",false);
				
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				WebDriver driver = new ChromeDriver(caps);*/
				
				
				
				
				
				//**************************************			
				
				
				
				
				
				APP_LOGS.info("Chrome Browser opened");
				
				
			}
			
			
			
			
			else if(browserType.equalsIgnoreCase("FF"))
			{
				//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ssrivastava4\\workspace\\PulseProject\\driver\\geckodriver.exe");
				
                   downloadPath=b.preInitialize();
				
				
		
				 
				 
			/*	FirefoxProfile profile = new FirefoxProfile();
			
				profile.setPreference("browser.download.folderList", 2);
				profile.setPreference("browser.download.manager.showWhenStarting", false);
				profile.setPreference("browser.download.dir", downloadPath);
				profile.setPreference("browser.helperApps.neverAsk.openFile",
						"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
		"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
				profile.setPreference("browser.helperApps.alwaysAsk.force", false);
				profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
				profile.setPreference("browser.download.manager.focusWhenStarting", false);
				profile.setPreference("browser.download.manager.useWindow", false);
				profile.setPreference("browser.download.manager.showAlertOnComplete", false);
				profile.setPreference("browser.download.manager.closeWhenDone", false);
			
				
				DesiredCapabilities capabilities = new DesiredCapabilities();
			    capabilities.setBrowserName("firefox");
			    capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
			    capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			    driver = new FirefoxDriver(capabilities);
			    
			    
			    */
			    
			    
			    
			    
			    //********************************
			    
			    
                   System.setProperty("webdriver.gecko.driver","C:\\Users\\ssrivastava4\\workspace\\PulseProject4\\geckodriver.exe");
                   
           		WebDriver driver = new FirefoxDriver();
				
				APP_LOGS.info("FireFox Browser opened");
			}
			
			
			
			
			
			else if(browserType.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", "C:\\Users\\ssrivastava4\\workspace\\PulseProject\\driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
				APP_LOGS.info("IE Browser opened");
			}
			else
			{
				System.out.println("Browser input is invalid. Please go and select the browser properly");
				
				APP_LOGS.info("Browser input is invalid. Please go and select the browser properly");
			}
			
						
		
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

			APP_LOGS.info("Implicit wait given");
		      
			 

         	String url = eLib.getCellValue(path,"PreCon", 1, 0);
			 
			driver.manage().window().maximize();
			driver.get(url);
			
			APP_LOGS.info("Url opened");
			
			
			
	
   b.preInitialize();
        
		
		b.insertsql(method.getName());
	
		

		b.executesqlandverifytext();
		b.getlastRunid();
		
		
		
	
	    System.out.println("Executing Test Case id  : "+b.getlastRunid());
	       
	       APP_LOGS.info("Executing Test Case id is : "+	b.getlastRunid());
	       
	       
	   

			    
	}
	
		
		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
			
			
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}

	
	
	
	@AfterMethod

	
	
		
		public void tearDown(ITestResult result) throws IOException{
			
			
		
		
		
			if(result.getStatus()==ITestResult.FAILURE){
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS ->"+result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS ->"+result.getThrowable()); //to add error/exception in extent report
				
				String screenshotPath = BaseTest.getScreenshot(driver, result.getName());
				
				
				
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
				//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			
			
			else if(result.getStatus()==ITestResult.SUCCESS){
				
				extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS ->"+result.getName()); //to add name in extent report
				//extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS ->"+result.getThrowable()); //to add error/exception in extent report
				
			//	String screenshotPath1 = BaseTest.getScreenshot(driver, result.getName());
				
				
			//	extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath1));
		

			}
			
			/*HomePage hp = new HomePage(driver);
			//hp.clickOnProfile(driver);
			hp.clickArrow();
			
			hp.Logout();*/
	
		
			
			
			extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
			
			
	}

	
	@AfterTest
	public void postCondition() throws InterruptedException
	
	
	{
		
	//	driver.get("C:\\Users\\ssrivastava4\\workspace\\PulseProject3\\test-output\\"+"AutomationLog_TestRunId-"+b.getlastRunid()+"ExtentReport.html");
		
		
		Thread.sleep(25000);
		
		driver.quit();
			extent.flush();
			extent.close();
		}
			

				
		
		
		
	

		
		
			
}	
