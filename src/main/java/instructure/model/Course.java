package instructure.model;

import org.csveed.annotations.CsvCell;
import org.csveed.annotations.CsvFile;
import org.csveed.annotations.CsvIgnore;
import org.csveed.bean.ColumnNameMapper;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by natarajan on 4/15/15.
 */

@CsvFile(separator = ',', mappingStrategy = ColumnNameMapper.class)
public class Course {

    public Course(){
        Set<Student> empty = new HashSet<>();
        this.enrolledStudents = empty;
    }

    public Long getCourse_id() {        return course_id;    }

    public void setCourse_id(Long course_id) {        this.course_id = course_id;    }

    public String getCourse_name() {        return course_name;    }

    public void setCourse_name(String course_name) {        this.course_name = course_name;    }

    public String getState() {        return state;    }

    public void setState(String state) {        this.state = state;    }

    public Set<Student> getEnrolledStudents() {        return enrolledStudents;    }

    public void setEnrolledStudents(Student enrolledStudents) {
        getEnrolledStudents().add(enrolledStudents);
    }

    @CsvCell(columnName = "course_id")
    private Long course_id;

    @CsvCell(columnName = "course_name")
    private String course_name;

    @CsvCell(columnName = "state")
    private String state;

    @CsvIgnore
    private Set<Student> enrolledStudents;
}
