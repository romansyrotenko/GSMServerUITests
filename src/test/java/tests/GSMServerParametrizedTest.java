package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class GSMServerParametrizedTest extends BaseTest {

    @Parameterized.Parameters
    public static Iterable <String[]> productsForSearchTest() {
        return Arrays.asList(new String[][] {
                {"Camera for Apple iPhone 5 Cell Phone"},
                {"CS9500 GPS Navigation Box for OEM Monitors"},
                {"GPS Antenna for CS9100 / CS9200 Navigation Box"},
                {"RIFF Box Cable Set"},
                {"BEST Dongle"},
                {"Miracle Key Dongle"},
                {"Medusa PRO Box"},
        });
    }

    @Parameterized.Parameter
    public String SearchProductName;

    @Test
    public void testFindProductOnSearchResultsPageParametrized() {
        mainPage.open();
        mainPage.searchProduct(SearchProductName);
        searchResultsPage.shouldBeOnSearchPage(SearchProductName);
    }

}
