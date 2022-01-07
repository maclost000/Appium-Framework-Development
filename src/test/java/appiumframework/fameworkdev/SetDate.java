package appiumframework.fameworkdev;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import apiDemosPageObjects.DateWidgetPage;
import apiDemosPageObjects.HomePage;
import apiDemosPageObjects.InlinePage;
import apiDemosPageObjects.PreferenceDependenciespage;
import apiDemosPageObjects.PreferencePage;
import apiDemosPageObjects.ViewsPage;
import io.appium.java_client.TouchAction;
import  static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import  static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SetDate extends MobileCapabilities {

	@Test(dataProvider="getData")
	public void timeSetting(String data) throws  InterruptedException, IOException
	{
		
		service=startServer();
		
          AndroidDriver<AndroidElement> driver = capabilities("APIDemosApp");
          
          HomePage home = new HomePage(driver);
          home.ViewsMenu.click();
          
         // driver.findElement(By.xpath("//*[@text='Views']")).click();
          ViewsPage view = new ViewsPage(driver);
          view.dateWidgets.click();
         // driver.findElement(By.xpath("//*[@text='Date Widgets']")).click();
          
          DateWidgetPage widget = new DateWidgetPage(driver);
          widget.Inline.click();
          //driver.findElement(By.xpath("//*[@text='2. Inline']")).click();
          
          InlinePage inline = new InlinePage(driver);
          inline.timeOne.click();
          
          //driver.findElement(By.xpath("//*[@content-desc='9']")).click();
         
          TouchAction touchAction = new TouchAction(driver);
          
         WebElement firstTime =   inline.timeSec;
         WebElement secondTime =   inline.timeThird;
          touchAction.longPress(longPressOptions().withElement(element(firstTime))).moveTo(element(secondTime)).release().perform();
          Thread.sleep(3000);
          driver.pressKey(new KeyEvent(AndroidKey.BACK));
          driver.pressKey(new KeyEvent(AndroidKey.BACK));
          driver.pressKey(new KeyEvent(AndroidKey.BACK));
          
          home.preferencesMenu.click();
          
          PreferencePage page = new PreferencePage(driver);
          page.preDep.click();
          //driver.findElement(By.xpath("//*[@text='3. Preference dependencies']")).click();
          PreferenceDependenciespage depends = new PreferenceDependenciespage(driver);
          depends.preDepends.click();
          //driver.findElement(By.id("android:id/checkbox")).click();
          
          depends.wifiSettings.click();
          //driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();
          
          depends.editPassword.sendKeys(data);
          //driver.findElement(By.id("android:id/edit")).sendKeys("Password");
          
          depends.oK.click();
          //driver.findElement(By.id("android:id/button1")).click();
          service.stop();
	}
	
	@DataProvider
	public Object[] getData()
	{
		Object[] data = new Object[2];
		data[0] = "Password1";
		data[1] = "Password2";
		return data;
	}

}
