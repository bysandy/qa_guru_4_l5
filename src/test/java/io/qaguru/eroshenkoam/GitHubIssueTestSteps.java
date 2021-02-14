package io.qaguru.eroshenkoam;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class GitHubIssueTestSteps extends TestBase{

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";

    @Test
    @Link(name = "Base URL", value = BASE_URL)
    @Owner("tryfanauLV")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("critical")})
    @Feature("Issues")
    @Story("Search Issue in already existed repository")
    @DisplayName("Search Issue by number in repository")
    public void testIssueSearch(){
        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);

        step("Open github.com", ()-> {
            open(BASE_URL);
        });

        step("Search " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Open the repository " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Tap on the Issues", ()-> {
            $(withText("Issues")).click();
        });

        step("Check that the issue " + ISSUE_NUMBER + " exist",() -> {
            $(withText(ISSUE_NUMBER)).should(Condition.exist);
        });
    }

}
