package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends ParentPage {

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    public WebElement setup;

    @FindBy(xpath = "//span[text()='Parameters']")
    public WebElement parameters;

    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    public WebElement countries;

    @FindBy(xpath = "(//span[text()='Citizenships'])[1]")
    public WebElement citizenship;

    @FindBy(xpath = "//span[text()='Nationalities']")
    public WebElement nationalities;

    @FindBy(xpath = "//span[text()='Fees']")
    public WebElement fees;

    @FindBy (xpath = "//span[text()='Inventory']")
    public WebElement inventory;

    @FindBy (xpath = "(//span[text()='Setup'])[4]")
    public WebElement setupInvent;

    @FindBy (xpath = "(//span[text()='Item Categories'])[1]")
    public WebElement itemCategories;

    @FindBy (xpath = "(//span[text()='Entrance Exams'])[1]")
    public WebElement entranceExam;

    @FindBy (xpath = "(//span[text()='Setup'])[2]")
    public WebElement entranceExamSetup;

    @FindBy (xpath = "(//span[text()='Entrance Exams'])[2]")
    public WebElement entranceExam2;

    @FindBy (xpath = "(//span[text()='States'])[1]")
    public WebElement states;




    public WebElement getWebElement(String strElement){

        switch (strElement){

            case "setup" : return this.setup;
            case "parameters" : return this.parameters;
            case "countries" : return this.countries;
            case "citizenship" : return this.citizenship;
            case "nationalities" : return this.nationalities;
            case "fees" : return this.fees;
            case "inventory" : return this.inventory;
            case "setupInvent" : return this.setupInvent;
            case "itemCategories" : return this.itemCategories;
            case "entranceExam" : return this.entranceExam;
            case "entExSetup" : return this.entranceExamSetup;
            case "entranceExam2" : return this.entranceExam2;
            case "states" : return this.states;
        }
        return null;
    }

}
