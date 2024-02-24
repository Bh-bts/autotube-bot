package com.youtube.helpers;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.youtube.browsers.Browsers;

/**
 * Helper class providing methods for interacting with web elements and
 * JavaScript actions.
 *
 * @author Bhavin.Thumar
 */
public class ActionHelpers extends Browsers {

	/**
	 * Waits for the visibility of the specified web element.
	 *
	 * @param locator The web element to wait for.
	 * @return The WebElement after it becomes visible.
	 */
	public static WebElement dynamicTimeOut(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOf(locator));
	}

	/**
	 * Waits for the visibility of the specified web element.
	 *
	 * @param locator The web element to wait for.
	 * @return The WebElement after it becomes visible.
	 */
	public static JavascriptExecutor scrollTillElement(WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", locator);
		return js;
	}
}
