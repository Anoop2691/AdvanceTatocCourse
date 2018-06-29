package AdvanceTatocTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingFileHandlePage {

	WebDriver driver;
	@FindBy( id = "signature")
	private WebElement signature;
	@FindBy( linkText = "Download File")
	private WebElement downloadFile;
	@FindBy( className = "submit")
	private WebElement submit;
	public TestingFileHandlePage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	public void downloadFileAndReadSignature() throws InterruptedException {
		downloadFile.click();
		Thread.sleep(5000);		
		File file = new File("C:\\Users\\anoopkumar\\Downloads\\file_handle_test.dat");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		signature.sendKeys(prop.getProperty("Signature"));
		submit.click();
	}
}
