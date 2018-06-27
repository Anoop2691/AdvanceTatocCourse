package AdvanceTatocTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingHoverMenuSecondPage extends ReturnPageHeading{
	WebDriver driver;
	@FindBy(className = "menutitle")
	private WebElement findElementMenuTitleMenu2;
	@FindBy(xpath="//span[@class='menuitem' and text()='Go Next']")
	private WebElement findElementGoNext;
	public TestingHoverMenuSecondPage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	public void goingToDropdownMenu2AndClickingGoNext() {
		Actions action = new Actions(driver);
		action.moveToElement(findElementMenuTitleMenu2);
		action.moveToElement(findElementGoNext);
		action.click().build().perform();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
}
