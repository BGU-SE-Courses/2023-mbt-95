package hellocucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class UserLogin {

        private WebDriver driver;
        private WebDriverWait wait;

        public UserLogin() {
            // Set the path of the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "C:\\devop\\chromedriver.exe");

            // Create an instance of ChromeDriver and WebDriverWait
            driver = new ChromeDriver();
        }

        public void navigateToLoginPage() throws InterruptedException {
            // Navigate to the OpenCart website
            driver.get("http://localhost/");
            // Click on My Account, Login, and Register
            WebElement myAccountElement = driver.findElement(By.xpath("//*[@id=\"usernavigation\"]/div[3]/div[1]/span[1]"));
            myAccountElement.click();
            Thread.sleep(1000);
            WebElement LoginElement = driver.findElement(By.xpath("//*[@id=\"loginbtn\"]"));
            LoginElement.click();
            Thread.sleep(1000);

        }

        public void LoginUser(String username,String password) throws InterruptedException {
            // Fill in login details
            WebElement usernameElement = driver.findElement(By.xpath("//*[@id=\"username\"]"));
            usernameElement.sendKeys(password);
            WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            passwordElement.sendKeys(username);
            Thread.sleep(1000);
            // Scroll down to the "Agree" checkbox
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for a moment
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Click the "Agree" checkbox
            WebElement agreeCheckbox = driver.findElement(By.xpath("//*[@id=\"loginbtn\"]"));
            agreeCheckbox.click();

            // Wait for a few seconds to observe the actions
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void closeBrowser() {
            // Close the browser
            driver.quit();
        }
    }




