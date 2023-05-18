package pageObject;

import Browser.InitialiseBrowser;
import org.openqa.selenium.By;

public class TechStudyPage extends InitialiseBrowser {
    By dataAcquisitionAssetGroupBtn = By.id("dataAcquisitionType");
    By formsOption = By.id("FORMTypeName");

    public void ClickDataAcquisitionAssetGroupBtn(){
        driver.findElement(dataAcquisitionAssetGroupBtn).click();
    }
    public void clickFormsOption(){
        driver.findElement(formsOption).click();
    }
}
