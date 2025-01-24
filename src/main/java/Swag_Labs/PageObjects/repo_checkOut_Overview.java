package Swag_Labs.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class repo_checkOut_Overview {

	public repo_checkOut_Overview(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@data-test='item-quantity']")
	public WebElement GetQuantity;
	
	@FindBy(xpath="//*[@data-test='inventory-item-name']")
	public WebElement GetProductName;
	
	@FindBy(xpath="//*[@data-test='inventory-item-desc']")
	public WebElement GetProductDescription;
	
	@FindBy(xpath="//*[@data-test='item-quantity']")
	public WebElement GetProductPrice;
	
	@FindBy(xpath="//*[@data-test='payment-info-value']")
	public WebElement GetValue_PaymentInformation;
	
	@FindBy(xpath="//*[@data-test='shipping-info-value']")
	public WebElement GetValue_ShippingInformation;
	
	@FindBy(xpath="//*[@data-test='subtotal-label']")
	public WebElement GetValue_PriceTotal;
	
	@FindBy(id="finish")
	public WebElement clickOnFinishButton;
	
	
	@FindBy(id="back-to-products")
	public WebElement goBackHomeButton;
	
	
	@FindBy(id="cancel")
	public WebElement clickOnCancelButton;
	
	@FindBy(className="//*[@data-test='complete-text']")
	public WebElement OnFinishSuccessMessage;
	
}
