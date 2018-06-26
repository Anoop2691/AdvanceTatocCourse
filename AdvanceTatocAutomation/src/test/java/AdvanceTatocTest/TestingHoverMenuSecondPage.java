package AdvanceTatocTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingHoverMenuSecondPage {
	WebDriver driver;
	@FindBy(className = "menu title")
	private WebElement findElementAdvanceCourseLink;
	public TestingHoverMenuSecondPage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	public void goingToDropdownMenu2AndClickingGoNext() {
		Actions action = new Actions(driver);
		action.moveToElement(findElementAdvanceCourseLink);
	}
}
