package com.iamalexvybornyi.playwright.test.project.action;

import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.model.Account;
import com.iamalexvybornyi.playwright.test.project.page.LoginPage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginAction {

    @NonNull
    private final ThreadLocal<Driver> driver;
    @NonNull
    private final LoginPage loginPage;

    public void signUp(@NonNull Account account) {
        this.driver.get().getLocator(this.loginPage.getDisplayNameInput()).type(account.getDisplayName());
        this.driver.get().getLocator(this.loginPage.getSignUpEmailInput()).type(account.getEmail());
        this.driver.get().getLocator(this.loginPage.getSignUpPasswordInput()).type(account.getPassword());
        this.driver.get().getLocator(this.loginPage.getConfirmPasswordInput()).type(account.getPassword());
        this.driver.get().getLocator(this.loginPage.getSignUpButton()).click();
    }

    public void signIn(@NonNull Account account) {
        this.driver.get().getLocator(this.loginPage.getSignInEmailInput()).type(account.getEmail());
        this.driver.get().getLocator(this.loginPage.getSignInPasswordInput()).type(account.getPassword());
        this.driver.get().getLocator(this.loginPage.getSignInButton()).click();
    }
}
