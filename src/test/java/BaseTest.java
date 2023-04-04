import com.iamalexvybornyi.playwright.test.project.action.NavigationAction;
import com.iamalexvybornyi.playwright.test.project.config.CommonConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.DriverConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.UrlConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.util.TestDataGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = {CommonConfiguration.class, DriverConfiguration.class})
public class BaseTest {

    @Autowired
    protected ThreadLocal<Driver> driver;
    @Autowired
    protected UrlConfiguration urlConfiguration;
    @Autowired
    protected TestDataGenerator testDataGenerator;
    @Autowired
    protected NavigationAction navigationAction;

    @BeforeEach
    void createContextAndPage() {
        driver.get().start();
        navigationAction.navigateToUrl(urlConfiguration.getHome(), urlConfiguration.getHome());
    }

    @AfterEach
    void closeContext() {
        driver.get().getPage().get().close();
        driver.get().getBrowser().get().close();
        driver.get().getContext().get().close();
        driver.get().getPlaywright().get().close();
        driver.remove();
    }

}
