package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.AttachManager;
import utils.Credentionlmpl;
import utils.SystemProperty;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp() {
        final String login = Credentionlmpl.getCredConfig().getLogin();
        final String password = Credentionlmpl.getCredConfig().getPassword();
        final String remoteUrl = SystemProperty.readProperty();

        final String selenoidUrl = String.format("https://%s:%s@%s", login, password, remoteUrl);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("89.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = selenoidUrl + "/wd/hub/";
    }

    @AfterEach
    void attachDetailsToReport() {
        String sessionId = AttachManager.getSessionId();

        AttachManager.screenshotAs("Last screenshot");
        AttachManager.pageSource();
        AttachManager.browserConsoleLogs();
        closeWebDriver();
        AttachManager.addVideo(sessionId);
    }
}