package io.qaguru.eroshenkoam;

import org.junit.jupiter.api.Test;

public class GitHubIssueTestAnnotation extends TestBase{
    public  BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";

    @Test
    public void testIssueSearch(){
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssues();
        steps.issueSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
