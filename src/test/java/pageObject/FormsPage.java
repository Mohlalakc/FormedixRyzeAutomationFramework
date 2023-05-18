package pageObject;

import Browser.InitialiseBrowser;
import org.junit.runner.Description;
import org.openqa.selenium.By;

public class FormsPage extends InitialiseBrowser {
    By medicalHistoryOption = By.xpath("/html/body/div[3]/div/div/div/div/fdx-mdb-container-detail/div[2]/div/fdx-mdb-asset/div/div/div[1]/fdx-mdb-asset-browse/div/div[5]/fdx-virtual-scroll/div[2]/div/div[4]/div/div");
    By editMedicalHistoryBtn = By.id("switchEditMode");
    By medicalHistoryDescriptionTextBox = By.id("assetLocaleEditTextTextareadescription");
    By medicalHistoryUpdateBtn = By.id("saveAsset");

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
}
