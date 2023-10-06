package com.iamalexvybornyi.playwright.test.project.config;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import io.qameta.allure.Allure;
import lombok.NonNull;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayInputStream;
import java.util.Optional;

public class CustomTestWatcher implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        getDriver(context).quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        getDriver(context).quit();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        getDriver(context).quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.addAttachment(context.getDisplayName(),
                new ByteArrayInputStream(getDriver(context).getPage().get().screenshot()));
        getDriver(context).quit();
    }

    @NonNull
    private Driver getDriver(@NonNull ExtensionContext context) {
        final ApplicationContext applicationContext = SpringExtension.getApplicationContext(context);
        return applicationContext.getBean(Driver.class);
    }
}
