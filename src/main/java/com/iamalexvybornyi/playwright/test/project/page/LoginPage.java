package com.iamalexvybornyi.playwright.test.project.page;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class LoginPage implements Page {
    private final String alreadyHaveAnAccountHeader = "//div/h2[contains(text(), 'Already have an account?')]";
    private final String displayNameInput = "//input[@name='displayName']";
    private final String emailInput = "//div[./span[contains(text(), 'Sign up with your email and password')]]//input[@name='email']";
    private final String passwordInput = "//div[./span[contains(text(), 'Sign up with your email and password')]]//input[@name='password']";
    private final String confirmPasswordInput = "//div[./span[contains(text(), 'Sign up with your email and password')]]//input[@name='confirmPassword']";
    private final String signUpButton = "//button[@type='submit' and contains(text(), 'Sign Up')]";
}
