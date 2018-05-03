package com.puma.pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//a[@data-subnav='men-subnav']")
	private WebElement men;
	
	@FindBy(xpath="//a[@href='https://in.puma.com/men/shoes.html?dir=asc&order=position&in-stock=1']")
	private WebElement shoes;
	
	@FindBy(xpath="//a[@href='https://in.puma.com/men/shoes/running.html/?dir=asc&order=position&in-stock=1']")
	private WebElement runningShoes;
	
	//second shoes from list
	@FindBy(xpath="//a[@proid='71792' and @class='product-image promainimg']")
	private WebElement secondShoes;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void menShoe() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(men).build().perform();
		Thread.sleep(5000);
		shoes.click();
		runningShoes.click();
		secondShoes.click();
		
	}
}
