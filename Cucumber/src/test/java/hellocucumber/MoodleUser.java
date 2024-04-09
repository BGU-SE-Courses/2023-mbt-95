package hellocucumber;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MoodleUser {
    public MoodleWebDriver moodleWebDriver;
    public String username;
    public String password;

    public MoodleUser(String username, String password){
        moodleWebDriver = new MoodleWebDriver();
        this.username = username;
        this.password = password;
    }


    }
