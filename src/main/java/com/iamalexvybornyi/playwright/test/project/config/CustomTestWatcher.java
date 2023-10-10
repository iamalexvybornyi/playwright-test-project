package com.iamalexvybornyi.playwright.test.project.config;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.util.GlobalKeys;
import io.qameta.allure.Allure;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.MDC;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Slf4j
public class CustomTestWatcher implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        attachLogsToAllureReport(context);
        getDriver(context).quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        attachLogsToAllureReport(context);
        getDriver(context).quit();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        attachLogsToAllureReport(context);
        getDriver(context).quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        attachLogsToAllureReport(context);
        Allure.addAttachment(context.getRequiredTestMethod().getName() + "-screenshot",
                new ByteArrayInputStream(getDriver(context).getPage().get().screenshot()));
        getDriver(context).quit();
    }

    @NonNull
    private Driver getDriver(@NonNull ExtensionContext context) {
        final ApplicationContext applicationContext = SpringExtension.getApplicationContext(context);
        return applicationContext.getBean(Driver.class);
    }

    private void attachLogsToAllureReport(@NonNull ExtensionContext context) {
        final File logFile = new File(String.format("./target/logs/%s.log", MDC.get(GlobalKeys.TEST_ID.getKey())));
        byte[] logFileAsBytes;
        try {
            logFileAsBytes = FileUtils.readFileToByteArray(logFile);
            Allure.addAttachment(context.getRequiredTestMethod().getName() + "-log",
                    new ByteArrayInputStream(logFileAsBytes));
        } catch (IOException e) {
            log.error("Couldn't attach log file to the allure report");
            throw new RuntimeException(e);
        }
    }
}
