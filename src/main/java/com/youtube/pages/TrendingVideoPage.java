package com.youtube.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.youtube.helpers.ActionHelpers;

/**
 * Represents the page object model for the trending video page. Extends the
 * LatestVideoPage class.
 *
 * @author Bhavin.Thumar
 */
public class TrendingVideoPage extends LatestVideoPage {

	@FindBy(xpath = "//yt-formatted-string[text()='Trending']/ancestor::tp-yt-paper-item")
	WebElement trending_btn;

	@FindBy(xpath = "//ytd-item-section-renderer[1]//ytd-video-renderer[1]//a[@id='video-title']")
	WebElement video_link;

	/**
	 * Opens the trending video and retrieves its details.
	 */
	public void trendingVideo() {
		ActionHelpers.dynamicTimeOut(trending_btn).click();
		ActionHelpers.dynamicTimeOut(video_link).click();
		ActionHelpers.dynamicTimeOut(resumeVideo).click();

		String title = getTitle.getText();
		System.out.println("Latest Trending Video is " + ANSI_BLUE + title + ANSI_RESET + '\n');

		getTime();
	}

	/**
	 * Retrieves the time and views of the trending video.
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
