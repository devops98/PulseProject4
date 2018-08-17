package com.pulse.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;

import generic.BasePage;


public class LoginPage extends BasePage {
	
	
	
	

	@FindBy(xpath="//*[@id='wrapper-inner']//h2[text()='CEB Pulse Surveys']")
	private WebElement CEBPulseSurveys;
	
	
	@FindBy(xpath="//*[@id='j_username']")
	private WebElement  puser ;
	
	@FindBy(xpath="//*[@id='j_password']")
	
	private WebElement  ppassword ;
	
	@FindBy(xpath="//*[@id='proceed']")
	private WebElement plsignin;
	
	@FindBy(xpath="//span[contains(.,' invalid')]")
	private WebElement errMsg1;
	
	@FindBy(xpath="//LABEL[normalize-space(text())='Please enter a valid email address']")
	private WebElement errMsg;
	
	
	
	@FindBy(xpath="	 //SELECT[@name='j_company'] ")
private WebElement  Selects3_CEBfirstDemoLibraryTestingJaghadhiniSecondDemoPulselibraryPulselibrarychildPulseNotLib_SELECT ;
	
	
	
	@FindBy(xpath=" //BUTTON[@class='btn btn-primary']  ")
	private WebElement   Select_Account  ;
	
	
	BasePage b=new BasePage(driver);
	
	
	
	
	
	
	public void verifyCEBLogo(String cb)
	{
		b.verifyTextContains(driver, "//*[@id='wrapper-inner']//h2[text()='CEB Pulse Surveys']", cb);
	}
	
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	

	
	
	public void setUserName(String un)
	
	
	{
	
		
	
		//puser.sendKeys(un);
          
		
		b.type(driver, "//*[@id='j_username']", un);
	
		
		
	}
	
public void setPassword(String pw)
	
	
	{
	
		
	
//	ppassword.sendKeys(pw);

	b.type(driver,"//*[@id='j_password']", pw);
	
		
		
	}
	
	
	
	
	
	public void clickLogin(){

		
		//plsignin.click();
	
		b.Click(driver, "//*[@id='proceed']");
	//	plsignin.click();
	}
	
	
	
	public void dropdowntheaccount(String accnt){
		
	   

		Select oSelect = new Select(driver.findElement(By.xpath("//SELECT[@name='j_company']")));

			 
		oSelect.selectByVisibleText(accnt);
		 
           }
		
	
		
	
	
	public void clickselect(){
		//	sleep(1);
		
		
		Select_Account.click();
	
		}	
	
	
	
	
	
	
	public void verifyErrMsgIsDisplayed(){
		//sleep(2);
		
		Assert.assertTrue(errMsg.isDisplayed());
		
	}

}
