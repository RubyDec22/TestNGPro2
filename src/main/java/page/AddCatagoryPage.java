

package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCatagoryPage extends BasePage {
	
	WebDriver driver;

	public  static String addNewItem = "Ruby Kwatra new Catagory";
	   
	public AddCatagoryPage(WebDriver driver) {
		this.driver = driver;
//	WebElements	  
	}
	@FindBy(how=How.CSS, using="input[name='categorydata']")WebElement ADD_NEW_CATAGORY;
	@FindBy(how= How.CSS, using="input[value='Add category']")WebElement ADD_NEW_CATAGORY_BUTTON;
	@FindBy(how=How.CSS,using="select[name='name']")WebElement VALIDATE_ADDED_CATAGORY;
	@FindBy(xpath ="//select[@name='due_month']")public static WebElement VALIDATE_MONTH_NAMES;
	@FindBy(xpath ="//*[contains(text(),'The category already exists:')]")WebElement DUPLICATE_CATAGORY_MESSAGE;
	
	
//	interacteble method
	public void userShouldBeAbleToAddNewCatagoryItem(String addCatagory) {
		String insertCatagory = addCatagory + generateRandomNum(999);
		ADD_NEW_CATAGORY.sendKeys(insertCatagory);
	}
	
	public void userClickOnAddCatagoryButton() {
		ADD_NEW_CATAGORY_BUTTON.click();
	}
	
	   public void validateNewCatagoryIsAdded() {
//		  Assert.assertEquals(addNewItem, VALIDATE_ADDED_CATAGORY, "Ruby Kwatra new Catagory");
	   }
	   
	   public void selectFromDropdown(WebElement element) {
		   String before_xpath = "//*[@id='extra']/select[3]/option[";
		   String after_xpath = "]";
		   for(int i = 2; i <= 13; i++) {
			   String month = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			   System.out.println(month);
		   }
	  }   
		   public void validateNewCatagoryIsDuplicated() {
//		   Assert.assertEquals(AddCatagoryPage.addNewItem, DUPLICATE_CATAGORY_MESSAGE, "Duplicate Catagories" );
		   
		  

	}


}
