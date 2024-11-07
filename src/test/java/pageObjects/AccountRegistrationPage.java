package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
	  super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement txtLasttName;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement txtconfirmpassword;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement chkdpolicy;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
	WebElement msgConfirmation;

	
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLasttName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void settelephone(String tphone) {
		txttelephone.sendKeys(tphone);
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		txtconfirmpassword.sendKeys(pwd);
	}
	
	
	public void setPrivacyPolicy() {
		chkdpolicy.click();
	}
	
	public void clickContinue() {
//		sol1
		btncontinue.click();
		
//		sol2
//		Actions act = new Actions(driver);
//		act.moveToElement(btncontinue).click().perform();
		
//		sol3
//		btncontinue.submit();
		
//		sol4
//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", btncontinue);
		
		//sol5
//		btncontinue.sendKeys(Keys.RETURN);
		
		//sol6
//		WebDriverWait mywait =new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
	}
	
	
	public String getConfirmationMsg()
	{
		try {
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
		
	}
	
	
	
}
