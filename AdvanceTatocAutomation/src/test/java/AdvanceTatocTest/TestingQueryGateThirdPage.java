package AdvanceTatocTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingQueryGateThirdPage extends ReturnPageHeading{
	WebDriver driver;
	Connection connectingToDatabase;
	@FindBy( id = "symboldisplay")
	private WebElement findIdForGettingTextEcho;
	@FindBy( id = "name")
	private WebElement findIdForSettingName;
	@FindBy( id = "passkey")
	private WebElement findIdForSettingPassword;
	@FindBy( id = "submit")
	private WebElement findIdForSubmitting;
	public TestingQueryGateThirdPage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}

	public void databaseConnection() {
		try {
			String databaseUrl = "jdbc:mysql://10.0.1.86/tatoc";
			String username = "tatocuser";
			String password = "tatoc01";
			Class.forName("com.mysql.jdbc.Driver");
			connectingToDatabase =  (Connection) DriverManager.getConnection(databaseUrl, username, password);
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}

	void queryPerforming() {
		databaseConnection();
		try{
			String symbol=findIdForGettingTextEcho.getText();
			PreparedStatement queryToSelectidentity= connectingToDatabase.prepareStatement("select id from identity where symbol=?;");				
			queryToSelectidentity.setString(1,symbol);
			ResultSet rs= queryToSelectidentity.executeQuery();
			int id=0;
			while(rs.next()){
				id = Integer.parseInt(rs.getString("id"));
			}
			queryToSelectidentity= connectingToDatabase.prepareStatement("select name, passkey from credentials where id=?;");
			queryToSelectidentity.setInt(1, id);
	
			rs= queryToSelectidentity.executeQuery();
			String name="";
			String passkey="";
			while(rs.next()) {
				name=rs.getString("name");
				passkey=rs.getString("passkey");
			}
			findIdForSettingName.sendKeys(name);
			findIdForSettingPassword.sendKeys(passkey);
			findIdForSubmitting.click();
			connectingToDatabase.close();
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}
}
