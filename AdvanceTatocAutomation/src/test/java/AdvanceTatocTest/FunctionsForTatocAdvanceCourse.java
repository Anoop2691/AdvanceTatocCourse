package AdvanceTatocTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class FunctionsForTatocAdvanceCourse {
	WebDriver driver;
	AdvanceCourseFirstPage objectForAdvanceCourseFirstPage;
	TestingHoverMenuSecondPage objectForTestingHoverMenuSecondPage;
	TestingQueryGateThirdPage objectForTestingCorrectCredentialsThirdPage;
	public FunctionsForTatocAdvanceCourse(WebDriver driver){
		this.driver=driver;
		objectForAdvanceCourseFirstPage =new AdvanceCourseFirstPage(driver);
		objectForTestingHoverMenuSecondPage= new TestingHoverMenuSecondPage(driver);
		 objectForTestingCorrectCredentialsThirdPage= new TestingQueryGateThirdPage(driver);
	}
	public void firstPageClickingOnAdvanceCourse() {
		objectForAdvanceCourseFirstPage.clickOnWebElement();
		Assert.assertTrue(objectForAdvanceCourseFirstPage.returnPageHeadingText().contains("Hover Menu"));
	}
	public void secondPageClickingOnGoNextInDropdownMenu2() {
		objectForTestingHoverMenuSecondPage.goingToDropdownMenu2AndClickingGoNext();
		Assert.assertTrue(objectForTestingHoverMenuSecondPage.returnPageHeadingText().contains("Query Gate"));
	}
	public void thirdPageRetrievingDatabaseDataInThirdPage() {
		objectForTestingCorrectCredentialsThirdPage.queryPerforming();
		Assert.assertTrue(objectForTestingCorrectCredentialsThirdPage.returnPageHeadingText().contains("Ooyala Video Player"));	
		
	}
}