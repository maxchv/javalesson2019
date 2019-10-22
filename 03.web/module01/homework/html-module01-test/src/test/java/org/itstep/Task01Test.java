package org.itstep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.itstep.pages.Task01;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import nu.validator.messages.MessageEmitter;
import nu.validator.messages.MessageEmitterAdapter;
import nu.validator.messages.TextMessageEmitter;
import nu.validator.servlet.imagereview.ImageCollector;
import nu.validator.source.SourceCode;
import nu.validator.validation.SimpleDocumentValidator;
import nu.validator.xml.SystemErrErrorHandler;

public class Task01Test extends TestBase {

  private Task01 homepage;

  @BeforeEach
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, Task01.class);
  }

  @Test
  public void headerEquals() {
    driver.get(baseUrl + Task01.FILE_NAME);
    assertEquals("Romeo and Juliet", homepage.getHeader().getText());
  }

  @Test
  public void headerCenter() {
    driver.get(baseUrl + Task01.FILE_NAME);
    assertEquals("center", homepage.getHeader().getCssValue("text-align"));
  }

  @Test
  public void italicText() {
    driver.get(baseUrl + Task01.FILE_NAME);
    assertEquals("italic", homepage.getItalicParagraph().getCssValue("font-style"));
  }

  public boolean validateHtml(Path path) throws Exception {
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
    errorHandler.end("Ok", "Fails", "en");
    byte[] buff = out.toByteArray();
    String s = new String(buff, "utf-8");
    System.out.println(s);
    return 0 == errorHandler.getErrors();
  }

  @Test
  public void validate() throws IOException, Exception {
    var path = Paths.get(baseUrl.replace("file:///", ""), Task01.FILE_NAME);
    if (!validateHtml(path)) {
      fail("Not valid html");
    }
  }
}
