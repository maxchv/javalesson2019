package org.itstep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.itstep.pages.Task01;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;


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

 
}
