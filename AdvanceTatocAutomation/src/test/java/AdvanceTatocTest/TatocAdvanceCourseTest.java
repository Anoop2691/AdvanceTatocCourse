package AdvanceTatocTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TatocAdvanceCourseTest {
	WebDriver driver;
	FunctionsForTatocAdvanceCourse objectForAccessingFunctions;
 @BeforeClass
 void DriverInitialization() {
	 driver=new ChromeDriver();
	 driver.get("http://10.0.1.86/tatoc");
	 objectForAccessingFunctions =new FunctionsForTatocAdvanceCourse(driver);
 }
 @Test
 void checkAfterClickingAdvanceCourse() {
	 objectForAccessingFunctions.firstPageClickingOnAdvanceCourse();
 }
 @Test(dependsOnMethods="checkAfterClickingAdvanceCourse")
 void checkAfterClickingGonextInMenu2InHoverPage() {
	 objectForAccessingFunctions.secondPageClickingOnGoNextInDropdownMenu2();
 }
 @Test(dependsOnMethods="checkAfterClickingGonextInMenu2InHoverPage")
 void checkAfterRetrievingValidDataFromDatabaseAbdSubmittingInQueryGatePage() {
	 objectForAccessingFunctions.thirdPageRetrievingDatabaseDataInThirdPage();
 }
}
