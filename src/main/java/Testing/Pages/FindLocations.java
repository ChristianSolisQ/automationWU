package Testing.Pages;

import Helpers.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindLocations
{
    private final Common common;
    private final By iframeFindLocations = By.cssSelector("#responsive-template > div > div > div.flex-row > div.wu-responsive-columns.col-lg-12.col-md-12.col-sm-12.col-xs-12.colctrl > div > iframe");

    private final By txtZipCode = By.cssSelector("input[placeholder='Address, city, state or ZIP']");
    private final By lblNameSite = By.xpath("//h2[normalize-space()='VILNIAUS 11ASIS PASTAS']");
    private final By lblDistance = By.xpath("//div[normalize-space()='1.96 km']");
    private final By lblAddressFirstLane = By.xpath("//div[contains(text(),'Ozo G')]");
    private final By lblLocation = By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/ol[1]/li[1]/div[1]/div[3]/div[1]/div[3]/span[2]");
    private final By lblSchedule = By.xpath("//*[@id=\"__next\"]/div[1]/main/div[1]/div[1]/ol/li[1]/div/div[3]/div[1]/div[4]");
    private final By lblSendOnline = By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/ol[1]/li[1]/div[1]/div[3]/div[1]/a[1]");
    private final By lblPhone = By.xpath("//*[@id=\"__next\"]/div[1]/main/div[1]/div[1]/ol/li[1]/div/div[3]/div[1]/div[5]");

    public FindLocations(WebDriver driver) {
        this.common = new Common(driver);
    }


   public void changeToIframe(){
       try{
           common.waitForElementExplicit(iframeFindLocations,15);
           common.switchToFrame(iframeFindLocations);
           common.waitForElementImplicit(10);
       }catch (Exception exception){
           System.err.println(exception.getMessage());
       }
   }
    public void writeZipCode(String text) {
        try {
            common.waitForElementExplicitVisible(txtZipCode, 10);
            common.setTextWithEnter(txtZipCode,text);
            common.waitForElementImplicit(10);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
    public String getText(){
        String text;
        try{
            common.waitForElementImplicit(10);
            text = "The nearest open agent is: " + "\n" + common.getText(lblNameSite) +  "\n" + common.getText(lblDistance)  + "\n " +
                    common.getText(lblAddressFirstLane)  + "\n" + common.getText(lblLocation)  + "\n" + common.getText(lblSchedule) +   "\n" +
            common.getText(lblSendOnline)  + "\n" + common.getText(lblPhone)  + "\n";

        }catch (Exception exception){
            System.err.println(exception.getMessage());
            text = "";
        }
        return text;
    }
}
