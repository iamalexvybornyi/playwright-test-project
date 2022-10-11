package com.iamalexvybornyi.playwright.test.project.model;

import lombok.*;

@AllArgsConstructor
@Getter
public class Account {

    @NonNull
    private final String displayName;

    @NonNull
    private final String email;

    @NonNull
    private final String password;
}
