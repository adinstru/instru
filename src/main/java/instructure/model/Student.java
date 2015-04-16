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

    public Long getUser_id() {        return user_id;    }

    public void setUser_id(Long user_id) {        this.user_id = user_id;    }

    public Long getCourse_id() {        return course_id;    }

    public void setCourse_id(Long course_id) {        this.course_id = course_id;    }

    public String getUser_name() {        return user_name;    }

    public void setUser_name(String user_name) {        this.user_name = user_name;    }

    public String getState() {        return state;    }

    public void setState(String state) {        this.state = state;    }

    @CsvCell(columnName = "user_id")
    private Long user_id;
    @CsvCell(columnName = "course_id")
    private Long course_id;
    @CsvCell(columnName = "user_name")
    private String user_name;
    @CsvCell(columnName = "state")
    private String state;

    @Override
    public String toString(){
        return
                "user_id: "+user_id+"\n"+
                "user_name: "+user_name+"\n"+
                "course_id: "+course_id+"\n"+
                "state: "+state+"\n";
    }
}
