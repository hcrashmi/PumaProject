package com.puma.script;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.puma.generic.BaseTest;
import com.puma.pomClass.HomePage;
import com.puma.pomClass.IGNITEevoKNITPage;

public class AddProductTest extends BaseTest
{
	@Test
	public void addProduct() throws InterruptedException
	{
		Assert.assertEquals(driver.getTitle(),"Buy Sports T-Shirts, Tracks, Running Shoes and Accessories Online - in.puma.com");
		Reporter.log("Titles are same",true);
		
		HomePage hp=new HomePage(driver);
		hp.menShoe();
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow::"+parentWindow);
		
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		
		for(String wh:allWindows)
		{
			driver.switchTo().window(wh);
			
		}
		
		IGNITEevoKNITPage ip=new IGNITEevoKNITPage(driver);
		ip.addToCart();
		
		Thread.sleep(15000);
		
		String productName=driver.findElement(By.xpath("(//a[contains(.,'IGNITE')])[2]")).getText();
		System.out.println(productName);
		
		Assert.assertEquals(productName,"IGNITE EvoKNIT Lo 2 Men's Running Shoes");
		Reporter.log("text IGNITE EvoKNIT Lo 2 Men's Running Shoes is present",true);
		
		String value1 = driver.findElement(By.xpath("//td//select/option[1]")).getText();
		System.out.println(value1);
		Assert.assertEquals(value1, "1");
		Reporter.log("Quantity one is present",true);
		
	}
}
