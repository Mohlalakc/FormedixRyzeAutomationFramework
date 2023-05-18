package Browser;

import Utilities.Config;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class InitialiseBrowser {
    public static WebDriver driver;
    Config config = new Config();

    public WebDriver getDriver(){
        return driver;
    }
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver initialize(String browserName, String environment){
       config.loadProperties();
       String driverPath;
       String environmentPath;

       try{
           switch (browserName) {

               case "Chrome":
                   driverPath = config.properties.getProperty("ChromePath");
                   System.setProperty("webdriver.chrome.driver", driverPath);
                   System.setProperty("webdriver.http.factory", "jdk-http-client");
                   ChromeOptions options = new ChromeOptions();
                   options.addArguments("start-maximized");
                   options.addArguments("disable-popup-blocking");
                   driver = new ChromeDriver(options);
                   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                   break;
//               case "FIREFOX":
//                   driverPath = config.properties.getProperty("MozillaPath");
//                   System.setProperty("webriver.gecko.driver", driverPath);
//                   DesiredCapabilities capabilities = new DesiredCapabilities();
//                   capabilities.setCapability("platform", Platform.ANY);
//                   capabilities.setCapability("binary", "/ms/dist/fsf/PROJ/firefox/16.0.0/bin/firefox");
//                   capabilities.setCapability("binary", driverPath); //for Windows
//                   driver = new FirefoxDriver(capabilities);
//                   break;
               case "Edge":
                   driverPath = config.properties.getProperty("EdgePath");
                   System.setProperty("webdriver.edge.driver", driverPath);
                   EdgeOptions edgeOptions = new EdgeOptions();
                   driver.manage().window().maximize();
                   break;
               default:
                   throw new Exception("Unsupported browser " +browserName);

           }
           try{
               switch (environment) {
                   case "QA":
                       environmentPath = config.properties.getProperty("QA");
                       getDriver().get(environmentPath);
                       break;
                   default:
                       environmentPath = config.properties.getProperty("INT");
                       getDriver().get(environmentPath);
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           return driver;

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
