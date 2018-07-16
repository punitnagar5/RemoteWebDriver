package com.qait.automation.MyProject;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTestingOfRequestUrl {

	

public int FindStatusCodeUsingApi(String RequestURL) throws ClientProtocolException, IOException
{
	String RequestUrl = RequestURL;
	HttpClient client = new DefaultHttpClient();
	HttpGet getrequest = new HttpGet(RequestUrl);
	HttpResponse response = client.execute(getrequest);
	int statuscode = response.getStatusLine().getStatusCode();
	return statuscode;
}

@Test (priority = 1)
public void VerifyGetListUser() throws ClientProtocolException, IOException 
{
			int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/users?page=2");
			int ExpectedStatusCode = 200;
			System.out.println("Response code for VerifyGetListUser--------- \t"+actualStatusCode);
			Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}


@Test (priority = 2)
public void VerifySingleUser() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/users/2");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for VerifySingleUser--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 3)
public void VerifySingleUserNotFound() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/users/23");
		int ExpectedStatusCode = 404;
		System.out.println("Response code for VerifySingleUserNotFound--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 4)
public void VerifyListResource() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/unknown");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for VerifyListResource--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 5)
public void SingleResource() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/unknown/2");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for SingleResource--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 6)
public void SingleResourceNotFound() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/unknown/23");
		int ExpectedStatusCode = 404;
		System.out.println("Response code for SingleResourceNotFound--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 7)	//Bug//it shows 201 response code by UI
public void Create() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/users");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for Create--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 8)
public void VerifyUpdatePUT() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/users/2");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for VerifyUpdatePUT--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 9)
public void VerifyUpdatePATCH() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/users/2");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for VerifyUpdatePATCH--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 10)	//Bug//it shows 204 response code by UI
public void VerifyDelete() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/users/2");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for VerifyDelete--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 11)	//Bug//it shows 201 response code by UI
public void RegisterSuccessfull() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/register");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for RegisterSuccessfull--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 12)	//Bug//it shows 400 response code by UI
public void Register_UnSuccessfull() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/register");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for Register_UnSuccessfull--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 13)
public void LoginSuccessfull() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/login");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for LoginSuccessfull--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 14)	//Bug//it shows 400 response code by UI
public void Login_UnSuccessfull() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/login");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for Login_UnSuccessfull--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}

@Test (priority = 15)
public void DelayedResponse() throws ClientProtocolException, IOException
{
		int actualStatusCode = FindStatusCodeUsingApi("https://reqres.in/api/users?delay=3");
		int ExpectedStatusCode = 200;
		System.out.println("Response code for DelayedResponse--------- \t"+actualStatusCode);
		Assert.assertEquals(ExpectedStatusCode, actualStatusCode);
			
}
}

