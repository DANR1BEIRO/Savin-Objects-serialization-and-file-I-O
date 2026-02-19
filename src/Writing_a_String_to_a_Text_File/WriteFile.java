package Writing_a_String_to_a_Text_File;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter("test.txt")) {
            fileWriter.write("first test.txt line");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
