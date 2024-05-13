package StepDefinitions;

import Utilities.DBUtility;
import io.cucumber.java.en.Then;

public class _10_StatesControl {
    @Then("Send the Query the Database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String statesList) {
        DBUtility.getListData(statesList);
    }
}
