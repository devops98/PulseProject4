package com.pulse.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.testng.*;

import generic.BasePage;

public class Analyse extends BasePage{
	
	

	@FindBy(xpath=" //*[@href=\"/Pulse/Analyze\"] ")
	private WebElement  Analysebutton ;
	
	
	
	BasePage b=new BasePage(driver);
	
	
	
	
	
	
	public Analyse(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	

	public void clickanalysebutton()
	{
		
		b.mouseHoverToElementAndClick(driver, "//*[@href=\"/Pulse/Analyze\"]");
		
	
	}
	
	
	public void verifyanalysebutton()
	{
	
	
	b.verifyElementPresent(driver, " //*[@href=\"/Pulse/Analyze\"]");

	}
	
	

	public void scrolldown()
	{
		
		b.SpecialKeysaction(driver, "//*[@href=\"/Pulse/Analyze\"]","Control+End");
	
				
	}
	
	
	
		
	
	
	
	

	
	
	

}
