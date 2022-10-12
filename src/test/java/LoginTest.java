import com.iamalexvybornyi.playwright.test.project.action.CommonAction;
import com.iamalexvybornyi.playwright.test.project.action.LoginAction;
import com.iamalexvybornyi.playwright.test.project.model.Account;
import com.iamalexvybornyi.playwright.test.project.page.HomePage;
import com.iamalexvybornyi.playwright.test.project.page.LoginPage;
import com.iamalexvybornyi.playwright.test.project.util.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginTest extends BaseTest {

    @Autowired
    private HomePage homePage;
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private LoginAction loginAction;
    @Autowired
    private CommonAction commonAction;
    @Autowired
    private TestDataGenerator testDataGenerator;

    @BeforeEach
    void goToAuthPage() {
        driver.getPage().get().navigate(urlConfiguration.getAuth());
    }

    @Test
    public void signUpWithNewAccount() {
        final Account account = testDataGenerator.generateAccount();
        this.loginAction.signUp(account);
        this.commonAction.verifySignOutLinkIsDisplayed();
    }

    @Test
    public void loginWithExistingAccount() {
        this.driver.getLocator(homePage.getSignInLink()).click();
        this.driver.getLocator(loginPage.getAlreadyHaveAnAccountHeader()).click();
    }
}
