package hello;

import hello.Greeting;
import instructure.model.Course;
import instructure.model.PopulateCourses;
import instructure.model.PopulateStudent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * Created by natarajan on 4/15/15.
 */

@RestController
public class CourseController {

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String course() {
        return PopulateStudent.formatterCourses(PopulateStudent.getCoursesStudentList());
    }

    @RequestMapping(value = "/coursejson", method = RequestMethod.GET)
    public Map<Long, Course> courseJson() {
        return PopulateStudent.getCoursesStudentList();
    }
}
