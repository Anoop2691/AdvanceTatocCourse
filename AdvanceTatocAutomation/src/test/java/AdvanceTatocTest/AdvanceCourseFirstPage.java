package AdvanceTatocTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvanceCourseFirstPage {
	WebDriver driver;
	@FindBy(linkText = "Advanced Course")
	private WebElement findElementAdvanceCourseLink;
	@FindBy(className = "page")
	private WebElement getPageHeadingText;
	public AdvanceCourseFirstPage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	public void clickOnWebElement() {
		findElementAdvanceCourseLink.click();
	}
	
	public String returnPageHeadingText() {
		return getPageHeadingText.getText();
	}
}
