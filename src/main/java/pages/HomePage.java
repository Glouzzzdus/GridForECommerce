package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage
{

    @FindBy (xpath ="//div[@class='b-product-groups-gallery__header']/span[@class='b-product-groups-gallery__counter']")
    private List<WebElement> groupGalleryCounter;
    @FindBy(xpath = "//a[@class='b-product-groups-gallery__image-link']")
    private List<WebElement> lazyLinkToProductPage;
    @FindBy(id = "search_term")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@class='b-search__button']")
    private WebElement searchButton;

    public int getGroupGalleryCounter(int indexOf) {return Integer.parseInt(groupGalleryCounter.get(indexOf).getText());}
    public void getLinkToProductPage(int IndexOf) {lazyLinkToProductPage.get(IndexOf).click();}
    public void searchByKeyword(final String keyWord)
    {
        searchInput.sendKeys(keyWord);
        searchButton.click();
    }

    public HomePage(WebDriver driver) {super(driver);}
}
