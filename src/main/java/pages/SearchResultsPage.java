package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage
{
    @FindBy(xpath = "//a[@class='b-product-gallery__title']")
    private List<WebElement> searchResultsProductsList;
    @FindBy(xpath = "//input[@data-qaid='quantity_input']")
    private WebElement productQuantity;
    @FindBy(xpath = "//a[contains(@class,'js-product-buy-button')]")
    private WebElement productBuyButton;
    @FindBy(xpath = "//span[@class='x-quantity__button x-quantity__button_type_plus']")
    private WebElement quantityButtonPlus;
    @FindBy(xpath = "//span[contains(@class,'button_type_continue')]")
    private WebElement continueButton;
    @FindBy(xpath = "//div[@class='b-cart-button__wrapper']")
    private WebElement cartButton;
    public List<WebElement> getSearchResultsList()
    {
        return searchResultsProductsList;
    }
    public WebElement getProductQuantityInput()
    {
        return productQuantity;
    }
    public String getProductQuantity()
    {
       return productQuantity.getAttribute("value");
    }
    public int getSearchResultsCount()
    {
        return getSearchResultsList().size();
    }
    public int getSearchResultsWithCorrectName(String searchKeyword)
    {
        int wordContainsCounter = 0;
        for (WebElement a:searchResultsProductsList)
        {
            if (a.getText().contains(searchKeyword))
                wordContainsCounter += 1;
        }
        return wordContainsCounter;
    }
    public void addToCart()
    {
        productBuyButton.click();
    }
    public WebElement getQuantityButton()
    {
         return quantityButtonPlus;
    }
    public void continueShopping()
    {
        continueButton.click();
    }
    public WebElement getCartButton()
    {
       return cartButton;
    }
    public void getCart()
    {
        cartButton.click();
    }
    public SearchResultsPage(WebDriver driver) {super(driver);}
}
