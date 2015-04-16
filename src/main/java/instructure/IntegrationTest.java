package instructure;

import instructure.model.PopulateCourses;
import instructure.model.PopulateStudent;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by natarajan on 4/15/15.
 */
public class IntegrationTest {

    //Happy Test cases
    @Test  public void allActiveCourseActiveStudentsTest(){
        Assert.assertEquals(PopulateStudent.getCoursesStudentList("courses.csv", "students.csv").size(), 4);
    }

    @Test  public void ZeroActiveCourseAllActiveStudentsTest(){}
    @Test  public void AllActiveCourseZeroActiveStudentsTest(){}
    @Test  public void ZeroActiveCourseZeroActiveStudentsTest(){}
    @Test  public void ChangeHeaderOrderCoursesTest(){}
    @Test  public void ChangeHeaderOrderStudentTest(){}

    //Negative test cases
    @Test  public void EmptyCourseCsvFileTest(){}

    @Test(expectedExceptions = AssertionError.class)
    public void InvalidCourseCsvFileTest(){
        Assert.assertEquals(PopulateStudent.getCoursesStudentList("course.csv", "students.csv").size(), 4);

    }
    @Test  public void EmptyStudentCsvFileTest(){}

    @Test(expectedExceptions = AssertionError.class)
    public void InvalidStudentCsvFileTest(){
        Assert.assertEquals(PopulateStudent.getCoursesStudentList("courses.csv", "student.csv").size(), 4);

    }

    //Edge case test
    @Test  public void ReallyLongCourseIDCourseTest(){}
    @Test  public void NonNumericCourseIDCourseTest(){}
    @Test  public void ReallyLongCourseNameCourseTest(){}
    @Test  public void ReallyLongStatusCourseTest(){}
    @Test  public void InvalidCharacterCourseNameCourseTest(){}
    @Test  public void CourseNameWithCommaCourseTest(){}
}
