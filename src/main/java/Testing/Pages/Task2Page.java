package Testing.Pages;

import Helpers.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task2Page {
    private final Common common;
    private final By btnHamburguerMenu = By.cssSelector(".wu-icon.wu-icon-heading__xl.icon-0124_menu.action-light");
    private final By btnFindLocations = By.xpath("//li[contains(@class,'nav-item d-block d-XL-none')]//span[contains(@class,'white-space-nowrap nav-item__title')][normalize-space()='Find locations']");



    public Task2Page(WebDriver driver) {
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

    public void goToFindLocationsMenu(){
        try{
            common.waitForElementExplicitVisible(btnFindLocations, 20);
            common.click(btnFindLocations);
            common.waitForElementImplicit(10);
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }
    }
}
