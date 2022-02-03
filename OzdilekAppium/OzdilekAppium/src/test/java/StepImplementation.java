import com.google.common.collect.ImmutableMap;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StepImplementation extends BaseTest {
    FluentWait<WebDriver> wait;
    Logger logger = LogManager.getLogger(StepImplementation.class);


    @Step("Wait for defined second <time>")
    public void waitForseconds(int time) throws InterruptedException {
        Thread.sleep(time * 1000);
    }

    @Step("id <id> Click on the element")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();

    }

    @Step("xpath <xpath> Click on the element")
    public void clickByXpath(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();

    }

    @Step("Scroll the page <x> <y> <endX> <endY> <duration>")
    public void swipe(int startX, int startY, int endX, int endY, int msDuration) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(msDuration)))
                .moveTo(PointOption.point(endX, endY))
                .release();

        touchAction.perform();
    }



    @Step("id <id> Find the element <text> Enter the value")
    public void sendkeysByid(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);

    }
    @Step("Find element by id <id> and then check the text <text>")
    public void textAreacontrolId(String id, String text) {
        Assert.assertTrue("Text doesn't exist",
                appiumDriver.findElement(By.id(id)).getText().contains(text));
    }



    @Step("Click index2 from list <list>")
    public void clickIndexFromLıst(String xpath){
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        products.get(1).click();
    }



    @Step("Find element by <xpath> and then check the inside of <text>")
    public void textAreaControlXpath(String xpath, String text){
        Assert.assertTrue("Text doesn't exist",

                appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
    }



    @Step("Select element from <xpath> and click it randomly")
    public void clickRandomElement(String xpath) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index5 = random.nextInt(products.size());
        products.get(index5).click();
    }





}
