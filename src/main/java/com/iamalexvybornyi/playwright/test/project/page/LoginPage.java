package com.iamalexvybornyi.playwright.test.project.page;

import com.iamalexvybornyi.playwright.test.project.annotation.PageElement;
import com.iamalexvybornyi.playwright.test.project.page.core.Page;
import com.iamalexvybornyi.playwright.test.project.page.element.common.HeaderElement;
import com.microsoft.playwright.Locator;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class LoginPage implements Page {

    @PageElement(selector = "//div[@id='root']/div[1]")
    protected HeaderElement headerElement;

    @PageElement(selector = "//div/h2[contains(text(), 'Already have an account?')]")
    private Locator alreadyHaveAnAccountHeader;
    @PageElement(selector = "//input[@name='displayName']")
    private Locator displayNameInput;
    @PageElement(selector = "//div[./span[contains(text(), 'Sign up with your email and password')]]//input[@name='email']")
    private Locator signUpEmailInput;
    @PageElement(selector = "//div[./span[contains(text(), 'Sign in with your email and password')]]//input[@name='email']")
    private Locator signInEmailInput;
    @PageElement(selector = "//div[./span[contains(text(), 'Sign up with your email and password')]]//input[@name='password']")
    private Locator signUpPasswordInput;
    @PageElement(selector = "//div[./span[contains(text(), 'Sign in with your email and password')]]//input[@name='password']")
    private Locator signInPasswordInput;
    @PageElement(selector = "//div[./span[contains(text(), 'Sign up with your email and password')]]//input[@name='confirmPassword']")
    private Locator confirmPasswordInput;
    @PageElement(selector = "//button[@type='submit' and contains(text(), 'Sign Up')]")
    private Locator signUpButton;
    @PageElement(selector = "//button[@type='submit' and contains(text(), 'Sign In')]")
    private Locator signInButton;

}
