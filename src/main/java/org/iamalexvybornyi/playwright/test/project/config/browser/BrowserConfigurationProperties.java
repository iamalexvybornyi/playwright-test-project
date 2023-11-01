package org.iamalexvybornyi.playwright.test.project.config.browser;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class BrowserConfigurationProperties {

    @NonNull
    private String name;

    @Nullable
    private Resolution resolution;

    @NonNull
    private Boolean maximized;

    @NonNull
    private Boolean headless;

    @Getter
    @Setter
    public static class Resolution {
        private Integer width;
        private Integer height;
    }
}
