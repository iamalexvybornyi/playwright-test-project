package com.iamalexvybornyi.playwright.test.project;

import com.iamalexvybornyi.playwright.test.project.action.NavigationAction;
import com.iamalexvybornyi.playwright.test.project.config.CommonConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.CustomTestWatcher;
import com.iamalexvybornyi.playwright.test.project.config.UrlConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.util.GlobalKeys;
import com.iamalexvybornyi.playwright.test.project.util.TestDataGenerator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@ExtendWith(CustomTestWatcher.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {CommonConfiguration.class})
public class BaseTest {

    @Autowired
    protected Driver driver;
    @Autowired
    protected UrlConfiguration urlConfiguration;
    @Autowired
    protected TestDataGenerator testDataGenerator;
    @Autowired
    protected NavigationAction navigationAction;

    @BeforeEach
    protected void createContextAndPage(@NonNull TestInfo testInfo) {
        MDC.put(GlobalKeys.TEST_ID.getKey(), testInfo.getDisplayName());
        driver.start();
        navigationAction.navigateToUrl(urlConfiguration.getHome(), urlConfiguration.getHome());
    }

}
