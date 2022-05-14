package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage
{
    @FindBy(xpath = "//div[@data-qaid='product_description']")
    private WebElement productDescription;

    public WebElement getProductDescription()
    {
        return productDescription;
    }

    public ProductPage(WebDriver driver) {super(driver);}
}
