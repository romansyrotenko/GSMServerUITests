package steps;

import pages.SearchResultsPage;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SearchResultsPageSteps {

    SearchResultsPage searchResultsPage;

    public SearchResultsPageSteps(SearchResultsPage searchResultsPage) {
        this.searchResultsPage = searchResultsPage;
    }

    public void shouldBeOnSearchPage(String productName) {
        assertEquals("tag Title is wrong","Search - GsmServer", searchResultsPage.driver.getTitle());
        assertEquals("tag H1 is wrong","Search “" + productName + "”", searchResultsPage.searchResultString.getText());
        assertEquals("the Product didn't find in search results", ProductShouldBeOnSearchResults(productName),true);
    }

    public boolean ProductShouldBeOnSearchResults(String productName) {

        List<String> searchResultsList = new ArrayList<>();

        for(int i = 0; i < searchResultsPage.searchResults.size(); i++)
            searchResultsList.add(searchResultsPage.searchResults.get(i).getText());
        if (searchResultsList.contains(productName)) {
            return true;
        } else {
            System.out.println("The Product \"" + productName + "\" didn't find. The list of search results:" );
            for(int i = 0; i < searchResultsList.size(); i++) {
                System.out.println(searchResultsList.get(i));
            }
            return false;
        }
    }

}
