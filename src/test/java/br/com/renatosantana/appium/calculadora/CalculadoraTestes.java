package br.com.renatosantana.appium.calculadora;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTestes {
	private AndroidDriver<MobileElement> driver;
	
	@Before
	  public void iniciarTestes() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("deviceName", "NexusSix");
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
	  }
	
	@Test
	  public void validarSoma() {
	    MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("mais");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("igual");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	    Assert.assertEquals("4", el5.getText());
	  }
	
	@After
	  public void finalizartestes() {
	    driver.quit();
	  }
}
