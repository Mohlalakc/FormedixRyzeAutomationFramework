package Utilities;

import Browser.InitialiseBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenShots {

    public static String takeSnapShot(String fileWithpath) throws  Exception{
        TakesScreenshot screenshot = ((TakesScreenshot) InitialiseBrowser.driver);
        File ScrFile = screenshot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithpath);
        FileUtils.copyFile(ScrFile, DestFile);
        return fileWithpath;
    }
}
