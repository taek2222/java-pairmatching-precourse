package pairmatching.global.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FileUtil {

    private static final String DIRECTORY_PATH = "src/main/resources/";

    public static List<String> readFile(String fileName) {
        BufferedReader fileReader = openFileReader(fileName);
        return parseLines(fileReader);
    }

    private static BufferedReader openFileReader(String fileName) {
        try {
            File file = new File(DIRECTORY_PATH + fileName);
            FileReader fileReader = new FileReader(file);
            return new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> parseLines(BufferedReader fileReader) {
        return fileReader.lines()
                .toList();
    }
}
