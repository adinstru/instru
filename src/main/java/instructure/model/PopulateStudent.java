package instructure.model;

import instructure.filereader.ReadCSV;
import org.csveed.api.CsvClient;
import org.csveed.api.CsvClientImpl;
import org.csveed.report.CsvException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by natarajan on 4/15/15.
 */
public class PopulateStudent {

    public static Map<Long, Course> getCoursesStudentList() {
        //Get a list of course, need to validate the csv file for student has valid courseIds
        Map<Long, Course> listCoursesMutable = PopulateCourses.getCoursesList();
        Set<Long> validCourseIDs = listCoursesMutable.keySet();

        //Read mapped csv file to java bean
        CsvClient<Student> csvStudentReader = null;
        try {
            csvStudentReader = new CsvClientImpl<Student>(ReadCSV.getStudentReader(), Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Build the courseList
        List<Student> studentListFromCSV = null;
        try {
            studentListFromCSV = csvStudentReader.readBeans();
        }catch (CsvException exception){
            throw new AssertionError("Invalid csv format " +exception.getMessage());
        }

        //Create a unique active map
        Map<Long, Student> uniqueActiveStudentMap = new HashMap<>();
        Map<Long, Student> studentsWithInvalidCourseIds = new HashMap<>();
        for(Student student: studentListFromCSV){
            if(validCourseIDs.contains(student.getCourse_id().longValue())){
                if(student.getState().equalsIgnoreCase("active")){
                    listCoursesMutable.get(student.getCourse_id()).setEnrolledStudents(student);
                }
            } else{
                studentsWithInvalidCourseIds.put(student.getUser_id(), student);
            }
        }


        //If there are any student with invalid courseIds, throw exception and notify the school/college to send updated csv
        if(studentsWithInvalidCourseIds.size()>0){
            throw new AssertionError("Student with invalid courseIds, throwing exception, please notify the school/college to send updated csv"+
            studentsWithInvalidCourseIds);
        }
        return listCoursesMutable;
    }
}
