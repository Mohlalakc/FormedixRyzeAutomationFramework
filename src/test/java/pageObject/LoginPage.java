package pageObject;

import Browser.InitialiseBrowser;
import org.openqa.selenium.By;

public class LoginPage extends InitialiseBrowser {
    By userName = By.id("username");
    By passWord = By.id("password");
    By loginBtn = By.id("btnSubmit");
    By ryzeLogo = By.id("logo");

    public void enterUserName(String Username) {
        driver.findElement(userName).sendKeys(Username);
    }

    public void enterPassword(String Password) {

        driver.findElement(passWord).sendKeys(Password);
    }


    public void clickLoginBtn() throws InterruptedException {

        driver.findElement(loginBtn).click();
        Thread.sleep(4000);
    }
    public void RyzeLogoDisplayed(){
        driver.findElement(ryzeLogo).isDisplayed();
    }
}

