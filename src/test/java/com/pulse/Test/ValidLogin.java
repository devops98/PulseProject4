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
import com.pulse.Page.HomePage;
import com.pulse.Page.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;

import org.apache.log4j.Logger;



//@Listeners(generic.RealGuru99TimeReport.class)


	public class ValidLogin extends BaseTest{

	
	static int teststepcount=000000;
	
	
	//public static Logger APP_LOGS = Logger.getLogger("devpinoyLogger");


	  public static String logfiletimestamp;
	    
	  
	
	  
	//public static	ITestResult result = null;
		
		@Test(priority=1)
		public void testValidLogin1(Method method) throws Exception
		
		{
			
			 Randomaplphanumber R=new Randomaplphanumber();
			  
			String r=  R.Random();
			
				String un=Excel.getCellValue(XLPATH,"ValidLogin",1,0);
				String pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1);
				String accnt=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
	
				String cb=Excel.getCellValue(XLPATH,"Author",1,3);
			       
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
				
			
				HomePage h=new HomePage(driver);
				
				h.clickArrow();
				

				APP_LOGS.info("click arrrow down");
				
				h.Logout();
				
				APP_LOGS.info("click logout");
		}
	
	/*
		@Test(priority=2)
		public void testValidLogin2(Method method) throws Exception
		
		{
			
				String un=Excel.getCellValue(XLPATH,"ValidLogin",1,0);
				String pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1);
				String accnt=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
	
				String cb=Excel.getCellValue(XLPATH,"Author",1,3);
			       
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
				
               
				
				
				
				
				getScreenshot(driver, method.getName());
				
				Thread.sleep(5000);
				
	
				teststepcount++;
				
				
				System.out.println("Executing  Step No :"+teststepcount);
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				
				
				
				APP_LOGS.info("type password");
				 
				 
				l.setPassword(pw);
				
				Thread.sleep(5000);
				getScreenshot(driver, method.getName());
				
				teststepcount++;
				

				System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("click select");
				
				l.clickLogin();
				
				Thread.sleep(5000);
			
				getScreenshot(driver, method.getName());
				
				teststepcount++;
				
				
                  System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("click dropdown ");
				
				
				
				l.dropdowntheaccount(accnt);
				Thread.sleep(5000);
			
				
				getScreenshot(driver, method.getName());
				
				teststepcount++;
				
	            System.out.println("Executing  Step No :"+teststepcount);
				
				APP_LOGS.info("Executing  Step No :"+teststepcount);
				APP_LOGS.info("click select");
				
		
				l.clickselect();
				Thread.sleep(15000);
				
				getScreenshot(driver, method.getName());
				
				System.out.println("Number of steps in TC are "+teststepcount);
				
				
				APP_LOGS.info("Number of steps in TC are "+teststepcount);
				HomePage h=new HomePage(driver);
				
				h.clickArrow();
				

				APP_LOGS.info("click arrrow down");
				
				h.Logout();
				
				APP_LOGS.info("click logout");
		}
	
	*/
	
	
	
	/*
		
		@Test(priority=3)
		public void testCreateForm() throws InterruptedException
		
		{
		
			
			//	String sn=Excel.getCellValue(XLPATH,"Author",1,0);
			//	String dn=Excel.getCellValue(XLPATH,"Author",1,1);
				
				
				String un=Excel.getCellValue(XLPATH,"ValidLogin",1,0);
				String pw=Excel.getCellValue(XLPATH,"ValidLogin",1,1);
				String accnt=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
			
				 
				String n=Excel.getCellValue(XLPATH,"Author",1,0);
				
				
				Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		         
					
				 // configure log4j properties file
			       PropertyConfigurator.configure("log4j.properties");
			 
			       
			       
				
				//String HPT=Excel.getCellValue(XLPATH,"ValidLogin",1,2);
			       
			       
			       
			       
			       
					LoginPage l=new LoginPage(driver);
					
					
					
					
				
					
					l.setUserName(un);
					
					
					
					
					Thread.sleep(5000);
					
					
					APP_LOGS.info("type username");
					
					
					 
					 
					l.setPassword(pw);
					
					Thread.sleep(5000);
					
					
					APP_LOGS.info("type password");
					
					
					l.clickLogin();
					
					Thread.sleep(5000);
					APP_LOGS.info("click select");
					
					
					l.dropdowntheaccount(accnt);
					Thread.sleep(5000);
					APP_LOGS.info("click dropdown ");
					
					
					
					l.clickselect();
					Thread.sleep(15000);
					
					APP_LOGS.info("clicl select");
					
				Author a=new Author(driver);
				

				
				
				a.ClickonAuthorTab();
				
				Thread.sleep(5000);
				
				
				APP_LOGS.info("click author");
				
				a.Authornewsurvey();
				
				Thread.sleep(5000);
				
				
				APP_LOGS.info("click author new survey");
				
				
				a.Createfromscra();
				
				Thread.sleep(5000);
				
				
				
				APP_LOGS.info("click author create from scratch");
				
				a.typeSurveyName();
				
				
				Thread.sleep(5000);
				
				APP_LOGS.info("type survey name");
				
				a.CreateSurve();
				
				Thread.sleep(54000);
				
				APP_LOGS.info("Click create survey");
				
				
				a.RatingScale();
				Thread.sleep(5000);
				
			//	APP_LOGS.info("Click rating scale");
				
				HomePage h=new HomePage(driver);
				
				h.clickArrow();
				

				APP_LOGS.info("click arrrow down");
				
				h.Logout();
				
				APP_LOGS.info("click logout");
				
				
		}
		*/

	
	}










