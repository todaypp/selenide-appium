package org.selenide.examples.appium;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractApiDemosTest {
  @BeforeEach
  void setUp() {
    closeWebDriver();
    Configuration.browserSize = null;
    Configuration.browser = AndroidDriverWithDemos.class.getName();
    open();
  }
}
