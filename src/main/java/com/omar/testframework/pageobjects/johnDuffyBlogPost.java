package com.omar.testframework.pageobjects;

/**
 * Created by omar on 7/5/16.
 */
public class johnDuffyBlogPost {
    public johnDuffyBlogPost() {
    }

    private String textBlogPostPositionalTextXpath = "//*[@id=\"container\"]/article/section";
    private String textBlogPostTitleXpath = "//*[@id=\"container\"]/article/section/p[1]";
    private String textBlogPostSubtitleXpath = "//*[@id=\"container\"]/article/section/p[2]";
    private String imageHeaderImageXpath = "//*[@id=\"container\"]/article/section/figure/img";

    public String getTextBlogPostPositionalTextXpath() {
        return textBlogPostPositionalTextXpath;
    }

    public String getImageHeaderImageXpath() {
        return imageHeaderImageXpath;
    }

    public String getTextBlogPostTitleXpath() {
        return textBlogPostTitleXpath;
    }

    public String getTextBlogPostSubtitleXpath() {
        return textBlogPostSubtitleXpath;
    }
}
