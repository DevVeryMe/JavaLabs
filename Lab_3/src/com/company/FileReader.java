package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static String readFile(String path, Charset encoding) throws IOException
    {
        String content;
        try (Scanner scanner = new Scanner(new File(path), String.valueOf(encoding))) {
            content = scanner.useDelimiter("\\A").next();
        }

        return content;
    }

    public static String readFileAsString(String filePath)
    {
        String fileContent = null;

        try {
            fileContent = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }

    public static List<String> readFileAsStringList(String filePath)
    {
        List<String> wordsList = new ArrayList<>();

        try {
            File fileToRead = new File(filePath);
            Scanner myReader = new Scanner(fileToRead);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                wordsList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return wordsList;
    }
}
