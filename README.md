# playwright-test-project

This is a test automation project using Playwright, Java, JUnit5, and Spring. It also has logging and Allure reports support.
JUnit's in-built features are used for running tests in parallel.

## The structure of the project
1. Page objects are located inside `org.iamalexvybornyi.playwright.test.project.page`
2. Action classes are located inside `org.iamalexvybornyi.playwright.test.project.action` and use page objects inside of them
3. Action classes are used inside of tests
4. The code configuration of the browser is located under `org.iamalexvybornyi.playwright.test.project.config.browser`
5. The classes for common configuration are located under `org.iamalexvybornyi.playwright.test.project.config`
6. There a few util classes located under `org.iamalexvybornyi.playwright.test.project.util`
7. The configuration of the JUnit platform is located under `junit-platform.properties` (currently, it is set up to run 5 tests are run in parallel)
8. The parameters of the browser and the environment are configured using `application.yaml` and environment-related `application-*.yaml` files

## How to run the tests
To start the tests using cmd just run the following command:
```sh
mvn clean test
```

To run the particular set of tests just use the `-Dtest` parameter. The command will look like the following:
```sh
 mvn clean test -Dtest="org.iamalexvybornyi.playwright.test.project.NavigationTest"
```
