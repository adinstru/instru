package instructure.unittest;

import instructure.filereader.ReadCSV;
import org.springframework.boot.test.IntegrationTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by natarajan on 4/15/15.
 */
public class ReadCSVTest {

    @Test
    public void happyTest() throws IOException {
        Reader value = ReadCSV.getReader();
        Assert.assertNotNull(value);
    }

    @Test
    public void happyStudentFileTest() throws IOException {
        Reader value = ReadCSV.getStudentReader();
        Assert.assertNotNull(value);
    }
}
