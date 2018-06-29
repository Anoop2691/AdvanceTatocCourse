package AdvanceTatocTest;

import java.io.IOException;

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
	TestingRestPageByAddingSession objectForTestingRestPageByAddingSession;
	TestingFileHandlePage objectForTestingFileHandlePage;
	public FunctionsForTatocAdvanceCourse(WebDriver driver){
		this.driver=driver;
		objectForAdvanceCourseFirstPage =new AdvanceCourseFirstPage(driver);
		objectForTestingHoverMenuSecondPage= new TestingHoverMenuSecondPage(driver);
		 objectForTestingCorrectCredentialsThirdPage= new TestingQueryGateThirdPage(driver);
		 objectForTestingRestPageByAddingSession=new TestingRestPageByAddingSession(driver);
		 objectForTestingFileHandlePage= new TestingFileHandlePage(driver);
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
		driver.get("http://10.0.1.86/tatoc/advanced/rest");
		
	}
	public void fifthPageAddingCookieUsingSessionIdAndRegisterRestService() throws IOException {
		objectForTestingRestPageByAddingSession.generatingTokenAndRegisterRestService();
		System.out.println(driver.getTitle());
		Assert.assertEquals("Restful - Advanced Course - T.A.T.O.C",driver.getTitle());	
	}
	public void sixthPageDownloadFileAddSignature() throws IOException, InterruptedException {
		objectForTestingFileHandlePage.downloadFileAndReadSignature();
		Assert.assertTrue(driver.findElement(By.className("finish")).getText().contains("End"));	
	}
}