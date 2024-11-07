package testCases;

//Logging - record all the events in the form of text.
//Log levels -All < Trace < Debug < Info < Warn < Error < Fatal < Off

//Appeneders - Where to generate logs(console/File)
//Loggers - What type of logs generate (All < Trace < Debug < Info < Warn < Error < Fatal < Off)

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest  extends BaseClass{
	
	@Test(groups={"regression","Master"})
	public void verify_account_registration()
	{
		logger.info("*******Starting TC001_AccountRegistrationTest ******* ");
		logger.debug("This is a debud log message");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link ");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link ");
		
		
		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		rp.setFirstName(randomeString().toUpperCase());
		rp.setLastName(randomeString().toUpperCase());
		rp.setEmail(randomeString()+"@gmail.com");
		rp.settelephone(randomeNumber());
		
		String password = randomAlphaNumeric();
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		
		rp.setPrivacyPolicy();
		rp.clickContinue();
		
		logger.info("Validating excepted message");
		String confmsg = rp.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}else {
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
//		Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}
		
		catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("**** Finished TC001_AccountRegistrationTest **** ");
		
	}
	
	
	
	
	
	
}
