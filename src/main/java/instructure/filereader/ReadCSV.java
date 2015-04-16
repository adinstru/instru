package instructure.filereader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by natarajan on 4/15/15.
 */
public class ReadCSV {
    String directory = "";

    public static Reader getReader() throws IOException {
        String readString ="";
        List<String> readLines = Files.readAllLines(Paths.get("courses.csv"), StandardCharsets.US_ASCII);
        for(String pack: readLines){
            readString =readString+pack+"\n";
        }

        return new StringReader(new String(readString));
    }
}