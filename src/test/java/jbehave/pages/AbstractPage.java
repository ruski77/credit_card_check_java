package jbehave.pages;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;
import org.jbehave.web.selenium.SeleniumPage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 2/12/2013
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractPage extends SeleniumPage {

    public AbstractPage(Selenium selenium, ConditionRunner conditionRunner) {
        super(selenium, conditionRunner);
    }

    public void found(String text) {
        textIsVisible(text);
    }

    public void found(List<String> texts) {
        for (String text : texts) {
            found(text);
        }
    }

    public void notFound(String text) {
        textIsNotVisible(text);
    }
}
