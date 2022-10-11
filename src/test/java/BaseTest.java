import com.iamalexvybornyi.playwright.test.project.config.CommonConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.DriverConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.UrlConfiguration;
import com.iamalexvybornyi.playwright.test.project.config.browser.driver.Driver;
import com.iamalexvybornyi.playwright.test.project.util.TestDataGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {CommonConfiguration.class, DriverConfiguration.class})
public class BaseTest {

    @Autowired
    protected ThreadLocal<Driver> driver;

    @Autowired
    protected UrlConfiguration urlConfiguration;

    @Autowired
    protected TestDataGenerator testDataGenerator;

    @BeforeEach
    void createContextAndPage() {
        driver.get().start();
        driver.get().getPage().get().navigate(urlConfiguration.getHome());
    }

    @AfterEach
    void closeContext() {
        driver.get().getContext().get().close();
    }

    @AfterAll
    public void tearDown() {
        driver.get().getPlaywright().get().close();
        driver.remove();
    }

}
