package hello;

import instructure.model.Course;
import instructure.model.PopulateCourses;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

/**
 * Created by natarajan on 4/15/15.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        Map<Long, Course> vale = PopulateCourses.getCoursesList();
        SpringApplication.run(Application.class, args);
    }
}
