package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.youtube.browsers.Browsers;
import com.youtube.enums.BrowserTypes;
import com.youtube.pages.LatestVideoPage;
import com.youtube.util.PropertiesUtils;

/**
 * Test case class for executing the latest video functionality.
 *
 * @author Bhavin.Thumar
 */
public class LatestVideo {

	private WebDriver driver;

	/**
	 * Sets up the test environment before executing the test case. It initializes
	 * the WebDriver instance with the specified browser type and navigates to the
	 * URL based on the configuration.
	 */
	@BeforeTest
	public void setUp() {
		Browsers browser = new Browsers();
		driver = browser.startBrowser(BrowserTypes.CHROME,
				PropertiesUtils.getURL() + PropertiesUtils.getChannel() + PropertiesUtils.getTab(),
				PropertiesUtils.getHeadlessMode());
	}

	/**
	 * Test method for verifying the latest video functionality. It initializes the
	 * LatestVideoPage object using PageFactory, and then invokes the method to get
	 * the latest video title.
	 */
	@Test
	public void latestVideo() {
		LatestVideoPage obj = PageFactory.initElements(driver, LatestVideoPage.class);
		obj.getLatestVideoTitle();
	}
}
