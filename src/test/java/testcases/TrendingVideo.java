package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.youtube.browsers.Browsers;
import com.youtube.enums.BrowserTypes;
import com.youtube.pages.TrendingVideoPage;
import com.youtube.util.PropertiesUtils;

/**
 * Test case class for executing the trending video functionality.
 */
public class TrendingVideo extends Browsers {

	Browsers browsers;

	/**
	 * Sets up the test environment before executing the test case. It initializes
	 * the WebDriver instance with the specified browser type and navigates to the
	 * URL based on the configuration.
	 */
	@BeforeTest
	public void setUp() {
		browsers = new Browsers();
		driver = browsers.startBrowser(BrowserTypes.CHROME, PropertiesUtils.getURL(),
				PropertiesUtils.getHeadlessMode());
	}

	/**
	 * Test method for verifying the trending video functionality. It initializes
	 * the TrendingVideoPage object using PageFactory, and then invokes the method
	 * to get the trending video.
	 */
	@Test
	public void getTrendingVideo() {
		TrendingVideoPage obj = PageFactory.initElements(driver, TrendingVideoPage.class);
		obj.trendingVideo();
	}
}
