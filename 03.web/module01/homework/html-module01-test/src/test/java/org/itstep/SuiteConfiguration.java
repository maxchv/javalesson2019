package org.itstep;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Loads test suite configuration from resource files.
 */
public class SuiteConfiguration {

  private static final String DEBUG_PROPERTIES = "/debug.properties";

  private Properties properties;

  public SuiteConfiguration() throws IOException {
    this(System.getProperty("application.properties", DEBUG_PROPERTIES));
  }

  public SuiteConfiguration(String fromResource) throws IOException {
    properties = new Properties();
    properties.load(SuiteConfiguration.class.getResourceAsStream(fromResource));
  }

  public Capabilities getCapabilities() throws IOException {
    String capabilitiesFile = properties.getProperty("capabilities");

    Properties capsProps = new Properties();
    capsProps.load(SuiteConfiguration.class.getResourceAsStream(capabilitiesFile));

    DesiredCapabilities capabilities = new DesiredCapabilities();
    for (String name : capsProps.stringPropertyNames()) {
      String value = capsProps.getProperty(name);
      if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
        capabilities.setCapability(name, Boolean.valueOf(value));
      } else if (value.startsWith("file:")) {
        capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
      } else {
        capabilities.setCapability(name, value);
      }
    }
    System.out.println("headless: " + getProperty("headless") );
    if (isHeadless()) {
      if (getProperty("driver.class").contains("FirefoxDriver")) {
        FirefoxBinary fb = new FirefoxBinary();
        fb.addCommandLineOptions("--headless");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setBinary(fb);
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, opt);
      }
      if (getProperty("driver.class").contains("ChromeDriver")) {
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, opt);
      }
    }

    return capabilities;
  }

  public boolean isHeadless() {
    return hasProperty("headless") && "true".equals(getProperty("headless"));
  }

  public boolean hasProperty(String name) {
    return properties.containsKey(name);
  }

  public String getProperty(String name) {
    return properties.getProperty(name);
  }

  private Class<? extends WebDriver> getWebdireverClass() {
    String className = getProperty("driver.class");
    Class<? extends WebDriver> driverClass = null;
    try {
      driverClass = (Class<? extends WebDriver>) Class.forName(className);
    } catch (ClassNotFoundException | ClassCastException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return driverClass;
  }

  public WebDriver getWebDriver() throws IOException {
    Class<? extends WebDriver> driverClass = getWebdireverClass();
    WebDriverManager.getInstance(getWebdireverClass()).setup();
    WebDriver driver = null;
    try {
      driver = driverClass.getDeclaredConstructor(Capabilities.class).newInstance(getCapabilities());
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
        | NoSuchMethodException | SecurityException e) {
      e.printStackTrace();
    }
    return driver;
  }
}
