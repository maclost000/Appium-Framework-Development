package apiDemosPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InlinePage {

	
	public InlinePage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@content-desc='9']")
	public WebElement timeOne;
	
	@AndroidFindBy(xpath="//*[@content-desc='15']")
	public WebElement timeSec;
	
	@AndroidFindBy(xpath="//*[@content-desc='45']")
	public WebElement timeThird;
}
