package StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    private static String driverPath = "/Users/arpitarajpurohit/Downloads/chromedriver";

    public static WebDriver driver=null;

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public WebDriver getWebDriver() {
        return getWebDriver(false);
    }

    public WebDriver getWebDriver(boolean createNew) {
        if (driver == null || createNew) {
            driver = getChromeDriver();
        }
        return driver;
    }

    private void waitForLoading(int time) {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(time));
    }


    @Given("^login page is launched$")
    public void theURLPageIsLaunched() {
        getWebDriver().get("https://secure-sandbox.modulrfinance.com/");
        waitForLoading(2000);
    }

    @When("^user enters username$")
    public void usernameProvided() {
        WebElement emailField = getWebDriver().findElement(By.xpath("//*[@id=\"username-inp\"]"));
        emailField.click();
        emailField.sendKeys("Arpita.Rajpurohit45");
    }

    @And("^user enters password$")
    public void passwordProvided() {
        WebElement passwordField = getWebDriver().findElement(By.xpath("//*[@id=\"password-inp\"]"));
        passwordField.click();
        passwordField.sendKeys("Helloworld1*");
    }

    @And("^click on sign in button$")
    public void clickOnSignInButton() {
        WebElement signInSubmitButton = getWebDriver().findElement(By.xpath("//*[@id=\"signInSubmitButton\"]"));
        signInSubmitButton.click();
        waitForLoading(2000);
    }

    @And("^account overview page should display$")
    public void accountOverviewPageShouldDisplay() {
        WebElement overview = getWebDriver().findElement(By.cssSelector(".text-display"));
        assertTrue(overview.isDisplayed());
    }

    @Then("^inline error message should displayed$")
    public void thisFieldIsRequiredErrorMessageShouldDisplayed() {
        WebElement thisFieldIsRequiredErrorMessage = getWebDriver().findElement(By.cssSelector("div.alert.alert-danger.ng-star-inserted"));
        assertTrue(thisFieldIsRequiredErrorMessage.isDisplayed());
    }

    @And("^error3 message “The username or password is incorrect. Multiple incorrect sign-ins could result in your access being locked. If this does happen, you'll receive an email explaining how to reset your access”$")
    public void error3MessageTheUsernameOrPasswordIsIncorrectMultipleIncorrectSignInsCouldResultInYourAccessBeingLockedIfThisDoesHappenYouLlReceiveAnEmailExplainingHowToResetYourAccessShouldDisplayed() {
        WebElement error3 = getWebDriver().findElement(By.xpath("/html/body/app-root/app-signin/div/div/div[2]/div/form/div[3]"));
        assertTrue(error3.isDisplayed());
        error3.sendKeys("The username or password is incorrect. Multiple incorrect sign-ins could result in your access being locked. If this does happen, you'll receive an email explaining how to reset your access");
    }

    @And("^click on reset password link$")
    public void clickOnResetPasswordLink() {
        getWebDriver().findElement(By.xpath("//*[@id=\"forgotPasswordHref\"]")).click();
    }

    @When("^navigate to ‘Reset access’$")
    public void navigateToResetAccess() {
        getWebDriver().findElements(By.id("signInHeading"));
    }

    @And("^enters username$")
    public void entersUsername() {
        WebElement emailField1 = getWebDriver().findElement(By.xpath("//*[@id=\"usernameInput\"]"));
        emailField1.click();
        emailField1.sendKeys("Arpita.Rajpurohit45");
    }

    @Then("^click ‘reset password link’$")
    public void clickResetPasswordLink() {
        getWebDriver().findElement(By.xpath("//*[@id=\"signInSubmitButton\"]")).click();
    }

    @And("^reset password confirmation message should be displayed$")
    public void resetPasswordConfirmationMessageShouldBeDisplayed() {
        WebElement actualMessage = getWebDriver().findElement(By.xpath("//*[@id=\"emailSentSubheading\"]"));
        assertTrue(actualMessage.isDisplayed());
    }
}
