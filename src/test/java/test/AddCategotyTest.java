package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.AddCatagoryPage;
import util.BrowserFactory;

public class AddCategotyTest {
	
	WebDriver driver;
	
	AddCatagoryPage catagoryPage;

	String addCatagory = "Ruby Kwatra";
	
	
	@BeforeTest
	public void init() {
	driver = BrowserFactory.init();
	}
//	Test 1: Validate a user is able to add a category and once the category is added it should display.
	@Test(priority=1)
	public void userShouldBeAbleToAddNewCatagoryItem() {
		catagoryPage = PageFactory.initElements(driver, AddCatagoryPage.class);
		catagoryPage.userShouldBeAbleToAddNewCatagoryItem(addCatagory);
		catagoryPage.userClickOnAddCatagoryButton();
		catagoryPage.validateNewCatagoryIsAdded();
		
	}
//	Test 2: Validate a user is not able to add a duplicated category. 
//	If it does then the following message will display: 
//		"The category you want to add already exists: <duplicated category name>."
	  @Test(priority=2)
	  public void userShouldBeAbleToValidateTheMonths() {
		  catagoryPage.selectFromDropdown(AddCatagoryPage.VALIDATE_MONTH_NAMES);
	 
	  }
//	  Test 3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.

	  @Test(priority=3)
	  public void duplicateCatagoryInsertion() {
		  catagoryPage.userShouldBeAbleToAddNewCatagoryItem(addCatagory);
		  catagoryPage.userClickOnAddCatagoryButton();
		  catagoryPage.userShouldBeAbleToAddNewCatagoryItem(addCatagory);
		  catagoryPage.userClickOnAddCatagoryButton();
		  Assert.assertEquals(AddCatagoryPage.addNewItem, "Ruby Kwatra new Catagory");
		
	     BrowserFactory.tearDown();
		
		
		
	}

}
