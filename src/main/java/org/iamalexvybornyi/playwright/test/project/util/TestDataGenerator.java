package org.iamalexvybornyi.playwright.test.project.util;

import com.github.javafaker.Faker;
import org.iamalexvybornyi.playwright.test.project.model.Account;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestDataGenerator {

    private final Faker faker;

    @NonNull
    public String generateUsername() {
        return faker.name().username();
    }

    @NonNull
    public String generateRandomEmail(@NonNull Integer length, @NonNull String domain) {
        return StringUtils.join(faker.lorem().characters(length), "@", domain);
    }

    @NonNull
    public String generatePassword() {
        return faker.internet().password(8, 30, true, true, true);
    }

    @NonNull
    public Account generateAccount() {
        String username = this.generateUsername();
        String email = this.generateRandomEmail(10, "mail.com");
        String password = this.generatePassword();
        return new Account(username, email, password);
    }
}
