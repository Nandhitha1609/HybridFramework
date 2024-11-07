package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid-login success-test pass-logout
 * Data is valid -- login fail -- test fail
 * 
 * data is invalid --login success --test fail -- logout
 * data is invalid -- login failed -- test pass
 */
public class TC003_LoginDDT extends BaseClass {


	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")//getting data provider from different class
	public void verify_loginDDT(String email,String pwd, String exp) {
		
		logger.info("**** Starting verify_loginDDT ****");
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
				
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
				
		//MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				
				macc.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
				
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished verify_loginDDT ****");
		
	}
	

}