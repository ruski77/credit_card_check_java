package jbehave.steps;

import com.thoughtworks.selenium.SeleneseTestCase;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 1/12/2013
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreditCardSteps extends SeleneseTestCase {

    //private DefaultSelenium selenium;

    private WebDriver webDriver;
    private WebDriverBackedSelenium selenium;

    @BeforeStories
    public void setup() {
        //selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8080");
        //selenium.start();
        webDriver = new FirefoxDriver();
        selenium = new WebDriverBackedSelenium(webDriver, "http://localhost:8080");

    }

    @Given("I am on the $element page")
    public void onPage(String element) {
        selenium.open("home.jsp");
        selenium.waitForPageToLoad("10000");
        pause(1000);

        //selenium.captureScreenshot("/Users/russell/workspace/java/credit-card-check/target/test.png");
        WebElement fileUpload = selenium.getWrappedDriver().findElement(By.id("uploadFile"));
        fileUpload.sendKeys("file:///Users/russell/workspace/java/credit-card-check/target/test-classes/credit_cards.txt");


        //selenium.attachFile("uploadFile", "file:///Users/russell/workspace/java/credit-card-check/target/test-classes/credit_cards.txt");
        pause(1000);
        selenium.submit("fileUploadForm");
        selenium.waitForPageToLoad("10000");
        pause(1000);
    }

    @When("I see a list of $num credit cards")
    public void listOfCreditCards(int num) {
        selenium.waitForPageToLoad("10000");
        int cards = selenium.getWrappedDriver().findElements(By.xpath("//table//tr")).size();
        Assert.assertEquals("Unexpected number of cards found", cards, num);
    }

    @Then("I should see $validNum valid cards and $invalidNum invalid cards")
    public void validateCards(int validNum, int invalidNum) {
        int valid = selenium.getWrappedDriver().findElements(By.xpath("//td[contains(., '(valid)')]")).size();
        Assert.assertEquals("Unexpected number of valid cards found", valid, validNum);

        int invalid = selenium.getWrappedDriver().findElements(By.xpath("//td[contains(., '(invalid)')]")).size();
        Assert.assertEquals("Unexpected number of invalid cards found", invalid, invalidNum);
    }

    @AfterStories
    public void tearDown() {
        selenium.stop();
    }
}





    /*public CreditCardSteps(/^I am on the(.*?) page$/) do |page_name|
    visit path_to(page_name)
    end

    When(/^I see a list of (\d+) credit cards$/) do |count|
    count = count.to_i
    page.has_css?("table#cards tr", :count => (count + 1)) #add one for the header row
            end

    Then(/^I should see (\d+) valid cards and (\d+) invalid cards$/) do |valid_count, invalid_count|
    valid_count = valid_count.to_i
            invalid_count = invalid_count.to_i
    valid_regexp = Regexp.new(/(valid)/)
    invalid_regexp = Regexp.new(/(invalid)/)
    page.has_content?(valid_regexp, :count => valid_count)
    page.has_content?(invalid_regexp, :count => invalid_count)
    end*/
