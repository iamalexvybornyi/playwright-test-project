import org.junit.jupiter.api.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void navigateToShop() {
        navigationAction.navigateToUrl(urlConfiguration.getShop(), urlConfiguration.getShop());
    }

    @Test
    public void navigateToSignIn() {
        navigationAction.navigateToUrl(urlConfiguration.getAuth(), urlConfiguration.getAuth());
    }

    @Test
    public void navigateToHome() {
        navigationAction.navigateToUrl(urlConfiguration.getHome(), urlConfiguration.getHome());
    }
}
