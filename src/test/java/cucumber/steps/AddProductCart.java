package cucumber.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.config.DriverConfig;


public class AddProductCart {
    private WebDriver driver;
    
    public static String BASE_URL = "https://www.saucedemo.com/";
    public static String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    
    public AddProductCart() {
    	driver = DriverConfig.getInstance().getDriver();
    }
    
    
    @Given("user is on logged in using standard_user")
    public void user_is_on_logged_in_using_standard_user() {
        driver.get(BASE_URL);
        driver.findElement(new By.ByXPath("/html//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(new By.ByXPath("/html//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(new By.ByXPath("/html//input[@id='login-button']")).click();
    }
    
    @Then("User in  dashboard page")
    public void user_in_dashboard_page(){
        String products =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(products, "Products");
    }

    
    @And("user click the Add To Cart button")
    public void userClickTheAddToCartButton() {
    	driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();    	
    }

    @And("user click checkout logo")
    public void userClickCheckoutLogo() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
    }

    @And("user click continue shopping button")
    public void userClickContinueShoppingButton() {
        driver.findElement(By.xpath("//*[@id='continue-shopping']")).click();
    }

    @And("user click another product")
    public void userClickAnotherProduct() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']")).click();
    }
    @And ("user click product two")
    public void userClickProductTwo() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
    }
    @And ("user click product three")
    public void userClickProductThree() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
    }

    @And ("user click product four")
    public void userClickProductFour() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-onesie']")).click();
    }
    @And ("user click product five")
    public void userClickProductFive() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
    }

    @Then("user in on checkout page")
    public void userInOnCheckoutPage() {
        String text =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(text, "Your Cart");
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @Then("user in on checkout info page")
    public void userInOnCheckoutInfoPage() {
        String text =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(text, "Checkout: Your Information");
    }

    
    @And("input first name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Novaliza");
    }

    @And("input last name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Rakamin");
    }

    @And("input zip code")
    public void inputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("15411");
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @Then("user in on overview page")
    public void userInOnOverviewPage() {
        String text =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(text, "Checkout: Overview");
    }

    @And ("user click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//*[@id='finish']")).click();
    }

    @Then ("user in on complete page")
    public void userInOnCompletePage() {
        String text =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(text, "Checkout: Complete!");
    }

}
