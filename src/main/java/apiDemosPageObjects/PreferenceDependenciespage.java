package apiDemosPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceDependenciespage {
	
	

	public PreferenceDependenciespage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement preDepends;
	
	@AndroidFindBy(xpath="//*[@text='WiFi settings']")
	public WebElement wifiSettings;
	
	@AndroidFindBy(id="android:id/edit")
	public WebElement editPassword;
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement oK;
	
	

}
