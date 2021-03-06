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
        return getCoursesStudentList("courses.csv", "students.csv");
    }

    public static Map<Long, Course> getCoursesStudentList(String fileCourse, String fileStudent) {
        //Get a list of course, need to validate the csv file for student has valid courseIds
        Map<Long, Course> listCoursesMutable = PopulateCourses.getCoursesList(fileCourse);
        Set<Long> validCourseIDs = listCoursesMutable.keySet();

        //Read mapped csv file to java bean
        CsvClient<Student> csvStudentReader = null;
        csvStudentReader = new CsvClientImpl<Student>(ReadCSV.givenReader(fileStudent), Student.class);


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

    public static String formatterCourses(Map<Long, Course> displayMap){
        String formattedDisplay ="";
        for (Map.Entry<Long, Course> entry : displayMap.entrySet()){
            formattedDisplay=formattedDisplay+"CourseId: "+entry.getValue().getCourse_id()+"\t  "+
                    entry.getValue().getCourse_name()+"("+entry.getValue().getState() +")<BR>"+
            getSetString(entry.getValue().getEnrolledStudents());
        }
        return formattedDisplay;
    }

    private static String getSetString(Set<Student> enrolledStudents) {
        String listOfEnrolledStudents ="";
        if(enrolledStudents.size()<=0){
            listOfEnrolledStudents = "No active students enrolled for this course";
        }
        for(Student student: enrolledStudents){
            listOfEnrolledStudents = listOfEnrolledStudents+"UserId: "+student.getUser_id()
                    +"\t   "+student.getUser_name()+"("+student.getState()+")<BR>";
        }
        return listOfEnrolledStudents.concat("<BR>---------------------------------------<BR>");
    }
}
