package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
public class StudentClickOnPrevMessageDefinition {

    private static MoodleUser teacher;
    private static MoodleUser student;
    private final String DiscussionName = "FirstDiscuss";

    private int currentPage;
    static String student_username = "student";
    static  String student_password = "stud12345!";
    static String teacher_name = "teacher";
    static String teacher_password = "Niv12345!";
    @Before
    public static void before(){
        teacher = new MoodleUser(student_username, student_password);
        student = new MoodleUser(teacher_name,teacher_password);
    }
    @Given("the student is logged in on with {string} and {string}")
    public void student_is_logged_in_with_stud_username_and_password(String username, String password) {
        student.moodleWebDriver.login(username, password);
    }
    @When("user is on one of the  Announcmentes page of Ml course")
    public void StudentNavigateToAnno(){
        student.moodleWebDriver.navigateToMyCourses();
        student.moodleWebDriver.navigateToMLCourse();
        student.moodleWebDriver.navigateToAnnouncments();
        student.moodleWebDriver.navigateToa1Message();
    }
    @Given("Current page is not the only")
    public void current_page_is_not_only() throws Exception {
        if(!student.moodleWebDriver.notOnlyPage())
            throw new Exception("There is no previous page");
    }

    @When("Student presses the prev page button ")
    public void studentNavigatetoPreviousMessage() {
        student.moodleWebDriver.navigateToPreviousMessage();
    }



    @Then("the message changes to the previous message")
    public void Message_page_changes_to_the_Previous_page() throws Exception {
        if(student.moodleWebDriver.getCurrentmessagePage() - currentPage <= 0)
            throw new Exception("Student has not moved to the previous page");
    }

    @After
    public void tearDown() {
        teacher.moodleWebDriver.tearDown();
        student.moodleWebDriver.tearDown();
    }

}

