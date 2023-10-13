package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.model.Account;
import com.iamalexvybornyi.playwright.test.project.page.LoginPage;
import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginAction {
    @NonNull
    private final LoginPage loginPage;

    @Step("Sign up")
    public void signUp(@NonNull Account account) {
        log.info("Signing up user with the following details: {}", account);
        log.info("Filling in the required form fields");
        loginPage.getDisplayNameInput().fill(account.getDisplayName());
        loginPage.getSignUpEmailInput().fill(account.getEmail());
        loginPage.getSignUpPasswordInput().fill(account.getPassword());
        loginPage.getConfirmPasswordInput().fill(account.getPassword());
        log.info("Clicking the sign up button");
        loginPage.getSignUpButton().click();
    }

    @Step("Sign in")
    public void signIn(@NonNull Account account) {
        log.info("Signing in user with the following details: {}", account);
        log.info("Filling in the required form fields");
        loginPage.getSignInEmailInput().fill(account.getEmail());
        loginPage.getSignInPasswordInput().fill(account.getPassword());
        log.info("Clicking the sign in button");
        loginPage.getSignInButton().click();
    }
}
