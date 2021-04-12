package org.steps.page1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiconfig.AppResources;
import util.BaseUtil;

public class StepDefinitions extends BaseUtil {

    AppResources appUIResource = new AppResources();

    @Given("I want to open the xyz webpage to buy a watch")
    public void i_want_to_open_the_midtrans_webpage_to_buy_a_pillow() {
        // open webpage url in the selected browser
        openUrl(appUIResource.APP_URL);
        takeSnapshot("Home_Page");
    }

}
