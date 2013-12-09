package jbehave.pages;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 2/12/2013
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Home extends AbstractPage {

    public Home(Selenium selenium, ConditionRunner conditionRunner) {
        super(selenium, conditionRunner);
    }

    public void open() {
        open("/");
    }
}
