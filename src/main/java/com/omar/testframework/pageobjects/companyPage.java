package com.omar.testframework.pageobjects;

/**
 * Created by omar on 7/5/16.
 */
public class companyPage {
    public companyPage() {
    }

    private String textHeroTextXpath = "//*[@id=\"container\"]/section[1]/div/h1";
    private String linkSubNavCareersLinkXpath = "//*[@id=\"container\"]/section[1]/ul/li[4]/a";
    private String textCareersHeroTextXpath = "//*[@id=\"container\"]/section[9]/div/h3/p";

    public String getTextHeroTextXpath() {
        return textHeroTextXpath;
    }

    public String getLinkSubNavCareersLinkXpath() {
        return linkSubNavCareersLinkXpath;
    }

    public String getTextCareersHeroTextXpath() {
        return textCareersHeroTextXpath;
    }

}
