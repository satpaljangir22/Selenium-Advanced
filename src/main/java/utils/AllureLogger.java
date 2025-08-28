package utils;

import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class AllureLogger {

    private final Logger logger;

    private AllureLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public static AllureLogger getLogger(Class<?> clazz) {
        return new AllureLogger(clazz);
    }

    private void logToAllure(String level, String message) {
        String formatted = String.format("[%s] %s", level, message);
        Allure.addAttachment("Log", "text/plain",
                new ByteArrayInputStream(formatted.getBytes()), ".txt");
    }

    public void info(String message) {
        logger.info(message);
        logToAllure("INFO", message);
    }

    public void debug(String message) {
        logger.debug(message);
        logToAllure("DEBUG", message);
    }

    public void warn(String message) {
        logger.warn(message);
        logToAllure("WARN", message);
    }

    public void error(String message, Throwable t) {
        logger.error(message, t);
        logToAllure("ERROR", message + "\n" + t.getMessage());
    }
}
