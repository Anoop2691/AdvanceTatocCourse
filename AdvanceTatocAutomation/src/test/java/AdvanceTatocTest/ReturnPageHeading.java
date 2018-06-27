package AdvanceTatocTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReturnPageHeading {

	@FindBy(className = "page")
	private WebElement getPageHeadingText;
	public String returnPageHeadingText() {
		return getPageHeadingText.getText();
	}
}
