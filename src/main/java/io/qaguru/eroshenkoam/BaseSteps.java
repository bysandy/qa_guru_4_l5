package io.qaguru.eroshenkoam;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {
    private static final String BASE_URL = "https://github.com";

    @Step("Open github.com")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Search {repository}")
    public void searchForRepository(final String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Open the repository {repository}")
    public void goToRepositoryFromSearch(final String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Tap on the Issues")
    public void openRepositoryIssues() {
        $(withText("Issues")).click();
    }

    @Step("Check that the issue {number} exist")
    public void issueSeeIssueWithNumber(final String number) {
        $(withText(number)).should(Condition.visible);
    }
}
