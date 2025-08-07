package com.selenium.ui.browser;

import com.selenium.connectors.JsonConnector;
import com.selenium.ui.helper.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import static com.selenium.ui.browser.DriverType.*;
import static org.openqa.selenium.remote.CapabilityType.PROXY;


public class DriverFactoryManager {

    private  static Logger logger = LoggerHelper.getLogger(DriverFactoryManager.class);
    private RemoteWebDriver driver;

    private DriverType selectedDriverType;
    public  String v_browserVersion;
    public  String v_os;
    public  String v_osVersion;
    public  String v_deviceName;

    //Change your browserstack credentials here if needed. After https add your username + token , do not make any changes to HUB
    public static final String URL = "https://" + "ankitbansal_f9sUOX" + ":" + "EZWvm7Y2szy8xg3oSvUs" + "@hub-cloud.browserstack.com/wd/hub";


    public String useGridVariable = System.getProperty("useGrid");
    private final boolean apiInstance = Boolean.valueOf(JsonConnector.getConfig("apiInstance")!=null?JsonConnector.getConfig("apiInstance"):"false");
    private final boolean proxyEnabled = Boolean.getBoolean("proxyEnabled");


    public DriverFactoryManager(String  browserName, String browserVersion,String os,String osVersion,String deviceName) {
        logger.debug("Default browser type is Chrome. For other options reset the value in config.json");
        DriverType driverType = WEBDRIVERMANAGERCHROME;

        try {
            driverType = valueOf(browserName);

        } catch (IllegalArgumentException ignored) {
            logger.error("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            logger.error("No driver specified, defaulting to '" + driverType + "'...");
        }
        selectedDriverType = driverType;

        v_browserVersion=browserVersion;
        v_os=os;
        v_osVersion=osVersion;
        v_deviceName=deviceName;
    }

    public RemoteWebDriver getDriver(){


        if (driver == null) {
            instantiateWebDriver(selectedDriverType,v_browserVersion,v_os,v_osVersion,v_deviceName);
        }
        return driver;
    }
    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    private void instantiateWebDriver(DriverType browserName,String browserVersion,String os,String osVersion,String deviceName){
        boolean crossBrowser =  Boolean.parseBoolean(useGridVariable);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if (proxyEnabled) {
            //code for if proxy enabled
            desiredCapabilities.setCapability(PROXY, "");
        }
        if (crossBrowser) {
            URL seleniumGridURL = null;
            try {
                seleniumGridURL = new URL(URL);
            }catch (MalformedURLException e){
                logger.error("Exception in the url formed "+e.getMessage());
            }
            //Browserstack capabilities
            desiredCapabilities.setCapability("browserName", browserName);
            desiredCapabilities.setCapability("browserVersion", browserVersion);
            desiredCapabilities.setCapability("os", os);
            desiredCapabilities.setCapability("osVersion", osVersion);
            desiredCapabilities.setCapability("deviceName", deviceName);
            desiredCapabilities.setCapability("local", "false");


            driver = new RemoteWebDriver(seleniumGridURL, desiredCapabilities);
        } else if(apiInstance) {
            logger.info("Api Execution is initiated");
        } else {
            driver = browserName.getWebDriverObject(desiredCapabilities);
        }
    }

}
