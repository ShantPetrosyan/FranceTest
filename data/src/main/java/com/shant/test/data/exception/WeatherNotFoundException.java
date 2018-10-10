package com.shant.test.data.exception;

/**
 * Exception throw by the application when a Weather search can't return a valid result.
 */
public class WeatherNotFoundException extends Exception {
    public WeatherNotFoundException() {
        super();
    }
}
