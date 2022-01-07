package appiumframework.fameworkdev;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ecommercePageObjects.CartPage;
import ecommercePageObjects.LoginPage;
import ecommercePageObjects.ProductPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SumOfProducts extends MobileCapabilities {
       @Parameters({"data"})
	   @Test
	   public void totalValidation(String nameValue) throws IOException, InterruptedException
	   {
	
		service=startServer();
		
	    
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		
		LoginPage login = new LoginPage(driver);
		login.nameField.sendKeys(nameValue);
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shoes");
		driver.hideKeyboard();
		
		login.getFemaleCheckbox().click();
		//driver.findElement(By.xpath("//*[@text='Female']")).click();
		
		
		//driver.findElement(By.id("android:id/text1")).click();
		login.dropDown.click();
		
		Utilities u = new Utilities(driver);
		u.scrollToText("Benin");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Benin\"));");
		Thread.sleep(2000);
		
		
		//driver.findElement(By.xpath("//*[@text='Benin']")).click();
		login.getCountryName().click();
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		login.shopButton.click();
		
		ProductPage product = new ProductPage(driver);
		product.firstProduct.get(0).click();
		
		
		//driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		product.secondProduct.get(1).click();
		
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		product.buttonCart.click();
		Thread.sleep(2000);
		
		CartPage cart = new CartPage(driver);
		
		
		String amount1 = cart.firstPrice.get(0).getText();
		System.out.println(amount1);
		amount1 = amount1.substring(1);
		Double firstProductPrice = Double.parseDouble(amount1);
		System.out.println(firstProductPrice);
		String amount2 = cart.secondtPrice.get(1).getText();
		System.out.println(amount2);
		amount2 = amount2.substring(1);
		Double secProductPrice = Double.parseDouble(amount2);
		System.out.println(secProductPrice);
		String amount3 = cart.gettotalPrice().getText();
		amount3 = amount3.substring(1);
		Double totalProductPrice = Double.parseDouble(amount3);
		Double totalPrice = firstProductPrice+secProductPrice;
		
		System.out.println(totalProductPrice);
		System.out.println(totalPrice);
		Thread.sleep(3000);
		
		if(totalPrice.equals(totalProductPrice))
		{
			System.out.println("Both prices are same and valid");
		}
		else
		{
			System.out.println("Both Prices are not same and invalid");
			
		}
	   service.stop();
		
	}
       
       @BeforeTest
       public void killServer() throws IOException, InterruptedException
       {
       Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\appiumframework\\fameworkdev\\serverkill.bat");
    	Thread.sleep(3000); 
       }

}
