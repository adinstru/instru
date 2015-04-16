package instructure.model;

import org.csveed.annotations.CsvCell;
import org.csveed.annotations.CsvFile;
import org.csveed.annotations.CsvIgnore;
import org.csveed.bean.ColumnNameMapper;

import java.util.Set;

/**
 * Created by natarajan on 4/15/15.
 */

@CsvFile(separator = ',', mappingStrategy = ColumnNameMapper.class)
public class Course {

    @CsvCell(columnName = "course_id")
    private Long course_id;
    @CsvCell(columnName = "course_name")
    private String course_name;
    @CsvCell(columnName = "state")
    private String state;
    @CsvIgnore
    private Set<Student> enrolledStudents;
}
