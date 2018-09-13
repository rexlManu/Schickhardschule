package de.rexlmanu.vplanapi.misc;

import java.net.MalformedURLException;
import java.net.URL;

public enum Days {

    MONDAY("Montag", toUrl("https://www.schickhardtschule.de/susvertretung/montag.html")),
    TUESDAY("Dienstag", toUrl("https://www.schickhardtschule.de/susvertretung/dienstag.html")),
    WEDNESSDAY("Mittwoch", toUrl("https://www.schickhardtschule.de/susvertretung/mittwoch.html")),
    THURSDAY("Donnerstag", toUrl("https://www.schickhardtschule.de/susvertretung/donnerstag.html")),
    FRIDAY("Freitag", toUrl("https://www.schickhardtschule.de/susvertretung/freitag.html"));

    private String name;
    private URL url;

    Days(String name, URL url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public URL getUrl() {
        return url;
    }

    private static URL toUrl(String url){
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
