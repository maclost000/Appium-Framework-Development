package ecommercePageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	
	public LoginPage(AndroidDriver<AndroidElement> driver)
	{
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	
	//driver.findElement(By.xpath("//*[@text='Female']")).click();
	@AndroidFindBy(xpath = "//*[@text='Female']")
	private WebElement Female;
	
	//driver.findElement(By.id("android:id/text1")).click();
	@AndroidFindBy(id="android:id/text1")
	public WebElement dropDown;
	
	//driver.findElement(By.xpath("//*[@text='Benin']")).click();
	@AndroidFindBy(xpath="//*[@text='Benin']")
	private WebElement Country;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopButton;
	
	
	
	public WebElement getFemaleCheckbox()
	{
		return Female;
	}
	
	public WebElement getCountryName()
	{
		return Country;
	}

}

