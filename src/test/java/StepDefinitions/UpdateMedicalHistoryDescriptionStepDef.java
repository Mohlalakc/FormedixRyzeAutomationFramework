package StepDefinitions;

import Browser.InitialiseBrowser;
import Utilities.Config;
import Utilities.ScreenShots;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageObject.*;

import static Browser.InitialiseBrowser.driver;


public class UpdateMedicalHistoryDescriptionStepDef extends ScreenShots {
    InitialiseBrowser initialiseBrowser = new InitialiseBrowser();
    String screenshotPath = "src/test/resources/Screenshots/Login/";
    Config config = new Config();
    FormsPage formsPage = new FormsPage();
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();
    RyzeLandingPage ryzeLandingPage = new RyzeLandingPage();
    TechStudyPage techStudyPage =  new TechStudyPage();

    @After
    public void tearDown(Scenario scenario) throws Exception{
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.quit();
    }

@Given("Ryze website is open and I am on a login page open on {string} {string}")
public void ryze_website_is_open_and_i_am_on_a_login_page_open_on(String browser, String env) {
    try {
            initialiseBrowser.initialize(browser, env);
            this.takeSnapShot(screenshotPath + "Login.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    @When("I login with {string} and {string} credentials")
    public void i_login_with_and_credentials(String Username, String Password) throws Exception {

        loginPage.enterUserName(Username);
        loginPage.enterPassword(Password);
    }
    @Then("I click on Login button")
    public void i_click_on_login_button() throws InterruptedException {
        loginPage.clickLoginBtn();
    }
    @And("I click on the Repository button")
    public void iClickOnTheRepositoryButton() throws Exception {
        Thread.sleep(5000);
        this.takeSnapShot(screenshotPath+ "LandingPage.png");
        ryzeLandingPage.clickRepositoryBtn();
    }

    @And("I click on the Studies option")
    public void iClickOnTheStudiesOption() throws Exception {
        this.takeSnapShot(screenshotPath+ "RepositoryOptions.png");
        ryzeLandingPage.clickStudiesOption();

    }

    @And("I click on the Tech Study menu bar")
    public void iClickOnTheTechStudyMenuBar() throws Exception {
        ryzeLandingPage.clickStudiesMenuBtn();
        this.takeSnapShot(screenshotPath+ "TechStudyMenu.png");
    }

    @And("I verify the Tech Study options {string} {string} {string} {string}")
    public void iVerifyTheTechStudyOptions(String View, String Edit, String RemoveThisStudy, String TransitionThisStudy) {
        Assert.assertEquals(View, formsPage.viewOptionText());
        Assert.assertEquals(Edit, formsPage.editOptionText());
        Assert.assertEquals(RemoveThisStudy,formsPage.removeThisStudyOptionText());
        Assert.assertEquals(TransitionThisStudy, formsPage.transitionThisStudyOptionText());
    }

    @And("I click on the View button")
    public void iClickOnTheViewButton() throws Exception {
        ryzeLandingPage.clickStudiesMenuViewOption();
        this.takeSnapShot(screenshotPath+ "TechStudyScreen.png");
    }

    @And("I click on the Data Acquisition button")
    public void iClickOnTheDataAcquisitionButton() throws Exception {
        techStudyPage.ClickDataAcquisitionAssetGroupBtn();
        Thread.sleep(2000);
        this.takeSnapShot(screenshotPath+ "DataAcquisition.png");
    }

    @And("I click on forms option under assets")
    public void iClickOnFormsOptionUnderAssets() {
        techStudyPage.clickFormsOption();
    }

    @And("I click on the Medical History option")
    public void iClickOnTheMedicalHistoryOption() throws Exception {
        Thread.sleep(5000);
        formsPage.clickMedicalHistoryOption();
        this.takeSnapShot(screenshotPath+ "MedicalHistory.png");
    }

    @And("I click on the Edit Form button")
    public void iClickOnTheEditFormButton() throws InterruptedException {
        Thread.sleep(5000);
        formsPage.clickEditMedicalHistoryBtn();
    }

    @And("I clear the Description text box")
    public void iClearTheDescriptionTextBox() {
        formsPage.clearMedicalHistoryDescriptionTextBox();
    }

    @And("I capture the Description {string}")
    public void iCaptureTheDescription(String Description) throws Exception {
        Thread.sleep(5000);
        formsPage.EnterMedicalHistoryDescription(Description);
        this.takeSnapShot(screenshotPath+ "MedicalHistoryDescription.png");
    }

    @And("I click on the Update button")
    public void iClickOnTheUpdateButton() throws InterruptedException {
        Thread.sleep(5000);
        formsPage.clickMedicalHistoryUpdateBtn();
    }

    @And("I verify that the textbox is updated successfully {string}")
    public void iVerifyThatTheTextboxIsUpdatedSuccessfully(String Description){
    Assert.assertEquals(Description, formsPage.UpdatedDescritpion());
    }

    @And("I click on the profile")
    public void iClickOnTheProfile() throws Exception {
        logoutPage.clickProfileBtn();
        Thread.sleep(2000);
        this.takeSnapShot(screenshotPath+ "ProfileMenu.png");
    }

    @And("I click on Logout option")
    public void iClickOnLogoutOption() {
        logoutPage.clickSignoutOption();

    }

    @And("I verify that the Ryze Logo is displayed")
    public void iVerifyThatTheRyzeLogoIsDisplayed() throws Exception {
        loginPage.RyzeLogoDisplayed();
    }
}
