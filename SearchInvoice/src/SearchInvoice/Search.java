
/*********** This packages is used to search for an invoice for a customer entered by user using the search functionality,
  selecting the first invoice and approving the invoice. It also checks for the approval confirmation message.**************/

package SearchInvoice;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Login.Login;
import POM.POM;

public class Search {

	public static void main(String[] args) {
		try
		{
			WebDriver driver =  new FirefoxDriver();
			
			// waits for the firefox to load
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			// Gets to the page mentioned below
			driver.get("https://www.xero.com/signup/");
			
			//Calls the Login function which logins to the site.
			Login.LoginScreen(driver);
			
			//Waits for the page to load
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//Navigates to Account
			POM.Account(driver).click();
			
			//Navigates to Sales
			POM.Sales(driver).click();
			
			//Navigates to Repeating tab
			POM.RepeatingTab(driver).click();
			
			//Clicks on the Search button to search for invoice
			POM.SearchInvoice(driver).click();
			
			//Enters the text SAM to search for SAM's invoices
			POM.EnterText(driver).sendKeys("SAM");
			
			//Clicks on Search button to begin the search
			POM.SearchButton(driver).click();
			
			//Selects the First invoice.
			POM.SelectFirstRow(driver).click();
			
			//Approves the selected invoice
			POM.ApproveInvoice(driver).click();
			
			//Selects ok on the confirmation message.
			POM.Confirmation(driver).click();
			
			//Checks for the confirmation of the approval by checking the text appearing post approval on the screen.
			POM.VerifyMessageApproval(driver);
			
			//Prints and output to the user saying the approval is successful.
			System.out.println("The selected repeating invoice has been successfully approved!");
		
		}
		catch(Throwable e)
		{
			//Gives an error to user if the code falls out in any of the above task.
			System.out.println("Exception occured in the flow. try again!");
		}
	}

}
