package org.qacademy.core.ui;

import org.openqa.selenium.WebDriver;

@FunctionalInterface
public interface Browser {

    WebDriver getBrowser();
}
