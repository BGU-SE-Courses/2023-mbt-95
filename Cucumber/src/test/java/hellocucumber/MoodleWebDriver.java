package hellocucumber;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class MoodleWebDriver {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public static Map<String, String> urls = new HashMap<String, String>() {{
        put("loginPage", "http://localhost/login/index.php");
        put("MiddleMessagePage", "http://localhost/mod/forum/discuss.php?d=2");
        put("AnnuncementsPage", "http://localhost/mod/forum/view.php?id=1");
        put("coursePage", "http://localhost/course/view.php?id=2");
    }};
    public static Map<String, String> xpaths = new HashMap<String, String>() {{
        //buttons for login page
        put("loginButton", "//*[@id='loginbtn']");
        put("usernameField", "//*[@id='username']");
        put("passwordField", "//*[@id='password']");
        //button for the teacher to add discussion topic (before step)-->inside announcment page
        put("addDiscussionButton", "//*//*[@id='region-main']/div[2]/div[1]/div[1]/div[2]/a[1]");
        //button for the teacher to Delete discussion
        put("removeDiscussionButton", "//*[@id='p1']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[3]]");
        put("userMenuToggle", "//*[@id='user-menu-toggle']");
        put("PreviousDiscussionButton", "//*[@id=\"discussion-container-66141649a95e56614164994b4613\"]/div[1]/ul[1]/li[1]/a[1]");
    }};
    public MoodleWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\devop\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        // Create an instance of ChromeDriver and WebDriverWait
        driver = new ChromeDriver(option);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Navigates the webdriver to the provided URL.
     *
     * @param url url of the web page to navigate to
     */
    public void navigateToWebPage(String url) {
        driver.get(url);
        try {
            sleep(Duration.ofMillis(250).toMillis());
        } catch (Exception e){return;}
    }


    public void login(String username, String password) {
        driver.get(urls.get("loginPage"));

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpaths.get("usernameField")))).sendKeys(username);

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpaths.get("passwordField")))).sendKeys(password);

        driver.findElement(By.xpath(xpaths.get("loginButton"))).click();
    }

    public boolean notOnlyPage(){
        try {
            driver.findElement(By.xpath(xpaths.get("PreviousDiscussionButton")));
            return true;
        } catch (java.util.NoSuchElementException e){
            return false;
        }
    }

    /**
     * Retrieves current page
     */
    public int getCurrentmessagePage(){
        String url = driver.getCurrentUrl();
        int index = url.indexOf("page=");
        if(index > -1)
            return Integer.parseInt(url.substring(index + 5));
        return 0;
    }

    /**
     * Closes current selenium driver session.
     */
    public void tearDown(){
        this.driver.close();
    }

    public void navigateToMyCourses(){
        //navigate to my courses
        WebElement MyCoursesBotton = driver.findElement(By.xpath("//*[@id=\"moremenu-6613f4d6333f9-navbar-nav\"]/li[3]/a[1]"));
        MyCoursesBotton.click();
    }
    public void navigateToMLCourse(){
        //navigate to machine learning course box
        WebElement MLCourseBotton = driver.findElement(By.xpath("//*[@id=\"course-info-container-2-3\"]/div[1]/div[1]/a[1]/span[3]/span[2]"));
        MLCourseBotton.click();
    }
    public void navigateToAnnouncments(){
        //navigate to annoncments of the course
        WebElement AnnouncmentsBotton = driver.findElement(By.xpath("//*[@id=\"module-1\"]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]"));
        AnnouncmentsBotton.click();
    }
    public void navigateToa1Message(){
        //navigate to the middle message in ml course
        WebElement a1MBotton = driver.findElement(By.xpath("//*[@id=\"discussion-list-6613f68b5ae466613f68b4e4916\"]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/th[1]/div[1]/div[1]/a[1]"));
        a1MBotton.click();
    }
    public void navigateToFirstMessage(){
        //navigate to the middle message in ml course
        WebElement a1MBotton = driver.findElement(By.xpath("//*[@id=\"discussion-list-6614fe23b1c0c6614fe2367fc614\"]/div[3]/div[1]/table[1]/tbody[1]/tr[3]/th[1]/div[1]/div[1]/a[1]"));
        a1MBotton.click();
    }
    public void navigateToPreviousMessage(){
        //go to the message before a1 message
        WebElement BackFroma1MBotton = driver.findElement(By.xpath("PreviousDiscussionButton"));
        BackFroma1MBotton.click();
    }


    public void teacherDeleteMessage() {
        navigateToAnnouncments();
        navigateToa1Message();
        navigateToPreviousMessage();
        try {
            WebElement deleteButton = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("removeDiscussionButton")));
            deleteButton.click();
            // Handle confirmation dialog if necessary
        } catch (TimeoutException e) {
            System.out.println("Delete button not found or message already deleted.");
        }
    }
}