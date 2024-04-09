package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TeacherDeletePrevMessageDefinition {

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
        @Given("Teacher is logged in")
        public void Teacher_is_logged_in_with_stud_username_and_password(String username, String password) {
            teacher.moodleWebDriver.login(username, password);
        }
        @Given("Student is logged in")
        public void student_is_logged_in_with_stud_username_and_password(String username, String password) {
            student.moodleWebDriver.login(username, password);
        }
        @When("Teacher is on first announcment")
        public void StudentNavigateToFAnno(){
            teacher.moodleWebDriver.navigateToMyCourses();
            teacher.moodleWebDriver.navigateToMLCourse();
            teacher.moodleWebDriver.navigateToAnnouncments();
            student.moodleWebDriver.navigateToFirstMessage();
        }

    @When("Student is in the middle annoncment page")
    public void StudentNavigateToMAnno(){
        teacher.moodleWebDriver.navigateToMyCourses();
        teacher.moodleWebDriver.navigateToMLCourse();
        teacher.moodleWebDriver.navigateToAnnouncments();
        student.moodleWebDriver.navigateToa1Message();
    }
        @When("Teacher removes the previous announcment")
        public void TeacherRemovesprevAnnouncment() {
            student.moodleWebDriver.teacherDeleteMessage();
        }
        @When("Student presses the prev page button")
        public void StudentPresPrev() {
            student.moodleWebDriver.navigateToPreviousMessage();
        }


        @Then("Student is no longer seen the previous message button")
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

