package Swag_Labs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class repo_checkout_cart {

	public repo_checkout_cart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-test='item-quantity']")
	public WebElement GetTotalQuantity;
	
	@FindBy(xpath="//div[@data-test='inventory-item-name']")
	public WebElement GetAllProductNames;
	
	@FindBy(xpath="//div[@data-test='inventory-item-desc']")
	public WebElement GetAllProductDesc;
	
	@FindBy(xpath="//div[@data-test='inventory-item-price']")
	public WebElement GetAllProductPrice;
	
	@FindBy(id="checkout")
	public WebElement ClickOnCheckOutButton;
	
	@FindBy(id="continue-shopping")
	public WebElement ClickOnContinueShopping;
	
}
