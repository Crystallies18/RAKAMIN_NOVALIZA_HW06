package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.config.DriverConfig;

public class Login {
	
    private WebDriver driver;
    
    public static String BASE_URL = "https://www.saucedemo.com/";
    public static String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    
    public Login() {
    	driver = DriverConfig.getInstance().getDriver();
    }

    @Given("User on saucedemo login page")
    public void user_on_login_page() {
        driver.get(BASE_URL);
    }
    
    @When("Input username")
    public void input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void click_login_button(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User in on dashboard page")
    public void user_in_on_dashboard_page(){
        String products =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(products, "Products");
    }

    @And("Input invalid password")
    public void input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("random123");
    }

    @Then("User get error message")
    public void user_get_error_message(){
        String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }
    
    @When("User input (.*) as username$")
    public void user_input_username(String username) {
        WebElement weUserName = driver.findElement(new By.ByXPath("/html//input[@id='user-name']"));
        weUserName.sendKeys(username);
    }

    @When("User input (.*) as password$")
    public void user_input_password(String password) {
        WebElement wePassword = driver.findElement(new By.ByXPath("/html//input[@id='password']"));
        wePassword.sendKeys(password);
    }
    


    @Then("User verify (.*) login result$")
    public void user_verify_login_result(String status) {
        if("success".equalsIgnoreCase(status)) {
            driver.getCurrentUrl();
            Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        }else if("failed".equalsIgnoreCase(status)) {
            try {
                Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
                WebElement weErrorMessage = driver.findElement(new By.ByXPath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
                
                Assert.assertTrue(!StringUtils.isEmpty(weErrorMessage.getText()));
            }catch(NoSuchElementException e) {
                Assert.fail();
            }
        }
    }
    
}


