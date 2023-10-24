package cucumber.steps;


import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.config.DriverConfig;
import java.util.List;

public class Inventory  {

    private WebDriver driver;
        
    public static String BASE_URL = "https://www.saucedemo.com/";
    public static String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    
    public Inventory() {
    	driver = DriverConfig.getInstance().getDriver();
    }

    @Then("user can view (.*) images$")
    public void user_can_view_images(String is_image) {
        System.out.println(driver.getCurrentUrl());
        List<WebElement> elements = driver.findElements(new By.ByXPath("//img[@class='inventory_item_img']"));
        for (WebElement imgElement : elements) {
            // You can access attributes or perform actions on each img element
            String imgSrc = imgElement.getAttribute("src");
            System.out.println("Image Source: " + imgSrc);
            if("correct".equalsIgnoreCase(is_image)) {
                Assert.assertNotEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", imgSrc);
            } else if("wrong".equalsIgnoreCase(is_image)) {
                Assert.assertEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", imgSrc);
            }
        }
    }

//    /html//div[@id='inventory_container']/div/div[@id='inventory_container']/div/div[1]/div[@class='inventory_item_img']/a[@href='#']/img[@alt='Sauce Labs Backpack']
    //
}
