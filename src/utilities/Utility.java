package utilities;

import browserfactory.BaseTest;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {


    // This method will click on element

    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }


    // This method will get text from element

    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    //******************************* Alert Methods *************************************************//

    /**
     * This method will switch to alert
     */

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept to alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert() {

        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        System.out.println(textOnAlert);
        return textOnAlert;
    }

    public void sendKeysToAlert() {
        driver.switchTo().alert().sendKeys("Sweta");
    }

    //******************************* Select Methods *************************************************//

    /**
     * This method will select the option visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);

    }

    //******************************* Mouse Methods *************************************************//

    public void mouseHover(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHover).build().perform();
    }

    public void mouseHoverAndClick(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        Thread.sleep(2000);
        actions.moveToElement(mouseHover).click().build().perform();
    }

    //******************************* Assert verify Methods *************************************************//

    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);

    }

    public void verifyMessageText(String exceptedMessage, String actualMessage, @Nullable String errorMessage) {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);

    }
}
