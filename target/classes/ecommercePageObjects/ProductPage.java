package ecommercePageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {
	
	public ProductPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	//driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
		public List<WebElement> firstProduct;
		
		//driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
		public List<WebElement> secondProduct;
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
		public WebElement buttonCart;
		
}
