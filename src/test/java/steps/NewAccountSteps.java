package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.LoginPage;
import page.SideNavigation;
import util.BrowserFactory;

public class NewAccountSteps {
	WebDriver driver;
	LoginPage loginPage;
	SideNavigation sideNavigation;
	
	@Before
	public void startFirst() {
		driver = BrowserFactory.startBrowser();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		sideNavigation = PageFactory.initElements(driver, SideNavigation.class);
	}
	
	@Given("^a user with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void a_user_with_username_and_password(String userName, String password) {
		loginPage.login(userName, password);
	}
	
	@When("^user navigates to New Account Page$")
	public void user_navigates_to_New_Account_Page() throws InterruptedException {
	   sideNavigation.goToNewAccountPage();
	}
	
	@Then("^New Account page should display$")
	public void new_Account_page_should_display() {
	    Assert.assertTrue("Page did not display", false);
	}
	
	@After
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}