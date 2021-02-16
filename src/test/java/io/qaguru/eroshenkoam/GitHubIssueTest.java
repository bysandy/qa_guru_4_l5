package io.qaguru.eroshenkoam;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueTest extends TestBase {
    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "bysandy/qa_guru_4_l5";
    private static final String ISSUE_NUMBER = "#3";

    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        // Open github.com
        open(BASE_URL);
        // Fill in the search field  bysandy/qa_guru_4_l5
        // Tap on the Search button
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        // Select result that identical to search string
        // Open the repository
        $(By.linkText(REPOSITORY)).click();
        // Tap on the Issues
        $(withText("Issues")).click();
        // Check that the issue #3 exist
        $(withText(ISSUE_NUMBER)).should(Condition.exist);

    }

}
