package Swag_Labs.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class repo_ProductsPage {

	public repo_ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="inventory_item_name ")
	public WebElement productName;
	
	@FindBy(xpath="//div[@data-test='inventory-item-name']")
	public List<WebElement> productListName;
	
	@FindBy(xpath="//div[@data-test='inventory-item-price']")
	public List<WebElement> productListPrice;
	
	@FindBy(xpath="//div[@data-test='add-to-cart-sauce-labs-backpack']")
	public WebElement AddToCartButton;
	
	@FindBy(xpath="//div[@data-test='remove-sauce-labs-backpack']")
	public WebElement RemoveFromCartButton;
	
	@FindBy(xpath="//div[@data-test='shopping-cart-link']")
	public WebElement GoToCartButton;
	
	
}
