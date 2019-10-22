package org.itstep;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

/**
 * Base class for all the JUnit-based test classes
 */
public abstract class TestBase {

  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  static SuiteConfiguration config;

  static {
    try {
      config = new SuiteConfiguration();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @BeforeAll
  public static void loadConfig() throws Throwable {
    baseUrl = config.getProperty("site.url");
    capabilities = config.getCapabilities();
  };

  @BeforeEach
  public void initDriver() throws Throwable {
    driver = config.getWebDriver();
  }

  @AfterEach
  public void tearDown() throws Throwable {
    if (driver != null) {
      driver.quit();
    }
  }
}
