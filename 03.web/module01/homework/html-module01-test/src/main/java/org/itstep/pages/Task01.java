package org.itstep.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * Sample page
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
public class Task01 extends Page {

  @FindBy(tagName = "h1")
  private WebElement header;

  @FindBy(css="body > p:nth-child(6)")
  private WebElement italicParagraph;

  public static final String FILE_NAME = "task01.html";

  public Task01(WebDriver webDriver) {
    super(webDriver);
    log.debug("Crate HomePage");
  }
}
