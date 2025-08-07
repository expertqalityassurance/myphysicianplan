package com.selenium.ui.browser;

import com.selenium.ui.helper.ResourceHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;


public enum DriverType implements DriverSetup {
	
	CHROME {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourceHelper("/src/main/resources/chromedriver"));
			System.setProperty("webdriver.chrome.silentOutput", "true");
			HashMap<String, Object> chromePreferences = new HashMap<>();
			chromePreferences.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.merge(capabilities);
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--profile-directory=Profile 1");
			options.addArguments("user-data-dir=C:\\Users\\ADMIN\\AppData\\Local\\Google\\Chrome\\User Data");
			options.addArguments("--no-default-browser-check");
			options.addArguments("--silent");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			options.setExperimentalOption("prefs", chromePreferences);

			return new ChromeDriver(options);
		}
	},
	
	FIREFOX {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capabilities);
			options.setHeadless(HEADLESS);
			return new FirefoxDriver(options);
		}
		
	},
	
	SAFARI {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			// TODO Auto-generated method stub
			return null;
		}
		
	},
	
	API {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return null;
		}
		
	},

	WEBDRIVERMANAGERCHROME {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-default-browser-check");
			options.addArguments("--silent");
			options.addArguments("--start-maximized");
			options.addArguments("--remote-allow-origins=*");
			//options.addArguments("--remote-debugging-port=9222");
			//options.addArguments("--headless");
			//options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			//options.addArguments("--disable-gpu"); // applicable to windows os only
			//options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			return new ChromeDriver(options);
		}
	},

	WEBDRIVERMANAGERFIREFOX {
		public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments();
			return new FirefoxDriver();
		}
	};
	

public final static boolean HEADLESS = Boolean.getBoolean("headless");

}
