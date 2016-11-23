/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import geb.report.ReportState
import geb.report.Reporter
import geb.report.ReportingListener
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.safari.SafariDriver

import java.util.concurrent.TimeUnit

import static org.openqa.selenium.remote.DesiredCapabilities.firefox

localUrl {
    devFoo = "http://knockoutjs.com/examples/"
    localFoo="http://knockoutjs.com/examples/"
    prodFoo= "http://knockoutjs.com/examples/"
}



// When disabled, a new browser will be started for each test (Safer execution)
if (System.properties['cacheBrowser'] == null) {
    cacheDriver = false
    cacheDriverPerThread = false
    quitCachedDriverOnShutdown = false
}

// Set reporter to a null reporter class, to avoid issue with geb reporting
// lifecycle triggering post-cleanup (when driver.quit() has been called)/
reporter = new Reporter() {
    @Override
    void writeReport(ReportState reportState) {

    }

    @Override
    void addListener(ReportingListener listener) {

    }
}


driver = {
    def myOs = System.getProperty("os.name").toLowerCase()
    // switch between mac (for development), and linux for code ship.  Will add windows if we need it
    def chromeDriver = ""
     if (myOs.startsWith("mac")){
        chromeDriver = new File('src/test/resources/osx/chromedriver')
     } else{
         chromeDriver = new File('src/test/resources/linux/chromedriver')
     }
    System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS)
    driver.manage().deleteAllCookies()
    driver.manage().window().maximize()
    driver
   }


remoteUrl = System.properties['remoteWebDriverHubUrl'] ? new URL(System.properties['remoteWebDriverHubUrl'].toString()) : new URL('http://localhost:7500/wd/hub')


def String appUrl;
appUrl = System.properties['appUrl'].toString();
baseUrl = localUrl.getProperty(appUrl).toString()


reportsDir = "target/geb-reports"

waiting {
	timeout = 30
	retryInterval = 0.5
	slow { timeout = 60 }
}



environments {
    // to use these, run as “mvn -Dgeb.env=firefox”
   firefox{
        driver ={
            FirefoxProfile fp = new FirefoxProfile();
	        driver = new FirefoxDriver(fp);
	        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS)
	        driver.manage().deleteAllCookies()
	        driver.manage().window().maximize()
	        driver
        }
    }


    remote {
        driver = {
            driver = new RemoteWebDriver(remoteUrl, DesiredCapabilities.internetExplorer())
            driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS)
            driver
        }
    }

    safari {
        driver = {
            driver = new SafariDriver()
            driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS)
            driver
        }
    }


    remote_ios {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "iPhone Simulator");
        capabilities.setCapability("version", "6.1");
        capabilities.setCapability("app", "safari");
        driver = {
            remoteDriver = new RemoteWebDriver(remoteUrl, capabilities);
            remoteDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
            remoteDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            remoteDriver
        }
    }


    remote_android{
        chromeDriver = new File('src/test/resources/osx/chromedriver')
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Google Nexus 5");
        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().window().setSize(new Dimension(360,640));
        driver
    }


    remote_ios_with_chromedriver{
        chromeDriver = new File('src/test/resources/osx/chromedriver')
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Apple iPhone 6");
        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().window().setSize(new Dimension(375,677));
        driver
    }



}