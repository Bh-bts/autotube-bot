package com.youtube.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.youtube.browsers.Browsers;
import com.youtube.helpers.ActionHelpers;
import com.youtube.util.PropertiesUtils;

/**
 * Represents the page object model for the latest video page.
 *
 * @author Bhavin.Thumar
 */
public class LatestVideoPage extends Browsers {

	@FindBy(xpath = "//ytd-two-column-browse-results-renderer[@page-subtype='channels']//ytd-rich-grid-row[@class='style-scope ytd-rich-grid-renderer'][1]//ytd-rich-item-renderer[1]//a[@id='video-title-link']")
	WebElement firstVideo;
	@FindBy(xpath = "//button[@data-title-no-tooltip='Pause']")
	WebElement resumeVideo;
	@FindBy(xpath = "//div[@id='title']/h1/yt-formatted-string")
	WebElement getTitle;
	@FindBy(xpath = "//yt-formatted-string[@id='info']/span[3]")
	WebElement getTime;
	@FindBy(xpath = "//div[@id='description-inner']//tp-yt-paper-button[@id='expand']")
	WebElement showMore_btn;
	@FindBy(xpath = "//yt-formatted-string[@id='info']/span[1]")
	WebElement views;

	/**
	 * Retrieves the title, time, and views of the latest video.
	 */
	public void getLatestVideoTitle() {
		ActionHelpers.dynamicTimeOut(firstVideo).click();
		ActionHelpers.dynamicTimeOut(resumeVideo).click();

		String title = getTitle.getText();
		System.out.println("Latest video of the " + PropertiesUtils.getChannel() + " channel is : " + ANSI_BLUE + title
				+ ANSI_RESET + '\n');

		getTime();
	}

	/**
	 * Retrieves the time and views of the latest video.
	 */
	private void getTime() {
		ActionHelpers.scrollTillElement(getTime);
		String time = getTime.getText();
		ActionHelpers.dynamicTimeOut(showMore_btn).click();

		String time1 = getTime.getText();
		System.out.println(ANSI_YELLOW + time + ANSI_RESET + " Uploaded video" + " or uploaded on " + ANSI_YELLOW
				+ time1 + ANSI_RESET + '\n');

		String getViews = views.getText();
		System.out.println("Views are : " + ANSI_GREEN + getViews + ANSI_RESET + '\n');
	}
}
