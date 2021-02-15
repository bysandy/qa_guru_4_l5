package io.qaguru.eroshenkoam;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.parameter;

public class GitHubIssueTestAnnotation extends TestBase{
    public  BaseSteps steps = new BaseSteps();

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "bysandy/qa_guru_4_l5";
    private static final String ISSUE_NUMBER = "#3";

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

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssues();
        steps.issueSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
