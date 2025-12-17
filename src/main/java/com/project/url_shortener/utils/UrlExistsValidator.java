package com.project.url_shortener.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


public class UrlExistsValidator {
    private static final Logger log = LoggerFactory.getLogger(UrlExistsValidator.class);

    public static boolean doesUrlExist(String urlString) {
        try {
            log.info("Checking for url validity");
            URL url = new URI(urlString).toURL();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

            int responseCode = httpURLConnection.getResponseCode();
            return (responseCode >= 200 && responseCode < 400);
        } catch (Exception e) {
            log.error("Error while checking url {}: ", urlString, e);
            return false;
        }
    }


}
