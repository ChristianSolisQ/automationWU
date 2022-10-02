package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


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
            System.out.println("El elemento que fue clickeado es: " + element );

        }catch(NoSuchElementException exception){
            //Assert.fail("Can't click the element: " + element + ". Error msg:" + exception.getMessage());
            System.err.println("Can't click the element: " + element + ". Error msg:" + exception.getMessage());
        }
    }

    /**
    * scrollToButton
    * @param element the element to be clicked
     **/
    public void scrollToButton(By element){
        WebElement webElement;
        try{
            webElement = driver.findElement(element);
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement);
            actions.click();
            System.out.println("El elemento que fue clickeado es: " + element );
        }catch(NoSuchElementException exception){
           // Assert.fail("Can't click the element: " + element + ". Error msg:" + exception.getMessage());
            System.err.println("Can't click the element: " + element + ". Error msg:" + exception.getMessage());
        }
    }
    /**
    * waitForElementImplicit
    * @param time to be wait in seconds
     **/
    public void waitForElementImplicit(int time){
        try{
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        }catch (Exception exception){
            //Assert.fail("Can't wait for: " + time + " seconds. Error msg:" + exception.getMessage());
            System.err.println("Can't wait for: " + time + " seconds. Error msg:" + exception.getMessage());
        }
    }


    /**
     * Sleep
     * @param time to be waiting
     */
public void sleep(int time){
    try{
        Thread.sleep(time);
    }catch(Exception exception){
        System.err.println("Can't wait for: " + time + " seconds. Error msg:" + exception.getMessage());
    }
}
}