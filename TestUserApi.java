package com.qait.automation.MyProject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestUserApi{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindAll({ @FindBy(css = "li[data-http='get']") })
	List<WebElement> GET;
	@FindAll({@FindBy(css = "li[data-http='post']")})
	List<WebElement> POST;
	@FindBy(css = "li[data-id='put']")
	WebElement PUT;
	@FindBy(className ="response-code")
	WebElement ResponseCode;
	@FindBy(css = "#console > div.endpoints > ul > li:nth-child(9)")
	WebElement PATCH;
	@FindBy(css = "#console > div.endpoints > ul > li:nth-child(10)")
	WebElement DELETE;
	@FindBy(css = "#technical-bits > ul > li:nth-child(1) > p:nth-child(2) > strong > a")
	WebElement DigitalOceanReference;
	@FindBy(css = "body > div.SiteFrame > main > header > div > div > div.bui-Col-6\\40 medium > h1")
	WebElement HeadingOfDigitalOcean;
	@FindBy(css = "#technical-bits > ul > li:nth-child(3) > p:nth-child(3) > span > a")
	WebElement GitHubLink;
	@FindBy(css = "body > div.header-content > header > section > h1 > a")
	WebElement MainPage_Reqires;
	@FindBy(css = "body > div.header-content > main > div > h2:nth-child(1)")
	WebElement Heading2;
	@FindBy(className = "url")
	WebElement RequestUrl;

	
	
	public void code() throws InterruptedException
	{
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(ResponseCode)).isEnabled();
			((JavascriptExecutor) driver).executeScript("scroll(0,900);");
			String statusCode = ResponseCode.getText();
			System.out.println("Response code\t" +statusCode);
	}


	
	@BeforeClass
	 public void RequiredCondition() {
		driver = new ChromeDriver();
		driver.get("https://reqres.in/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
		
	}
	@Test(priority = 0)
	public void TestMainPage()
	{
		MainPage_Reqires.click();
		wait.until(ExpectedConditions.visibilityOf(Heading2)).isDisplayed();
		String expected_url = "https://reqres.in/";
		Assert.assertEquals(expected_url,driver.getCurrentUrl(),"your page is not loading to main page again");
		
	}
	
	
	
	@Test(priority = 1)
	public void VerifyGetListPATCHtUser() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,900);");
		GET.get(0).click();
		code();
		String expectedReq = "/api/users?page=2";
		String CurrentReq = RequestUrl.getText();	
		Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	
	
	
	@Test(priority = 2)
	public void VerifySingleUser() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,900);");
		GET.get(1).click();
		code();
		String expectedReq = "/api/users/2";
		String CurrentReq = RequestUrl.getText();
		Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
		
	}
	
	@Test(priority = 3)
	public void VerifySingleUserNotFound() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,900);");
		GET.get(2).click();
		code();
		String expectedReq = "/api/users/23";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
		
	}
	
	
	@Test(priority = 4)
	public void VerifyListResource() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,950);");
		GET.get(3).click();
		code();
		String expectedReq = "/api/unknown";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	
	@Test(priority = 5)
	public void SingleResource() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,950);");
		GET.get(4).click();
		Thread.sleep(500);
		code();
		String expectedReq = "/api/unknown/2";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
		}
	
	@Test(priority = 6)
	public void SingleResourceNotFound() throws InterruptedException
{
		((JavascriptExecutor) driver).executeScript("scroll(0,950);");
		GET.get(5).click();
		code();
		String expectedReq = "/api/unknown/23";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	@Test(priority = 7)
	public void Create() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,950);");
		POST.get(0).click();
		code();
		String expectedReq = "/api/users";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	@Test(priority = 8)
	public void VerifyUpdatePUT() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,980);");
		PUT.click();
		code();
			String expectedReq = "/api/users/2";
			String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	
	
	@Test(priority = 9)
	public void VerifyUpdatePATCH() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,980);");
		PATCH.click();
		code();
		String expectedReq = "/api/users/2";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	@Test(priority = 10)
	public void VerifyDelete() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,980);");
		DELETE.click();
		code();
		String expectedReq = "/api/users/2";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	
	@Test(priority = 11)
	public void RegisterSuccessfull() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,1050);");
		POST.get(1).click();
		code();
		String expectedReq = "/api/register";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	
	@Test(priority = 12)
	public void Register_UnSuccessfull() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,1050);");
		POST.get(2).click();
		code();
		String expectedReq = "/api/register";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	
	@Test(priority = 13)
	public void LoginSuccessfull() throws InterruptedException
{
		((JavascriptExecutor) driver).executeScript("scroll(0,1050);");
		POST.get(3).click();
		code();
		String expectedReq = "/api/login";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	
	@Test(priority = 14)
	public void Login_UnSuccessfull() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,1050);");
	POST.get(4).click();
		code();
		String expectedReq = "/api/login";
		String CurrentReq = RequestUrl.getText();
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	
	@Test(priority = 15)
	public void DelayedResponse() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,1050);");
		GET.get(6).click();
		wait.until(ExpectedConditions.visibilityOf(ResponseCode)).isEnabled();
		code();
		String expectedReq = "/api/users?delay=3";
		String CurrentReq = RequestUrl.getText();
		
				Assert.assertEquals(expectedReq,CurrentReq,"Request Not Matched");
	}
	
	
		
	@Test(priority =16)
	public void testDigitalOceanReference()
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,1800);");
		DigitalOceanReference.click();
		Assert.assertTrue(HeadingOfDigitalOcean.isDisplayed());
		System.out.println("you are on DigitalOceanReferencePage");
		driver.navigate().back();
	}
	
	@Test(priority = 17)
	public  void TestGitHubLink()
	{
		((JavascriptExecutor) driver).executeScript("scroll(0,1800);");
			GitHubLink.click();
			String ExpectedUrl="https://github.com/benhowdle89/reqres";
			Assert.assertEquals(ExpectedUrl,driver.getCurrentUrl(),"error occur");
			System.out.println("you are on GitHub page linked with this UI");
			driver.navigate().back();
			((JavascriptExecutor) driver).executeScript("scroll(0,0);");

			
	}
}