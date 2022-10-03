package Testing.Pages;

import Helpers.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task1Page {
    private final Common common;
    private By btnHamburguerMenu = By.cssSelector(".wu-icon.wu-icon-heading__xl.icon-0124_menu.action-light");
    private By btnSettings = By.xpath("//span[contains(@class,'white-space-nowrap nav-item__title')][normalize-space()='Settings']");
    private By ddlCountry = By.cssSelector("#Question");
    private By btnYesConfirmation = By.cssSelector("button[ng-click='redirect();'] translate[class='ng-scope']");

    public Task1Page(WebDriver driver) {
        this.common = new Common(driver);
    }

    public void goToWesterUnionPage(String url){
        try{
            common.getUrl(url);
            common.waitForElementImplicit(10);
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }

    }

    public void expandHamburgerMenu(){
        try{
            common.waitForElementExplicit(btnHamburguerMenu, 10);
            common.click(btnHamburguerMenu);
            common.waitForElementImplicit(10);
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }
    }

    public void goToSettingsMenu(){
        try{
            common.waitForElementExplicitVisible(btnSettings, 20);
            common.click(btnSettings);
            common.waitForElementImplicit(10);
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }
    }
    public void changeCountry(String value){
        try{
            common.waitForElementImplicit(10);
            common.selectDropDownList(ddlCountry,value);
            common.waitForElementImplicit(10);
            common.click(btnYesConfirmation);
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }
    }



}
