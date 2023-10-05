package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.model.Account;
import com.iamalexvybornyi.playwright.test.project.page.LoginPage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginAction {

    @NonNull
    private final Driver driver;
    @NonNull
    private final LoginPage loginPage;

    public void signUp(@NonNull Account account) {
        log.info("Signing up user with the following details: {}", account);
        log.info("Filling in the required form fields");
        this.driver.getLocator(this.loginPage.getDisplayNameInput()).fill(account.getDisplayName());
        this.driver.getLocator(this.loginPage.getSignUpEmailInput()).fill(account.getEmail());
        this.driver.getLocator(this.loginPage.getSignUpPasswordInput()).fill(account.getPassword());
        this.driver.getLocator(this.loginPage.getConfirmPasswordInput()).fill(account.getPassword());
        log.info("Clicking the sign up button");
        this.driver.getLocator(this.loginPage.getSignUpButton()).click();
    }

    public void signIn(@NonNull Account account) {
        log.info("Signing in user with the following details: {}", account);
        log.info("Filling in the required form fields");
        this.driver.getLocator(this.loginPage.getSignInEmailInput()).fill(account.getEmail());
        this.driver.getLocator(this.loginPage.getSignInPasswordInput()).fill(account.getPassword());
        log.info("Clicking the sign in button");
        this.driver.getLocator(this.loginPage.getSignInButton()).click();
    }
}
