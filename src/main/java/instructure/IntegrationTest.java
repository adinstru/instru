package instructure;

import org.testng.annotations.Test;

/**
 * Created by natarajan on 4/15/15.
 */
public class IntegrationTest {

    //Happy Test cases
    @Test  public void allActiveCourseActiveStudentsTest(){}
    @Test  public void ZeroActiveCourseAllActiveStudentsTest(){}
    @Test  public void AllActiveCourseZeroActiveStudentsTest(){}
    @Test  public void ZeroActiveCourseZeroActiveStudentsTest(){}
    @Test  public void ChangeHeaderOrderCoursesTest(){}
    @Test  public void ChangeHeaderOrderStudentTest(){}

    //Negative test cases
    @Test  public void EmptyCourseCsvFileTest(){}
    @Test  public void InvalidCourseCsvFileTest(){}
    @Test  public void EmptyStudentCsvFileTest(){}
    @Test  public void InvalidStudentCsvFileTest(){}

    //Edge case test
    @Test  public void ReallyLongCourseIDCourseTest(){}
    @Test  public void NonNumericCourseIDCourseTest(){}
    @Test  public void ReallyLongCourseNameCourseTest(){}
    @Test  public void ReallyLongStatusCourseTest(){}
    @Test  public void InvalidCharacterCourseNameCourseTest(){}
    @Test  public void CourseNameWithCommaCourseTest(){}
}
