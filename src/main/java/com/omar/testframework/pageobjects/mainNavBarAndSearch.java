package com.omar.testframework.pageobjects;

/**
 * Created by omar on 7/5/16.
 */
public class mainNavBarAndSearch {

    public mainNavBarAndSearch() {
    }

    private String title = "3C | Mobile Marketing Solutions & Services";
    private String elementSearchBarXPath = "//*[@id=\"searchform\"]";
    private String buttonSearchBarSubmitXpath = "//*[@id=\"searchsubmit\"]";
    private String textfieldSearchBarTextFieldXpath = "//*[@id=\"s\"]";
    private String textlinkTopNavCompanyLinkXpath = "//*[@id=\"menu-item-149\"]/a";

    public String getTitle() {
        return title;
    }

    public String getElementSearchBarXPath() {
        return elementSearchBarXPath;
    }

    public String getButtonSearchBarSubmitXpath() {
        return buttonSearchBarSubmitXpath;
    }

    public String getTextfieldSearchBarTextFieldXpath() {
        return textfieldSearchBarTextFieldXpath;
    }

    public String getTextlinkTopNavCompanyLinkXpath() {
        return textlinkTopNavCompanyLinkXpath;
    }
}
