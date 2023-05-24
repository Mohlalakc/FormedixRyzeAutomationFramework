package pageObject;

import Browser.InitialiseBrowser;
import org.openqa.selenium.By;

public class FormsPage extends InitialiseBrowser {
    By medicalHistoryOption = By.xpath("/html/body/div[3]/div/div/div/div/fdx-mdb-container-detail/div[2]/div/fdx-mdb-asset/div/div/div[1]/fdx-mdb-asset-browse/div/div[5]/fdx-virtual-scroll/div[2]/div/div[4]/div/div");
    By editMedicalHistoryBtn = By.id("switchEditMode");
    By medicalHistoryDescriptionTextBox = By.id("assetLocaleEditTextTextareadescription");
    By medicalHistoryUpdateBtn = By.id("saveAsset");
    By ViewOption = By.xpath("//*[@id=\"fdxMdbContainerListItem0View\"]");
    By EditOption = By.xpath("//*[@id=\"fdxMdbContainerListItem0Edit\"]");
    By RemoveThisStudyOption = By.xpath("//*[@id=\"fdxMdbContainerListItem0Delete\"]");
    By TransitionThisStudyOption = By.xpath("//*[@id=\"fdxMdbContainerListItem0Transition\"]");
    By UpdateDescription = By.xpath("//*[@id=\"formDescription\"]/span");

    public void clickMedicalHistoryOption() {
        driver.findElement(medicalHistoryOption).click();
    }
    public void clickEditMedicalHistoryBtn() {
        driver.findElement(editMedicalHistoryBtn).click();
    }
    public void clearMedicalHistoryDescriptionTextBox() {
        driver.findElement(medicalHistoryDescriptionTextBox).clear();
    }
    public void EnterMedicalHistoryDescription(String Description){
        driver.findElement(medicalHistoryDescriptionTextBox).sendKeys(Description);
    }
    public void clickMedicalHistoryUpdateBtn(){
        driver.findElement(medicalHistoryUpdateBtn).click();
    }

    public String viewOptionText(){
        String ViewOptTxt = driver.findElement(ViewOption).getText();
        return ViewOptTxt;
    }
    public String editOptionText(){
        String EditOptTxt = driver.findElement(EditOption).getText();
        return EditOptTxt;
    }
    public String removeThisStudyOptionText(){
        String RemoveThisStudyOptionTxt = driver.findElement(RemoveThisStudyOption).getText();
        return RemoveThisStudyOptionTxt;
    }
    public String transitionThisStudyOptionText(){
        String TransitionThisStudyOpionTxt = driver.findElement(TransitionThisStudyOption).getText();
        return TransitionThisStudyOpionTxt;
    }
    public String UpdatedDescritpion(){
        String UpdatedDescTxt = driver.findElement(UpdateDescription).getText();
        return UpdatedDescTxt;
    }
}
