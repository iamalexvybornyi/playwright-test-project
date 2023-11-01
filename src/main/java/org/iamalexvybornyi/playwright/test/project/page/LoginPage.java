package org.iamalexvybornyi.playwright.test.project.page;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class LoginPage extends BasePage implements Page {
    private final String alreadyHaveAnAccountHeader = "//div/h2[contains(text(), 'Already have an account?')]";
    private final String displayNameInput = "//input[@name='displayName']";
    private final String signUpEmailInput = "//div[./span[contains(text(), 'Sign up with your email and password')]]//input[@name='email']";
    private final String signInEmailInput = "//div[./span[contains(text(), 'Sign in with your email and password')]]//input[@name='email']";
    private final String signUpPasswordInput = "//div[./span[contains(text(), 'Sign up with your email and password')]]//input[@name='password']";
    private final String signInPasswordInput = "//div[./span[contains(text(), 'Sign in with your email and password')]]//input[@name='password']";
    private final String confirmPasswordInput = "//div[./span[contains(text(), 'Sign up with your email and password')]]//input[@name='confirmPassword']";
    private final String signUpButton = "//button[@type='submit' and contains(text(), 'Sign Up')]";
    private final String signInButton = "//button[@type='submit' and contains(text(), 'Sign In')]";
}
