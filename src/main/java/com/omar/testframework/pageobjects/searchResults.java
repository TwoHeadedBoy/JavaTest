package com.omar.testframework.pageobjects;

/**
 * Created by omar on 7/5/16.
 * Notes: none of the page's search results have enumerated elements, so I'm forced to use
 * fragile xpaths that are likely to fail against a stiffer test.
 */
public class searchResults {
    public searchResults() {
    }

    private String textSearchResultsHeaderXpath = "//*[@id=\"container\"]/section/h1";
    private String elementSearchResultsXpath = "//*[@class=\"search-result\"]";
    private String textSearchResultHeaderXpath = "//*[@id=\"container\"]/section/article[%]/h2/a";

    public String getTextSearchResultsHeaderXpath() {
        return textSearchResultsHeaderXpath;
    }

    public String getElementSearchResultsXpath() {
        return elementSearchResultsXpath;
    }

    public String getTextSearchResultHeaderXpath() {
        return textSearchResultHeaderXpath;
    }

    public String getResultHeaderXpathByIndex(int index) {
        String xpath = getTextSearchResultHeaderXpath().replace("%", Integer.toString(index));
        return xpath;
    }
}
