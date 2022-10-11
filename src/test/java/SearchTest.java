import com.iamalexvybornyi.playwright.test.project.page.HomePage;
import com.iamalexvybornyi.playwright.test.project.page.LoginPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchTest extends BaseTest {

    @Autowired
    private HomePage homePage;
    @Autowired
    private LoginPage loginPage;

    @Test
    public void loginWithExistingAccount21() {
        this.driver.get().getLocator(homePage.getSignInLink()).click();
        this.driver.get().getLocator(loginPage.getAlreadyHaveAnAccountHeader()).click();
    }

    @Test
    public void loginWithExistingAccount22() {
        this.driver.get().getLocator(homePage.getSignInLink()).click();
        this.driver.get().getLocator(loginPage.getAlreadyHaveAnAccountHeader()).click();
    }
}
