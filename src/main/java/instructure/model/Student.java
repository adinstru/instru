package instructure.model;

import org.csveed.annotations.CsvCell;
import org.csveed.annotations.CsvFile;
import org.csveed.annotations.CsvIgnore;
import org.csveed.bean.ColumnNameMapper;

/**
 * Created by natarajan on 4/15/15.
 */

@CsvFile(separator = ',', mappingStrategy = ColumnNameMapper.class)
public class Student {

    @CsvCell(columnName = "user_id")
    private Long user_id;
    @CsvCell(columnName = "course_id")
    private Long course_id;
    @CsvCell(columnName = "user_name")
    private String user_name;
    @CsvCell(columnName = "state")
    private String state;

}
