package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class Common {

    /**
    *The driver
     **/
    private final WebDriver driver;

    /**
     *Instant a new Common
     * @param driver the driver
     **/
    public Common(WebDriver driver) {
        this.driver = driver;
    }

    /**
    *Get a new url
    * @param url a new url to redirect
     **/
    public void getUrl(String url){
        driver.get(url);
    }

    /**
    *Click
    * @param element the element to be clicked
     **/
    public void click(By element){
        try{
            driver.findElement(element).click();
            System.out.println("The element was be clicked was: " + element );
        }catch(NoSuchElementException exception){
            System.err.println("Can't click the element: " + element + ". Error msg:" + exception.getMessage());
        }
    }
    /**
     *setTextWithEnter
     * @param element the element to be written
     * @param text the text to be written in the text field
     **/
    public void setTextWithEnter(By element, String text){
        try{
            driver.findElement(element).sendKeys(text);
            driver.findElement(element).sendKeys(Keys.ENTER);
            System.out.println("The element to be written is: " + element + " with the text: " + text);
        }catch(NoSuchElementException exception){
            System.err.println("Can't write in the element: " + element + ". Error msg:" + exception.getMessage());
        }
    }

    /**
     *getText
     * @param element the element to be written
     **/
    public String getText(By element){
        String text;
        try{
            text = driver.findElement(element).getText();
            System.out.println("The element to be select is: " + element + " with the text: " + text);
        }catch(NoSuchElementException exception){
            System.err.println("Can't write in the element: " + element + ". Error msg:" + exception.getMessage());
            text = " ";
        }
        return text;
    }


    /**
    * waitForElementImplicit
    * @param time to be wait in seconds
     **/
    public void waitForElementImplicit(int time){
        try{
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        }catch (Exception exception){
            System.err.println("Can't wait for: " + time + " seconds. Error msg:" + exception.getMessage());
        }
    }

    /**
     * waitForElementExplicit
     * @param element the element to be clicked
     * @param time to be waiting in seconds
     **/
    public void waitForElementExplicit(By element, int time){
        WebDriverWait webDriverWait = new WebDriverWait(driver,time);
        WebElement webElement = driver.findElement(element);
        try{
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        }catch (Exception exception){
            System.err.println("Can't wait for: " + time + " seconds. Error msg:" + exception.getMessage());
        }
    }
    /**
     * waitForElementExplicitVisible
     * @param element the element to be clicked
     * @param time to be waiting in seconds
     **/
    public void waitForElementExplicitVisible(By element, int time){
        WebDriverWait webDriverWait = new WebDriverWait(driver,time);
        try{
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }catch (Exception exception){
            System.err.println("Can't wait for: " + time + " seconds. Error msg:" + exception.getMessage());
        }
    }


    /**
     * selectDropDownList
     * @param element to be select
     * @param value of the element select
     */
    public void selectDropDownList(By element, String value){
        try{
            Select optionSelect = new Select(driver.findElement(element));
            optionSelect.selectByVisibleText(value);
            System.out.println("The element was be clicked was: " + element + " and the value is: " + value);
        }catch(Exception exception){
            System.err.println("Can't select the element: " + element + ". Error msg:" + exception.getMessage());
        }
    }
    /**
     *
     */
    public void switchToFrame(By element){
        WebElement iframe;
        try{
            iframe = driver.findElement(element);
            driver.switchTo().frame(iframe);
            System.out.println("The element to of the iframe is: " + element );
        }catch(NoSuchElementException exception){
            System.err.println("Can't write in the element: " + element + ". Error msg:" + exception.getMessage());
        }
    }
}