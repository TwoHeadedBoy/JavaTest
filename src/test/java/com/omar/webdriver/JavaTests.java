package com.omar.webdriver;

import com.omar.testframework.pageobjects.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by omar on 7/5/16.
 */

public class JavaTests {
    @Test
    public void javaTest1() {

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://3cinteractive.com");

        mainNavBarAndSearch MainPageHelper = new mainNavBarAndSearch();
        searchResults SearchResulstHelper = new searchResults();
        johnDuffyBlogPost BlogPostHelper = new johnDuffyBlogPost();

        // assert - page title
        String title = MainPageHelper.getTitle();
        Assert.assertTrue("Page Title should be \"" + title + "\"",
                driver.getTitle().contains(title));

        // assert - search bar
        WebElement searchBar = driver.findElement(
                By.xpath(MainPageHelper.getElementSearchBarXPath()));
        Assert.assertTrue("Search Bar is visible", searchBar.isDisplayed());

        // search for term
        String searchTerm = "duffy";
        WebElement searchBarTextField = driver.findElement(
                By.xpath(MainPageHelper.getTextfieldSearchBarTextFieldXpath()));
        searchBarTextField.click();
        searchBarTextField.sendKeys(searchTerm);
//        searchBar.submit();
        //or try this
        WebElement searchBarSubmit = driver.findElement(
                By.xpath(MainPageHelper.getButtonSearchBarSubmitXpath()));
        searchBarSubmit.click();

        // validate search
        WebElement searchResultsHeader = driver.findElement(
                By.xpath(SearchResulstHelper.getTextSearchResultsHeaderXpath()));
        String searchResultsHeaderText = searchResultsHeader.getText();
        String expectedText = "Search Results for: duffy";
        // note - Assert.assertSame failed on identical strings (???)
        Assert.assertTrue("Search results header should equal \"" + expectedText + "\"",
                searchResultsHeaderText.equals(expectedText));

        // validate first result
        List<WebElement> searchResultsBatch = driver.findElements(
                By.xpath(SearchResulstHelper.getElementSearchResultsXpath()));

        if (searchResultsBatch.isEmpty())
            Assert.fail("No results returned or no elements found"); // error out of test

        WebElement firstResult = searchResultsBatch.get(0);
        String resultText = firstResult.getText();
        WebElement firstResultHeader = driver.findElement(By.xpath(
                SearchResulstHelper.getResultHeaderXpathByIndex(1)));
        String resultHeader = firstResultHeader.getText();
        expectedText = "John Duffy";
        Assert.assertTrue("First result header = \"" + expectedText + "\"",
                resultHeader.equals(expectedText));
        expectedText = "John Duffy is a visionary";
        Assert.assertTrue("First result text contains \"" + expectedText + "\"",
                resultText.contains(expectedText));

        // navigate to first result
        firstResultHeader.click();

        // validate image present
        WebElement headerImage = driver.findElement(By.xpath(
                BlogPostHelper.getImageHeaderImageXpath()));
        Assert.assertTrue("Header image of blog post is present", headerImage.isDisplayed());

        // validate title text
        String expectedTitle = "John Duffy";
        WebElement blogPostTitle = driver.findElement(By.xpath(
                BlogPostHelper.getTextBlogPostTitleXpath()));
        Assert.assertTrue("Blog post title is present", blogPostTitle.isDisplayed());
        Assert.assertTrue("Blog post title is \"" + expectedTitle + "\"",
                blogPostTitle.getText().equals(expectedTitle));

        // validate subtitle text
        String expectedSubtitle = "Founder & Chief Executive Officer";
        WebElement blogPostSubtitle = driver.findElement(By.xpath(
                BlogPostHelper.getTextBlogPostSubtitleXpath()));
        Assert.assertTrue("Blog post subtitle is present", blogPostSubtitle.isDisplayed());
        Assert.assertTrue("Blog post subtitle is \"" + expectedSubtitle + "\"",
                blogPostSubtitle.getText().equals(expectedSubtitle));

        // validate text/subtext position
        String blogPostChildrenXpath = BlogPostHelper.getTextBlogPostPositionalTextXpath() + "/*";
        List<WebElement> blogPostChildren = driver.findElements(By.xpath(blogPostChildrenXpath));
        Assert.assertTrue("First child element is title",
                blogPostChildren.get(0).getText().equals(expectedTitle));
        Assert.assertTrue("Second child element is subtitle",
                blogPostChildren.get(1).getText().equals(expectedSubtitle));

        driver.close();
        driver.quit();
    }

    @Test
    public void javaTest2() {
        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://3cinteractive.com");

        mainNavBarAndSearch MainPageHelper = new mainNavBarAndSearch();
        companyPage CompanyPageHelper = new companyPage();
        jobViteFrame JobViteFrameHelper = new jobViteFrame();

        // click company link
        WebElement menuNavCompany = driver.findElement(By.xpath(
                MainPageHelper.getTextlinkTopNavCompanyLinkXpath()));
        menuNavCompany.click();

        // validate on company page
        String expectedText = "Expertise Built From Experience";
        WebElement companyPageHeroText = driver.findElement(By.xpath(
                CompanyPageHelper.getTextHeroTextXpath()));
        Assert.assertTrue("Navigated to company page", companyPageHeroText.isDisplayed());
        Assert.assertTrue("Hero text equals \"" + expectedText + "\"",
                companyPageHeroText.getText().equals(expectedText));

        // click subnav careers link
        WebElement companyPageSubNavCareersLink = driver.findElement(By.xpath(
                CompanyPageHelper.getLinkSubNavCareersLinkXpath()));
        companyPageSubNavCareersLink.click();

        // validate browser scroll to careers page
        expectedText = "Do You Have What It Takes To Help Define The Future Of Mobile?";
        WebElement companyPageCareersHeroText = driver.findElement(By.xpath(
                CompanyPageHelper.getTextCareersHeroTextXpath()));
        Assert.assertTrue("Scrolled down to careers section",
                companyPageCareersHeroText.isDisplayed()); // might be true even at top of page
        Assert.assertTrue("Careers hero text equals \"" + expectedText + "\"",
                companyPageCareersHeroText.getText().equals(expectedText));

        // switch to iframe
        WebElement jobViteIFrame = driver.findElement(By.id(JobViteFrameHelper.getIframeJobViteIFrameId()));
        driver.switchTo().frame(jobViteIFrame);

        // navigate to specific job link
        String specificJobXpath = "//*[@id=\"jvform\"]/div/div[1]/div/ul[2]/li[2]/a";
        WebElement specificJobLink = driver.findElement(By.xpath(specificJobXpath));
        specificJobLink.click();

        // validate job page elements
        String specificJobTitleXpath = "//*[@id=\"jvform\"]/div/div[1]/div[2]/div[2]/h2";
        String specificJobSubtitleXpath = "//*[@id=\"jvform\"]/div/div[1]/div[2]/div[2]/h3";

        // adding pause
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement specificJobTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(specificJobTitleXpath)));
        // resuming
        WebElement specificJobSubtitle = driver.findElement(By.xpath(specificJobSubtitleXpath));
        Assert.assertTrue("Job title is visible", specificJobTitle.isDisplayed());
        String expectedTitle = "QA Engineer";
        Assert.assertTrue("Job title is \"" + expectedTitle + "\"",
                specificJobTitle.getText().equals(expectedTitle));
        String expectedSubtitle = "Engineering/Software | Boca Raton, FL, United States";
        Assert.assertTrue("Job subtitle reads \" "+ expectedSubtitle +"\"",
                specificJobSubtitle.getText().equals(expectedSubtitle));

        // navigate jobvite frame
        WebElement applyButton = driver.findElement(By.xpath(
                JobViteFrameHelper.getButtonJobViteApplyXpath()));
        Assert.assertTrue("Apply button is visible", applyButton.isDisplayed());
        applyButton.click();

        // submit for error
        WebElement submitButton = driver.findElement(By.xpath(
                JobViteFrameHelper.getButtonJobViteSubmitXpath()));
        Assert.assertTrue("Submit button is visible", submitButton.isDisplayed());
        submitButton.click();

        // validate error
        WebElement jobFormNameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(
                        JobViteFrameHelper.getTextfieldJobViteNameId())));
        String classAttribute = jobFormNameField.getAttribute("class");
        Assert.assertTrue("Error present in element class", classAttribute.contains("jverror"));

        // open resume upload dialog
        WebElement jobFormApplyWithResumeButton = driver.findElement(By.id(
                JobViteFrameHelper.getButtonJobViteApplyWithResumeId()));
        jobFormApplyWithResumeButton.click();

        // switch to iframe
        WebElement jvFileIframe = driver.findElement(By.id(
                JobViteFrameHelper.getIframeFileFrameId()));
        driver.switchTo().frame(jvFileIframe);

        // select file
        WebElement jobFormChooseFileButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(
                        JobViteFrameHelper.getButtonJobViteResumeChooseFileId())));
        String pwd = System.getProperty("user.dir");
        jobFormChooseFileButton.sendKeys(pwd + "/resume.txt");

        // switch to iframe
        driver.switchTo().parentFrame();

        // submit file
        WebElement jobFormUploadResumeButton = driver.findElement(By.xpath(
                JobViteFrameHelper.getButtonJobViteResumeSubmitXpath()));
        jobFormUploadResumeButton.click();

        // hit form submit again to trigger textarea text population
//        submitButton = driver.findElement(By.xpath(
//                JobViteFrameHelper.getButtonJobViteSubmitXpath()));
//        Assert.assertTrue("Submit button is visible", submitButton.isDisplayed());
//        submitButton.click();

        // validate resume text in field
        WebElement jobFormResumeField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(
                JobViteFrameHelper.getTextareaJobViteResumeFieldId())));
        String textAreaText = jobFormResumeField.getAttribute("value");
        expectedText = "This is a test";
        Assert.assertTrue("Resume textarea contains \"" + expectedText + "\"",
                textAreaText.contains(expectedText));

        driver.close();
        driver.quit();
    }
}
