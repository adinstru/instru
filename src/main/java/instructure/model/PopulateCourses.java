package instructure.model;

import instructure.filereader.ReadCSV;
import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;
import org.csveed.report.CsvException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by natarajan on 4/15/15.
 */
public class PopulateCourses {

    public static Map<Long, Course> getCoursesList() {
        return getCoursesList("courses.csv");
    }

    public static Map<Long, Course> getCoursesList(String fileName) {
        //Read mapped csv file to java bean
        CsvClient<Course> csvCourseReader = null;
        csvCourseReader = new CsvClientImpl<Course>(ReadCSV.givenReader(fileName), Course.class);


        //Build the courseList
        List<Course> courseListFromCSV = null;
        try {
            courseListFromCSV = csvCourseReader.readBeans();
        }catch (CsvException exception){
            throw new AssertionError("Invalid csv format " +exception.getMessage());
        }

        //Create a unique active map
        Map<Long, Course> uniqueActiveCourseMap = new HashMap<>();
        for(Course course: courseListFromCSV){
            if(course.getState().equalsIgnoreCase("active")){
                uniqueActiveCourseMap.put(course.getCourse_id(), course);
            }
        }

        return uniqueActiveCourseMap;
    }
}
