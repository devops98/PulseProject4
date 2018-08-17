package com.pulse.Test;
	import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pulse.Page.Author;
import com.pulse.Page.Demographics;
import com.pulse.Page.HomePage;
import com.pulse.Page.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;

import org.apache.log4j.Logger;



//@Listeners(generic.RealGuru99TimeReport.class)


	public class Demographicscolorverification extends BaseTest{

	
	static int teststepcount=000000;
	
	
	//public static Logger APP_LOGS = Logger.getLogger("devpinoyLogger");


	  public static String logfiletimestamp;
	    
	  
	
	  
	//public static	ITestResult result = null;
		
		@Test(priority=1)
		public void testcolor(Method method) throws Exception
		
		{
			
			 Randomaplphanumber R=new Randomaplphanumber();
			  
			String r=  R.Random();
			
				String un=Excel.getCellValue(XLPATH,"ValidLogin",2,0);
				String pw=Excel.getCellValue(XLPATH,"ValidLogin",2,1);
				String accnt=Excel.getCellValue(XLPATH,"ValidLogin",2,2);
	
				String cb=Excel.getCellValue(XLPATH,"Author",1,3);
				
				String sn=Excel.getCellValue(XLPATH,"ValidLogin",2,3);
				
				
				
			       
				//Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
			     
				Logger APP_LOGS = Logger.getLogger(ValidLogin.class);
				
		
			    	
			
		
	    		     
	    		     
	    		    
				//String HPT=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
				LoginPage l=new LoginPage(driver);
				
			
				
				
				teststepcount++;
				
				System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				
				APP_LOGS.info("Verifying CeB Logo");
				
				
				
				l.verifyCEBLogo(cb);
		
			getScreenshot(driver, method.getName());
		
			
				teststepcount++;
				
				
				System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				Thread.sleep(5000);
				
				
				APP_LOGS.info("type username");
				
				l.setUserName(un);
				
				
				extentTest.log(LogStatus.PASS, "username is Typed ");
				
				
				extentTest.log(LogStatus.INFO, "Snapshot below: ");
				
		        r= BaseTest.getScreenshot(driver, method.getName());
					
					
					extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(r));
			
				
				
				
				
				
				getScreenshot(driver, method.getName());
				
				Thread.sleep(5000);
				
	
				teststepcount++;
				
				
				System.out.println("Executing  Step No :"+teststepcount);
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				
				
				
				APP_LOGS.info("type password");
				 
				 
				l.setPassword(pw);
				
				Thread.sleep(5000);
				
				extentTest.log(LogStatus.PASS, "password is Typed ");
				
				
				extentTest.log(LogStatus.INFO, "Snapshot below: ");
		        r= BaseTest.getScreenshot(driver, method.getName());
					
					
					extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(r));
			
			
				
				
				
				
				getScreenshot(driver, method.getName());
				
				teststepcount++;
				

				System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("click select");
				
				l.clickLogin();
				
				Thread.sleep(5000);
				
				
				
                   extentTest.log(LogStatus.PASS, "select is CLICKED ");
                   
               	extentTest.log(LogStatus.INFO, "Snapshot below: ");
				
		        r= BaseTest.getScreenshot(driver, method.getName());
					
					
					extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(r));
			
			
				
				
			
				getScreenshot(driver, method.getName());
				
				teststepcount++;
				
				
                  System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("click dropdown ");
				
				
				
				l.dropdowntheaccount(accnt);
				Thread.sleep(5000);
			
				
				 extentTest.log(LogStatus.PASS, "dropdown is CLICKED ");
				 
					extentTest.log(LogStatus.INFO, "Snapshot below: ");
					
			        r= BaseTest.getScreenshot(driver, method.getName());
						
						
						extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(r));
				
				
				
				getScreenshot(driver, method.getName());
				
				teststepcount++;
				
	            System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				APP_LOGS.info("click select");
				
		
				l.clickselect();
				Thread.sleep(15000);
				
				
				 extentTest.log(LogStatus.PASS, "select is CLICKED ");
				 
					extentTest.log(LogStatus.INFO, "Snapshot below: ");

				r = BaseTest.getScreenshot(driver, method.getName());
						
						
						extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(r));
				
				
				
				getScreenshot(driver, method.getName());
				
			
		Demographics d=new Demographics(driver);
		
		
		d.clickanalysebutton();
		
		d.typesearchsurvey(sn);
		
		d.clickonsearchicon();
		
		d.clickonanalysebutton();
		
		
		d.clickonFavorabilitytab();
		
		}
		
	}










