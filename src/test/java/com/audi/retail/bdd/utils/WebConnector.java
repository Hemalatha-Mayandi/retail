package com.audi.retail.bdd.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
public class WebConnector {

	// Browser to be used
		public enum Browsers {
			Firefox, Chrome, InternetExplorer
		};
		
		public static WebDriver driver;
		
		private static Map<Browsers, WebDriver> drivers = new HashMap<Browsers, WebDriver>();
		
		private static WebConnector webConnectorInstance;
		
		private static final Logger LOG = LoggerFactory.getLogger(WebConnector.class); 
		
		public WebConnector() {
			PageFactory.initElements(driver, this);
		}
		
		/**
		 * Singleton pattern to get the WebConnector Instance
		 *
		 * @return instance
		 */
		public static WebConnector getInstance() {
			if (webConnectorInstance == null) {
				 webConnectorInstance = new WebConnector();
			}

			return webConnectorInstance;
		}
		
		public static void initialiseDriver(Browsers browser) {
			switch (browser) {
			case Firefox: {
				if (drivers.get(Browsers.Firefox) == null) {
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setPlatform(Platform.ANY);
					capabilities.setJavascriptEnabled(true);
					drivers.put(Browsers.Firefox, new FirefoxDriver(capabilities));
					//log.info("opening browser Firefox");
				}
				driver = drivers.get(Browsers.Firefox);
				driver.manage().window().maximize();
				break;
			}
			case Chrome: {
				if (drivers.get(Browsers.Chrome) == null) {
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();

					capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
					capabilities.setCapability("chrome.switches", Arrays.asList("--disable-logging"));
					//HashMap<String, String> chromePreferences = new HashMap<>();
					//chromePreferences.put("profile.password_manager_enabled", "false");
					//capabilities.setCapability("chrome.prefs", chromePreferences);
					 ChromeDriverManager.getInstance().setup();
					drivers.put(Browsers.Chrome, new ChromeDriver(capabilities));
					//log.info("opening browser Chrome");
				}
				driver = drivers.get(Browsers.Chrome);
				driver.manage().window().maximize();
				break;
			}
			case InternetExplorer:
				if (drivers.get(Browsers.InternetExplorer) == null) {
					InternetExplorerDriverManager.getInstance().setup();
					drivers.put(Browsers.InternetExplorer, new InternetExplorerDriver());
					//log.info("opening browser InternetExplorer");
				}
				driver = drivers.get(Browsers.InternetExplorer);
				driver.manage().window().maximize();
				break;
			}
		}
		
		
}
