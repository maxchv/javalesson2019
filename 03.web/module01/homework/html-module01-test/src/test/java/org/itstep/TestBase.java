package org.itstep;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.jcabi.w3c.ValidatorBuilder;

import org.itstep.pages.Task01;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import nu.validator.messages.MessageEmitter;
import nu.validator.messages.MessageEmitterAdapter;
import nu.validator.messages.TextMessageEmitter;
import nu.validator.servlet.imagereview.ImageCollector;
import nu.validator.source.SourceCode;
import nu.validator.validation.SimpleDocumentValidator;
import nu.validator.xml.SystemErrErrorHandler;

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

  @Test
  public void validateNvuHtml() throws Exception {
    var path = getPath();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    SourceCode sourceCode = new SourceCode();
    ImageCollector imageCollector = new ImageCollector(sourceCode);
    boolean showSource = false;
    MessageEmitter emitter = new TextMessageEmitter(out, false);
    Pattern pattern = Pattern.compile("");
    MessageEmitterAdapter errorHandler = new MessageEmitterAdapter(pattern, sourceCode, showSource, imageCollector, 0,
        false, emitter);

    errorHandler.setErrorsOnly(true);

    SimpleDocumentValidator validator = new SimpleDocumentValidator();
    validator.setUpMainSchema("http://s.validator.nu/html5-rdfalite.rnc", new SystemErrErrorHandler());
    validator.setUpValidatorAndParsers(errorHandler, true, false);
    // validator.checkHtmlInputSource(new InputSource(in));
    validator.checkHtmlFile(path.toFile(), true);
    errorHandler.end("Ok", "Fails", "ru");

    if (0 != errorHandler.getErrors()) {
      byte[] buff = out.toByteArray();
      String s = new String(buff, "utf-8");
      fail("Not valid html " + s);
    }
  }

  private Path getPath() {
    return Paths.get(baseUrl.replace("file:///", ""), Task01.FILE_NAME);
  }

  @Test
  public void validateW3c() throws IOException {
    var path = getPath();
    var result = new ValidatorBuilder().html().validate(Files.readString(path));
    if (!result.valid()) {
      var err = result.errors().stream().map(d -> "Line: " + d.line() + ": " + d.message() + ", " + d.explanation())
          .collect(Collectors.joining("\n"));
      fail("Not valid html: " + err);
    }
  }
}
