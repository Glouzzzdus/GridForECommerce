package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTest
{
    private static final int INDEX_OF = 0;
    private static final long WAITING_TIME = 120;
    private static final String SEARCH_KEYWORD = "фрезер";
    private static final String EXPECTED_VALUE = "2";
    @Test
    public void checkThatCounterEqualSearchAmount()
    {
        getHomePage().waitForPageLoadComplete(WAITING_TIME);
        int A = getHomePage().getGroupGalleryCounter(INDEX_OF);
        getHomePage().getLinkToProductPage(INDEX_OF);
        getSearchResultsPage().waitForPageLoadComplete(WAITING_TIME);
        int B = getSearchResultsPage().getSearchResultsCount();
        assertEquals(A,B);
    }
    @Test
    public void checkThatSearchResultsContainsSearchKeyword()
    {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().waitForPageLoadComplete(WAITING_TIME);
        assertTrue(getSearchResultsPage().getSearchResultsWithCorrectName(SEARCH_KEYWORD) <= getSearchResultsPage().getSearchResultsCount());
    }
    @Test
    public void checkAddToCartMoreQuantity()
    {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().waitForPageLoadComplete(WAITING_TIME);
        getSearchResultsPage().addToCart();
        getSearchResultsPage().waitVisibilityOfElement(WAITING_TIME, getSearchResultsPage().getQuantityButton());
        getSearchResultsPage().getQuantityButton().click();
        getSearchResultsPage().waitVisibilityOfValue(WAITING_TIME, getSearchResultsPage().getProductQuantityInput(), EXPECTED_VALUE);
        getSearchResultsPage().continueShopping();
        getSearchResultsPage().waitVisibilityOfElement(WAITING_TIME, getSearchResultsPage().getCartButton());
        getSearchResultsPage().getCart();
        getHomePage().waitForPageLoadComplete(WAITING_TIME);
        assertEquals(getSearchResultsPage().getProductQuantity(), EXPECTED_VALUE);

    }
    
}
