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
	public FunctionsForTatocAdvanceCourse(WebDriver driver){
		this.driver=driver;
		objectForAdvanceCourseFirstPage =new AdvanceCourseFirstPage(driver);
		objectForTestingHoverMenuSecondPage= new TestingHoverMenuSecondPage(driver);
	}
	public void firstPageClickingOnAdvanceCourse() {
		objectForAdvanceCourseFirstPage.clickOnWebElement();
		Assert.assertTrue(objectForAdvanceCourseFirstPage.returnPageHeadingText().contains("Hover Menu"));
	}
	public void secondPageClickingOnGoNextInDropdownMenu2() {
		
	}
	/*public void HoverMenuTest(){
		WebElement element=driver.findElement(By.className("menutitle"));
		Actions action = new Actions(driver);
		action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Go Next')]]"))).click().build().perform();
	}*/
	
	

}