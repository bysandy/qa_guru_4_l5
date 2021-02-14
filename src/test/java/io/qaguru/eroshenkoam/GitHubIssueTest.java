package io.qaguru.eroshenkoam;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#68";

    @Test
    public void testIssueSearch(){
        // Open github.com
        open("https://github.com");
        // Fill in the search field  eroshenkoam/allure-example
        // Tap on the Search button
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        // Select result that identical to search string
        // Open the repository
        $(By.linkText(REPOSITORY)).click();
        // Tap on the Issues
        $(withText("Issues")).click();
        // Check that the issue #68 exist
        $(withText(ISSUE_NUMBER)).should(Condition.exist);

    }

}
