package com.youtube.browsers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.youtube.enums.BrowserTypes;

/**
 * This class manages the creation and configuration of WebDriver instances for
 * different browsers.
 * 
 * @author Bhavin.Thumar
 */
public class Browsers  {
	
	public static WebDriver driver;

	/**
	 * Starts a browser session based on the provided browser type, URL, and
	 * headless mode.
	 * 
	 * @param browserType The type of browser to start.
	 * @param webUrl      The URL to navigate to.
	 * @param headless    Whether to start the browser in headless mode.
	 * @return The WebDriver instance for the started browser.
	 */
	public WebDriver startBrowser(BrowserTypes browserType, String webUrl, boolean headless) {
		System.out.println("Open browser is: " + browserType + " with headless mode is : " + headless);
		switch (browserType) {
		case CHROME:
			driver = createChromeDriver(headless);
			break;
		case FIREFOX:
			driver = createFirefoxDriver(headless);
			break;
		case EDGE:
			driver = createEdgeDriver(headless);
			break;
		default:
			System.out.println("Browser is not found");
			break;
		}

		if (driver != null) {
			driver.manage().window().maximize();
			driver.get(webUrl);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}

		return driver;
	}

	/**
	 * Creates a new instance of ChromeDriver based on the provided headless mode.
	 * 
	 * @param headless Whether to start the ChromeDriver in headless mode.
	 * @return A new instance of ChromeDriver.
	 */
	private WebDriver createChromeDriver(boolean headless) {
		ChromeOptions chromeOption = new ChromeOptions();
		if (headless) { 
			chromeOption.addArguments("--remote-allow-origins=*");
			chromeOption.addArguments("--window-size=1920,1080");
			chromeOption.addArguments("--start-maximized");
			chromeOption.addArguments("--headless");
			chromeOption.addArguments("--disable-gpu");
			chromeOption.addArguments("--no-sandbox");
			chromeOption.addArguments("--allow-running-insecure-content");
		}
		return new ChromeDriver(chromeOption);
	}

	/**
	 * Creates a new instance of FirefoxDriver based on the provided headless mode.
	 * 
	 * @param headless Whether to start the FirefoxDriver in headless mode.
	 * @return A new instance of FirefoxDriver.
	 */
	private WebDriver createFirefoxDriver(boolean headless) {
		FirefoxOptions firefoxOption = new FirefoxOptions();
		if (headless) {
			firefoxOption.addArguments("--headless");
		}
		return new FirefoxDriver(firefoxOption);
	}

	/**
	 * Creates a new instance of EdgeDriver based on the provided headless mode.
	 * 
	 * @param headless Whether to start the EdgeDriver in headless mode.
	 * @return A new instance of EdgeDriver.
	 */
	private WebDriver createEdgeDriver(boolean headless) {
		EdgeOptions edgeOption = new EdgeOptions();
		if (headless) {
			edgeOption.addArguments("--headless");
		}
		return new EdgeDriver(edgeOption);
	}

	/**
	 * Quits the current browser session.
	 */
	public void quitBrowser() {
		driver.quit();
	}

}
