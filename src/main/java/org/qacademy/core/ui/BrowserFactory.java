package org.qacademy.core.ui;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

public final class BrowserFactory {

    private static final Map<DriverType, Supplier<Browser>> BROWSERS = new EnumMap<>(DriverType.class);
    static {
        BROWSERS.put(DriverType.CHROME, Chrome::new);
    }

    private BrowserFactory() {
    }

    public static WebDriver getDriverManager(final DriverType driverType) {
        return BROWSERS.getOrDefault(driverType, Chrome::new).get().getBrowser();
    }
}
