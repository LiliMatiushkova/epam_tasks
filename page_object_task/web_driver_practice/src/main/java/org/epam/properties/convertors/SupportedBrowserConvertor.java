package org.epam.properties.convertors;

import org.epam.enumeration.SupportedBrowsers;

public class SupportedBrowserConvertor {

    public static SupportedBrowsers valueOfWebBrowser(String webBrowserName) {
        return switch (webBrowserName) {
            case "chrome" -> SupportedBrowsers.CHROME;
            case "firefox" -> SupportedBrowsers.FIREFOX;
            default -> throw new IllegalArgumentException(
                    "This type of the browser is not supported");
        };
    }
}
