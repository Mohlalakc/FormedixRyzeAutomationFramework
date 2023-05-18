package pageObject;

import Browser.InitialiseBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RyzeLandingPage extends InitialiseBrowser {
    By repositoryBtn = By.xpath("//*[@id=\"menuMdb\"]/fdx-main-nav-item/div");
    By studiesOption = By.xpath("//*[@id=\"menuMdbStudies\"]/span/span");
    By studiesMenuBtn = By.xpath("//*[@id=\"fdxMdbContainerListItem0MenuToggle\"]");
    By studiesMenuViewOption = By.xpath("//*[@id=\"fdxMdbContainerListItem0View\"]");

    public void clickRepositoryBtn(){
        driver.findElement(repositoryBtn).click();
    }
    public void CheckRepositoryBtnDisplayed(){
        driver.findElement(repositoryBtn).isDisplayed();
    }
    public void clickStudiesOption(){
        driver.findElement(studiesOption).click();
    }
    public void clickStudiesMenuBtn(){
        driver.findElement(studiesMenuBtn).click();
    }
    public void viewStudiesMenu(){
        driver.findElement(studiesMenuViewOption).getText();
    }
    public void clickStudiesMenuViewOption() {
        driver.findElement(studiesMenuViewOption).click();
    }
}
